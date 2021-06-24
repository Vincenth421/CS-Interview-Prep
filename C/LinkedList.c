#include <stdio.h>
#include <stdlib.h>
#include "LinkedList.h"
#include <stdbool.h>

/* Node definition */
typedef struct Node{
  int item;
  struct Node* next;
} node_t;

/*** Linked List operations ***/

/* Insert at the front of list. O(1) */
void insert(node_t** head, int item) {

  node_t* node = (node_t*) malloc(sizeof(node_t));
  if(node == NULL)
  {
    fprintf(stderr, "Unable to allocate memory for new node\n");
    exit(-1);
  }

  node->item = item;
  node->next = *head;
  *head = node;
}

/* Get item at given index. If failed, return false. */
bool get(node_t* head, int index, int* item) {
  node_t* pointer = head;
  for(int i = 0; i < index; i++) {
    if(pointer == NULL) return false;
    pointer = pointer->next;
  }
  
  *item = pointer->item;
  return true;
}

/* Delete front of list. O(1) */
void delete(node_t** head) {
  if(*head != NULL) {
    node_t* temp = *head;
    *head = (*head)->next;
    free(temp);
  }
}

/* Free the list. O(N) */
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

/*** Utility functions ***/

/* Print the list. O(N) */
void print_list(node_t* head)
{
  node_t* point = head;
  while(point != NULL)
  {
    printf("%d ", point->item);
    point = point->next;
  }

  printf("\n");
}

/* Check if 2 lists contain same contents. O(N) */
bool list_equals(node_t* list1, node_t* list2)
{
  node_t* point1 = list1;
  node_t* point2 = list2;

  while(point1 != NULL && point2 != NULL)
  {
    if (point1->item != point2->item) return false;
    point1 = point1->next;
    point2 = point2->next;
  }

  //if both pointers are NULL, they are equal
  return point1 == NULL && point2 == NULL;
}
