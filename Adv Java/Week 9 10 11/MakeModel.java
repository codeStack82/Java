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

public class MakeModel extends JPanel{
	//GLOBAL VARIABLES
	public static final int WIDTH    = 500;
	public static final int HEIGHT   = 35;
	JPanel northPanel, centerPanel, southPanel; //Only declaring
	JLabel titleLabel; //Only declaring
    JComboBox makeComboBox, modelComboBox;

	Color c;
	
	public MakeModel() {
		super();

		titleLabel = new JLabel("Detail");
		titleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		northPanel.add(titleLabel);
        northPanel.setBackground(Color.RED);
		add(northPanel, BorderLayout.NORTH);

        String makeInfo[] = {"Choose Make","Toyota", "Honda"};
        makeComboBox = new JComboBox(makeInfo);

        String modelInfo[] = {"Choose Model","Tundra","Tacoma","Highlander","Ridgline","Pilot", "Civic"};
        modelComboBox = new JComboBox(modelInfo);

        northPanel.add(makeComboBox);
        northPanel.add(modelComboBox);

		setVisible(true); //Make visible needs to be after everything so everything can be seen
	}
	
	public static void main (String[] args) { 
		MakeModel sales = new MakeModel(); //invoke the constructor      
	}

    // private class myHandler implements ActionListener{
    //     public void actionPerformed(ActionEvent e){
    //         String str = "";
    //         if(e.getSource() == makeComboBox){
    //             System.out.println(event.getActionCommand());
    //         }
    //     }

    // }
}