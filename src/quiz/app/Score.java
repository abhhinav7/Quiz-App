package quiz.app;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Score extends JFrame implements ActionListener{
    JButton Exit,Restart;
    Score(String name,int score){
        setBounds(600, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 =i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,150,300,250);
        add(image);
        
        JLabel heading = new JLabel("Thankyou " +name+" for playing Simple Minds",JLabel.CENTER);
        heading.setBounds(0,0,750,30);
        heading.setFont(new Font("Calibiri",Font.PLAIN,20));
        add(heading);
        
        JLabel sc = new JLabel("Your Score is "+score);
        sc.setBounds(430,230,400,30);
        sc.setFont(new Font("Calibiri",Font.PLAIN,30));
        add(sc);
        
        Exit = new JButton("Exit");
        Exit.setBounds(430,320,100,40);
        Exit.addActionListener(this);
        add(Exit);
        
        Restart = new JButton("Restart");
        Restart.setBounds(540,320,100,40);
        Restart.addActionListener(this);
        add(Restart);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Exit){
            setVisible(false);
        }
        else{
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args){
        new Score("user",0);
    }
}
