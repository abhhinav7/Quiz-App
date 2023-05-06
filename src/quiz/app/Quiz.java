package quiz.app;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Quiz extends JFrame implements ActionListener{
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String user_answers[] = new String[10];
    
    JLabel Question_Number,Question;
    JRadioButton option1,option2,option3,option4;
    ButtonGroup groupoption;
    JButton next ,submit;
    
    public static int timer = 30;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    public static String name;
    
    Quiz(String name){
        this.name=name;
        setBounds(250, 0, 1440, 1080);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1440,392);
        add(image);
        
        Question_Number = new JLabel();
        Question_Number.setBounds(100,450,50,30);
        Question_Number.setFont(new Font("Calibiri",Font.PLAIN,24));
        add(Question_Number);
        
        Question = new JLabel();
        Question.setBounds(150,450,900,30);
        Question.setFont(new Font("Calibiri",Font.PLAIN,24));
        add(Question);
        
        
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";
        
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";
        
        option1 = new JRadioButton();
        option1.setBounds(170,500,700,30);
        option1.setBackground(Color.WHITE);
        option1.setFont(new Font("Calibiri",Font.PLAIN,20));
        add(option1);
        
        option2 = new JRadioButton();
        option2.setBounds(170,530,700,30);
        option2.setBackground(Color.WHITE);
        option2.setFont(new Font("Calibiri",Font.PLAIN,20));
        add(option2);
        
        option3 = new JRadioButton();
        option3.setBounds(170,560,700,30);
        option3.setBackground(Color.WHITE);
        option3.setFont(new Font("Calibiri",Font.PLAIN,20));
        add(option3);
        
        option4 = new JRadioButton();
        option4.setBounds(170,590,700,30);
        option4.setBackground(Color.WHITE);
        option4.setFont(new Font("Calibiri",Font.PLAIN,20));
        add(option4);
        
        groupoption= new ButtonGroup();
        groupoption.add(option1);
        groupoption.add(option2);
        groupoption.add(option3);
        groupoption.add(option4);
        
        next = new JButton("Next");
        next.setBounds(1100,500,200,40);
        next.addActionListener(this);
        add(next);
        
        submit = new JButton("Submit");
        submit.setBounds(1100,580,200,40);
        submit.addActionListener(this);
        add(submit);
        submit.setEnabled(false);
        
        start(count);
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        String time = "Time Left - "+ timer+" seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Calibiri",Font.PLAIN,20));
        if(timer > 0){
            g.drawString(time,1100,500);
        }else{
            g.drawString("Time Up!!",1100,500);
        }
        
        timer--;
        try{
            Thread.sleep(1000);
            repaint();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(ans_given==1){
            ans_given=0;
            timer=30;
        }
        else if(timer<0){
            timer = 30;
            if(count==8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count==9){
                if(groupoption.getSelection()==null){
                    user_answers[count]="";
                }
                else{
                    user_answers[count]=groupoption.getSelection().getActionCommand();  
                }
                for(int i=0;i<user_answers.length;i++){
                    if(user_answers[i].equals(answers[i][1])){
                        score+=10;
                    }
                }
                setVisible(false);
                new Score(name,score);
            }
            else{
                if(groupoption.getSelection()==null){
                    user_answers[count++]="";
                }
                else{
                    user_answers[count++]=groupoption.getSelection().getActionCommand();               
                }
            }
            start(count);
        }
        
        
    }
    
    public void start(int count){
        Question_Number.setText(""+(count+1)+". ");
        Question.setText(questions[count][0]);
        
        option1.setText(questions[count][1]);
        option1.setActionCommand(questions[count][1]);
        
        option2.setText(questions[count][2]);
        option2.setActionCommand(questions[count][2]);
        
        option3.setText(questions[count][3]);
        option3.setActionCommand(questions[count][3]);
        
        option4.setText(questions[count][4]);
        option4.setActionCommand(questions[count][4]);
        
        groupoption.clearSelection();
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            repaint();
            ans_given=1;
            if(groupoption.getSelection()==null){
                user_answers[count]="";
            }
            else{
                user_answers[count]=groupoption.getSelection().getActionCommand();               
            }
            if(count==8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        }
        if(ae.getSource()==submit){
            ans_given=1;
            if(groupoption.getSelection()==null){
                user_answers[count]="";
            }
            else{
                user_answers[count]= groupoption.getSelection().getActionCommand();
            }
            for(int i=0;i<user_answers.length;i++){
                    if(user_answers[i].equals(answers[i][1])){
                        score+=10;
                    }
                }
            setVisible(false);
            new Score(name,score);
            
        }
    }
    public static void main(String[] args){
        new Quiz("User");
    }
}
