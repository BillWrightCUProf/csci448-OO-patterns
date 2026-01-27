package ooconcepts.wrongvariablescope;

public class RadioactiveCreature extends Creature {
    int radioactiveLevel;

    public RadioactiveCreature(String newName, Double newHealth, int newRadioactiveLevel) {
        super(newName, newHealth);
        this.radioactiveLevel = newRadioactiveLevel;
    }
}
