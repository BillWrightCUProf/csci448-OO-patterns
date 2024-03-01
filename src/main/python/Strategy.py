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
    def quack2(self):
        print("QUACK! QUACK!!")

class GentleQuackStrategy(QuackStrategyAbstract):
    def quack(self):
        print("quack!")

if __name__ == "__main__":
    loud = LoudQuackStrategy()
    gentle = GentleQuackStrategy()
    loud.quack()
    gentle.quack()