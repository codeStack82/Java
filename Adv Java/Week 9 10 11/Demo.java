//Zabrina Antry
//OCCC Fall 2017
//Mouse Demo


import java.awt.*;  //For Container
import javax.swing.*;
import java.awt.event.*; //Event sub library!!!

public class Demo extends JFrame implements MouseListener, MouseMotionListener{
	//GLOBAL VARIABLES
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	JPanel northPanel, centerPanel, southPanel;//Only declaring
	JLabel titleLabel; //Only declaring
	JLabel xCoord, yCoord;
	JButton leftButton, middleButton, rightButton;
	
	Color c;
	
	public Demo() {
		super();
		setSize(WIDTH, HEIGHT); //Setting size
		setTitle("My Mouse Demo"); //Title
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); //Always make your program exit!!!
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout()); //Creating border layout
		
		titleLabel = new JLabel ("Insert graphic here");
		titleLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		northPanel.add(titleLabel);
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		
		//X Y 
		xCoord = new JLabel("X: ");
		yCoord = new JLabel("Y: ");
		centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		centerPanel.add(xCoord);
		centerPanel.add(yCoord);
		contentPane.add(centerPanel, BorderLayout.CENTER);
		xCoord.setFont(new Font("Arial", Font.PLAIN, 40));
		yCoord.setFont(new Font("Arial", Font.PLAIN, 40));
		
		
		//Buttons
		leftButton = new JButton("LEFT");
		middleButton = new JButton("CENTER");
		rightButton = new JButton("RIGHT");
		leftButton.setFont(new Font("Arial", Font.PLAIN, 40));
		middleButton.setFont(new Font("Arial", Font.PLAIN, 40));
		rightButton.setFont(new Font("Arial", Font.PLAIN, 40));
		
		c = leftButton.getBackground();
		
		southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		southPanel.add(leftButton);
		southPanel.add(middleButton);
		southPanel.add(rightButton);
		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		//Add mouse motion listener
		addMouseListener(this);
		leftButton.addMouseListener(this);
		middleButton.addMouseListener(this);
		rightButton.addMouseListener(this);
		
		addMouseMotionListener(this); //needed for the X and Y
		
		setVisible(true); //Make visible needs to be after everything so everything can be seen
	}
	
	public static void main (String [] args) { 
		Demo md = new Demo(); //invoke the constructor
	}
	
	//MouseListener Methods
	@Override
	public void mouseEntered(MouseEvent me) {
		if (me.getSource() == leftButton) {
			leftButton.setBackground(Color.BLUE);
		}
		if (me.getSource() == middleButton) {
			middleButton.setBackground(Color.BLUE);
		}
		if (me.getSource() == rightButton) {
			rightButton.setBackground(Color.BLUE);
		}
	}
	
	@Override
	public void mouseExited(MouseEvent me) {
		if (me.getSource() == leftButton) {
			leftButton.setBackground(c);
		}
		if (me.getSource() == middleButton) {
			middleButton.setBackground(c);
		}
		if (me.getSource() == rightButton) {
			rightButton.setBackground(c);
		}
	}
	
	@Override
	public void mousePressed(MouseEvent me) {
		if (me.getButton() == MouseEvent.BUTTON1) {
			leftButton.setBackground(Color.RED);
		}
		if (me.getButton()== MouseEvent.BUTTON2) {
			middleButton.setBackground(Color.RED);
		}
		if (me.getButton() == MouseEvent.BUTTON3) {
			rightButton.setBackground(Color.RED);
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent me) {
		if (me.getButton() == MouseEvent.BUTTON1) {
			leftButton.setBackground(c);
		}
		if (me.getButton()== MouseEvent.BUTTON2) {
			middleButton.setBackground(c);
		}
		if (me.getButton() == MouseEvent.BUTTON3) {
			rightButton.setBackground(c);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent me) {
		
	}
	
	//MouseMotionListener methods
	@Override
	public void mouseDragged(MouseEvent me) {}
	
	@Override
	public void mouseMoved(MouseEvent me) {
		xCoord.setText("X: " + me.getX());
		yCoord.setText("Y: " + me.getY());
		
	}
	
}
