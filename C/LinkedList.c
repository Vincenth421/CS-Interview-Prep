#include <stdio.h>
#include <stdlib.h>
#include "LinkedList.h"

typedef struct Node{
  int item;
  struct Node* next;
} node_t;

void init_list(node_t** head) {

}

/* Adds item to end of list */
void append(node_t** head, int item)
{
  if(head == NULL) {
    fprintf(stderr, "List is NULL\n");
    exit(-1);
  }

  node_t* node = (node_t*) malloc(sizeof(node_t));

  if(node == NULL)
  {
    fprintf(stderr, "Unable to allocate memory for new node\n");
    exit(-1);
  }

  node->item = item;
  node->next = NULL;

  if (*head == NULL)
  {
    *head = node;
  } else {

    node_t *curr = *head;
    while (curr->next != NULL)
    {
      curr = curr->next;
    }

    curr->next = node;
  }
}

void print_list(node_t* head)
{
  node_t* point = head;
  while(point != NULL)
  {
    printf("%d ", point->item);
    point = point->next;
  }

}

void free_list(node_t** head)
{
  node_t* temp;

  while(*head != NULL)
  {
    temp = *head;
    *head = (*head)->next;
    free(temp);
  }
}
