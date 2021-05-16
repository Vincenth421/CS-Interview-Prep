/* Linked list functions */

/* Linked list node type definition */
typedef struct Node node_t;

/* Linked list operations */
void init_list(node_t**, int);
void insert(node_t**, int);
void append(node_t**, int);
void delete(node_t**);
void free_list(node_t**);

/* Utility function */
void print_list(node_t*);
