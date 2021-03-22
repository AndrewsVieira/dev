#include <stdio.h>
#include <stdlib.h>
#include "linear_deque.h"

int main() {
    Deque* deque;
    int elements[] = {1,2,3,4,5,6,7,8,9,10};
    int i;
    int e;

    deque = create_deque();

    // teste início
    for(i = 0; i <= LENGTH; i++) {
        if(insert_begin(deque, elements[i])) {
            printf("inserindo pelo início da fila o elemento %d\n", elements[i]);
         } else {
            printf("fila cheia\n");
         }
    }
    
    for(i = 0; i <= LENGTH; i++) {
        if(get_begin(deque, &e)) printf("retirando pelo início o número %d\n", e);
        if(remove_begin(deque, &e)) {
            printf("%d removido pelo início\n", e);
        } else {
            printf("deque vazio\n");
        }
    }

    // teste final
    for(i = 0; i <= LENGTH; i++) {
        if(insert_end(deque, elements[i])) {
            printf("inserindo pelo final da fila o elemento %d\n", elements[i]);
         } else {
            printf("fila cheia\n");
         }
    }
    
    for(i = 0; i <= LENGTH; i++) {
        if(get_end(deque, &e)) printf("retirando pelo final o número %d\n", e);
        if(remove_end(deque, &e)) {
            printf("%d removido pelo final\n", e);
        } else {
            printf("deque vazio\n");
        }
    }

    free_deque(deque);
}