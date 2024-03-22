import java.lang.Thread;
public class threadclass extends Thread{
    private int seconds;

    public threadclass(String name, int seconds){
            super(name);
            this.seconds=seconds;
    }
    
    public void run(){
        while(seconds>0){
            System.out.println(getName()+" is counting down "+seconds);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            seconds--;
        }
        System.out.println(getName()+" is done counting down");
    }

     public static void main(String[] args){
        threadclass t1 = new threadclass("Thread 1", 5);
        threadclass t2 = new threadclass("Thread 2", 7);
        t1.start();
        t2.start();
     }
}