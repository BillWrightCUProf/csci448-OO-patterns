package ooconcepts;

import java.util.ArrayList;
import java.util.List;

public class GenericTypes {
    List<Integer> myInts = new ArrayList<>(List.of(1, 2, 3));
    List<Number> myNums = new ArrayList<>(List.of(1, 2, 3));

    public void test() {
//        myNums = myInts;
    }
}
