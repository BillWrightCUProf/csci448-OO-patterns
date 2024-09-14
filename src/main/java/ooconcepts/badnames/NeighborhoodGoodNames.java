package ooconcepts.badnames;

public class NeighborhoodGoodNames {

    int width;
    int length;
    int density;    // or peoplePerBlock or peoplePerSquareBlock

    public NeighborhoodGoodNames(int width, int length, int density) {
        this.width = width;
        this.length = length;
        this.density = density;
    }

    public int getArea() {
        return width * length;
    }

    public int getPopulation() {
        return width * length * density;
    }
}
