package naming.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasketballPlayerPool {
    List<String> AVAILABLE_PLAYERS = new ArrayList<>(List.of("Alice", "Bob", "Claire", "Don", "Eve", "Frank", "Grace", "Hank", "Ivy", "Jack"));

    public List<String> selectPlayers(Integer numPlayers) {
        return selectNFrom(numPlayers, AVAILABLE_PLAYERS);
    }

    public List<String> selectNFrom(Integer n, List<String> list) {
        Collections.shuffle(list);
        return list.subList(0, n);
    }
}
