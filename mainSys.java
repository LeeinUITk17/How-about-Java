
public class mainSys implements Runnable {
    private Synchronization account;

    public mainSys(Synchronization account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(500);
            account.withdraw(300);
        }
    }

    public static void main(String[] args) {
        Synchronization account = new Synchronization(0);
        mainSys transaction = new mainSys(account);
        Thread thread = new Thread(transaction);
        thread.start();
    }
}

class Synchronization {
    private int balance;

    public Synchronization(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public int getBalance() {
        return balance;
    }
}


class MainSys {
    public static void main(String[] args) {   
        Synchronization account = new Synchronization(1000); 
        mainSys transaction = new mainSys(account);
        Thread transactionThread1 = new Thread(transaction);
        Thread transactionThread2 = new Thread(transaction);
        transactionThread1.start();
        transactionThread2.start();
    }
}