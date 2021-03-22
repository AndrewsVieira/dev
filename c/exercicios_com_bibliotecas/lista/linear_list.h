#define LENGTH 10

typedef struct List_ List;

List *create_list();
void empty(List *list);
void full(List *list);
int insert_head(List *list, int element);
int insert_tail(List *list, int element);
int insert_position(List *list, int element, int position);
int remove_head(List *list, int *element);
int remove_tail(List *list, int *element);
int remove_position(List *list, int *element, int position);
int get_head(List *list, int *element);
int get_tail(List *list, int *element);
int get_position(List *list, int *element, int position);
void free_list(List *list);