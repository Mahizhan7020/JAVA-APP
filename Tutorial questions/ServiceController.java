public class ServiceModel {
    public int calculate(boolean g,boolean o,boolean b,boolean bt){
        int cost=0;
        if(g) cost+=1000; if(o) cost+=800; if(b) cost+=1200; if(bt) cost+=500;
        return cost;
    }
}
import javax.swing.*;
public class ServiceView extends JFrame {
    JTextField reg=new JTextField();
    JComboBox<String> type=new JComboBox<>(new String[]{"Two Wheeler","Car"});
    JCheckBox gs=new JCheckBox("General Service ₹1000");
    JCheckBox oc=new JCheckBox("Oil Change ₹800");
    JCheckBox bs=new JCheckBox("Brake Service ₹1200");
    JCheckBox bc=new JCheckBox("Battery Check ₹500");
    JButton calc=new JButton("Calculate Cost");
    JLabel result=new JLabel();
    public ServiceView(){
        setTitle("Service Estimator"); setSize(400,400); setLayout(null);
        reg.setBounds(100,30,150,30); type.setBounds(100,70,150,30);
        gs.setBounds(100,110,200,30); oc.setBounds(100,140,200,30);
        bs.setBounds(100,170,200,30); bc.setBounds(100,200,200,30);
        calc.setBounds(100,240,150,30); result.setBounds(100,280,200,30);
        add(reg);add(type);add(gs);add(oc);add(bs);add(bc);add(calc);add(result);
        setVisible(true);
    }
}
public class ServiceController {
    public ServiceController(ServiceView v){
        ServiceModel m=new ServiceModel();
        v.calc.addActionListener(e->{
            int cost=m.calculate(v.gs.isSelected(),v.oc.isSelected(),v.bs.isSelected(),v.bc.isSelected());
            v.result.setText("Total Cost: ₹"+cost);
        });
    }
    public static void main(String[] args){new ServiceController(new ServiceView());}
}
