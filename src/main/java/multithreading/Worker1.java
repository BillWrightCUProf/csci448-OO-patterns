package multithreading;

class Worker1 implements Runnable {
    private final Object lockA;
    private final Object lockB;

    Worker1(Object lockA, Object lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + " acquired lockA");
            try {
                Thread.sleep(100); // gives the other thread time to grab lockB
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println(Thread.currentThread().getName() + " trying to acquire lockB");
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + " acquired lockB");
            }
        }
    }
}
