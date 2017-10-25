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
        this.setTitle("Mouse Demo");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(5,5));
        //Main panel -> from java.awt
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel jp = new CarSales();
        this.add(jp);

        this.setVisible(true);
        setResizable(false);
        
    }

    public static void main(String[] args){
        WidgetFrame n = new WidgetFrame();
    }

}