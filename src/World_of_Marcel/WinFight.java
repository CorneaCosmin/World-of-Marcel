package World_of_Marcel;

import javax.swing.*;
import java.awt.*;

public class WinFight extends JFrame
{
    public WinFight(String name)
    {
        setMinimumSize(new Dimension(260,100));
        setLayout(new BorderLayout());
        JLabel jLabel=new JLabel("Ai invins inamicul!");
        ImageIcon imageIcon=new ImageIcon("src\\World_of_Marcel\\winfight.png");
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
