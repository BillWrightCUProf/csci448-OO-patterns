# Polymorphia Homework Sequence

## Homework 1: Starting Polymorphia – just Adventurer and Creature and fighting
### Learning Objectives: 
* Installing IntelliJ
* Java
* Gradle 
* Running tests
* Using the Debugger

* Create classes Adventurer, Creature, and Room

In this version we’ll implement the method loseHealth() and call it on a character and verify it with getHealth()
Later this will be a private method (encapsulation) and so will getHealth(). We’ll replace with fight(creature) and isAlive()

## Homework 2: Expanding Polymorphia - Polymorphia, Maze (2x2), Room, Character superclass
### Learning Objectives: DRY, Inheritance, Encapsulation, Small Methods
Elements: Adventurers, Creatures, Food, 2x2 Maze		

## Homework 3: Two Sources of Truth, Encapsulation, Dependency Injection and Die Injection, Logging
Learning Objectives: Dependency Injection, Logging, Documenting the five concepts in the homework description
Removing “new” keywords and System.out.println statements from our code
New Elements: 9x9 Maze

## Homework 4: BDD, TDD, Die Injection
Learning Objectives: BDD, TDD, and Die Injection
New Elements:
Cowards(eat, move), Gluttons (eat, fight, move), Fighters (fight, eat, move)
Creature now move (move, initial health range 5-10)
Demons (fight, move, initial health range: 10-15)
Food values between 1.0 and 2.0

## Homework 4A?: BDD and Strategy Pattern
Learning Objectives: BDD, Scenarios to describe the strategy of play and food items
New Elements:
Cowards(eat, move), Gluttons (eat, fight, move), Fighters (fight, eat, move)
Creature now move (move, initial health range 5-10)
Demons (fight, move, initial health range: 10-15)
Food values between 1.0 and 2.0

## Homework 5: Extending Polymorphia and Adding the Factory and Builder Patterns
Learning Objectives: Using Factories and a Builder to create a general Maze that codes to abstractions
New Elements:
Cowards(eat, move), Gluttons (eat, fight, move), Fighters (fight, eat, move)
Creature now move (move, initial health range 5-10)
Demons (fight, move, initial health range: 10-15)
N-room, fully-connected maze
N-room, m-connection maze
Food values between 1.0 and 2.0

## Homework 6: Aggregation Over Inheritance via the Strategy Pattern
Learning Objectives: Strategy Pattern, UML Diagram, Changing Strategies

## Homework 7: Adding the Observer, Adaptor, and Singleton Patterns
Learning Objectives: Multithreading, Observer, Adaptor Patterns, Optional MessageBus
Adding in AudibleObserver and MazeObserver

Use the same Observer pattern for both Audible and Console

Homework 7: Writing Maze Displayer
Learning Objectives:
Write a Swing-based displayer

Add the ability to create a line of rooms and attach it to a room in the MazeBuilder.
Add the ability to create a ring of rooms and attach it to a room in the MazeBuilder.
Improving the maze drawing to handle the above – give it hints like:

{drawLinearly: [room1, room2, room3], drawAsRing: [room4, room5, room6], layoutRadially: [room7, room8, room9]} and it would look like this:

Place treasure randomly in the maze, maybe guarded by a non-moving creature and the player that get the treasure wins the game


Implement a new layout strategy for existing maze drawer

Might be fun to write a layout strategy that will layout a grid maze of rooms with just knowing the connections. For instance, Rooms with just two connections go in the corners. Maybe a constraint algorithm approach or a recursive algorithm…
Homework 8: Adding the Encapsulation and BDD to Polymorphia
Learning Objectives:

RandomRoom – room that has n connections but only shows one of them when asked for neighbors. It randomly connects and disconnects to its possible neighbors.

// Could another player cause this player to enter a room with a creature using this method?
// Yes. How could we prevent that? We need this method to be public for Room to call it.
// We could remove this reference to the room and out in a maze reference. Then the character
// would ask the maze to switch to a new room. The player would only know the room name. But
// then the player could just ask for another charcter to enter a room with a creature.

## Homework 8: Extending Polymorphia with the Decorator Pattern and a Human Player
Learning Objectives:  Multithreading, Decorator Pattern, I/O

Have the game get all the commands for all of the players and schedule them with a thread pool. That way the command you wanted to run might not be valid when you your command gets run, so we need to code to handle this. We can build in a slight delay with the automatic players and they just run along at will and the human player plays as fast as they can think and type.

Armor
Invisibility Cloak
Reincarnation potion
Cloning – split health points
Sword

Magic Room that loses one neighbor per query of getRooms() until it gets to zero and then ramps back up

## Homework 9: Turning Polymorphia into a Service
Learning Objectives: REST endpoints, Service API, Multithreading, Multiple Games (what do we do about the Singletons?), DI Framework to handle that.

## Homework 10: Creating A Custom Strategy via the Service Provider Interface
Learning Objectives: SPI
