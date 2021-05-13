#include <stdio.h>
#include "linear_list.h"

int main() {
    int elements[] = {1,2,3,4,5,6,7,8,9,10};
    List *list;
    int i;
    int e;

    list = create_list();

    for(i = 0; i <= LENGTH; i++) {
        if(insert_head(list, elements[i])) {
            if(get_head(list, &e)) printf("elemento %d inserido na lista pelo início\n", e);
        } else {
            printf("fila cheia\n");
        }
    }

    printf("verificando ordenamento da fila...\n");

    for(i = 0; i < LENGTH; i++) {
        if(get_position(list,&e, i)) printf("elemento %d: %d\n", i, e);
    }

    if(remove_position(list, &e, 5)) printf("elemento 5 removido: %d\n", e);

    printf("verificando ordenamento da fila...\n");

    for(i = 0; i < LENGTH; i++) {
        if(get_position(list,&e, i)) printf("elemento %d: %d\n", i, e);
    }

    if(insert_position(list, 11, 3)) printf("elemento inserido na posicao 3: %d\n", 11);

    printf("verificando ordenamento da fila...\n");

    for(i = 0; i < LENGTH; i++) {
        if(get_position(list,&e, i)) printf("elemento %d: %d\n", i, e);
    }

    for(i = 0; i <= LENGTH; i++) {
        if(remove_tail(list, &e)) {
            printf("elemento %d removido da lista pelo final\n", e);
        } else {
            printf("fila vazia\n");
        }
    }

    free_list(list);
}