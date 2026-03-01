package stepdefs;

import bdd.Body;
import io.cucumber.java.en.Given;

import java.util.HashMap;
import java.util.Map;

public class MyStepdefs {
    Map<String, Body> bodies = new HashMap<>();

//    @Given("^I have a body (.*) of mass (\\d+) at x,y position (\\d+),(\\d+)$")
//    void givenABodyAtPosition(String bodyName, Integer mass, Integer x, Integer y) {
//        Body body = new Body(bodyName, mass);
//        bodies.put(bodyName, body);
//        System.out.println(bodies);
//        System.out.println("Body " + bodyName + " has mass " + mass + " at position " + x + "," + y);
//    }
}
