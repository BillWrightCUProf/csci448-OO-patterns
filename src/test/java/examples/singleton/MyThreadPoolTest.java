package examples.singleton;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MyThreadPoolTest {

    @Test
    void testThreadPool() {
        MyThreadPool threadPool = MyThreadPool.getInstance();
        assertNotNull(threadPool);

        Optional<MyThread> thread1 = threadPool.get();
        assertTrue(thread1.isPresent());

        Optional<MyThread> thread2 = threadPool.get();
        assertTrue(thread2.isPresent());

        Optional<MyThread> thread3 = threadPool.get();
        assertFalse(thread3.isPresent());

        threadPool.release(thread1.get());
        Optional<MyThread> thread4 = threadPool.get();
        assertTrue(thread4.isPresent());
    }

}