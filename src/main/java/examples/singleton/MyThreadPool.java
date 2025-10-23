package examples.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MyThreadPool implements Pool<MyThread>, ObjectFactory<MyThread> {
    private static MyThreadPool instance = new MyThreadPool();
    private static final int DEFAULT_SIZE = 2;

    private final Map<MyThread, Boolean> pool;

    private MyThreadPool() {
        pool = new HashMap<>();
    }

    public static MyThreadPool getInstance() {
        if (instance == null) {
            instance = new MyThreadPool();
        }
        return instance;
    }

    @Override
    public MyThread createNew() {
        return new MyThread();
    }

    @Override
    public synchronized Optional<MyThread> get() {
        for (Map.Entry<MyThread, Boolean> threadAvailable : pool.entrySet()) {
            if (threadAvailable.getValue()) {
                threadAvailable.setValue(false);
                return Optional.of(threadAvailable.getKey());
            }
        }
        if (pool.size() < DEFAULT_SIZE) {
            MyThread newThread = createNew();
            pool.put(newThread, false);
            return Optional.of(newThread);
        }
        return Optional.empty();
    }

    @Override
    public synchronized void release(MyThread object) {
        pool.put(object, true);
    }

    @Override
    public void shutdown() {
    }
}
