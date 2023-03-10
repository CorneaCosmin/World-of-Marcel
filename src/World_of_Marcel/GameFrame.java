package World_of_Marcel;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameFrame extends JFrame
{
    JTextField jt3;
    JTextField jt4;
    JTextField jt5;
    JTextField jt6;
    JTextField jt14;
    JPanel jp;
    public GameFrame(String name,Character character,Grid grid)
    {
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1830,830));
        ImageIcon imageIcon=new ImageIcon("src\\World_of_Marcel\\1200px-WOM_Chile_logo.svg.png");
        Image image=imageIcon.getImage();
        setIconImage(image);

        String[] columns=new String[grid.width];
        for(int k=0;k< grid.width;k++)
        {
            columns[k]=new String();
            columns[k]="";
        }
        Object[][] table=new Object[grid.length][grid.width];
        int i,j;
        for(i=0;i<grid.length;i++)
            for(j=0;j< grid.width;j++)
            {
                if(i==grid.current.ox && j==grid.current.oy)
                {
                    ImageIcon imagePlayer=new ImageIcon("src\\World_of_Marcel\\character.png");
                    Image imageP=imagePlayer.getImage();
                    Image imageP1=imageP.getScaledInstance(75,75,Image.SCALE_FAST);
                    imagePlayer=new ImageIcon(imageP1);
                    table[i][j]=imagePlayer;
                }
                else if(grid.get(i).get(j).visited==false)
                {
                    ImageIcon imagePlayer=new ImageIcon("src\\World_of_Marcel\\question.png");
                    Image imageP=imagePlayer.getImage();
                    Image imageP1=imageP.getScaledInstance(75,75,Image.SCALE_FAST);
                    imagePlayer=new ImageIcon(imageP1);
                    table[i][j]=imagePlayer;
                }
                else if(grid.get(i).get(j).visited==true)
                {
                    if(grid.get(i).get(j).element.toCharacter()=='N')
                    {
                        ImageIcon imagePlayer=new ImageIcon("src\\World_of_Marcel\\empty.png");
                        Image imageP=imagePlayer.getImage();
                        Image imageP1=imageP.getScaledInstance(75,75,Image.SCALE_FAST);
                        imagePlayer=new ImageIcon(imageP1);
                        table[i][j]=imagePlayer;
                    }
                    if(grid.get(i).get(j).element.toCharacter()=='F')
                    {
                        ImageIcon imagePlayer=new ImageIcon("src\\World_of_Marcel\\finish.png");
                        Image imageP=imagePlayer.getImage();
                        Image imageP1=imageP.getScaledInstance(75,75,Image.SCALE_FAST);
                        imagePlayer=new ImageIcon(imageP1);
                        table[i][j]=imagePlayer;
                    }
                    if(grid.get(i).get(j).element.toCharacter()=='S')
                    {
                        ImageIcon imagePlayer=new ImageIcon("src\\World_of_Marcel\\shop.png");
                        Image imageP=imagePlayer.getImage();
                        Image imageP1=imageP.getScaledInstance(75,75,Image.SCALE_FAST);
                        imagePlayer=new ImageIcon(imageP1);
                        table[i][j]=imagePlayer;
                    }
                    if(grid.get(i).get(j).element.toCharacter()=='E')
                    {
                        ImageIcon imagePlayer=new ImageIcon("src\\World_of_Marcel\\enemy.png");
                        Image imageP=imagePlayer.getImage();
                        Image imageP1=imageP.getScaledInstance(75,75,Image.SCALE_FAST);
                        imagePlayer=new ImageIcon(imageP1);
                        table[i][j]=imagePlayer;
                    }
                }
            }
        DefaultTableModel model = new DefaultTableModel(table, columns);
        JTable map = new JTable(model)
        {
            public Class getColumnClass(int column) {
                return Icon.class;
            }
        };
        map.setRowHeight(95);
//        map.setGridColor(Color.white);
        JPanel story2=new JPanel();
        JLabel label=new JLabel("Povestea casutei: ");
        JTextField story1=new JTextField(50);
        story2.add(label);
        story2.add(story1);
        story2.setBackground(new Color(198,195,195));
        JPanel infoMoves=new JPanel();
        infoMoves.setLayout(new FlowLayout());
        JLabel move=new JLabel("Te-ai deplasat la: ");
        JTextField move1=new JTextField(30);
        JPanel movePanel=new JPanel();
        movePanel.add(move);
        movePanel.add(move1);
        JLabel where=new JLabel("Ai ajuns pe: ");
        JTextField where1=new JTextField(30);
        JPanel wherePanel=new JPanel();
        wherePanel.add(where);
        wherePanel.add(where1);
        movePanel.setBackground(new Color(198,195,195));
        wherePanel.setBackground(new Color(198,195,195));
        infoMoves.add(movePanel);
        infoMoves.add(wherePanel);
        infoMoves.add(story2);
        add(map);


        JPanel buttons=new JPanel();
        buttons.setLayout(new FlowLayout());
        JButton north=new JButton("North");
        JButton south=new JButton("South");
        JButton east=new JButton("East");
        JButton west=new JButton("West");


        JPanel jPanel=new JPanel();
        jPanel.setLayout(new FlowLayout());
        JPanel jp1=new JPanel();
        jp1.add(new JLabel("Name: "+character.name));
        jPanel.add(jp1);
        JPanel jp2=new JPanel();
        jp2.add(new JLabel("Character: "+character.getClass().getSimpleName()));
        jPanel.add(jp2);
        JPanel jp3=new JPanel();
        jt3=new JTextField("Level: "+character.level);
        jt3.setEditable(false);
        jt3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font fontJt3=new Font(jt3.getFont().getName(),Font.BOLD,jt3.getFont().getSize());
        jt3.setFont(fontJt3);
        jp3.add(jt3);
        jPanel.add(jp3);
        JPanel jp4=new JPanel();
        jt4=new JTextField("Experience: "+character.experience);
        jt4.setEditable(false);
        jt4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font fontJt4=new Font(jt4.getFont().getName(),Font.BOLD,jt4.getFont().getSize());
        jt4.setFont(fontJt4);
        jp4.add(jt4);
        jPanel.add(jp4);
        JPanel jp5=new JPanel();
        jt5=new JTextField("Life: "+character.currentLife);
        jt5.setEditable(false);
        jt5.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font fontJt5=new Font(jt5.getFont().getName(),Font.BOLD,jt5.getFont().getSize());
        jt5.setFont(fontJt5);
        jp5.add(jt5);
        jPanel.add(jp5);
        JPanel jp6=new JPanel();
        jt6=new JTextField("Mana: "+character.currentManna);
        jt6.setEditable(false);
        jt6.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font fontJt6=new Font(jt6.getFont().getName(),Font.BOLD,jt6.getFont().getSize());
        jt6.setFont(fontJt6);
        jp6.add(jt6);
        jPanel.add(jp6);
        JPanel jp14=new JPanel();
        jt14=new JTextField("Coins: "+character.inventory.coins);
        jt14.setEditable(false);
        jt14.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font fontJt14=new Font(jt14.getFont().getName(),Font.BOLD,jt14.getFont().getSize());
        jt14.setFont(fontJt14);
        jp14.add(jt14);
        jPanel.add(jp14);
        JPanel jp7=new JPanel();
        jp7.add(new JLabel("Fire: "+character.fire));
        jPanel.add(jp7);
        JPanel jp8=new JPanel();
        jp8.add(new JLabel("Ice: "+character.ice));
        jPanel.add(jp8);
        JPanel jp9=new JPanel();
        jp9.add(new JLabel("Earth: "+character.earth));
        jPanel.add(jp9);
        JPanel jp10=new JPanel();
        jp10.add(new JLabel("Abilities: "));
        jPanel.add(jp10);
        jp=new JPanel();
        for(int k=0;k<character.abilities.size();k++)
        {
            JTextField jt=new JTextField(character.abilities.get(k).getClass().getSimpleName());
            jt.setEditable(false);
            jt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            Font fontJt=new Font(jt.getFont().getName(),Font.BOLD,jt.getFont().getSize());
            jt.setFont(fontJt);
            jp.add(jt);
        }
        jPanel.add(jp);
        JPanel jp11=new JPanel();
        jp11.add(new JLabel("Charisma: "+character.charisma));
        jPanel.add(jp11);
        JPanel jp12=new JPanel();
        jp12.add(new JLabel("Strength: "+character.strength));
        jPanel.add(jp12);
        JPanel jp13=new JPanel();
        jp13.add(new JLabel("Dexterity: "+character.dexterity));
        jPanel.add(jp13);
        jPanel.setBackground(Color.CYAN);
        add(jPanel,BorderLayout.PAGE_START);

        //de terminat jocul
        GameFrame gameFrame=this;
        north.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (grid.get(grid.current.ox).get(grid.current.oy).ox - 1 < 0)
                    move1.setText("Nu se poate deplasa la nord!");
                else {
                    move1.setText("nord");
                    if (grid.current.element.toCharacter() == 'N') {
                        //de verif banii
                        ImageIcon imagePlayer = new ImageIcon("src\\World_of_Marcel\\empty.png");
                        Image imageP = imagePlayer.getImage();
                        Image imageP1 = imageP.getScaledInstance(75, 75, Image.SCALE_FAST);
                        imagePlayer = new ImageIcon(imageP1);
                        map.setValueAt(imagePlayer, grid.current.ox, grid.current.oy);
                    }
                    if (grid.current.element.toCharacter() == 'F') {
                        ImageIcon imagePlayer = new ImageIcon("src\\World_of_Marcel\\finish.png");
                        Image imageP = imagePlayer.getImage();
                        Image imageP1 = imageP.getScaledInstance(75, 75, Image.SCALE_FAST);
                        imagePlayer = new ImageIcon(imageP1);
                        map.setValueAt(imagePlayer, grid.current.ox, grid.current.oy);
                    }
                    if (grid.current.element.toCharacter() == 'S') {
                        ImageIcon imagePlayer = new ImageIcon("src\\World_of_Marcel\\shop.png");
                        Image imageP = imagePlayer.getImage();
                        Image imageP1 = imageP.getScaledInstance(75, 75, Image.SCALE_FAST);
                        imagePlayer = new ImageIcon(imageP1);
                        map.setValueAt(imagePlayer, grid.current.ox, grid.current.oy);
                    }
                    if (grid.current.element.toCharacter() == 'E') {
                        ImageIcon imagePlayer = new ImageIcon("src\\World_of_Marcel\\enemy.png");
                        Image imageP = imagePlayer.getImage();
                        Image imageP1 = imageP.getScaledInstance(75, 75, Image.SCALE_FAST);
                        imagePlayer = new ImageIcon(imageP1);
                        map.setValueAt(imagePlayer, grid.current.ox, grid.current.oy);
                    }

                    grid.current = grid.get(grid.current.ox-1).get(grid.current.oy);
                    grid.player.currentOx=grid.current.ox;
                    story1.setText(grid.current.story);
                    if(grid.current.element.toCharacter()=='S')
                        where1.setText("o casuta cu magazin.");
                    if(grid.current.element.toCharacter()=='F')
                        where1.setText("casuta de finish.");
                    if(grid.current.element.toCharacter()=='N')
                        where1.setText("o casuta goala.");
                    if(grid.current.element.toCharacter()=='E')
                        where1.setText("o casuta cu inamic.");
                    EnemyFrame enemyFrame;
                    if(grid.current.visited==false) {
                        Random rand = new Random();
                        if (grid.current.element.toCharacter() == 'N') {
                            int chance = rand.nextInt(5);
                            if (chance == 3) {
                                grid.player.inventory.coins += 500;
                                Coins coins=new Coins("Bonus");
                            }
                        }
                        if(grid.current.element.toCharacter()=='E')
                        {
                            enemyFrame=new EnemyFrame("Fight",character,(Enemy) grid.current.element,gameFrame);
                        }
                    }
                    WinFrame winFrame;
                    if(grid.current.element.toCharacter() == 'F')
                    {
                        dispose();
                        winFrame=new WinFrame(character);
                    }
                    ShopFrame shopFrame;
                    if (grid.current.element.toCharacter() == 'S')
                        shopFrame=new ShopFrame("Magazin",character,(Shop) grid.current.element,gameFrame);
                    ImageIcon imagePlayer = new ImageIcon("src\\World_of_Marcel\\character.png");
                    Image imageP = imagePlayer.getImage();
                    Image imageP1 = imageP.getScaledInstance(75, 75, Image.SCALE_FAST);
                    imagePlayer = new ImageIcon(imageP1);
                    map.setValueAt(imagePlayer, grid.current.ox, grid.current.oy);
                    jt3.setText("Level: "+character.level);
                    jt4.setText("Experience: "+character.experience);
                    jt5.setText("Life: "+character.currentLife);
                    jt6.setText("Mana: "+character.currentManna);
                    jt14.setText("Coins: "+character.inventory.coins);
                    jp.removeAll();
                    for(int k=0;k<character.abilities.size();k++)
                    {
                        JTextField jt=new JTextField(character.abilities.get(k).getClass().getSimpleName());
                        jt.setEditable(false);
                        jt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        Font fontJt=new Font(jt.getFont().getName(),Font.BOLD,jt.getFont().getSize());
                        jt.setFont(fontJt);
                        jp.add(jt);
                    }
                    if(character.abilities.size()==0)
                        remove(jp);
                    revalidate();
                    repaint();
                    map.repaint();
                    grid.current.visited = true;
                }
            }
        });

        south.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (grid.get(grid.current.ox).get(grid.current.oy).ox + 1 >= grid.length)
                    move1.setText("Nu se poate deplasa la sud!");
                else {
                    move1.setText("sud");
                    if (grid.current.element.toCharacter() == 'N') {
                        ImageIcon imagePlayer = new ImageIcon("src\\World_of_Marcel\\empty.png");
                        Image imageP = imagePlayer.getImage();
                        Image imageP1 = imageP.getScaledInstance(75, 75, Image.SCALE_FAST);
                        imagePlayer = new ImageIcon(imageP1);
                        map.setValueAt(imagePlayer, grid.current.ox, grid.current.oy);
                    }
                    if (grid.current.element.toCharacter() == 'F') {
                        ImageIcon imagePlayer = new ImageIcon("src\\World_of_Marcel\\finish.png");
                        Image imageP = imagePlayer.getImage();
                        Image imageP1 = imageP.getScaledInstance(75, 75, Image.SCALE_FAST);
                        imagePlayer = new ImageIcon(imageP1);
                        map.setValueAt(imagePlayer, grid.current.ox, grid.current.oy);
                    }
                    if (grid.current.element.toCharacter() == 'S') {
                        ImageIcon imagePlayer = new ImageIcon("src\\World_of_Marcel\\shop.png");
                        Image imageP = imagePlayer.getImage();
                        Image imageP1 = imageP.getScaledInstance(75, 75, Image.SCALE_FAST);
                        imagePlayer = new ImageIcon(imageP1);
                        map.setValueAt(imagePlayer, grid.current.ox, grid.current.oy);
                    }
                    if (grid.current.element.toCharacter() == 'E') {
                        ImageIcon imagePlayer = new ImageIcon("src\\World_of_Marcel\\enemy.png");
                        Image imageP = imagePlayer.getImage();
                        Image imageP1 = imageP.getScaledInstance(75, 75, Image.SCALE_FAST);
                        imagePlayer = new ImageIcon(imageP1);
                        map.setValueAt(imagePlayer, grid.current.ox, grid.current.oy);
                    }

                    grid.current = grid.get(grid.current.ox + 1).get(grid.current.oy);
                    grid.player.currentOx = grid.current.ox;
                    story1.setText(grid.current.story);
                    if(grid.current.element.toCharacter()=='S')
                        where1.setText("o casuta cu magazin.");
                    if(grid.current.element.toCharacter()=='F')
                        where1.setText("casuta de finish.");
                    if(grid.current.element.toCharacter()=='N')
                        where1.setText("o casuta goala.");
                    if(grid.current.element.toCharacter()=='E')
                        where1.setText("o casuta cu inamic.");
                    EnemyFrame enemyFrame;
                    if(grid.current.visited==false) {
                        Random rand = new Random();
                        if (grid.current.element.toCharacter() == 'N') {
                            int chance = rand.nextInt(5);
                            if (chance == 3) {
                                grid.player.inventory.coins += 500;
                                Coins coins=new Coins("Bonus");
                            }
                        }
                        if(grid.current.element.toCharacter()=='E')
                        {
                            enemyFrame=new EnemyFrame("Fight",character,(Enemy) grid.current.element,gameFrame);
                        }
                    }
                    WinFrame winFrame;
                    if(grid.current.element.toCharacter() == 'F')
                    {
                        dispose();
                        winFrame=new WinFrame(character);
                    }
                    ShopFrame shopFrame;
                    if (grid.current.element.toCharacter() == 'S')
                        shopFrame=new ShopFrame("Magazin",character,(Shop) grid.current.element,gameFrame);
                    ImageIcon imagePlayer = new ImageIcon("src\\World_of_Marcel\\character.png");
                    Image imageP = imagePlayer.getImage();
                    Image imageP1 = imageP.getScaledInstance(75, 75, Image.SCALE_FAST);
                    imagePlayer = new ImageIcon(imageP1);
                    map.setValueAt(imagePlayer, grid.current.ox, grid.current.oy);
                    jt3.setText("Level: "+character.level);
                    jt4.setText("Experience: "+character.experience);
                    jt5.setText("Life: "+character.currentLife);
                    jt6.setText("Mana: "+character.currentManna);
                    jt14.setText("Coins: "+character.inventory.coins);
                    jp.removeAll();
                    for(int k=0;k<character.abilities.size();k++)
                    {
                        JTextField jt=new JTextField(character.abilities.get(k).getClass().getSimpleName());
                        jt.setEditable(false);
                        jt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        Font fontJt=new Font(jt.getFont().getName(),Font.BOLD,jt.getFont().getSize());
                        jt.setFont(fontJt);
                        jp.add(jt);
                    }
                    if(character.abilities.size()==0)
                        remove(jp);
                    revalidate();
                    repaint();
                    map.repaint();
                    grid.current.visited = true;
                }
            }
        });

        east.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (grid.get(grid.current.ox).get(grid.current.oy).oy + 1 >= grid.width)
                    move1.setText("Nu se poate deplasa la est!");
                else {
                    move1.setText("est");
                    if (grid.current.element.toCharacter() == 'N') {
                        ImageIcon imagePlayer = new ImageIcon("src\\World_of_Marcel\\empty.png");
                        Image imageP = imagePlayer.getImage();
                        Image imageP1 = imageP.getScaledInstance(75, 75, Image.SCALE_FAST);
                        imagePlayer = new ImageIcon(imageP1);
                        map.setValueAt(imagePlayer, grid.current.ox, grid.current.oy);
                    }
                    if (grid.current.element.toCharacter() == 'F') {
                        ImageIcon imagePlayer = new ImageIcon("src\\World_of_Marcel\\finish.png");
                        Image imageP = imagePlayer.getImage();
                        Image imageP1 = imageP.getScaledInstance(75, 75, Image.SCALE_FAST);
                        imagePlayer = new ImageIcon(imageP1);
                        map.setValueAt(imagePlayer, grid.current.ox, grid.current.oy);
                    }
                    if (grid.current.element.toCharacter() == 'S') {
                        ImageIcon imagePlayer = new ImageIcon("src\\World_of_Marcel\\shop.png");
                        Image imageP = imagePlayer.getImage();
                        Image imageP1 = imageP.getScaledInstance(75, 75, Image.SCALE_FAST);
                        imagePlayer = new ImageIcon(imageP1);
                        map.setValueAt(imagePlayer, grid.current.ox, grid.current.oy);
                    }
                    if (grid.current.element.toCharacter() == 'E') {
                        ImageIcon imagePlayer = new ImageIcon("src\\World_of_Marcel\\enemy.png");
                        Image imageP = imagePlayer.getImage();
                        Image imageP1 = imageP.getScaledInstance(75, 75, Image.SCALE_FAST);
                        imagePlayer = new ImageIcon(imageP1);
                        map.setValueAt(imagePlayer, grid.current.ox, grid.current.oy);
                    }

                    grid.current = grid.get(grid.current.ox).get(grid.current.oy+1);
                    grid.player.currentOy=grid.current.oy;
                    story1.setText(grid.current.story);
                    if(grid.current.element.toCharacter()=='S')
                        where1.setText("o casuta cu magazin.");
                    if(grid.current.element.toCharacter()=='F')
                        where1.setText("casuta de finish.");
                    if(grid.current.element.toCharacter()=='N')
                        where1.setText("o casuta goala.");
                    if(grid.current.element.toCharacter()=='E')
                        where1.setText("o casuta cu inamic.");
                    EnemyFrame enemyFrame;
                    if(grid.current.visited==false) {
                        Random rand = new Random();
                        if (grid.current.element.toCharacter() == 'N') {
                            int chance = rand.nextInt(5);
                            if (chance == 3) {
                                grid.player.inventory.coins += 500;
                                Coins coins=new Coins("Bonus");
                            }
                        }
                        if(grid.current.element.toCharacter()=='E')
                        {
                            enemyFrame=new EnemyFrame("Fight",character,(Enemy) grid.current.element,gameFrame);
                        }
                    }
                    WinFrame winFrame;
                    if(grid.current.element.toCharacter() == 'F')
                    {
                        dispose();
                        winFrame=new WinFrame(character);
                    }
                    ShopFrame shopFrame;
                    if (grid.current.element.toCharacter() == 'S')
                        shopFrame=new ShopFrame("Magazin",character,(Shop) grid.current.element,gameFrame);
                    ImageIcon imagePlayer = new ImageIcon("src\\World_of_Marcel\\character.png");
                    Image imageP = imagePlayer.getImage();
                    Image imageP1 = imageP.getScaledInstance(75, 75, Image.SCALE_FAST);
                    imagePlayer = new ImageIcon(imageP1);
                    map.setValueAt(imagePlayer, grid.current.ox, grid.current.oy);
                    jt3.setText("Level: "+character.level);
                    jt4.setText("Experience: "+character.experience);
                    jt5.setText("Life: "+character.currentLife);
                    jt6.setText("Mana: "+character.currentManna);
                    jt14.setText("Coins: "+character.inventory.coins);
                    jp.removeAll();
                    for(int k=0;k<character.abilities.size();k++)
                    {
                        JTextField jt=new JTextField(character.abilities.get(k).getClass().getSimpleName());
                        jt.setEditable(false);
                        jt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        Font fontJt=new Font(jt.getFont().getName(),Font.BOLD,jt.getFont().getSize());
                        jt.setFont(fontJt);
                        jp.add(jt);
                    }
                    if(character.abilities.size()==0)
                        remove(jp);
                    revalidate();
                    repaint();
                    map.repaint();
                    grid.current.visited = true;
                }
            }
        });

        west.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (grid.get(grid.current.ox).get(grid.current.oy).oy - 1 < 0)
                    move1.setText("Nu se poate deplasa la vest!");
                else {
                    move1.setText("vest");
                    if (grid.current.element.toCharacter() == 'N') {
                        ImageIcon imagePlayer = new ImageIcon("src\\World_of_Marcel\\empty.png");
                        Image imageP = imagePlayer.getImage();
                        Image imageP1 = imageP.getScaledInstance(75, 75, Image.SCALE_FAST);
                        imagePlayer = new ImageIcon(imageP1);
                        map.setValueAt(imagePlayer, grid.current.ox, grid.current.oy);
                    }
                    if (grid.current.element.toCharacter() == 'F') {
                        ImageIcon imagePlayer = new ImageIcon("src\\World_of_Marcel\\finish.png");
                        Image imageP = imagePlayer.getImage();
                        Image imageP1 = imageP.getScaledInstance(75, 75, Image.SCALE_FAST);
                        imagePlayer = new ImageIcon(imageP1);
                        map.setValueAt(imagePlayer, grid.current.ox, grid.current.oy);
                    }
                    if (grid.current.element.toCharacter() == 'S') {
                        ImageIcon imagePlayer = new ImageIcon("src\\World_of_Marcel\\shop.png");
                        Image imageP = imagePlayer.getImage();
                        Image imageP1 = imageP.getScaledInstance(75, 75, Image.SCALE_FAST);
                        imagePlayer = new ImageIcon(imageP1);
                        map.setValueAt(imagePlayer, grid.current.ox, grid.current.oy);

                    }
                    if (grid.current.element.toCharacter() == 'E') {
                        ImageIcon imagePlayer = new ImageIcon("src\\World_of_Marcel\\enemy.png");
                        Image imageP = imagePlayer.getImage();
                        Image imageP1 = imageP.getScaledInstance(75, 75, Image.SCALE_FAST);
                        imagePlayer = new ImageIcon(imageP1);
                        map.setValueAt(imagePlayer, grid.current.ox, grid.current.oy);
                    }

                    grid.current = grid.get(grid.current.ox).get(grid.current.oy-1);
                    grid.player.currentOy=grid.current.oy;
                    story1.setText(grid.current.story);
                    if(grid.current.element.toCharacter()=='S')
                        where1.setText("o casuta cu magazin.");
                    if(grid.current.element.toCharacter()=='F')
                        where1.setText("casuta de finish.");
                    if(grid.current.element.toCharacter()=='N')
                        where1.setText("o casuta goala.");
                    if(grid.current.element.toCharacter()=='E')
                        where1.setText("o casuta cu inamic.");
                    EnemyFrame enemyFrame;
                    if(grid.current.visited==false) {
                        Random rand = new Random();
                        if (grid.current.element.toCharacter() == 'N') {
                            int chance = rand.nextInt(5);
                           if (chance == 3) {
                                grid.player.inventory.coins += 500;
                                Coins coins=new Coins("Bonus");
                            }
                        }
                        if(grid.current.element.toCharacter()=='E')
                        {
                            enemyFrame=new EnemyFrame("Fight",character,(Enemy) grid.current.element,gameFrame);
                        }
                    }
                    WinFrame winFrame;
                    if(grid.current.element.toCharacter() == 'F')
                    {
                        dispose();
                        winFrame=new WinFrame(character);
                    }
                    ShopFrame shopFrame;
                    if (grid.current.element.toCharacter() == 'S')
                        shopFrame=new ShopFrame("Magazin",character,(Shop) grid.current.element,gameFrame);
                    ImageIcon imagePlayer = new ImageIcon("src\\World_of_Marcel\\character.png");
                    Image imageP = imagePlayer.getImage();
                    Image imageP1 = imageP.getScaledInstance(75, 75, Image.SCALE_FAST);
                    imagePlayer = new ImageIcon(imageP1);
                    map.setValueAt(imagePlayer, grid.current.ox, grid.current.oy);
                    jt3.setText("Level: "+character.level);
                    jt4.setText("Experience: "+character.experience);
                    jt5.setText("Life: "+character.currentLife);
                    jt6.setText("Mana: "+character.currentManna);
                    jt14.setText("Coins: "+character.inventory.coins);
                    jp.removeAll();
                    for(int k=0;k<character.abilities.size();k++)
                    {
                        JTextField jt=new JTextField(character.abilities.get(k).getClass().getSimpleName());
                        jt.setEditable(false);
                        jt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        Font fontJt=new Font(jt.getFont().getName(),Font.BOLD,jt.getFont().getSize());
                        jt.setFont(fontJt);
                        jp.add(jt);
                    }
                    if(character.abilities.size()==0)
                        remove(jp);
                    revalidate();
                    repaint();
                    map.repaint();
                    grid.current.visited = true;
                }
            }
        });
        buttons.add(north);
        buttons.add(south);
        buttons.add(east);
        buttons.add(west);
        buttons.setBackground(Color.CYAN);
        infoMoves.setBackground(new Color(202,11,11));
        JPanel end=new JPanel();
        end.setLayout(new GridLayout(2,1));
//        end.add(story);
        end.add(infoMoves);
        end.add(buttons);
        add(end,BorderLayout.PAGE_END);

//        add(buttons,BorderLayout.PAGE_END);
//        infoMoves.setBounds(0,0,10,10);
//        add(infoMoves,BorderLayout.CENTER);
        pack();
        show();
    }
}
