import javax.swing.*;

public class StudentRegistration {
    public static void main(String[] args) {
        JFrame f = new JFrame("Student Registration");
        JTextField name = new JTextField(); name.setBounds(100,50,150,30);
        JTextField reg = new JTextField(); reg.setBounds(100,100,150,30);
        JRadioButton male = new JRadioButton("Male"); male.setBounds(100,150,70,30);
        JRadioButton female = new JRadioButton("Female"); female.setBounds(180,150,80,30);
        ButtonGroup bg = new ButtonGroup(); bg.add(male); bg.add(female);
        String[] dept = {"CSE","IT","ECE","EEE"};
        JComboBox<String> cb = new JComboBox<>(dept); cb.setBounds(100,200,150,30);
        JButton submit = new JButton("Submit"); submit.setBounds(100,250,150,30);

        submit.addActionListener(e -> {
            String gender = male.isSelected() ? "Male" : "Female";
            JOptionPane.showMessageDialog(f,"Name:"+name.getText()+" RegNo:"+reg.getText()+" Gender:"+gender+" Dept:"+cb.getSelectedItem());
        });

        f.add(name); f.add(reg); f.add(male); f.add(female); f.add(cb); f.add(submit);
        f.setSize(400,400); f.setLayout(null); f.setVisible(true);
    }
}
