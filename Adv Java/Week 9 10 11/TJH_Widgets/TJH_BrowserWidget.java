 /*
*   Tyler Hunt
*   Advanved C++
*   OCCC Fall 2017
*   Due: 10/29/17
*   Details: TJH_BrowserWidget
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.*; 
import javax.swing.*;
 

public class TJH_BrowserWidget extends JPanel implements MouseListener, MouseMotionListener{

	  JLabel urlLabel, lngLabel, headerLabel, detailsLabel;
	  JTextField urlInput, lngInput;
	  JButton applyButton;
	  JLabel imageLabel = null;
	  ImageIcon imageIcon;
	  JPanel parent;

	TJH_BrowserWidget()
	{
        parent = this;
		setLayout(null);

		headerLabel = new JLabel("Browser Widget");
		headerLabel.setBounds(10, 5, 300, 20);
		headerLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		add(headerLabel);
		
		urlLabel = new JLabel("Enter url: ");
		urlLabel.setBounds(10, 30, 70, 20);
		add(urlLabel);
		
		urlInput = new JTextField("http://www.google.com" );
		urlInput.setBounds(90, 30, 200, 20);
		add(urlInput);
		
		detailsLabel = new JLabel("Details: Enter url and press \'Apply\'");
		detailsLabel.setBounds(10, 60, 300, 20);
		detailsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		add(detailsLabel);
		
		 
		this.applyButton = new JButton("Apply");
		this.add(applyButton);
		this.applyButton.setBounds(290, 30, 70, 30);
		imageLabel= new JLabel();
		this.add(imageLabel);
		//loadMap();
		
		applyButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				loadMap();
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				

		      
			}
		});
		if(""=="") return;

		// show the GUI window
		setVisible(true);			
	}
	private void loadMap()
	{
		JEditorPane website = null;
		 try {
		    website = new JEditorPane(urlInput.getText());
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		website.setEditable(false);

		JFrame frame = new JFrame();
		frame.add(new JScrollPane(website));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();

	}
	ItemListener comboBoxListener = new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			JComboBox source = (JComboBox) e.getSource();
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
		 
	}

	private String getImage(String img)
	{
		return img + ".jpg";
	}

}
