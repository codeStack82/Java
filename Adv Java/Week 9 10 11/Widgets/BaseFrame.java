import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

class BaseFrame extends JFrame {

  // Constructor:
  public BaseFrame() {
		this.setTitle("Hunt Week Java GUI JFrame");
		this.setSize(500,500); 				// default size is 500,500
		this.setLocation(200,200); 		// default is 200, 200 (top left corner)

		// Add Panels
		Container contentPane = getContentPane();
		contentPane.add(new Car_Widget());
		this.add(new Car_Widget());

		// Window Listeners				// window close 
		addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				} 
		} );
  } 

  public static void main(String[] args) {
    //Create main frame
		JFrame f = new BaseFrame();
					f.show();
					
    Car_Widget cw = new Car_Widget();
		cw.show();
    
  } 
} 

