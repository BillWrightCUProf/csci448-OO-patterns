package examples.singleton;

public interface ObjectFactory<T> {
    // Returns a new instance of an object type T.
    public abstract T createNew();
}
