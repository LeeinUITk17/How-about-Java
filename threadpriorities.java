public class threadpriorities {
    public static void main(String[] args) {
        Thread highPriorityThread = new Thread(new Task(), "HighPriorityThread");
        Thread lowPriorityThread = new Thread(new Task(), "LowPriorityThread");

        highPriorityThread.setPriority(Thread.MAX_PRIORITY); 
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY); 

        highPriorityThread.start();
        lowPriorityThread.start();
    }
    static class Task implements Runnable {
        public void run() {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                Math.sin(i);
            }
            long endTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " - Execution time: " + (endTime - startTime) + "ms");
        }
    }
}
