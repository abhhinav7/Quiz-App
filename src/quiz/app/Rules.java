package quiz.app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Rules extends JFrame implements ActionListener{
    String Full_name;
    JButton start,exit;
    Rules(String Full_Name){
        this.Full_name = Full_Name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Welcome "+Full_Name+" to Simple Minds",JLabel.CENTER);
        heading.setBounds(0,20,700,30);
        heading.setFont(new Font("Calibiri",Font.BOLD,25));
        heading.setForeground(Color.black);
        add(heading);
        
        JLabel rules = new JLabel();
        rules.setBounds(20,90,700,500);
        rules.setFont(new Font("Calibiri",Font.PLAIN,18));
        rules.setForeground(Color.black);
        rules.setText(
                "<html>"+ 
                "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
                "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                "4. Crying is allowed but please do so quietly." + "<br><br>" +
                "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
                "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
            "<html>"
        );
        add(rules);
        
        start = new JButton("Enter");
        start.setBounds(10,600,145,25);
        start.addActionListener(this); 
        add(start);
        
        exit = new JButton("Back");
        exit.setBounds(160,600,145,25);
        exit.addActionListener(this);
        add(exit);
        
        setSize(800,720);
        setLocation(540,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==start){
            new Quiz(Full_name);
            setVisible(false);
        }else{
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args){
        new Rules("User");
    }
}
