/*
 * Tyler HUnt
 * Advanced Java
 * Extra Credit - Multimedia viewer
 * Project 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MediaViewer extends Application {
    private final FileChooser fileChooser = new FileChooser();
    private final ImageView imageView = new ImageView();

    private double height;
    
    // The list of images in the current directory
    ArrayList<String> foundImages = new ArrayList<String>();
    private int position = -1;
    
    // The position in the array list which points to the current image.
    private final Button nextButton = new Button("Next");
    private final Button prevButton = new Button("Previous");

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);

        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");

        menuBar.getMenus().addAll(menuFile);
        MenuItem menuOpen = new MenuItem("Open");
        MenuItem menuQuit = new MenuItem("Quit");

        menuFile.getItems().addAll(menuOpen, menuQuit);

        menuQuit.setOnAction(actionEvent -> Platform.exit());

        menuOpen.setOnAction(actionEvent -> {
            File file = fileChooser.showOpenDialog(primaryStage);
            showImage(file);
        });

        nextButton.setOnAction(evt -> {
            position++;
            update();

        });
        prevButton.setOnAction(evt -> {
            position--;
            update();

        });

        HBox hb = new HBox();
        hb.getChildren().addAll(nextButton, prevButton);

        root.setTop(menuBar);
        root.setCenter(imageView);
        root.setBottom(hb);

        primaryStage.setTitle("Media Viewer");
        primaryStage.setScene(scene);

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setMaximized(true);
        primaryStage.show();
        height = bounds.getHeight();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void showImage(File f) {
        try {

            Image image = new Image(new FileInputStream(f));
            imageView.setImage(image);
            imageView.setFitHeight(height - 150);
            imageView.setPreserveRatio(true);

            buildImageList(f);
        } catch (FileNotFoundException ex) {} 
        catch (IOException ex) {}
    }

    
    // Load the file names of all files in the given directory.
    
    private void buildImageList(File f) throws IOException {
        File dir = f.getParentFile();
        if (dir.isDirectory()) {
            File[] allFiles = dir.listFiles();
            int c = 0;
            for (File file : allFiles) {
                if (file.isFile()) {
                    int idx = file.getName().lastIndexOf('.');
                    if(idx != -1) { 
                        String cnt = file.getName().substring(idx+1).trim().toLowerCase();
                        if (cnt.equals("jpeg") || cnt.equals("png") 
                                || cnt.equals("jpg") || cnt.equals("gif")) {
                            foundImages.add(file.toString());
                            if (file.equals(f)) {
                                position = c;
                            }
                            c++;
                        }
                    }
                }
            }
        }
    }
    private void update() {
        try {
            Media sound = new Media(new File("sounds/click.mp3").toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            
            // check the bounds, wrap around if we have exceeded the bounds
            if (position == foundImages.size()) {
                position = 0;
            } else if (position == -1) {
                position = foundImages.size() - 1;
            }

            String path = foundImages.get(position);
            System.out.println(path);
            Image image = new Image(new FileInputStream(path));
            imageView.setImage(image);
            imageView.setFitHeight(height - 100);
            imageView.setPreserveRatio(true);
        } catch (FileNotFoundException ex) {
           // Logger.getLogger(MediaViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
