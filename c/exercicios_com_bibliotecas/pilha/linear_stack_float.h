/**
* Cabeçalho da pilha - Definições - linear_stach.h
*/

#define LENGTH 10

typedef struct Stack_ Stack;

Stack* create_stack();
int push(Stack* stack, float value);
int pop(Stack* stack, float* value);
int top(Stack* stack, float* value);
void free_stack(Stack* stack);
