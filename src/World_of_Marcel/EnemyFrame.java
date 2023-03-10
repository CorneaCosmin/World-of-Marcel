package World_of_Marcel;

import World_of_Marcel.Enemy;
import World_of_Marcel.Character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;

public class EnemyFrame extends JFrame
{
    public EnemyFrame(String name, Character character, Enemy enemy,GameFrame gameFrame)
    {
        super(name);
        setMinimumSize(new Dimension(1830,830));
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBackground(new Color(255,255,153));
        getContentPane().setBackground(new Color(255,255,153));
        JPanel infoCharacter=new JPanel();
        infoCharacter.setBackground(new Color(255,255,153));
        infoCharacter.setLayout(new GridLayout(14,1));
        ImageIcon imageIcon=new ImageIcon("src\\World_of_Marcel\\characterfight.png");
        Image image=imageIcon.getImage();
        Image image1 = image.getScaledInstance(85, 85, Image.SCALE_FAST);
        imageIcon=new ImageIcon(image1);
        setIconImage(image1);
        infoCharacter.add(new JLabel(imageIcon));
        JLabel nameCharacter=new JLabel(character.name+", "+character.getClass().getSimpleName());
        infoCharacter.add(nameCharacter);
        JTextField lifeCharacter=new JTextField("Viata curenta: "+character.currentLife);
        lifeCharacter.setBackground(new Color(255,255,153));
        lifeCharacter.setEditable(false);
        lifeCharacter.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font fontLife=new Font(lifeCharacter.getFont().getName(),Font.BOLD,lifeCharacter.getFont().getSize());
        lifeCharacter.setFont(fontLife);
        infoCharacter.add(lifeCharacter);
        JTextField manaCharacter=new JTextField("Mana curenta: "+character.currentManna);
        manaCharacter.setBackground(new Color(255,255,153));
        manaCharacter.setEditable(false);
        manaCharacter.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font fontMana=new Font(manaCharacter.getFont().getName(),Font.BOLD,manaCharacter.getFont().getSize());
        manaCharacter.setFont(fontMana);
        infoCharacter.add(manaCharacter);
        JTextField fireCharacter=new JTextField("Fire: "+character.fire);
        fireCharacter.setBackground(new Color(255,255,153));
        fireCharacter.setEditable(false);
        fireCharacter.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font fontFire=new Font(fireCharacter.getFont().getName(),Font.BOLD,fireCharacter.getFont().getSize());
        fireCharacter.setFont(fontFire);
        infoCharacter.add(fireCharacter);
        JTextField iceCharacter=new JTextField("Ice: "+character.ice);
        iceCharacter.setBackground(new Color(255,255,153));
        iceCharacter.setEditable(false);
        iceCharacter.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font fontIce=new Font(iceCharacter.getFont().getName(),Font.BOLD,iceCharacter.getFont().getSize());
        iceCharacter.setFont(fontIce);
        infoCharacter.add(iceCharacter);
        JTextField earthCharacter=new JTextField("Earth: "+character.earth);
        earthCharacter.setBackground(new Color(255,255,153));
        earthCharacter.setEditable(false);
        earthCharacter.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font fontEarth=new Font(earthCharacter.getFont().getName(),Font.BOLD,earthCharacter.getFont().getSize());
        earthCharacter.setFont(fontEarth);
        infoCharacter.add(earthCharacter);
        JLabel abilitiesCharacter=new JLabel("Abilitati curente:");
        infoCharacter.add(abilitiesCharacter);
        for(int i=0;i<character.abilities.size();i++)
        {
            JPanel combine=new JPanel();
            JTextField ability=new JTextField("Abilitate: "+character.abilities.get(i).getClass().getSimpleName());
            JTextField damage=new JTextField("Damage: "+character.abilities.get(i).damage);
            JTextField costManna=new JTextField("Cost mana: "+character.abilities.get(i).costManna);
            ability.setBackground(new Color(255,255,153));
            damage.setBackground(new Color(255,255,153));
            costManna.setBackground(new Color(255,255,153));
            ability.setEditable(false);
            ability.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            Font fontAbility=new Font(ability.getFont().getName(),Font.BOLD,ability.getFont().getSize());
            ability.setFont(fontAbility);
            damage.setEditable(false);
            damage.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            Font fontDamage=new Font(damage.getFont().getName(),Font.BOLD,damage.getFont().getSize());
            damage.setFont(fontDamage);
            costManna.setEditable(false);
            costManna.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            Font fontCostMana=new Font(costManna.getFont().getName(),Font.BOLD,costManna.getFont().getSize());
            costManna.setFont(fontCostMana);
            combine.setBackground(new Color(255,255,153));
            combine.add(ability);
            combine.add(damage);
            combine.add(costManna);
            infoCharacter.add(combine);
        }
        JLabel potionsCharacter=new JLabel("Potiuni curente:");
        infoCharacter.add(potionsCharacter);
        for(int i=0;i<character.inventory.potions.size();i++)
        {
            JPanel combine=new JPanel();
            JTextField potion=new JTextField("Potiune: "+character.inventory.potions.get(i).getClass().getSimpleName());
            JTextField price=new JTextField("Pret: "+character.inventory.potions.get(i).pricePotion());
            JTextField weight=new JTextField("Cost mana: "+character.inventory.potions.get(i).weightPotion());
            potion.setBackground(new Color(255,255,153));
            price.setBackground(new Color(255,255,153));
            weight.setBackground(new Color(255,255,153));
            combine.setBackground(new Color(255,255,153));
            potion.setEditable(false);
            potion.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            Font fontPotion=new Font(potion.getFont().getName(),Font.BOLD,potion.getFont().getSize());
            potion.setFont(fontPotion);
            price.setEditable(false);
            price.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            Font fontPrice=new Font(price.getFont().getName(),Font.BOLD,price.getFont().getSize());
            price.setFont(fontPrice);
            weight.setEditable(false);
            weight.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            Font fontWeight=new Font(weight.getFont().getName(),Font.BOLD,weight.getFont().getSize());
            weight.setFont(fontWeight);
            combine.add(potion);
            combine.add(price);
            combine.add(weight);
            infoCharacter.add(combine);
        }


        add(infoCharacter,BorderLayout.WEST);



        JPanel infoEnemy=new JPanel();
        infoEnemy.setBackground(new Color(255,255,153));
        infoEnemy.setLayout(new GridLayout(12,1));
        ImageIcon imageEnemy=new ImageIcon("src\\World_of_Marcel\\enemyfight.png");
        Image image2=imageEnemy.getImage();
        Image image3 = image2.getScaledInstance(85, 85, Image.SCALE_FAST);
        imageIcon=new ImageIcon(image3);
        infoEnemy.add(new JLabel(imageIcon));
        JLabel nameEnemy= new JLabel("Inamic");
        infoEnemy.add(nameEnemy);
        JTextField lifeEnemy=new JTextField("Viata curenta: "+enemy.currentLife);
        lifeEnemy.setBackground(new Color(255,255,153));
        lifeEnemy.setEditable(false);
        lifeEnemy.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font fontLifeE=new Font(lifeEnemy.getFont().getName(),Font.BOLD,lifeEnemy.getFont().getSize());
        lifeEnemy.setFont(fontLifeE);
        infoEnemy.add(lifeEnemy);
        JTextField manaEnemy=new JTextField("Mana curenta: "+enemy.currentManna);
        manaEnemy.setBackground(new Color(255,255,153));
        manaEnemy.setEditable(false);
        manaEnemy.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font fontManaE=new Font(manaEnemy.getFont().getName(),Font.BOLD,manaEnemy.getFont().getSize());
        manaEnemy.setFont(fontManaE);
        infoEnemy.add(manaEnemy);
        JTextField fireEnemy=new JTextField("Fire: "+enemy.fire);
        fireEnemy.setBackground(new Color(255,255,153));
        fireEnemy.setEditable(false);
        fireEnemy.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font fontFireE=new Font(fireEnemy.getFont().getName(),Font.BOLD,fireEnemy.getFont().getSize());
        fireEnemy.setFont(fontFireE);
        infoEnemy.add(fireEnemy);
        JTextField iceEnemy=new JTextField("Ice: "+enemy.ice);
        iceEnemy.setBackground(new Color(255,255,153));
        iceEnemy.setEditable(false);
        iceEnemy.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font fontIceE=new Font(iceEnemy.getFont().getName(),Font.BOLD,iceEnemy.getFont().getSize());
        iceEnemy.setFont(fontIceE);
        infoEnemy.add(iceEnemy);
        JTextField earthEnemy=new JTextField("Earth: "+enemy.earth);
        earthEnemy.setBackground(new Color(255,255,153));
        earthEnemy.setEditable(false);
        earthEnemy.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font fontEarthE=new Font(earthEnemy.getFont().getName(),Font.BOLD,earthEnemy.getFont().getSize());
        earthEnemy.setFont(fontEarthE);
        infoEnemy.add(earthEnemy);
        JLabel abilitiesEnemy=new JLabel("Abilitati inamic:");
        infoEnemy.add(abilitiesEnemy);
        for(int i=0;i<enemy.abilities.size();i++)
        {
            JPanel combine=new JPanel();
            JTextField ability=new JTextField("Abilitate: "+enemy.abilities.get(i).getClass().getSimpleName());
            JTextField damage=new JTextField("Damage: "+enemy.abilities.get(i).damage);
            JTextField costManna=new JTextField("Cost mana: "+enemy.abilities.get(i).costManna);
            ability.setBackground(new Color(255,255,153));
            damage.setBackground(new Color(255,255,153));
            costManna.setBackground(new Color(255,255,153));
            combine.setBackground(new Color(255,255,153));
            ability.setEditable(false);
            ability.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            Font fontAbility=new Font(ability.getFont().getName(),Font.BOLD,ability.getFont().getSize());
            ability.setFont(fontAbility);
            damage.setEditable(false);
            damage.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            Font fontDamage=new Font(damage.getFont().getName(),Font.BOLD,damage.getFont().getSize());
            damage.setFont(fontDamage);
            costManna.setEditable(false);
            costManna.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            Font fontCostMana=new Font(costManna.getFont().getName(),Font.BOLD,costManna.getFont().getSize());
            costManna.setFont(fontCostMana);
            combine.add(ability);
            combine.add(damage);
            combine.add(costManna);
            infoEnemy.add(combine);
        }

        add(infoEnemy,BorderLayout.EAST);

        Vector<String> vButton2=new Vector();
        vButton2.add("Foloseste potiune");
        vButton2.add("ManaPotion");
        vButton2.add("HealthPotion");
        Vector<String> vButton3=new Vector<>();
        vButton3.add("Foloseste abilitate");
        vButton3.add("Fire");
        vButton3.add("Ice");
        vButton3.add("Earth");
        JPanel buttons=new JPanel();
        buttons.setBackground(new Color(255,255,153));
        buttons.setLayout(new FlowLayout());
        JButton button1=new JButton("Atac normal");
        JComboBox button2=new JComboBox(vButton2);
        JComboBox button3=new JComboBox(vButton3);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ok=1;
                int damage=character.getDamage();
                enemy.receiveDamage(damage);
                if(enemy.currentLife<=0)
                {
                    dispose();
                    ok=0;
                    Random rand=new Random();
                    int chance= rand.nextInt(5);
                    if(chance==0 || chance==1 || chance==2 || chance==4)
                    {
                        character.inventory.coins+=500;
                        WinCoins winCoins=new WinCoins("Win coins");
                    }
                    character.experience+= rand.nextInt(100-50)+50;
                    if(character.experience>=100)
                    {
                        character.level++;
                        character.experience-=100;
                    }
                    character.nrEnemies++;
                    gameFrame.jt3.setText("Level: "+character.level);
                    gameFrame.jt4.setText("Experience: "+character.experience);
                    gameFrame.jt5.setText("Life: "+character.currentLife);
                    gameFrame.jt6.setText("Mana: "+character.currentManna);
                    gameFrame.jt14.setText("Coins: "+character.inventory.coins);
                    gameFrame.jp.removeAll();
                    for(int k=0;k<character.abilities.size();k++)
                    {
                        JTextField jt=new JTextField(character.abilities.get(k).getClass().getSimpleName());
                        jt.setEditable(false);
                        jt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        Font fontJt=new Font(jt.getFont().getName(),Font.BOLD,jt.getFont().getSize());
                        jt.setFont(fontJt);
                        gameFrame.jp.add(jt);
                    }
                    if(character.abilities.size()==0)
                        remove(gameFrame.jp);
                    WinFight winFight=new WinFight("Win");
                }
                lifeEnemy.setText("Viata curenta: "+enemy.currentLife);
                Random rand=new Random();
                if(ok==1)
                {int chanceAbility=rand.nextInt(2);
                if(chanceAbility==1 && enemy.abilities.size()!=0)
                {
                    int nrAbility= rand.nextInt(enemy.abilities.size());
                    character.accept(enemy.abilities.get(nrAbility));
                    if(enemy.currentManna>=enemy.abilities.get(nrAbility).costManna)
                    {
                        character.receiveDamage(enemy.abilities.get(nrAbility).damage);
                        LoseBattle loseBattle;
                        LoseFrame loseFrame;
                        if(character.currentLife<=0)
                        {
                            dispose();
                            gameFrame.dispose();
                            loseBattle=new LoseBattle("You lost!");
                            loseFrame=new LoseFrame(character);
                        }
                        enemy.currentManna-=enemy.abilities.get(nrAbility).costManna;
                        lifeCharacter.setText("Viata curenta: "+character.currentLife);
                        manaEnemy.setText("Mana curenta: "+enemy.currentManna);
                        infoEnemy.remove(8+nrAbility);
                        enemy.abilities.remove(nrAbility);
                    }
                    else
                    {
                        int damage1= enemy.getDamage();
                        character.receiveDamage(damage1);
                        LoseBattle loseBattle;
                        LoseFrame loseFrame;
                        if(character.currentLife<=0)
                        {
                            dispose();
                            gameFrame.dispose();
                            loseBattle=new LoseBattle("You lost!");
                            loseFrame=new LoseFrame(character);
                        }
                        lifeCharacter.setText("Viata curenta: "+character.currentLife);
                    }
                }
                else
                {
                    int damage1= enemy.getDamage();
                    character.receiveDamage(damage1);
                    LoseBattle loseBattle;
                    LoseFrame loseFrame;
                    if(character.currentLife<=0)
                    {
                        dispose();
                        gameFrame.dispose();
                        loseBattle=new LoseBattle("You lost!");
                        loseFrame=new LoseFrame(character);
                    }
                    lifeCharacter.setText("Viata curenta: "+character.currentLife);
                }}
                revalidate();
                repaint();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(button2.getSelectedItem()==null)
                    return;
                int exist=1;
                if(button2.getSelectedItem().equals("ManaPotion")){
                    int i,index=-1;
                    for(i=0;i<character.inventory.potions.size();i++)
                        if(character.inventory.potions.get(i).getClass().getSimpleName().equals("ManaPotion"))
                        {
                            character.inventory.potions.get(i).usePotion(character);
                            index=i;
                            break;
                        }
                    NoPotion noPotion;
                    if(index==-1)
                    {
                        noPotion=new NoPotion("Error Potion");
                        exist=0;
                    }
                    else{
                    manaCharacter.setText("Mana curenta: "+character.currentManna);
                        infoCharacter.remove(8+character.abilities.size()+1+index);}
                }
                else if(button2.getSelectedItem().equals("HealthPotion"))
                {
                    int i,index=-1;
                    for(i=0;i<character.inventory.potions.size();i++)
                        if(character.inventory.potions.get(i).getClass().getSimpleName().equals("HealthPotion"))
                        {
                            character.inventory.potions.get(i).usePotion(character);
                            index=i;
                            break;
                        }
                    NoPotion noPotion;
                    if(index==-1)
                    {
                        noPotion=new NoPotion("Error Potion");
                        exist=0;

                    }else{
                    lifeCharacter.setText("Viata curenta: "+character.currentLife);
                    infoCharacter.remove(8+character.abilities.size()+1+index);}
                }
                else if(button2.getSelectedItem().equals("Foloseste potiune"))
                    exist=0;
                Random rand=new Random();
                if(exist==1) {
                    int chanceAbility = rand.nextInt(2);
                    if (chanceAbility == 1 && enemy.abilities.size() != 0) {
                        int nrAbility = rand.nextInt(enemy.abilities.size());
                        character.accept(enemy.abilities.get(nrAbility));
                        if (enemy.currentManna >= enemy.abilities.get(nrAbility).costManna) {
                            character.receiveDamage(enemy.abilities.get(nrAbility).damage);
                            LoseBattle loseBattle;
                            LoseFrame loseFrame;
                            if(character.currentLife<=0)
                            {
                                dispose();
                                gameFrame.dispose();
                                loseBattle=new LoseBattle("You lost!");
                                loseFrame=new LoseFrame(character);
                            }
                            enemy.currentManna -= enemy.abilities.get(nrAbility).costManna;
                            lifeCharacter.setText("Viata curenta: " + character.currentLife);
                            manaEnemy.setText("Mana curenta: " + enemy.currentManna);
                            infoEnemy.remove(8 + nrAbility);
                            enemy.abilities.remove(nrAbility);
                        } else {
                            int damage1 = enemy.getDamage();
                            character.receiveDamage(damage1);
                            LoseBattle loseBattle;
                            LoseFrame loseFrame;
                            if(character.currentLife<=0)
                            {
                                dispose();
                                gameFrame.dispose();
                                loseBattle=new LoseBattle("You lost!");
                                loseFrame=new LoseFrame(character);
                            }
                            lifeCharacter.setText("Viata curenta: " + character.currentLife);
                        }
                    } else {
                        int damage1 = enemy.getDamage();
                        character.receiveDamage(damage1);
                        LoseBattle loseBattle;
                        LoseFrame loseFrame;
                        if(character.currentLife<=0)
                        {
                            dispose();
                            gameFrame.dispose();
                            loseBattle=new LoseBattle("You lost!");
                            loseFrame=new LoseFrame(character);
                        }
                        lifeCharacter.setText("Viata curenta: " + character.currentLife);
                    }
                }
                button2.setSelectedIndex(0);
                revalidate();
                repaint();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(button3.getSelectedItem()==null)
                    return;
                int exist=1;
                if(button3.getSelectedItem().equals("Fire"))
                {
                    int i,index=-1;
                    for(i=0;i<character.abilities.size();i++)
                        if(character.abilities.get(i).getClass().getSimpleName().equals("Fire"))
                        {
                            if(character.currentManna>=character.abilities.get(i).costManna)
                            {
                                index=i;
                            }
                            break;
                        }
                    NoAbility noAbility;
                    if(index==-1)
                    {
                        noAbility=new NoAbility("Error Ability");
                        exist=0;
                    }
                    else
                    {
                        character.currentManna-=character.abilities.get(index).costManna;
                        enemy.accept(character.abilities.get(index));
                        enemy.receiveDamage(character.abilities.get(index).damage);
                        if(enemy.currentLife<=0)
                        {
                            dispose();
                            exist=0;
                            Random rand=new Random();
                            int chance= rand.nextInt(5);
                            if(chance==0 || chance==1 || chance==2 || chance==4)
                            {
                                character.inventory.coins+=500;
                                WinCoins winCoins=new WinCoins("Win coins");
                            }
                            character.experience+= rand.nextInt(100-50)+50;
                            if(character.experience>=100)
                            {
                                character.level++;
                                character.experience-=100;
                            }
                            character.nrEnemies++;
                            gameFrame.jt3.setText("Level: "+character.level);
                            gameFrame.jt4.setText("Experience: "+character.experience);
                            gameFrame.jt5.setText("Life: "+character.currentLife);
                            gameFrame.jt6.setText("Mana: "+character.currentManna);
                            gameFrame.jt14.setText("Coins: "+character.inventory.coins);
                            gameFrame.jp.removeAll();
                            for(int k=0;k<character.abilities.size();k++)
                            {
                                JTextField jt=new JTextField(character.abilities.get(k).getClass().getSimpleName());
                                jt.setEditable(false);
                                jt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                                Font fontJt=new Font(jt.getFont().getName(),Font.BOLD,jt.getFont().getSize());
                                jt.setFont(fontJt);
                                gameFrame.jp.add(jt);
                            }
                            if(character.abilities.size()==0)
                                remove(gameFrame.jp);
                            WinFight winFight=new WinFight("Win");
                        }
                        lifeEnemy.setText("Viata curenta: "+enemy.currentLife);
                        manaCharacter.setText("Mana curenta: "+character.currentManna);
                        character.abilities.remove(index);
                        infoCharacter.remove(8+index);
                    }
                }
                else if(button3.getSelectedItem().equals("Ice"))
                {
                    int i,index=-1;
                    for(i=0;i<character.abilities.size();i++)
                        if(character.abilities.get(i).getClass().getSimpleName().equals("Ice"))
                        {
                            if(character.currentManna>=character.abilities.get(i).costManna)
                            {
                                index=i;
                            }
                            break;
                        }
                    NoAbility noAbility;
                    if(index==-1)
                    {
                        noAbility=new NoAbility("Error Ability");
                        exist=0;
                    }
                    else
                    {
                        character.currentManna-=character.abilities.get(index).costManna;
                        enemy.accept(character.abilities.get(index));
                        enemy.receiveDamage(character.abilities.get(index).damage);
                        if(enemy.currentLife<=0)
                        {
                            dispose();
                            exist=0;
                            Random rand=new Random();
                            int chance= rand.nextInt(5);
                            if(chance==0 || chance==1 || chance==2 || chance==4)
                            {
                                character.inventory.coins+=500;
                                WinCoins winCoins=new WinCoins("Win coins");
                            }
                            character.experience+= rand.nextInt(100-50)+50;
                            if(character.experience>=100)
                            {
                                character.level++;
                                character.experience-=100;
                            }
                            character.nrEnemies++;
                            gameFrame.jt3.setText("Level: "+character.level);
                            gameFrame.jt4.setText("Experience: "+character.experience);
                            gameFrame.jt5.setText("Life: "+character.currentLife);
                            gameFrame.jt6.setText("Mana: "+character.currentManna);
                            gameFrame.jt14.setText("Coins: "+character.inventory.coins);
                            gameFrame.jp.removeAll();
                            for(int k=0;k<character.abilities.size();k++)
                            {
                                JTextField jt=new JTextField(character.abilities.get(k).getClass().getSimpleName());
                                jt.setEditable(false);
                                jt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                                Font fontJt=new Font(jt.getFont().getName(),Font.BOLD,jt.getFont().getSize());
                                jt.setFont(fontJt);
                                gameFrame.jp.add(jt);
                            }
                            if(character.abilities.size()==0)
                                remove(gameFrame.jp);
                            WinFight winFight=new WinFight("Win");
                        }
                        lifeEnemy.setText("Viata curenta: "+enemy.currentLife);
                        manaCharacter.setText("Mana curenta: "+character.currentManna);
                        character.abilities.remove(index);
                        infoCharacter.remove(8+index);
                    }
                }
                else if(button3.getSelectedItem().equals("Earth"))
                {
                    int i,index=-1;
                    for(i=0;i<character.abilities.size();i++)
                        if(character.abilities.get(i).getClass().getSimpleName().equals("Earth"))
                        {
                            if(character.currentManna>=character.abilities.get(i).costManna)
                            {
                                index=i;
                            }
                            break;
                        }
                    NoAbility noAbility;
                    if(index==-1)
                    {
                        noAbility=new NoAbility("Error Ability");
                        exist=0;
                    }
                    else
                    {
                        character.currentManna-=character.abilities.get(index).costManna;
                        enemy.accept(character.abilities.get(index));
                        enemy.receiveDamage(character.abilities.get(index).damage);
                        if(enemy.currentLife<=0)
                        {
                            dispose();
                            exist=0;
                            Random rand=new Random();
                            int chance= rand.nextInt(5);
                            if(chance==0 || chance==1 || chance==2 || chance==4)
                            {
                                character.inventory.coins+=500;
                                WinCoins winCoins=new WinCoins("Win coins");
                            }
                            character.experience+= rand.nextInt(100-50)+50;
                            if(character.experience>=100)
                            {
                                character.level++;
                                character.experience-=100;
                            }
                            character.nrEnemies++;
                            gameFrame.jt3.setText("Level: "+character.level);
                            gameFrame.jt4.setText("Experience: "+character.experience);
                            gameFrame.jt5.setText("Life: "+character.currentLife);
                            gameFrame.jt6.setText("Mana: "+character.currentManna);
                            gameFrame.jt14.setText("Coins: "+character.inventory.coins);
                            gameFrame.jp.removeAll();
                            for(int k=0;k<character.abilities.size();k++)
                            {
                                JTextField jt=new JTextField(character.abilities.get(k).getClass().getSimpleName());
                                jt.setEditable(false);
                                jt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                                Font fontJt=new Font(jt.getFont().getName(),Font.BOLD,jt.getFont().getSize());
                                jt.setFont(fontJt);
                                gameFrame.jp.add(jt);
                            }
                            if(character.abilities.size()==0)
                                remove(gameFrame.jp);
                            WinFight winFight=new WinFight("Win");
                        }
                        lifeEnemy.setText("Viata curenta: "+enemy.currentLife);
                        manaCharacter.setText("Mana curenta: "+character.currentManna);
                        character.abilities.remove(index);
                        infoCharacter.remove(8+index);
                    }
                }
                else if(button3.getSelectedItem().equals("Foloseste abilitate"))
                    exist=0;


                Random rand=new Random();
                if(exist==1) {
                    int chanceAbility = rand.nextInt(2);
                    if (chanceAbility == 1 && enemy.abilities.size() != 0) {
                        int nrAbility = rand.nextInt(enemy.abilities.size());
                        character.accept(enemy.abilities.get(nrAbility));
                        if (enemy.currentManna >= enemy.abilities.get(nrAbility).costManna) {
                            character.receiveDamage(enemy.abilities.get(nrAbility).damage);
                            LoseBattle loseBattle;
                            LoseFrame loseFrame;
                            if(character.currentLife<=0)
                            {
                                dispose();
                                gameFrame.dispose();
                                loseBattle=new LoseBattle("You lost!");
                                loseFrame=new LoseFrame(character);
                            }
                            enemy.currentManna -= enemy.abilities.get(nrAbility).costManna;
                            lifeCharacter.setText("Viata curenta: " + character.currentLife);
                            manaEnemy.setText("Mana curenta: " + enemy.currentManna);
                            infoEnemy.remove(8 + nrAbility);
                            enemy.abilities.remove(nrAbility);
                        } else {
                            int damage1 = enemy.getDamage();
                            character.receiveDamage(damage1);
                            LoseBattle loseBattle;
                            LoseFrame loseFrame;
                            if(character.currentLife<=0)
                            {
                                dispose();
                                gameFrame.dispose();
                                loseBattle=new LoseBattle("You lost!");
                                loseFrame=new LoseFrame(character);
                            }
                            lifeCharacter.setText("Viata curenta: " + character.currentLife);
                        }
                    } else {
                        int damage1 = enemy.getDamage();
                        character.receiveDamage(damage1);
                        LoseBattle loseBattle;
                        LoseFrame loseFrame;
                        if(character.currentLife<=0)
                        {
                            dispose();
                            gameFrame.dispose();
                            loseBattle=new LoseBattle("You lost!");
                            loseFrame=new LoseFrame(character);
                        }
                        lifeCharacter.setText("Viata curenta: " + character.currentLife);
                    }
                }
                button3.setSelectedIndex(0);
                revalidate();
                repaint();
            }
        });
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        add(buttons,BorderLayout.PAGE_END);
        pack();
        show();
    }
}
