package ooconcepts;

public class CyclomaticComplexityExample {
    int a;
    int b;

    public CyclomaticComplexityExample(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public boolean myMethod() {
        return a > b;
    }
}
