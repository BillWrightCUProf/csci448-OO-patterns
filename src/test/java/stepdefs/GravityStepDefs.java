package stepdefs;

import bdd.Body;
import bdd.Position;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.HashMap;
import java.util.Map;

public class GravityStepDefs {
    Map<String, Body> bodies = new HashMap<>();

    @Given("I have a body {word} of mass {int} at x,y position {int},{int}")
    public void iHaveABodySunOfMassAtXYPosition(String name, int mass, int x, int y) {
        Body body = new Body(name, mass);
        body.setPosition(new Position(x,y));
        bodies.put(name, body);
        System.out.println(bodies);
        System.out.println("Body " + name + " has mass " + mass + " at position " + x + "," + y);
    }

    @And("the {word} has a velocity of {int},{int}")
    public void theBodyHasAVelocityOf(String name, int x, int y) {
        Body body = bodies.get(name);
        body.setVelocity(new Position(x,y));
    }
}
