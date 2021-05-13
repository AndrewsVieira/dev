#include <stdlib.h>
#include "linear_queue.h"

#define FALSE 0
#define TRUE 1

struct Queue_ {
    int quantity;
    int elements[LENGH];
};

Queue* create_queue() {
    Queue* queue = (Queue*)malloc(sizeof(Queue));
    if(queue != NULL) {
        queue->quantity = 0;
    }
    return queue;
}
int inserting(Queue *queue, int element) {
    if(queue->quantity == LENGH) return FALSE;
    queue->elements[queue->quantity++] = element;
    return TRUE;
}
int removing(Queue *queue, int *element) {
    if(queue->quantity > 0) {
        *element = queue->elements[0];
        queue->quantity--;
        int i;
        for(i = 0; i < queue->quantity; i++) {
            queue->elements[i] = queue->elements[i+1];
        }
        return TRUE;
    }
    return FALSE;
}
int next(Queue *queue, int *element) {
    if(queue->quantity > 0) {
        *element = queue->elements[0];
        return TRUE;
    }
    return FALSE;
}
void free_queue(Queue* queue) {
    free(queue);
}