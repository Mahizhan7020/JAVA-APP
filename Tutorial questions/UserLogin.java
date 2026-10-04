import javax.swing.*;

public class UserLogin {
    public static void main(String[] args) {
        JFrame f = new JFrame("Login");
        JTextField user = new JTextField(); user.setBounds(100,50,150,30);
        JPasswordField pass = new JPasswordField(); pass.setBounds(100,100,150,30);
        JCheckBox remember = new JCheckBox("Remember Me"); remember.setBounds(100,150,150,30);
        JCheckBox notify = new JCheckBox("Receive Notifications"); notify.setBounds(100,180,200,30);
        JButton login = new JButton("Login"); login.setBounds(100,220,150,30);

        login.addActionListener(e -> {
            JOptionPane.showMessageDialog(f,"Login Successful for "+user.getText());
        });

        f.add(user); f.add(pass); f.add(remember); f.add(notify); f.add(login);
        f.setSize(400,400); f.setLayout(null); f.setVisible(true);
    }
}
