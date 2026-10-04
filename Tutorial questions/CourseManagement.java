import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CourseManagement {
    public static void main(String[] args) {
        JFrame f = new JFrame("Course Management");
        String[] courses = {"Java","Python","C++","DBMS"};
        JList<String> list = new JList<>(courses);
        JScrollPane sp1 = new JScrollPane(list); sp1.setBounds(20,20,100,100);

        String[] cols = {"Name","Course","Status"};
        DefaultTableModel model = new DefaultTableModel(cols,0);
        JTable table = new JTable(model);
        JScrollPane sp2 = new JScrollPane(table); sp2.setBounds(150,20,300,150);

        JTextField name = new JTextField(); name.setBounds(20,140,100,30);
        JButton add = new JButton("Add"); add.setBounds(20,180,100,30);
        JButton remove = new JButton("Remove"); remove.setBounds(20,220,100,30);

        add.addActionListener(e -> {
            model.addRow(new Object[]{name.getText(),list.getSelectedValue(),"Enrolled"});
        });
        remove.addActionListener(e -> {
            int row = table.getSelectedRow();
            if(row!=-1) model.removeRow(row);
        });

        f.add(sp1); f.add(sp2); f.add(name); f.add(add); f.add(remove);
        f.setSize(500,300); f.setLayout(null); f.setVisible(true);
    }
}
