import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class concurrency{
    public static void main(String[] args) {
        Map<String, Integer> sharedData = new ConcurrentHashMap<>();
        Thread writerThread = new Thread(new WriterTask(sharedData));
        Thread readerThread = new Thread(new ReaderTask(sharedData));
        writerThread.start();
        readerThread.start();
    }

    static class WriterTask implements Runnable {
        private Map<String, Integer> sharedData;

        public WriterTask(Map<String, Integer> sharedData) {
            this.sharedData = sharedData;
        }

        public void run() {
            sharedData.put("key", 1);
            System.out.println("WriterTask: Data added to shared map.");
        }
    }

    static class ReaderTask implements Runnable {
        private Map<String, Integer> sharedData;

        public ReaderTask(Map<String, Integer> sharedData) {
            this.sharedData = sharedData;
        }

        public void run() {
            Integer value = sharedData.get("key");
            System.out.println("ReaderTask: Value from shared map: " + value);
        }
    }
}
