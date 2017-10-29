//Zabrina Antry
//OCCC Fall 2017
//ClassCode

//Works
import java.awt.*;  //For Container
import javax.swing.*;
import java.awt.event.*; //Event sub library!!!

//4 widgets - Maps / videos / or other media
//Naming TJH, zip folder and submit

//Need to this class name for each widget  //mousedemopanel

public class Header extends JPanel{
	//GLOBAL VARIABLES
	public static final int WIDTH    = 500;
	public static final int HEIGHT   = 35;
	JPanel northPanel, centerPanel, southPanel;//Only declaring
	JLabel titleLabel; //Only declaring
	JLabel xCoord, yCoord;
	JButton leftButton, middleButton, rightButton;
	
	Color c;
	
	public Header() {
		super();

		titleLabel = new JLabel("Car Sales Widget");
		titleLabel.setFont(new Font("Arial", Font.PLAIN, 28));
		northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		northPanel.add(titleLabel);
        //northPanel.setBackground(Color.RED);
		add(northPanel, BorderLayout.NORTH);
		
		setVisible(true); //Make visible needs to be after everything so everything can be seen
	}
	
	public static void main (String[] args) { 
		Header sales = new Header(); //invoke the constructor
	}

}