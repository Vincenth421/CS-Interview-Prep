JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	LinkedList.java \
	Stack.java \
	Queue.java

default: run

run: main
	java -cp ./out Main

main: classes
	$(JC) -d ./out -cp ./out Main.java

classes:
	$(JC) -d ./out $(CLASSES)

clean:
	$(RM) ./out/*.class
