#include <stdio.h>
#include "LinkedList.h"

int main()
{
     struct LinkedList* head = NULL;
     add(&head, 1);
     add(&head, 2);
     add(&head, 3);

     printList(head);
     freeList(&head);

     return 0;
}
