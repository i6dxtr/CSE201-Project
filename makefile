all: Main.class

Main.class: Main.java Boss.java Combat.java Command.java CommandFactory.java Enemy.java Game.java Inventory.java Item.java Player.java Potion.java Requirement.java Room.java RoomFactory.java Trap.java Weapon.java
	javac Main.java Boss.java Combat.java Command.java CommandFactory.java Enemy.java Game.java Inventory.java Item.java Player.java Potion.java Requirement.java Room.java RoomFactory.java Trap.java Weapon.java

run: Main.class
	java Main

clean:
	rm -f *.class
