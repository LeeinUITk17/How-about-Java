import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sysnch {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable task = new Task(i);
            threadPool.execute(task);
        }
        threadPool.shutdown();
    }

    static class Task implements Runnable {
        private int taskId;

        public Task(int id) {
            this.taskId = id;
        }

        @Override
        public void run() {
            System.out.println("Task " + taskId + " is running.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task " + taskId + " is completed.");
        }
    }
}
