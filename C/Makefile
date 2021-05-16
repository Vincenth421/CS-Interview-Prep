CC = gcc

# Directory for executable and object files
ODIR = out

# Header files
DEPS = LinkedList.h

# All object files needed
_OBJ = LinkedList.o Main.o
# Convert *.o into $(ODIR)/*.o
OBJ = $(patsubst %,$(ODIR)/%,$(_OBJ))

# Other flags
CFLAGS = -Wall

default: Main

# Compile file to run.
Main: $(OBJ)
	$(CC) -o $(ODIR)/$@ $^ $(CFLAGS)

# Compile object files
$(ODIR)/%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

# Clear output directory
.PHONY: clean
clean:
	rm $(ODIR)/*
