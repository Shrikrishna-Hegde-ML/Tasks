
public class MyRunnable implements Runnable{

    @Override
    public void run(){
        try{
        for(int i=0;i<10;i++){
            System.out.println("Running in Runnable");
            Thread.sleep(500);
        }
    }catch(Exception e){System.out.println(e);}
        
        
    }

    public static void main(String[] args) {
        MyRunnable newRun = new MyRunnable();
        Thread th = new Thread(newRun);
        th.start();
        
        
    }
}