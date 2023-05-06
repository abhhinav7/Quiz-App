package quiz.app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    JButton rules,back;
    JTextField tfname ;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,600,470);
        add(image);
        
        JLabel heading = new JLabel("Simple Minds");
        heading.setBounds(775,60,300,45);
        heading.setFont(new Font("Calibiri",Font.BOLD,40));
        heading.setForeground(Color.blue);
        add(heading);
        
        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(815,125,200,20);
        name.setFont(new Font("Calibiri",Font.ITALIC,20));
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(750,150,300,25);
        tfname.setFont(new Font("Calibiri",Font.PLAIN,16));
        tfname.setHorizontalAlignment(JTextField.CENTER);
        add(tfname);
        
        rules = new JButton("Enter");
        rules.setBounds(750,180,145,25);
        rules.addActionListener(this); 
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(905,180,145,25);
        back.addActionListener(this);
        add(back);
        
        setSize(1200,500);
        setLocation(350,200);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==rules){
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
        }else if(ae.getSource()==back){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new Login();
        
    }
}


