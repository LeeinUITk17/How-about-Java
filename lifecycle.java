import java.lang.Thread;
public class lifecycle {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Thread state: " + Thread.currentThread().getState());
        });
        System.out.println("Thread state: " + thread.getState()); 
        thread.start();
        try {
            Thread.sleep(100); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread state: " + thread.getState()); 
        try {
            thread.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread state: " + thread.getState()); 
    }
}