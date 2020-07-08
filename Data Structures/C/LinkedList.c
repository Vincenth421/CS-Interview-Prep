#include <stdio.h>
#include <stdlib.h>
#include "LinkedList.h"

void add(struct LinkedList** head, int item)
{
     struct LinkedList* node = (struct LinkedList*) malloc(sizeof(struct LinkedList*));

     if(node == NULL)
     {
          fprintf(stderr, "Unable to allocate memory for new node\n");
          exit(-1);
     }

     node->item = item;
     node->next = NULL;

     if(*head == NULL)
     {
          *head = node;
     } else {

        struct LinkedList *curr = *head;
        while (curr->next != NULL)
        {
            curr = curr->next;
        }

        curr->next = node;
    }
}

void printList(struct LinkedList* head)
{
     struct LinkedList* point = head;
     while(point != NULL)
     {
          printf("%d ", point->item);
          point = point->next;
     }

}

void freeList(struct LinkedList** head)
{
     struct LinkedList* temp;

     while(*head != NULL)
     {
          temp = *head;
          *head = (*head)->next;
          free(temp);
     }
}
