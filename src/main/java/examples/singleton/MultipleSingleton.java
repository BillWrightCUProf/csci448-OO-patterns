package examples.singleton;

import java.util.HashMap;
import java.util.Map;

public class MultipleSingleton {
    private static final Map<String, MultipleSingleton> instances = new HashMap<>();

    private MultipleSingleton() {
    }

    public static MultipleSingleton getInstance(String key) {
        if (!instances.containsKey(key)) {
            instances.put(key, new MultipleSingleton());
        }
        return instances.get(key);
    }
}
