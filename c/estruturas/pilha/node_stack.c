#include "linear_stack.h"
#include "../node/single_node.h"
#include<stdlib.h>

#define FALSE 0;
#define TRUE 1;

struct Stack_ {
    Node* top;
};

Stack* create_stack() {
    Stack* node = (Stack*)malloc(sizeof(struct Stack_));
    if (node != NULL) {
        node->top = NULL;
    }
    return node;
}

int push(Stack* stack, int value) {
    Node* node = create_node(value);
    if(node == NULL) return FALSE;
    set_next(node, stack->top);
    stack->top = node;
    return TRUE;
}

int pop(Stack* stack, int* value) {
    if(stack->top != NULL) {
        *value = get_data(stack->top);
        Node* removed = stack->top;
        stack->top = get_next(stack->top);
        free(removed);
        return TRUE;
    } else {
        return FALSE;
    }
}

int top(Stack* stack, int* value) {
    if(stack->top != NULL) {
        *value = get_data(stack->top);
        return TRUE;
    } else {
        return FALSE;
    }
}

void free_stack(Stack* stack) {
    Node* cursor = stack->top;
    Node* removed;
    while(cursor != NULL) {
        removed = cursor;
        cursor = get_next(removed);
        free(removed);
    }
    free(stack);
}
