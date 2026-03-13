package examples.template.character;

abstract class Character {
    public final void doAction(Room room) {
        if (shouldFight(room)) {
            fight(selectCreature(room));
        } else if (shouldEat(room)) {
            eat(selectFood());
        } else if (shouldMove(room)) {
            moveTo(selectNeighbor(room));
        } else {
            doSomethingElse(room);
        }
    }

    abstract protected boolean shouldFight(Room room);
    abstract protected boolean shouldEat(Room room);
    abstract protected boolean shouldMove(Room room);
    abstract protected Character selectCreature(Room room);
    abstract protected Food selectFood();
    abstract protected Room selectNeighbor(Room room);

    private void fight(Character character) {}
    private void eat(Food food) {}
    private void moveTo(Room room) {}
    protected void doSomethingElse(Room room) {
        // do nothing, stay put
    }

}
