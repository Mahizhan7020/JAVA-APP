public class StudentModel {
    private String name;
    private int m1,m2,m3;
    public StudentModel(String n,int a,int b,int c){name=n;m1=a;m2=b;m3=c;}
    public int getTotal(){return m1+m2+m3;}
    public double getAverage(){return getTotal()/3.0;}
    public String getGrade(){
        double avg=getAverage();
        if(avg>=90) return "A";
        else if(avg>=75) return "B";
        else if(avg>=60) return "C";
        else if(avg>=50) return "D";
        else return "F";
    }
    public String getName(){return name;}
}
import javax.swing.*;
public class StudentView extends JFrame {
    JTextField name=new JTextField();
    JTextField m1=new JTextField();
    JTextField m2=new JTextField();
    JTextField m3=new JTextField();
    JButton calc=new JButton("Calculate Result");
    JLabel result=new JLabel();
    public StudentView(){
        setTitle("Grade Calculator");
        setSize(400,400); setLayout(null);
        name.setBounds(100,50,150,30); m1.setBounds(100,100,150,30);
        m2.setBounds(100,150,150,30); m3.setBounds(100,200,150,30);
        calc.setBounds(100,250,150,30); result.setBounds(100,300,200,30);
        add(name);add(m1);add(m2);add(m3);add(calc);add(result);
        setVisible(true);
    }
}
public class StudentController {
    public StudentController(StudentView v){
        v.calc.addActionListener(e->{
            StudentModel m=new StudentModel(v.name.getText(),
                Integer.parseInt(v.m1.getText()),
                Integer.parseInt(v.m2.getText()),
                Integer.parseInt(v.m3.getText()));
            v.result.setText("Total:"+m.getTotal()+" Avg:"+m.getAverage()+" Grade:"+m.getGrade());
        });
    }
    public static void main(String[] args){new StudentController(new StudentView());}
}
