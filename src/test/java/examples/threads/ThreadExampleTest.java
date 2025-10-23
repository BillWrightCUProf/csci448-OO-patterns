package examples.threads;

import org.junit.jupiter.api.Test;


class ThreadExampleTest {

    @Test
    void testFixedPool() {
        ThreadExample threadExample = new ThreadExample(1, 10);
        threadExample.executeFixedThreadPool();
    }

    @Test
    void testCachedPool() {
        ThreadExample threadExample = new ThreadExample(1, 10);
        threadExample.executeCachedThreadPool();
    }

    @Test
    void testScheduledPool() {
        ThreadExample threadExample = new ThreadExample(5, 20);
        threadExample.executeScheduledThreadPool();
    }

}