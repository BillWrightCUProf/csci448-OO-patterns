package ooconcepts.dependencyinjection;

public class Polymorphia {
    private Maze maze;

    public Polymorphia(Maze maze) {
        this.maze = maze;
    }

    void updateMaze(Maze newMaze) {
        this.maze = newMaze;
    }
}
