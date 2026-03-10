package ooconcepts.oodesignproblems;

//Directions:
//Write the class for a World object like this:
//    Worlds have dimensions of height and width
//    A Random object is used by all Worlds to generate random positions
//    Worlds have a collection of Obstacles placed within it
//    We need a method that returns all the worlds ever created
//    We need a method to place an Obstacle in the world
//
//    Write the class with all variables, the constructor, and all method signatures

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class World {
    private static Random random = new Random();
    private static Collection<World> createdWorlds = new ArrayList<>();

    private int height;
    private int width;
    private Collection<Obstacle> obstacles = new ArrayList<>();

    World(int height, int width) {
        this.height = height;
        this.width = width;
        createdWorlds.add(this);
    }

    void placeObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);
    }

    static Collection<World> getCreatedWorlds() {
        return List.copyOf(createdWorlds);
    }
}
