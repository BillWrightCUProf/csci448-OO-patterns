package examples.builder;

import java.time.LocalDate;

public class TripClient {

    public static void main(String[] args) {
        var trip = new Trip(LocalDate.now(), LocalDate.now()
                , 7, 2, 3, 3, 80, 5, 30);
        System.out.println(trip);





        // With setters -- might be inconsistent
        // Object is not mutable
        var trip2 = new Trip(LocalDate.now(),
                LocalDate.now().plusDays(14), 14, 2);
        trip.setMinimumStars(3);
        trip.setMinimumRecommendations(80);






        // With builder
        var builder = new Trip.Builder(LocalDate.now(),
                LocalDate.now(), 15, 2);
        var trip3 = builder
                .minimumStars(3)
                .rating(5)
                .numberKids(0)
                .build();
        System.out.println(trip3);


        // With builder 2
        public static void main(String[] args) {
            var trip = Trip.builder(LocalDate.now(),
                            LocalDate.now().plusDays(15), 15, 2)
                    .minimumStars(3)
                    .rating(5)
                    .numberKids(0)
                    .build();
            System.out.println(trip);
        }
    }



















}
