CC = gcc

default: Main.o

Main: LinkedList.o
	$(CC) -o Main LinkedList.c Main.c LinkedList.o

LinkedList:
	$(CC) LinkedList.c

rm:
	rm Main
