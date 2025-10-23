package ooconcepts.codetointerface;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeToInterfaceTest {

    @Test
    void test() {
        ArrayList<String> friends = new ArrayList<String>();
        friends.add("John");
        friends.add("Jane");

        HashMap<String, ArrayList<String>> couples = new HashMap<String, ArrayList<String>>();
        couples.put("names", friends);
    }

    @Test
    void test2() {
        List<String> friends = new ArrayList<>();
        friends.add("John");
        friends.add("Jane");

        Map<String, List<String>> couples = new HashMap<>();
        couples.put("names", friends);
    }
}
