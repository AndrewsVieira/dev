#include "../node/single_node.h"
#include "linear_queue.h"
#include <stdlib.h>

#define FALSE 0
#define TRUE 1

struct Queue_ {
    Node* begin;
    Node* end;
};

Queue* create_queue() {
    Queue* queue = (Queue*)malloc(sizeof(struct Queue_));
    if(queue != NULL) {
        queue->begin = NULL;
        queue->end = NULL;
    }
    return queue;
}

int inserting(Queue *queue, int element) {
    Node* new_node = create_node(element);
    if(new_node == NULL) return FALSE;
    if(queue->begin == NULL) {
        queue->begin = new_node;
    } else {
        set_next(queue->end, new_node);
    }
    queue->end = new_node;
    return TRUE;
}

int removing(Queue *queue, int *element) {
    if(queue->begin == NULL) return FALSE;
    *element = get_data(queue->begin);
    Node* temp = queue->begin;
    queue->begin = get_next(queue->begin);
    free(temp);
    return TRUE;
}

int next(Queue *queue, int *element) {
    if(queue == NULL) return FALSE;
    *element = get_data(queue->begin);
    return TRUE; 
}

void free_queue(Queue* queue) {
    Node* temp;
    while(queue->begin != NULL) {
        temp = queue->begin;
        queue->begin = get_next(temp);
        free(temp);
    }
    free(queue);
}
