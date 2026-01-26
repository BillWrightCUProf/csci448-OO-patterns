package refactoring.dotsandboxes;

import org.junit.jupiter.api.Test;


class DotsAndBoxesModelTest {

    @Test
    void dotsAndBoxesModel() {
        DotsAndBoxesModel model = new DotsAndBoxesModel(2, 2);
        model.setOwner(0,0,Player.PLAYER);
        model.setOwner(1,1,Player.COMPUTER);
        System.out.println(model);
    }

    @Test
    void testRowString() {
        DotsAndBoxesModel model = new DotsAndBoxesModel(2, 2);
        model.setOwner(0,0,Player.PLAYER);
        System.out.println(model.rowString(0));
    }

}