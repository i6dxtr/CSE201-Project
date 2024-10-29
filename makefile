all: Main.class

Main.class: Main.java Game.java Room.java Requirement.java
	javac Main.java Game.java Room.java Requirement.java

run: Main.class
	java Main

clean:
	rm -f *.class
