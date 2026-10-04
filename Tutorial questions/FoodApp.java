class OrderProcessing extends Thread {
    public OrderProcessing() { setName("OrderProcessing"); setPriority(MAX_PRIORITY); }
    public void run() {
        for(int i=1;i<=3;i++) {
            System.out.println(getName()+" Priority:"+getPriority()+" - Processing Order "+i);
        }
    }
}

class DeliveryTracking extends Thread {
    public DeliveryTracking() { setName("DeliveryTracking"); setPriority(NORM_PRIORITY); }
    public void run() {
        for(int i=1;i<=3;i++) {
            System.out.println(getName()+" Priority:"+getPriority()+" - Tracking Delivery "+i);
        }
    }
}

class Notification extends Thread {
    public Notification() { setName("Notification"); setPriority(MIN_PRIORITY); }
    public void run() {
        for(int i=1;i<=3;i++) {
            System.out.println(getName()+" Priority:"+getPriority()+" - Sending Notification "+i);
        }
    }
}

public class FoodApp {
    public static void main(String[] args) {
        new OrderProcessing().start();
        new DeliveryTracking().start();
        new Notification().start();
    }
}
