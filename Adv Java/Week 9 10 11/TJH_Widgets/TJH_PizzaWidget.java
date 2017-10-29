 /*
*   Tyler Hunt
*   Advanved C++
*   OCCC Fall 2017
*   Due: 10/29/17
*   Details: TJH_PizzaWidget
*/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class TJH_PizzaWidget extends JPanel implements MouseListener, MouseMotionListener{

	String[] pizaStyles = {"New York Style", "Neapolitan"};
	String[] nyFlavs = {"Cheese Pizza", "Pepperoni", "Tikka"};
	String[] neopoli= {"Fajita", "Marshal", "Takuta"};
	JComboBox pizzaStyle, pizzaFlav;
	JLabel styleLabel, flavourLabel;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 400;
	 
	JLabel titleLabel; //Only declaring
	JLabel xCoord, yCoord;
	JButton leftButton, middleButton, rightButton;
	JLabel extraCheeseLabel;
	JCheckBox extraCheeseChk;
	JLabel sauceLabel;
	JRadioButton hot, extraExtraHot, extraHot;
	JTextArea instructionsText;
	JLabel instructionsLabel;
	JButton buildBtn;
	JLabel imageLabel;
	ImageIcon imageIcon;
	Color c;

	TJH_PizzaWidget(){
		setLayout(null);
		
		imageIcon = new ImageIcon("Pepperoni.jpg");
		
		imageLabel = new JLabel("", imageIcon, JLabel.CENTER);
		add(imageLabel);
		imageLabel.setBounds(300, 50, 100, 100);
		this.styleLabel = new JLabel("Style: ");
	 
		add(this.styleLabel);
		this.styleLabel.setBounds(10, 50, 80, 20);
		this.pizzaStyle = new JComboBox(pizaStyles); 
		add(this.pizzaStyle);
		this.pizzaStyle.setBounds(90, 50, 150, 20);
		this.pizzaStyle.addItemListener(this.comboBoxListener);
		 
		this.flavourLabel = new JLabel("Flavour: ");
		this.flavourLabel.setBounds(10, 80, 80, 20);
		this.add(flavourLabel);
		this.pizzaFlav = new JComboBox(this.nyFlavs);
		this.pizzaFlav.addItemListener(this.comboBoxListener);
		this.pizzaFlav.setBounds(90, 80, 150, 20);
		this.add(this.pizzaFlav);
		
		
		this.extraCheeseLabel = new JLabel("Extra Cheese:");
		this.add(this.extraCheeseLabel);
		this.extraCheeseLabel.setBounds(10, 110, 80, 20);
		
		this.extraCheeseChk = new JCheckBox();
		this.add(this.extraCheeseChk);
		this.extraCheeseChk.setBounds(90, 110, 120, 20);
		 
		//titleLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		
		this.sauceLabel = new JLabel("Sauce:");
		this.add(this.sauceLabel);
		this.sauceLabel.setBounds(10, 140, 80, 20);
		
		 this.hot = new JRadioButton("Hot");
		 this.hot.setBounds(90, 140, 50, 20);
		 this.add(hot);
		 
		 this.extraHot = new JRadioButton("Extra Hot");
		 this.extraHot.setBounds(150, 140, 120, 20);
		 this.add(extraHot);
		 
		 this.extraExtraHot = new JRadioButton("Extreme Hot");
		 this.extraExtraHot.setBounds(150, 160, 200, 20);
		 this.add(extraExtraHot);
		
		 ButtonGroup bg = new ButtonGroup();
		 bg.add(this.hot);
		 bg.add(this.extraHot);
		 bg.add(this.extraExtraHot);
		 
		 this.instructionsLabel = new JLabel("Instructions");
		 this.instructionsLabel.setBounds(10, 160, 80, 20);;
		 this.instructionsText = new JTextArea();
		 this.instructionsText.setBounds(10, 180, 300, 150);
		 this.add( instructionsLabel);
		 this.add(this.instructionsText);
		 
		 this.buildBtn = new JButton( "Build my Pizza!");
		 this.buildBtn.setBounds(30, 350, 120, 20);
		 this.add(this.buildBtn);
		 this.buildBtn.addMouseListener(this);
		 addMouseMotionListener(this); //needed for the X and Y
		
		setVisible(true); //Make visible needs to be after everything so everything can be seen
	}
	ItemListener comboBoxListener = new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			JComboBox source = (JComboBox) e.getSource();
			
			if(source == pizzaStyle)
			{
				String make = source.getSelectedItem().toString();
				System.out.println(make);
				switch(make)
				{
					case "New York Style":
					{
						pizzaFlav.removeAll();
						pizzaFlav.setModel(new DefaultComboBoxModel(nyFlavs));
						break;
					}
					case "Neapolitan":
					{
						pizzaFlav.setModel(new DefaultComboBoxModel(neopoli));
						break;
					}
					 
				}

			}
			else if(source == pizzaFlav)
			{
				String model = pizzaFlav.getSelectedItem().toString();
				System.out.println(model);
				remove(imageLabel);
				imageIcon = new ImageIcon(getImage(model));
				imageLabel = new JLabel("", imageIcon, JLabel.CENTER);
				add(imageLabel);
				imageLabel.setBounds(300, 50, 100, 100);
			}
		}
	};
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		 
		if(arg0.getSource() == this.buildBtn)
		{
			if(instructionsText.getText().length() < 10)
			{
				JOptionPane.showMessageDialog(getParent(), "Please give at least 10 character long instruction.");
				return;
			}
			if(!this.extraExtraHot.isSelected() && !this.extraHot.isSelected() && !this.hot.isSelected())
			{
				JOptionPane.showMessageDialog(getParent(), "PLease select a sauce");
				return;
			}
			String result = "";
			result = "You have chosen a " + this.pizzaStyle.getSelectedItem().toString() 
					+ " flavour '" + this.pizzaFlav.getSelectedItem().toString() + "'"
					+ ", extra cheese " + (this.extraCheeseChk.isSelected() ? " yes" : "no")
					+ ", sauce " + (this.extraExtraHot.isSelected() ? " Extreme Hot " : ( this.extraHot.isSelected() ? " Extra Hot " : "  hot"))
					+ ", additional instructions: '"  + this.instructionsText.getText() + "'";
			JOptionPane.showMessageDialog(getParent(), result);
		}

	}
	private String getImage(String piza)
	{
		return piza + ".jpg";
	}

}
