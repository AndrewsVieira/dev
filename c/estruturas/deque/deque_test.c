#include <stdio.h>
#include "linear_deque.h"

int main() {
    Deque *deque;
    deque = create_deque();
    int i;
    for(i = 0; i < 5; i++) {
        if(insert_begin(deque, (i + 1) * 2)) {
            printf("Inseriu no inicio -> %d\n", (i+1)*2);
        }
    }
    for(i = 0; i < 5; i++) {
        if(insert_end(deque, (6 + i) * 2)) {
            printf("Inseriu no fim -> %d\n", (6+i)*2);
        }
    }
    int value;
    for(i = 5; i < 10; i++) {
        if(remove_end(deque, &value)) {
            printf("Retirando do fim -> %d\n", value);	
        } else {
            printf("Fila vazia \n");
        }		
    }
    for(i = 0; i < 5; i++) {
        if(remove_begin(deque, &value)) {
            printf("Retirando do inicio -> %d\n", value);	
        } else {
            printf("Fila vazia \n");
        }		
    }
    free_deque(deque);
}	