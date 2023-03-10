package World_of_Marcel;

import javax.swing.*;
import java.awt.*;

public class WinFrame extends JFrame
{
    public WinFrame(Character character)
    {
        super("Ai terminat jocul!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1830,830));
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new GridLayout(6,1));
        ImageIcon imageIcon=new ImageIcon("src\\World_of_Marcel\\youwin.png");
        Image image=imageIcon.getImage();
        Image image1=image.getScaledInstance(100,100,Image.SCALE_FAST);
        imageIcon=new ImageIcon(image1);
        setIconImage(image1);
        jPanel.add(new JLabel(imageIcon));
        jPanel.add(new JLabel("Nume: "+character.name+", "+character.getClass().getSimpleName()));
        jPanel.add(new JLabel("Level: "+character.level));
        jPanel.add(new JLabel("Experienta: "+character.experience));
        jPanel.add(new JLabel("Monede: "+character.inventory.coins));
        jPanel.add(new JLabel("Numar de inamici infranti: "+character.nrEnemies));
        add(jPanel,BorderLayout.CENTER);
        add(new JLabel(),BorderLayout.EAST);
        add(new JLabel(),BorderLayout.WEST);
        pack();
        show();
    }
}
