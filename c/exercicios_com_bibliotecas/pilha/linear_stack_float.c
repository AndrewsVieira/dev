/**
 * Implementação da pilha - linear_stack.c
 */

#include <stdlib.h>
#include "linear_stack_float.h"

struct Stack_ {
    int quantity;
    int element[LENGTH];
};

Stack* create_stack() {
    Stack* stack = (Stack*)malloc(sizeof(Stack));
    if(stack != NULL) {
        stack->quantity = 0;
    }
    return stack;
}

int push(Stack* stack, float value) {
    if (LENGTH == stack->quantity) return 0;
    stack->element[stack->quantity++] = value;
    return 1;
}

int pop(Stack* stack, float* value) {
    if(stack->quantity > 0) {
        *value = stack->element[--(stack->quantity)];
        return 1;
    }
    return 0;
}

int top(Stack* stack, float* value) {
    if(stack->quantity > 0) {
        *value = stack->element[stack->quantity - 1];
        return 1;
    }
    return 0;
}

void free_stack(Stack* stack) {
    free(stack);
}