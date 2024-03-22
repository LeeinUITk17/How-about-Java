import java.util.concurrent.TimeUnit;
import java.lang.Thread;
class Teller extends Thread{
    private int number=0;
      public Teller(String name){
         super(name);
      }
      public void run(){
        while(number<3){
            System.out.println(getName()+" is serving the customer");
            number++;
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
      }
}

public class multithreading{
    public static void main(String[] args){
        int numberofTellers = 3;
        for(int i=1;i<=numberofTellers;i++){
            Teller teller = new Teller("Teller "+i);
            teller.start();
        }
    }
}