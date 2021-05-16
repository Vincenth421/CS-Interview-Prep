#include <stdio.h>
#include <stdlib.h>
#include "LinkedList.h"

typedef struct Node{
  int item;
  struct Node* next;
} node_t;

/* Initialize head with ITEM item. HEAD can be NULL */
void init_list(node_t** head, int item) {
  /* Initialize head if NULL */
  if (*head == NULL) {
    *head = (node_t*) malloc(sizeof(node_t));
    if (*head == NULL) {
      fprintf(stderr, "List is NULL\n");
      exit(-1);
    }
  }

  /* Initialize fields */
  (*head)->item = item;
  (*head)->next = NULL;
}

/* Insert at the front of list. O(1) */
void insert(node_t** head, int item) {
  if(*head == NULL) {
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
  node->next = *head;
  *head = node;
}

/* Delete front of list. O(1) */
void delete(node_t** head) {
  if(*head == NULL) {
    fprintf(stderr, "List is NULL\n");
    exit(-1);
  }

  node_t* temp = *head;
  *head = (*head)->next;
  free(temp);
}

/* Adds item to end of list. O(N) */
void append(node_t** head, int item)
{
  if(*head == NULL) {
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

  node_t *curr = *head;
  while (curr->next != NULL)
  {
    curr = curr->next;
  }

  curr->next = node;
}

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
