struct LinkedList{
     int item;
     struct LinkedList* next;
};
void add(struct LinkedList**, int);
void printList(struct LinkedList*);
void freeList(struct LinkedList**);
