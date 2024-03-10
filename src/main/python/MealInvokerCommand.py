from CommandPattern import Command, Sandwich, SandwichCommand


class MealInvoker:
    # Has a reference to the Command, and can execute the method

    def __init__(self, command: Command):
        self._command = command
        self._command_list = []  # type: List[Command]

    def set_command(self, command: Command):
        self.command = command

    def get_command(self):
        print(self.command.__class__.__name__)

    def add_command_to_list(self, command: Command):
        self._command_list.append(command)

    def execute_commands(self):
        # Execute all the saved commands, then empty the list.
        for cmd in self._command_list:
            cmd.execute()
        self._command_list.clear()

    def invoke(self):
        self._command.execute()


if __name__ == "__main__":
    # Command pattern in action
    sandwich = Sandwich()  # receiver
    command_sandwich = SandwichCommand(sandwich)  # concrete command

    meal_invoker = MealInvoker(command_sandwich)  # invoker
    meal_invoker.invoke()  # Execute one command

    meal_invoker.add_command_to_list(command_sandwich)
    meal_invoker.execute_commands()  # Execute all commands in the list
