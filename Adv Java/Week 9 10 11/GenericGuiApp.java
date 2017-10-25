import java.awt.*;
import javax.swing.*;

public class GenericGuiApp extends JFrame{
    //Use for week 9 homework
    public static final int WIDTH   = 400;
    public static final int HEIGHT  = 400;

    public GenericGuiApp(){
        super();

        //Set basic frame params  //from javax.swing
        setSize(WIDTH, HEIGHT);
        // setTitle("Mouse Demo");
        // setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout(5,5));
        //Main panel -> from java.awt
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel jp = new W9_Class_Code1();
        add(jp);

        setVisible(true);
        setResizable(false);
        
    }

    public static void main(String[] args){
        GenericGuiApp n = new GenericGuiApp();
    }

}