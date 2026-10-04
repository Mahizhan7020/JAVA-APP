public class EmployeeModel {
    private String id,name,dept;
    private String username="admin";
    private String password="admin123";

    public boolean validateLogin(String u,String p){
        return u.equals(username) && p.equals(password);
    }

    public boolean changePassword(String oldPass,String newPass){
        if(oldPass.equals(password)){
            password=newPass;
            return true;
        }
        return false;
    }

    public void setEmployee(String i,String n,String d){
        id=i; name=n; dept=d;
    }

    public String getEmployee(){
        return "ID:"+id+" Name:"+name+" Dept:"+dept;
    }
}
import javax.swing.*;

public class EmployeeView {
    JFrame loginFrame=new JFrame("Login");
    JTextField user=new JTextField();
    JPasswordField pass=new JPasswordField();
    JButton loginBtn=new JButton("Login");

    JFrame mainFrame=new JFrame("Employee Portal");
    JMenuBar mb=new JMenuBar();
    JMenu emp=new JMenu("Employee");
    JMenuItem addEmp=new JMenuItem("Add Employee");
    JMenuItem viewEmp=new JMenuItem("View Employee");
    JMenu tools=new JMenu("Tools");
    JMenuItem changePass=new JMenuItem("Change Password");
    JMenu exit=new JMenu("Exit");
    JMenuItem logout=new JMenuItem("Logout");
    JMenuItem exitApp=new JMenuItem("Exit Application");

    public EmployeeView(){
        loginFrame.setSize(300,200); loginFrame.setLayout(null);
        user.setBounds(100,30,150,30); pass.setBounds(100,70,150,30);
        loginBtn.setBounds(100,110,100,30);
        loginFrame.add(user); loginFrame.add(pass); loginFrame.add(loginBtn);
        loginFrame.setVisible(true);

        emp.add(addEmp); emp.add(viewEmp);
        tools.add(changePass);
        exit.add(logout); exit.add(exitApp);
        mb.add(emp); mb.add(tools); mb.add(exit);
        mainFrame.setJMenuBar(mb);
        mainFrame.setSize(400,300);
    }
}
import javax.swing.*;

public class EmployeeController {
    EmployeeModel model;
    EmployeeView view;

    public EmployeeController(EmployeeModel m,EmployeeView v){
        model=m; view=v;

        v.loginBtn.addActionListener(e->{
            if(model.validateLogin(v.user.getText(),new String(v.pass.getPassword()))){
                JOptionPane.showMessageDialog(v.loginFrame,"Login Successful");
                v.loginFrame.dispose();
                v.mainFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(v.loginFrame,"Invalid Credentials");
            }
        });

        v.addEmp.addActionListener(e->{
            JTextField id=new JTextField();
            JTextField name=new JTextField();
            JTextField dept=new JTextField();
            Object[] fields={"ID",id,"Name",name,"Dept",dept};
            int opt=JOptionPane.showConfirmDialog(v.mainFrame,fields,"Add Employee",JOptionPane.OK_CANCEL_OPTION);
            if(opt==JOptionPane.OK_OPTION){
                model.setEmployee(id.getText(),name.getText(),dept.getText());
                JOptionPane.showMessageDialog(v.mainFrame,"Employee Added");
            }
        });

        v.viewEmp.addActionListener(e->{
            JOptionPane.showMessageDialog(v.mainFrame,model.getEmployee());
        });

        v.changePass.addActionListener(e->{
            JPasswordField oldP=new JPasswordField();
            JPasswordField newP=new JPasswordField();
            JPasswordField confP=new JPasswordField();
            Object[] fields={"Old Password",oldP,"New Password",newP,"Confirm Password",confP};
            int opt=JOptionPane.showConfirmDialog(v.mainFrame,fields,"Change Password",JOptionPane.OK_CANCEL_OPTION);
            if(opt==JOptionPane.OK_OPTION){
                if(!new String(newP.getPassword()).equals(new String(confP.getPassword()))){
                    JOptionPane.showMessageDialog(v.mainFrame,"Passwords do not match");
                } else if(model.changePassword(new String(oldP.getPassword()),new String(newP.getPassword()))){
                    JOptionPane.showMessageDialog(v.mainFrame,"Password Changed");
                } else {
                    JOptionPane.showMessageDialog(v.mainFrame,"Old Password Incorrect");
                }
            }
        });

        v.logout.addActionListener(e->{
            v.mainFrame.dispose();
            new EmployeeController(new EmployeeModel(),new EmployeeView());
        });

        v.exitApp.addActionListener(e->System.exit(0));
    }

    public static void main(String[] args){
        new EmployeeController(new EmployeeModel(),new EmployeeView());
    }
}
