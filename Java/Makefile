JC = javac
ODIR = out
CLASSES = LinkedList.java Stack.java Queue.java BST.java MaxHeap.java

default: directories run

directories:
	mkdir -p $(ODIR)

# Runs executable in $(ODIR)
run: main
	java -cp $(ODIR) Main

# Outputs main executable to $(ODIR)
main: classes
	$(JC) -d $(ODIR) -cp $(ODIR) Main.java

classes:
	$(JC) -d $(ODIR) $(CLASSES)

.PHONY: clean
clean:
	rm $(ODIR)/*
