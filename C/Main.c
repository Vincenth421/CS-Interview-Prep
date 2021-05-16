#include <stdio.h>
#include "LinkedList.h"

int main(void)
{
     node_t* head = NULL;
     append(&head, 1);
     append(&head, 2);
     append(&head, 3);

     print_list(head);
     free_list(&head);

     return 0;
}
