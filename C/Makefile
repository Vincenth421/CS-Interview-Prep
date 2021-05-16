CC = gcc

# Directory for object files
ODIR = out

# Header files
DEPS = LinkedList.h

# All object files needed
_OBJ = LinkedList.o Main.o
# Convert *.o into <output directory>/*.o
OBJ = $(patsubst %,$(ODIR)/%,$(_OBJ))

# Other flags
CFLAGS = -Wall

all: directories Main

# Make output directory if not exist
directories:
	mkdir -p $(ODIR)

# Compile main file. $@ gets left side of colon, $^ gets right side.
Main: $(OBJ)
	$(CC) -o $@ $^ $(CFLAGS)

# Compile object files into out directory. $< gets first arg on left side of colon.
# In this case, $< is all of the C files. Use -c flag to only generate object files.
$(ODIR)/%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

# Clear output directory and executables (Windows only)
.PHONY: clean
clean:
	rm $(ODIR)/* ./*.exe
