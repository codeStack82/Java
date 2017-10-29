import java.awt.event.*;
import javax.swing.*;

class SalesPanel extends JPanel {

	JPanel northPanel, centerPanel, southPanel; 
	JLabel titleLabel;
	JComboBox makeComboBox, modelComboBox;
	JRadioButton manual, automatic;
	JRadioButton air, power, cd, wheels, paint; 
	JButton exit, calculate;
	JTextBox downPayment;
	JTextArea description;


  // Constructor:
  public SalesPanel() {
		this.setLayout(new BorderLayout(5,5))
		this.setSize(500,500); 				// default size is 500,500

		//Create Header label - north
		titleLabel = new JLabel("Detail");
		titleLabel.setFont(new Font("Arial", Font.PLAIN, 12));

		//Create cbo Panel - east
		String makeInfo[] = {"Choose Make","Toyota", "Honda"};
		String modelInfo[] = {"Choose Model"};
		makeComboBox = new JComboBox(makeInfo);
		modelComboBox = new JComboBox(modelInfo);

		// Create TextBox - center
		downPayment = new JTextBox();
			group.add(downPayment);

		// Create Radio buttons - center
		ButtonGroup group1 = new ButtonGroup();
			manual = new JRadioButton("Manual");
			automatic = new JRadioButton("Automatic");
				group1.add(manual);
				group1.add(automatic);
				group1.setLayout(new FlowLayout());

		// Create vertical panel for radio buttons
		JPanel transmissionPanel = new JPanel(new GridLayout(2,1));
			transmissionPanel.add(manual);
			transmissionPanel.add(automatic);
			pack();
		//

		// Create Radio buttons - center
		ButtonGroup group2 = new ButtonGroup();
			air = new JRadioButton("Air Conditioning");
			power = new JRadioButton("Power Windows");
			cd = new JRadioButton("CD Player");
			wheels = new JRadioButton("Rally Wheels");
			paint = new JRadioButton("Two-Tone Paint");
			group2.add(air);
			group2.add(power);
			group2.add(cd);
			group2.add(wheels);
			group2.add(paint);
	
		// Create vertical panel for radio buttons
		JPanel accessoriesPanel = new JPanel();
			accessoriesPanel.setLayout(new GridLayout(5,1));
			accessoriesPanel.add(air);
			accessoriesPanel.add(power);
			accessoriesPanel.add(cd);
			accessoriesPanel.add(wheels);
			accessoriesPanel.add(paint);
			pack();
		//	
		
		// Create buttons - south	
		ButtonGroup group3 = new ButtonGroup();
			exit = new JButton("Exit");
			calculate = new JButton("Calculate");
				group3.add(exit);
				group3.add(calculate);

		// Create textarea - south	
		description = new JTextArea("Add details here....",5, 50);
			group3.add(description);
		//
		
		JPanel buttonPanel = new JPanel(new FlowPanel());
			buttonPanel.add(exit);
			buttonPanel.add(calculate);
			buttonPanel.add(description);
		 //

		// North Panel
		northPanel.add(titleLabel);
		northPanel.add(makeComboBox);
		northPanel.add(modelComboBox);

		// Center Panel
		centerPanel.add(transmissionPanel);
		centerPanel.add(accessoriesPanel);

		// South Panel
		southPanel.add(exit);
		southPanel.add(calculate);
		southPanel.add(description);

		setVisible(true); 
	}

  public static void main(String[] args) {
    JPanel f = new SalesPanel();
  } 
} 

