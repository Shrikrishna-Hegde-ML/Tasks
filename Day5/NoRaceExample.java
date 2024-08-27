
public class NoRaceExample {

    public static int sharedVariable = 0;
    public static void main(String[] args) {
        MyThread th1 = new MyThread();
        MyThread th2 = new MyThread();
        try {
        th1.start();
        th2.start();
        
        th1.join();
        th2.join();

        System.out.println(sharedVariable);
        
        } catch (Exception e) {
            
        }
        
        
    }
    static class MyThread extends Thread{

        //Object lock = new Object();
        
        @Override
        public void run(){
                incrementVar();
            }
        public synchronized void incrementVar(){
            //synchronized (lock)
            {
                int i=0;
                while (i<5) {
                sharedVariable++;
                i++;
            }
        }    
        }
    }
}

