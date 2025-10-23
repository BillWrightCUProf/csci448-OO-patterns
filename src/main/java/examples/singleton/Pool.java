package examples.singleton;

import java.util.Optional;

public interface Pool<T> {
    // Return one of the pooled objects.
    Optional<T> get();

    // Object T to be returned back to pool
    void release(T object);

    // Shuts down the pool, should release all resources.
    void shutdown();

}
