import java.awt.*;
import javax.swing.*;

public class GenerisGuiApp extends JPanel{
    //Use for week 9 homework
    public static final int WIDTH   = 400;
    public static final int HEIGHT  = 400;


    public GenerisGuiApp(){
        super();

        //Set basic frame params  //from javax.swing
        setSize(WIDTH, HEIGHT);
        setTitle("Mouse Demo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Main panel -> from java.awt
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(5, 5));

        JPanel jp = new MouseDemoPanel();

        setVisible(true);
        setResizable(false);
        
    }

    public static void main(String[] args){
        GenerisGuiApp = new GenerisGuiApp();
    }

}