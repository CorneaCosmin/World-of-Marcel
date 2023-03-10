package World_of_Marcel;

import javax.swing.*;
import java.awt.*;

public class NoAbility extends JFrame
{
    public NoAbility(String name)
    {
        super(name);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(260,100));
        setLayout(new BorderLayout());
        JLabel jLabel=new JLabel("Caracterul nu are aceasta abilitate sau suficienta mana!");
        ImageIcon imageIcon=new ImageIcon("src\\World_of_Marcel\\Screenshot 2022-01-10 193508.png");
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
