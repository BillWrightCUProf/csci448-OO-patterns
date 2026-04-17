package multithreading;

public class DeadlockDemo {
    public static void main(String[] args) {
        final Object lockA = new Object();
        final Object lockB = new Object();

        Thread t1 = new Thread(new Worker1(lockA, lockB), "Thread-1");
        Thread t2 = new Thread(new Worker2(lockA, lockB), "Thread-2");

        t1.start();
        t2.start();
    }
}