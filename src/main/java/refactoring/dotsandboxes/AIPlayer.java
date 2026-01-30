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
        Side move = tryCompletingABox();
        if (move != null) {
            return move;
        }
        move = tryAvoidingGivingBox();
        if (move != null) {
            return move;
        }
        return chooseRandomMove();
    }

    private Side chooseRandomMove() {
        RandomGenerator randomGenerator = new Random();
        List<Side> unownedSides = model.getUnownedSides();
        int index = randomGenerator.nextInt(unownedSides.size());
        return unownedSides.get(index);
    }

    private Side tryAvoidingGivingBox() {
        Box box = model.findBoxWithNSides(1);
        if (box != null) {
            return box.getUnownedSides().getFirst();
        }
        return null;
    }

    private Side tryCompletingABox() {
        Box box = model.findBoxWithNSides(3);
        if (box != null) {
            return box.getUnownedSides().getFirst();
        }
        return null;
    }
}
