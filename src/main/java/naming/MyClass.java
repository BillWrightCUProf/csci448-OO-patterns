package naming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyClass {
    static List<String> MY_CONSTANT = new ArrayList<>(List.of("Alice", "Bob", "Claire", "Don", "Eve", "Frank", "Grace", "Hank", "Ivy", "Jack"));

    public List<String> myMethod(Integer n) {

        return selectNFrom(n, MY_CONSTANT);
    }

    public List<String> selectNFrom(Integer n, List<String> list) {
        Collections.shuffle(list);
        return list.subList(0, n);
    }
}

