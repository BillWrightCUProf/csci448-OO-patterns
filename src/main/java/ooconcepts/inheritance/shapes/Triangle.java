package ooconcepts.inheritance.shapes;

public class Triangle extends Polygon {
    public static int NUMBER_OF_SIDES = 3;

//    public Triangle(int width, int height) {
//        this.width = width;
//        this.height = height;
//        this.sides = 3;
//    }

    public Triangle(int width, int height) {
        super(width, height, NUMBER_OF_SIDES);
    }

    @Override
    int area() {
        return (width * height) / 2;
    }
}
