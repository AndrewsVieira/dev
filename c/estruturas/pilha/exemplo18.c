#include <stdio.h>
#include "linear_stack.h"

int main() {
    Stack *stack;
    stack = create_stack();
    int i;
    for(i = 0; i < 10; i++) {
        push(stack, (i + 1) * 2);
    }
    int value;
    for(i = 0; i < 12 + 1; i++) {
        if(pop(stack, &value)) {
            printf("Desempilhando -> %d\n", value);
        } else {
            printf("Pilha vazia\n");
        }
    }
    free_stack(stack);
}