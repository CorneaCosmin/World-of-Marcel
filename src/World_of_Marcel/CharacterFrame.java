package World_of_Marcel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class CharacterFrame extends JFrame
{
    int numberCharacter;
    public CharacterFrame(String name, int numberAccount, List<Account> accounts, LinkedList<LinkedList<String>> stories)
    {
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300,100));
        ImageIcon imageIcon=new ImageIcon("src\\World_of_Marcel\\1200px-WOM_Chile_logo.svg.png");
        Image image=imageIcon.getImage();
        setIconImage(image);
        Vector<String> characters=new Vector<String>();
        for(int i=0;i<accounts.get(numberAccount).characters.size();i++)
            characters.add(accounts.get(numberAccount).characters.get(i).name);
        JComboBox jList=new JComboBox(characters);
        jList.setBounds(5,5,10,10);
        JPanel info=new JPanel();
        JPanel panel1=new JPanel();
        panel1.add(new JLabel("Name"));
        JTextField jt1=new JTextField(20);
        panel1.add(jt1);
        JPanel panel2=new JPanel();
        panel2.add(new JLabel("Level"));
        JTextField jt2=new JTextField(20);
        panel2.add(jt2);
        JPanel panel3=new JPanel();
        panel3.add(new JLabel("Experience"));
        JTextField jt3=new JTextField(20);
        panel3.add(jt3);
        info.add(panel1);
        info.add(panel2);
        info.add(panel3,BorderLayout.CENTER);
        jList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jList.getSelectedItem()==null)
                    return;
                for(int i=0;i<characters.size();i++) {
                    if (jList.getSelectedItem().toString().equals(accounts.get(numberAccount).characters.get(i).name))
                    {
                        numberCharacter=i;
                        String level=Integer.toString(accounts.get(numberAccount).characters.get(i).level);
                        String experience=Integer.toString(accounts.get(numberAccount).characters.get(i).experience);
                        jt1.setText(accounts.get(numberAccount).characters.get(i).getClass().getSimpleName());
                        jt2.setText(level);
                        jt3.setText(experience);
                    }
                }
            }
        });
        add(jList,BorderLayout.WEST);
        add(info,BorderLayout.EAST);
        JButton jb=new JButton("Choose");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jList.getSelectedItem()==null)
                    return;
                dispose();
                Random random=new Random();
                int length=random.nextInt(8-3)+3;
                int width=random.nextInt(9-5)+5;
                int startOx=random.nextInt(length);
                int startOy=random.nextInt(width);
                Cell currentCell=new Cell(startOx, startOy, new CellElement() {
                    @Override
                    public char toCharacter() {
                        return 'N';
                    }
                });
                currentCell.visited=true;
                Grid grid=Grid.generateMap(length,width,accounts.get(numberAccount).characters.get(numberCharacter),currentCell,startOx,startOy);
                grid.setCurrent(grid.get(startOx).get(startOy));
                grid.addStories(stories);
                GameFrame gameFrame=new GameFrame("World of Marcel",accounts.get(numberAccount).characters.get(numberCharacter),grid);
            }
        });
        add(jb,BorderLayout.SOUTH);
        pack();
        show();
    }
}
