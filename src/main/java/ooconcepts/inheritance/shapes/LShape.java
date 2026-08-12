package ooconcepts.inheritance.shapes;

public class LShape {
    private int myLWidth;
    private int myLInnerWidth;
    private int myLHeight;
    private int myLInnerHeight;

    public LShape(int width, int innerWidth, int height, int innerHeight) {
        this.myLWidth = width;
        this.myLInnerWidth = innerWidth;
        this.myLHeight = height;
        this.myLInnerHeight = innerHeight;
    }

    public int area() {
        return (myLWidth * myLHeight) - (myLInnerWidth * myLInnerHeight);
    }
}
