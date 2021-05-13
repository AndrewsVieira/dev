#include "linear_queue.h"
#include<stdio.h>

int main() {
    int i, value, success;
    Queue* queue = create_queue();
    success = removing(queue, &value);
    if(success) {
        printf("removeu de fila nova vazia %d\n", value);
    } else {
        printf("a fila está vazia. Não há nada a ser removido.\n");
    }     
    for(i = 0; i < 12; i++) {
        success = inserting(queue, i * 10);
        if(!success) {
            printf("Fila cheia com o indice [%d]\n", i);
        } else {
            printf("inserindo na fila o elemento %d no índice [%d]\n", i * 10,i);
        }
    }
    for(i = 0; i < 14; i++) {
        success = removing(queue, &value);
        if(!success) {
            printf("fila vazia com o indice [%d]\n", i);
        } else {
            printf("Retirado o valor %d no indice %d\n", value, i);
        }
    }
    for(i = 0; i < 14; i++) {
        success = inserting(queue, i);
        if(success) {
            printf("inseriu %d na fila\n", i);
        }
        if(i % 4) {
            success = removing(queue, &value);
            if(success) {
                printf("removeu %d da fila\n", value);
            }
        }    
    }
    for(i = 0; i < 14; i++) {
        success = removing(queue, &value);
        if(success) {
            printf("removeu %d da fila\n", value);
        } else {
            printf("fila vazia\n");
        }
    }
}