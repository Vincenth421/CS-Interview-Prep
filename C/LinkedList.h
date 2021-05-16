/* Linked list functions */

/* Linked list node type definition */
typedef struct Node node_t;

/* Linked list operations */
void init_list(node_t**);
void append(node_t**, int);
void free_list(node_t**);

/* Utility function */
void print_list(node_t*);
