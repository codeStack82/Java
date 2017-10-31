 /*
*   Tyler Hunt
*   Advanved C++
*   OCCC Fall 2017
*   Due: 10/29/17
*   Details: TJH_MapWidget
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
 

public class TJH_MapWidget extends JPanel implements MouseListener, MouseMotionListener{

	  JLabel latLabel, lngLabel, headerLabel, detailsLabel;
	  JTextField latInput, lngInput;
	  JButton applyButton;
	  JLabel imageLabel = null;
	  ImageIcon imageIcon;
	  JPanel parent;

	TJH_MapWidget(){
       	parent = this;
		setLayout(null);
		
		headerLabel = new JLabel("Google Map Widget");
		headerLabel.setBounds(10, 10, 300, 20);
		headerLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		add(headerLabel);

		latLabel = new JLabel("Lat: ");
		latLabel.setBounds(10, 40, 40, 20);
		add(latLabel);
		
		latInput = new JTextField("32.2" );
		latInput.setBounds(60, 40, 50, 20);
		add(latInput);
		
		lngLabel = new JLabel("Lng: ");
		lngLabel.setBounds(120, 40, 40, 20);
		add(lngLabel);
		
		lngInput = new JTextField( "-97.7");
		lngInput.setBounds(170, 40, 50, 20);
		add(lngInput);
		
		this.applyButton = new JButton("Apply");
		this.add(applyButton);
		this.applyButton.setBounds(230, 40, 90, 30);
		imageLabel= new JLabel();
		this.add(imageLabel);
		//loadMap();

		detailsLabel = new JLabel("Details: Enter lat/long and press \'Apply\'");
		detailsLabel.setBounds(10, 70, 300, 20);
		detailsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		add(detailsLabel);
	 
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
		 JFrame test = new JFrame("Google Maps");
		// if(imageLabel != null);
		
			parent.remove(imageLabel);
			// TODO Auto-generated method stub
			try {
	            String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center=" + latInput.getText() + ","+ lngInput.getText() +"&zoom=11&size=612x612&scale=2&maptype=roadmap";
	            String destinationFile = "image.jpg";
	            String str = destinationFile;
	            URL url = new URL(imageUrl);
	            InputStream is = url.openStream();
	            OutputStream os = new FileOutputStream(destinationFile);

	            byte[] b = new byte[2048];
	            int length;

	            while ((length = is.read(b)) != -1) {
	                os.write(b, 0, length);
	            }

	            is.close();
	            os.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	             
	        }
			catch (Exception e) {
				e.printStackTrace();
				}
			test.add(new JLabel(new ImageIcon((new ImageIcon("image.jpg")).getImage().getScaledInstance(630, 600,
	                java.awt.Image.SCALE_SMOOTH))));
			test.setVisible(true);
	        test.pack();
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
