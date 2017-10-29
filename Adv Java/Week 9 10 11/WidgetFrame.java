import java.awt.*;
import javax.swing.*;

public class WidgetFrame extends JFrame{
    //Use for week 9 homework
    public static final int WIDTH   = 500;
    public static final int HEIGHT  = 500;

    public WidgetFrame(){
        super();

        //Set basic frame params  //from javax.swing
        setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());


        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel jp1 = new Header();
        this.add(jp1, BorderLayout.NORTH);

        JPanel jp2 = new MakeModel();
        this.add(jp2, BorderLayout.WEST);

        this.setVisible(true);
        //setResizable(false);
        
    }

    public static void main(String[] args){
        WidgetFrame n = new WidgetFrame();
    }
}