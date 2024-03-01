from abc import ABCMeta, abstractmethod

class Command(metaclass=ABCMeta):
    # The command interface that declares a method (execute) for a particular action.
    @abstractmethod
    def execute(self):
        pass

class Sandwich:
    # Receiver with method for action
    def make_sandwich(self):
        print("A sandwich is being made")

class SandwichCommand(Command):
    #A concrete / specific Command class, implementing execute()

    def __init__(self, sandwich: Sandwich):
        self._sandwich = sandwich

    def execute(self):
        self._sandwich.make_sandwich()


if __name__ == "__main__":
    sandwich = Sandwich()
    sandwich_command = SandwichCommand(sandwich)
    sandwich_command.execute()