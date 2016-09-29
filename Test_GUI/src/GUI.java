import javax.swing.*;
public class GUI{
	public static void main(String[] args){
		JFrame frame1  = new JFrame("Test Frame");
		JButton btn1 = new JButton("OK");
		JTextField text1 = new JTextField("test",0);
		
			frame1.setSize(300,200);
			frame1.setVisible(true); //make visable
			frame1.setLocationRelativeTo(null); //center screen
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit on close
			
			frame1.add(btn1);
			frame1.add(text1);
			
	}
}
