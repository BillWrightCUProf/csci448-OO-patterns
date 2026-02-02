package refactoring.dotsandboxes;

import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class AIPlayer {
    DotsAndBoxesModel model;

    public AIPlayer(DotsAndBoxesModel model) {
        this.model = model;
    }

    public Side chooseMove() {
        // Search for boxes with # of owned sides in this order:
        for (int numOfOwnedSides : List.of(3, 1, 0, 2)) {
            System.out.println("Looking for box with " + numOfOwnedSides + " sides...");
            Box box = model.findBoxWithNSides(numOfOwnedSides);
            if (box != null) {
                System.out.println("Found box with " + numOfOwnedSides + " sides!");
                for (Side side : box.getUnownedSides()) {
                    List<Box> boxesSharingSide = model.getBoxesSharingSide(side);
                    if (boxesSharingSide.size() == 1) {
                        System.out.println("Found a side that isn't share with other boxes!");
                        return side;
                    }
                    if (boxesSharingSide.stream().allMatch(b -> b.getUnownedSides().size() != 2)) {
                        System.out.println("Found a side that is shared with other boxes with the same number of sides!");
                        return side;
                    }
                }
            }
        }
        // We should never get here
        return chooseRandomMove();
    }

    private Side chooseRandomMove() {
        RandomGenerator randomGenerator = new Random();
        List<Side> unownedSides = model.getUnownedSides();
        int index = randomGenerator.nextInt(unownedSides.size());
        return unownedSides.get(index);
    }
}
