import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

class BaseFrame extends JFrame {

  // Constructor:
  public BaseFrame() {
		//this.setTitle("Hunt Week Java GUI JFrame");
		this.setSize(400,400); 				// default size is 500,500
		this.setLocation(200,200); 		// default is 200, 200 (top left corner)

		// Add Panels
		Container contentPane = getContentPane(); 
		contentPane.add(new TJH_CarWidget());
		// contentPane.add(new TJH_PizzaWidget());
		// contentPane.add(new TJH_MapWidget());
		// contentPane.add(new TJH_BrowserWidget());
		
		// Window Listeners		
		addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				} 
		} );
  } 

  public static void main(String[] args) {
    JFrame f = new BaseFrame();
    f.show();
  } 
} 

