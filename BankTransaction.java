public class BankTransaction implements Runnable {
    private synchronization account;

    public BankTransaction(synchronization account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(500);
            account.withdraw(300);
        }
    }

    public static void main(String[] args) {
        synchronization account = new synchronization(0);
        BankTransaction transaction = new BankTransaction(account);
        Thread thread = new Thread(transaction);
        thread.start();
    }
}
