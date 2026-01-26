package ooconcepts.inheritance.shapes;

public class Rectangle extends Polygon {
    public static int NUMBER_OF_SIDES = 4;

//    public Rectangle(int width, int height) {
//        this.width = width;
//        this.height = height;
//        this.sides = 4;
//    }

    public Rectangle(int width, int height) {
        super(width, height, NUMBER_OF_SIDES);
    }

    @Override
    int area() {
        return width * height;
    }
}
