package ooconcepts;


class AirplaneTest {


    void testAirplane() {
        Airplane airplane = new Airplane(5);
        airplane.setSpeed(10);
        System.out.println( airplane.getSpeed());
    }

}