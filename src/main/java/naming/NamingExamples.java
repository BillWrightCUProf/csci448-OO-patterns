package naming;

import java.util.List;
import java.util.stream.Collectors;

public class NamingExamples {

    public static List<Integer> f2(List<Integer> integers) {
        return integers.stream()
                   .filter(i -> i > 0)
                   .map(i -> i * 2)
                   .collect(Collectors.toList());
    }
}
