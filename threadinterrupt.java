public class threadinterrupt {
    public static void main(String[] args) {
        Thread taskThread = new Thread(new Task());
        taskThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        taskThread.interrupt();
    }

    static class Task implements Runnable {
        public void run() {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Task is running... (" + i + "/5)");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Task interrupted. Stopping...");
                return; 
            }
            System.out.println("Task completed successfully.");
        }
    }
}
