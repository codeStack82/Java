 /*
*   Tyler Hunt
*   Advanved C++
*   OCCC Fall 2017
*   Due: 10/29/17
*   Details: TJH_CarWidget
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

public class TJH_CarWidget extends JPanel implements MouseListener, MouseMotionListener{

	String[] carModels = {"BMW", "Lamborghini", "McLaren", "Ferrari"};
	String[] bmwModels = {"5 series", "7 series", "X5 Series", "4 Series"};
	String[] mcLarenModels = {"570S", "640S", "720S"};	
	String[] lamborghiniModels = {"Aventador", "Huracan", "Countach", "Gallardo"};
	String[] ferrariModels = {"F430", "F355", "F355 GTB"};

	JComboBox carMake, carModel;
	JLabel carMakeLabel, carModelLabel;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 400;
	 
	JLabel titleLabel; //Only declaring
	JLabel xCoord, yCoord;
	JButton leftButton, middleButton, rightButton;
	JLabel insuranceLabel;
	JCheckBox insuranceChkBox;
	JLabel colorLabel;
	JRadioButton redColorBtn, blueClrBtn, greenClrBtn;
	JTextArea instructionsText;
	JLabel instructionsLabel;
	JButton buildBtn;
	JLabel imageLabel;
	ImageIcon imageIcon;
	Color c;

	TJH_CarWidget(){
		setLayout(null);
		
		imageIcon = new ImageIcon("bmw_500_series.jpg");
		
		imageLabel = new JLabel("", imageIcon, JLabel.CENTER);
		add(imageLabel);
		imageLabel.setBounds(300, 50, 100, 100);
		this.carMakeLabel = new JLabel("Make: ");
	 
		add(this.carMakeLabel);
		this.carMakeLabel.setBounds(10, 50, 80, 20);
		this.carMake = new JComboBox(carModels); 
		add(this.carMake);
		this.carMake.setBounds(90, 50, 150, 20);
		this.carMake.addItemListener(this.comboBoxListener);
		titleLabel = new JLabel("Insert graphic here");
		
		this.carModelLabel = new JLabel("Model: ");
		this.carModelLabel.setBounds(10, 80, 80, 20);
		this.add(carModelLabel);
		this.carModel = new JComboBox(this.lamborghiniModels);
		this.carModel.addItemListener(this.comboBoxListener);
		this.carModel.setBounds(90, 80, 150, 20);
		this.add(this.carModel);
		
		
		this.insuranceLabel = new JLabel("Insurance:");
		this.add(this.insuranceLabel);
		this.insuranceLabel.setBounds(10, 110, 80, 20);
		
		this.insuranceChkBox = new JCheckBox();
		this.add(this.insuranceChkBox);
		this.insuranceChkBox.setBounds(90, 110, 120, 20);
		 
		//titleLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		
		this.colorLabel = new JLabel("Color:");
		this.add(this.colorLabel);
		this.colorLabel.setBounds(10, 140, 80, 20);
		
		 this.redColorBtn = new JRadioButton("Red");
		 this.redColorBtn.setBounds(90, 140, 50, 20);
		 this.add(redColorBtn);
		 
		 this.greenClrBtn = new JRadioButton("Green");
		 this.greenClrBtn.setBounds(150, 140, 60, 20);
		 this.add(greenClrBtn);
		 
		 this.blueClrBtn = new JRadioButton("Blue");
		 this.blueClrBtn.setBounds(210, 140, 50, 20);
		 this.add(blueClrBtn);
		
		 ButtonGroup bg = new ButtonGroup();
		 bg.add(this.redColorBtn);
		 bg.add(this.greenClrBtn);
		 bg.add(this.blueClrBtn);
		 
		 this.instructionsLabel = new JLabel("Instructions");
		 this.instructionsLabel.setBounds(10, 160, 80, 20);;
		 this.instructionsText = new JTextArea();
		 this.instructionsText.setBounds(10, 180, 300, 150);
		 this.add( instructionsLabel);
		 this.add(this.instructionsText);
		 
		 this.buildBtn = new JButton( "Build my Car");
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
			System.out.println("Change");
			if(source == carMake)
			{
				String make = source.getSelectedItem().toString();
				switch(make.toLowerCase())
				{
					case "lamborghini":
					{
						carModel.removeAll();
						carModel.setModel(new DefaultComboBoxModel(lamborghiniModels));
						break;
					}
					case "bmw":
					{
						carModel.setModel(new DefaultComboBoxModel(bmwModels));
						break;
					}
					case "mclaren":
					{
						carModel.setModel(new DefaultComboBoxModel(mcLarenModels));
						break;
					}
					case "ferrari":
					{
						carModel.setModel(new DefaultComboBoxModel(ferrariModels));
						break;
					}
				}

			}
			else if(source == carModel)
			{
				String model = carModel.getSelectedItem().toString();
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
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		 
		if(arg0.getSource() == this.buildBtn)
		{
			if(instructionsText.getText().length() < 10)
			{
				JOptionPane.showMessageDialog(getParent(), "Please give atleast 10 character long instruction.");
				return;
			}
			if(!this.blueClrBtn.isSelected() && !this.greenClrBtn.isSelected() && !this.redColorBtn.isSelected())
			{
				JOptionPane.showMessageDialog(getParent(), "PLease select a color");
				return;
			}
			String result = "";
			result = "You have chosen a " + this.carMake.getSelectedItem().toString() 
					+ " model '" + this.carModel.getSelectedItem().toString() + "'"
					+ ", insurance " + (this.insuranceChkBox.isSelected() ? " yes" : "no")
					+ ", color " + (this.blueClrBtn.isSelected() ? " blue " : ( this.greenClrBtn.isSelected() ? " green " : " red"))
					+ ", additional instructions: '"  + this.instructionsText.getText() + "'";
			JOptionPane.showMessageDialog(getParent(), result);
		}

	}
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

	private String getImage(String carModel)
	{
		String model = "";
		switch(carModel)
		{
			case "5 series":
			{
				
				return "bmw_500_series.jpg";
				 
			}
			case "7 series":
			{
				return "7_series.jpg";
			 
			}
			case "X5 Series":
			{
				return "x5.jpg";
				
			}
			case "4 Series":
			{
				return "4.jpg";
				 
			}
			case "570S":
			{
				return "570S.jpg";
			}
			case "640S":
			{
				return "640S.jpg";
			}
			case "720S":
			{
				return "720S.jpg";
			}
			case "Aventador":
			{
				return "Aventador.jpg";
			}
			case "Huracan":
			{
				return "Huracan.jpg";
			}
			case "Countach":
			{
				return "Countach.jpg";
			}
			case "Gallardo":
			{
				return "Gallardo.jpg";
			}
			case "F430":
			{
				return "F430.jpg";
			}
			case "F355":
			{
				return "F355.jpg";
			}
			case "F355 GTB":
			{
				return "F355 GTB.jpg";
			}
		}
		return model;
	}

}
