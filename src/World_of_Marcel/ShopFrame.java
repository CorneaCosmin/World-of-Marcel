package World_of_Marcel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopFrame extends JFrame
{
    public ShopFrame(String name, Character character,Shop shop,GameFrame gameFrame)
    {
        super(name);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1830,830));
        ImageIcon imageIcon=new ImageIcon("src\\World_of_Marcel\\bottlepotion.png");
        Image image=imageIcon.getImage();
        Image image1 = image.getScaledInstance(150, 150, Image.SCALE_FAST);
        imageIcon=new ImageIcon(image1);
        setIconImage(image1);
        add(new JLabel(imageIcon),BorderLayout.CENTER);
        int i;

        JPanel infoShop=new JPanel();
        infoShop.setLayout(new GridLayout(1+shop.potions.size(),1));
        JLabel potionsShop=new JLabel("Potiuni din magazin:");
        potionsShop.setBackground(new Color(255,128,0));
        infoShop.add(potionsShop);
        for(i=0;i<shop.potions.size();i++)
        {
            JPanel combine=new JPanel();
            JTextField potion=new JTextField("Potiune: "+shop.potions.get(i).getClass().getSimpleName());
            potion.setEditable(false);
            potion.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            Font fontPotion=new Font(potion.getFont().getName(),Font.BOLD,potion.getFont().getSize());
            potion.setFont(fontPotion);
            potion.setBackground(new Color(255,128,0));
            JTextField price=new JTextField("Pret: "+shop.potions.get(i).pricePotion());
            price.setEditable(false);
            price.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            Font fontCoins=new Font(price.getFont().getName(),Font.BOLD,price.getFont().getSize());
            price.setFont(fontCoins);
            price.setBackground(new Color(255,128,0));
            JTextField weight=new JTextField("Greutate:"+shop.potions.get(i).weightPotion());
            weight.setEditable(false);
            weight.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            Font fontWeight=new Font(weight.getFont().getName(),Font.BOLD,weight.getFont().getSize());
            weight.setFont(fontWeight);
            weight.setBackground(new Color(255,128,0));
            combine.add(potion);
            combine.add(price);
            combine.add(weight);
            combine.setBackground(new Color(255,128,0));
            infoShop.add(combine);
        }
        infoShop.setBackground(new Color(255,128,0));
        add(infoShop,BorderLayout.EAST);

        JPanel infoPotions=new JPanel();
        infoPotions.setLayout(new GridLayout(7,1));
        JLabel inventory=new JLabel("Inventar:");
        JTextField coins=new JTextField("Monede: "+character.inventory.coins);
        coins.setEditable(false);
        coins.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font fontCoins=new Font(coins.getFont().getName(),Font.BOLD,coins.getFont().getSize());
        coins.setFont(fontCoins);
        JTextField weight=new JTextField("Greutate: "+character.inventory.currentWeight);
        weight.setEditable(false);
        weight.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font fontWeight=new Font(weight.getFont().getName(),Font.BOLD,weight.getFont().getSize());
        weight.setFont(fontWeight);
//        JPanel potiuni=new JPanel();
//        potiuni.setLayout(new GridLayout(character.inventory.potions.size()+1,1));
        inventory.setBackground(Color.GREEN);
        infoPotions.add(inventory);
        coins.setBackground(Color.GREEN);
        infoPotions.add(coins);
        weight.setBackground(Color.GREEN);
        infoPotions.add(weight);
        JLabel titlePotion=new JLabel("Potiuni curente: ");
        titlePotion.setBackground(Color.GREEN);
        infoPotions.add(titlePotion);
        for(i=0;i<character.inventory.potions.size();i++)
        {
            JPanel combine=new JPanel();
            JTextField potion=new JTextField("Potiune: "+shop.potions.get(i).getClass().getSimpleName());
            potion.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            Font fontPotion=new Font(potion.getFont().getName(),Font.BOLD,potion.getFont().getSize());
            potion.setFont(fontPotion);
            potion.setBackground(Color.GREEN);
            JTextField price=new JTextField("Pret: "+shop.potions.get(i).pricePotion());
            price.setEditable(false);
            price.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            Font fontCoins1=new Font(price.getFont().getName(),Font.BOLD,price.getFont().getSize());
            price.setFont(fontCoins1);
            price.setBackground(Color.GREEN);
            JTextField weight1=new JTextField("Greutate: "+shop.potions.get(i).weightPotion());
            weight1.setEditable(false);
            weight1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            Font fontWeight1=new Font(weight1.getFont().getName(),Font.BOLD,weight1.getFont().getSize());
            weight1.setFont(fontWeight1);
            weight1.setBackground(Color.GREEN);
            combine.add(potion);
            combine.add(price);
            combine.add(weight1);
            combine.setBackground(Color.GREEN);
            infoPotions.add(combine);
        }
//        potiuni.setBackground(Color.GREEN);
//        infoPotions.add(potiuni);
        infoPotions.setBackground(Color.GREEN);
        add(infoPotions,BorderLayout.WEST);


        JPanel buttons=new JPanel();
        buttons.setLayout(new FlowLayout());
        JButton manaButton=new JButton("Cumpara potiune de mana!");
        JButton healthButton=new JButton("Cumpara potiune de viata!");
        JButton back=new JButton("Intoarce-te la joc!");

        manaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if(manaButton.isSelected()==false)
//                    return;
                int indexPotion=-1;
                for(int j=0;j<shop.potions.size();j++)
                    if(shop.potions.get(j).getClass().getSimpleName().equals("ManaPotion"))
                    {
                        indexPotion=j;
                        break;
                    }
                if(indexPotion==-1)
                {
                    ErrorManaPotion errorManaPotion=new ErrorManaPotion("Eroare ManaPotion");
                }
                else if(character.inventory.coins<shop.potions.get(indexPotion).pricePotion())
                {
                    ErrorCoins errorCoins=new ErrorCoins("Eroare bani");
                }
                else if(character.inventory.calculateWeight()<shop.potions.get(indexPotion).pricePotion())
                {
                    ErrorWeight errorWeight=new ErrorWeight("Eroare greutate");
                }
                else
                {
                    character.inventory.coins-=shop.potions.get(indexPotion).pricePotion();
                    character.inventory.currentWeight+=shop.potions.get(indexPotion).weightPotion();
                    character.inventory.potions.add(shop.potions.get(indexPotion));
                    coins.setText("Monede: "+character.inventory.coins);
                    weight.setText("Greutate: "+ character.inventory.currentWeight);
                    JPanel combine=new JPanel();
                    JTextField potion=new JTextField("Potiune: "+shop.potions.get(indexPotion).getClass().getSimpleName());
                    JTextField price=new JTextField("Pret: "+shop.potions.get(indexPotion).pricePotion());
                    JTextField weight1=new JTextField("Greutate: "+shop.potions.get(indexPotion).weightPotion());
                    potion.setEditable(false);
                    potion.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                    Font fontPotion=new Font(potion.getFont().getName(),Font.BOLD,potion.getFont().getSize());
                    potion.setFont(fontPotion);
                    price.setEditable(false);
                    price.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                    Font fontCoins=new Font(price.getFont().getName(),Font.BOLD,price.getFont().getSize());
                    price.setFont(fontCoins);
                    weight1.setEditable(false);
                    weight1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                    Font fontWeight=new Font(weight1.getFont().getName(),Font.BOLD,weight1.getFont().getSize());
                    weight1.setFont(fontWeight);
                    price.setBackground(Color.GREEN);
                    potion.setBackground(Color.GREEN);
                    weight1.setBackground(Color.GREEN);
                    combine.add(potion);
                    combine.add(price);
                    combine.add(weight1);
                    combine.setBackground(Color.GREEN);
                    infoPotions.add(combine);
                    shop.potions.remove(indexPotion);
                    infoShop.setLayout(new GridLayout(shop.potions.size()+1,1));
                    infoShop.remove(indexPotion+1);
                    revalidate();
                    repaint();
                }
            }
        });

        healthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if(manaButton.isSelected()==false)
//                    return;
                int indexPotion=-1;
                for(int j=0;j<shop.potions.size();j++)
                    if(shop.potions.get(j).getClass().getSimpleName().equals("HealthPotion"))
                    {
                        indexPotion=j;
                        break;
                    }
                if(indexPotion==-1)
                {
                    ErrorHealthPotion errorHealthPotion=new ErrorHealthPotion("Eroare HealthPotion");
                }
                else if(character.inventory.coins<shop.potions.get(indexPotion).pricePotion())
                {
                    ErrorCoins errorCoins=new ErrorCoins("Eroare bani");
                }
                else if(character.inventory.calculateWeight()<shop.potions.get(indexPotion).pricePotion())
                {
                    ErrorWeight errorWeight=new ErrorWeight("Eroare greutate");
                }
                else
                {
                    character.inventory.coins-=shop.potions.get(indexPotion).pricePotion();
                    character.inventory.currentWeight+=shop.potions.get(indexPotion).weightPotion();
                    character.inventory.potions.add(shop.potions.get(indexPotion));
                    weight.setText("Greutate: "+ character.inventory.currentWeight);
                    coins.setText("Monede: "+character.inventory.coins);
                    JPanel combine=new JPanel();
                    JTextField potion=new JTextField("Potiune: "+shop.potions.get(indexPotion).getClass().getSimpleName());
                    JTextField price=new JTextField("Pret: "+shop.potions.get(indexPotion).pricePotion());
                    JTextField weight1=new JTextField("Greutate: "+shop.potions.get(indexPotion).weightPotion());
                    potion.setEditable(false);
                    potion.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                    Font fontPotion=new Font(potion.getFont().getName(),Font.BOLD,potion.getFont().getSize());
                    potion.setFont(fontPotion);
                    price.setEditable(false);
                    price.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                    Font fontCoins=new Font(price.getFont().getName(),Font.BOLD,price.getFont().getSize());
                    price.setFont(fontCoins);
                    weight1.setEditable(false);
                    weight1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                    Font fontWeight=new Font(weight1.getFont().getName(),Font.BOLD,weight1.getFont().getSize());
                    weight1.setFont(fontWeight);
                    price.setBackground(Color.GREEN);
                    potion.setBackground(Color.GREEN);
                    weight1.setBackground(Color.GREEN);
                    combine.add(potion);
                    combine.add(price);
                    combine.add(weight1);
                    combine.setBackground(Color.GREEN);
                    infoPotions.add(combine);
                    shop.potions.remove(indexPotion);
                    infoShop.setLayout(new GridLayout(shop.potions.size()+1,1));
                    infoShop.remove(indexPotion+1);
                    revalidate();
                    repaint();
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if(back.isSelected()==false)
//                    return;
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
                dispose();
            }
        });
        buttons.add(manaButton);
        buttons.add(healthButton);
        buttons.add(back);
        add(buttons,BorderLayout.SOUTH);
        pack();
        show();
    }
}
