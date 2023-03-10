package World_of_Marcel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class Autentificare extends JFrame
{
    int numberAccount;
    public Autentificare(String name, List<Account> accounts, LinkedList<LinkedList<String>> stories)
    {
        super(name);
        numberAccount=-1;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(100,50));
//        setLayout(new FlowLayout());
        JLabel email=new JLabel("Email:");
        JTextField email1=new JTextField(20);
        JLabel password=new JLabel("Password:");
        JPasswordField password1=new JPasswordField(20);
        JPanel panel1=new JPanel();
        panel1.add(email);
        panel1.add(email1);
        JPanel panel2=new JPanel();
        panel2.add(password);
        panel2.add(password1);
        JPanel panel3=new JPanel();
        panel3.add(panel1);
        panel3.add(panel2);
        ImageIcon imageIcon=new ImageIcon("src\\World_of_Marcel\\Screenshot 2022-01-10 191536.png");
        Image image=imageIcon.getImage();
        Image image1=image.getScaledInstance(300,250,Image.SCALE_FAST);
        imageIcon=new ImageIcon(image1);
        add(new JLabel(imageIcon),BorderLayout.NORTH);
        setIconImage(image);
        add(panel3,BorderLayout.CENTER);
        JButton jb=new JButton("Login");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i;
                for(i=0;i<accounts.size();i++) {
                    if (email1.getText().equals(accounts.get(i).info.getCred().getEmail()) && password1.getText().equals(accounts.get(i).info.getCred().getPassword()))
                        {
                            numberAccount=i;
                            dispose();
                            CharacterFrame characterFrame=new CharacterFrame("Character",numberAccount,accounts,stories);
                            break;
                        }
                    }
                if(i==accounts.size())
                {
                    dispose();
                    Check fail=new Check("Fail");
                }
                }
        });
        add(jb,BorderLayout.PAGE_END);
        setVisible(true);
        pack();
        show();
    }
}

