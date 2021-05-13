#define LENGTH 10

typedef struct Deque_ Deque;
Deque* create_deque();
int insert_begin(Deque *deque, int element);
int remove_begin(Deque *deque, int *element);
int get_begin(Deque *deque, int *element);
int insert_end(Deque *deque, int element);
int remove_end(Deque *deque, int *element);
int get_end(Deque *deque, int *element);
void free_deque(Deque *deque);