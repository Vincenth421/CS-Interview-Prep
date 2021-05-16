JC = javac
ODIR = out
CLASSES = LinkedList.java Stack.java Queue.java BST.java MaxHeap.java

all: directories run

directories:
	mkdir -p $(ODIR)

run: main
	java -cp $(ODIR) Main

main: classes
	$(JC) -d $(ODIR) -cp $(ODIR) Main.java

classes:
	$(JC) -d $(ODIR) $(CLASSES)

clean:
	rm $(ODIR)/*
