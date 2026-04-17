package multithreading;

class Worker2 implements Runnable {
    private final Object lockA;
    private final Object lockB;

    Worker2(Object lockA, Object lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockB) {
            System.out.println(Thread.currentThread().getName() + " acquired lockB");
            try {
                Thread.sleep(100); // gives the other thread time to grab lockA
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println(Thread.currentThread().getName() + " trying to acquire lockA");
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + " acquired lockA");
            }
        }
    }
}