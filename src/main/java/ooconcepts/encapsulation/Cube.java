package ooconcepts.encapsulation;

public class Cube {
    private int height;
    private int width;
    private int depth;

    public Cube(int height, int width, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return "Cube{" + "height=" + height + ", width=" +
                width + ", depth=" + depth + "}";
    }
}
