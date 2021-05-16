#include <stdio.h>
#include "LinkedList.h"

int main(void)
{
     node_t* head = NULL;
     init_list(&head, 1);
     append(&head, 2);
     append(&head, 3);
     append(&head, 4);
     insert(&head, 0);

     printf("Full list: ");
     print_list(head);

     delete(&head);

     printf("Deleted head: ");
     print_list(head);

     free_list(&head);

     return 0;
}
