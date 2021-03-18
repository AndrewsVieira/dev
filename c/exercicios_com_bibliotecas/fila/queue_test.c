#include <stdio.h>
#include "linear_queue.h"

int main() {
    Queue* queue;
    int elements[] = {1,2,3,4,5,6,7,8,9,10};
    int i;
    int element;

    queue = create_queue();
    for(i = 0; i <= LENGH; i++) {
        if(insert(queue, elements[i])) {
            printf("Populando a fila com o elemento %d\n", elements[i]);
        } else {
            printf("A fila está cheia\n");
        }
    }

    for(i = 0; i <= LENGH; i++) {
        if(removing(queue, &element)) {
            printf("O número %d saiu da fila\n", element);
        } else {
            printf("A fila está vazia\n");
        }
    }

    free_queue(queue);
}