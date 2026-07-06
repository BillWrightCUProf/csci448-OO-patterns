package cpluspluscomparison;

public class Generic {

    int sum(int[] anArray) {
        int total = 0;
        for (int value : anArray) {
            total += value;
        }
        return total;
    }

}
