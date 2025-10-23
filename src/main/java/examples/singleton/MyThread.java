package examples.singleton;

public class MyThread {
    private static int count = 0;
    private final int threadNum;

    public MyThread() {
        threadNum = ++count;
    }

    @Override
    public String toString() {
        return "Thread " + threadNum;
    }
}
