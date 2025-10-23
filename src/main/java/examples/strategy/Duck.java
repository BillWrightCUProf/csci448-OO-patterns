package examples.strategy;

import examples.factory.solution.composition.FlyBehavior;
import examples.factory.solution.composition.QuackBehavior;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
}
