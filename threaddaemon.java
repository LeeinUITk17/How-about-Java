public class threaddaemon {
    public static void main(String[] args) {
        MonitorThread monitorThread = new MonitorThread();
        monitorThread.setDaemon(true);
        monitorThread.start();
        WorkerThread worker1 = new WorkerThread("Worker 1");
        WorkerThread worker2 = new WorkerThread("Worker 2");
        worker1.start();
        worker2.start();
        try {
            worker1.join();
            worker2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All worker threads have finished.");
    }
    static class MonitorThread extends Thread {
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Monitoring system resources...");
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }  } } }
    static class WorkerThread extends Thread {
        public WorkerThread(String name) {
            super(name);
        }
        public void run() {
            System.out.println(getName() + " started.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " finished.");
        }}}
