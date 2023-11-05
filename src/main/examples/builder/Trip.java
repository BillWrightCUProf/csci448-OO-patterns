package examples.builder;

import java.time.LocalDate;

public class Trip {
    public final LocalDate startDate;
    public final LocalDate endDate;
    public final int duration;
    public final int numberTravellers;
    public final int numberKids;
    public final int minimumStars;
    public final int minimumRecommendations;
    public final int rating;
    public final int minimumNumberRatings;
    Trip(LocalDate startDate, LocalDate endDate,
         int duration, int numberTravellers,
         int numberKids, int minimumStars,
         int minimumRecommmendations,
         int rating, int minimumNumberRatings)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
        this.numberTravellers = numberTravellers;
        this.numberKids = numberKids;
        this.minimumStars = minimumStars;
        this.minimumRecommendations = minimumRecommendations;
        this.rating = rating;
        this.minimumNumberRatings = minimumNumberRatings;
    }








//    Telescoping Constructor Pattern
    Trip(LocalDate startDate, LocalDate enddate,
         int duration, int numberTravellers,
         int numberKids, int minimumStars,
         int minimumRecommendations) {
        this(startDate, enddate, duration, numberTravellers,
                numberKids, minimumStars,
                minimumRecommendations, 0, 0);
    }








    // make all instance variables private and final
    // create inner static class (no access to any instance variables of containing class)
    //

    public static class Builder {
        private LocalDate startDate;
        private LocalDate endDate;
        private int duration;
        private int numberTravellers;
        private int numberKids = 0;
        private int minimumStars = 0;
        private int minimumRecommendations = 0;
        private int rating = 0;
        private int minimumNumberRatings = 0;

        public Builder(LocalDate startDate,
                       LocalDate endDate, int duration,
                       int numberTravellers) {
            this.startDate = startDate;
// … abridged
        }

        public Builder numberKids(int numberKids) {
            this.numberKids = numberKids;
            return this;
        }

        public Builder minimumStars(int minimumStars) {
            this.minimumStars = minimumStars;
            return this;
        }

        public Builder rating(int ratingNumber) {
            this.rating = ratingNumber;
            return this;
        }

        // final method called on builder
        public Trip build() {
            return new Trip(this);
        }
    }
}
