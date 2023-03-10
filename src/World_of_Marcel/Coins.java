package World_of_Marcel;

import javax.swing.*;
import java.awt.*;

public class Coins extends JFrame
{
    public Coins(String name)
    {
     super(name);
//     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setMinimumSize(new Dimension(260,100));
    setLayout(new BorderLayout());
    JLabel jLabel=new JLabel("Ai gasit 500 de banuti!");
    ImageIcon imageIcon=new ImageIcon("src\\World_of_Marcel\\coin.png");
    Image image=imageIcon.getImage();
    Image image1=image.getScaledInstance(50,50,Image.SCALE_FAST);
    imageIcon=new ImageIcon(image1);
    setIconImage(image1);
    add(new JLabel(imageIcon),BorderLayout.NORTH);
    add(jLabel,BorderLayout.SOUTH);
    pack();
    show();
    }
}

