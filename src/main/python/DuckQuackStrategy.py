from abc import abstractmethod, ABC, ABCMeta  # Python's built-in abstract class library

class QuackStrategyAbstract(ABC):
    """You do not need to know about metaclasses.
    Just know that this is how you define abstract
    classes in Python."""
    __metaclass__ = ABCMeta

    @abstractmethod
    def quack(self):
        """Required Method"""

class LoudQuackStrategy(QuackStrategyAbstract):
    def quack(self):
        print("QUACK! QUACK!!")

class GentleQuackStrategy(QuackStrategyAbstract):
    def quack(self):
        print("quack!")

class Duck(object):
    def __init__(self, quack_strategy):
        self._quack_strategy = quack_strategy

    def quack(self):
        self._quack_strategy.quack()

# Types of Ducks
class ToyDuck(Duck):
    def __init__(self):
        super().__init__(GentleQuackStrategy())

class RobotDuck(Duck):
    def __init__(self):
        super().__init__(LoudQuackStrategy())

if __name__ == "__main__":
    toy = ToyDuck()
    robot = RobotDuck()
    toy.quack()
    robot.quack()