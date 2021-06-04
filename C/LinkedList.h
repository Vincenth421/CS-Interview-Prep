/* Linked list functions */

/* Linked list node type definition */
typedef struct Node node_t;

/* Linked list operations */
void insert(node_t**, int);
void delete(node_t**);
void free_list(node_t**);

/* Utility functions */
void print_list(node_t*);
bool list_equals(node_t*, node_t*);
