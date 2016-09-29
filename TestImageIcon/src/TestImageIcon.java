import javax.swing.*;
import java.awt.*;

public class TestImageIcon extends JApplet {

  private ImageIcon caIcon = 
    new ImageIcon(this.getClass().getResource("image/ca.gif"));
  private ImageIcon myIcon = 
    new ImageIcon(this.getClass().getResource("image/my.jpg"));
  private ImageIcon frIcon = 
    new ImageIcon(this.getClass().getResource("image/fr.gif"));
  private ImageIcon ukIcon = 
    new ImageIcon(this.getClass().getResource("image/uk.gif"));
  
  private JPanel p1 = new JPanel();

  public TestImageIcon() {
    p1.setLayout(new GridLayout(2, 2, 5, 5));
    p1.add(new JLabel(caIcon));
    p1.add(new JLabel(myIcon));
    p1.add(new JButton(frIcon));
    p1.add(new JButton(ukIcon));
	add(p1);
  }
}
