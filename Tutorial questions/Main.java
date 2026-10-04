class EmergencyAlert extends Thread {
    public EmergencyAlert() { setName("EmergencyAlert"); setPriority(MAX_PRIORITY); }
    public void run() {
        for(int i=1;i<=3;i++) {
            System.out.println(getName()+" Priority:"+getPriority()+" - Critical Alert "+i);
        }
    }
}

class VitalMonitor extends Thread {
    public VitalMonitor() { setName("VitalMonitor"); setPriority(NORM_PRIORITY); }
    public void run() {
        for(int i=1;i<=3;i++) {
            System.out.println(getName()+" Priority:"+getPriority()+" - Checking Vitals "+i);
        }
    }
}

class ReportGenerator extends Thread {
    public ReportGenerator() { setName("ReportGenerator"); setPriority(MIN_PRIORITY); }
    public void run() {
        for(int i=1;i<=3;i++) {
            System.out.println(getName()+" Priority:"+getPriority()+" - Generating Report "+i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new EmergencyAlert().start();
        new VitalMonitor().start();
        new ReportGenerator().start();
    }
}
