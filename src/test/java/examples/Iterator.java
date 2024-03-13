package examples;

public class Iterator {
    String[] items = new String[]{ "A", "B", "C", "D", "E" };

    public void printItems() {
        for (String item : items) {
            System.out.println(item);
        }
    }
}
