#include "linear_list.h"
#include <stdio.h>

int main() {
    List* list = create_list();
    int sucesso;
    int elemento;
    int posicao;

    for(int i = 0; i < 10; i++) {
        elemento = (i+1) * 22;
        posicao = i;

        sucesso = insert_position(list, elemento, posicao);
    }


    elemento = 99;
    posicao = 5;

    sucesso = insert_position(list, elemento, posicao);

    if(sucesso) {
        for(int i = 0; i < 20; i++) {
            sucesso = get_position(list, &elemento, i);
            if(!sucesso) printf("não existe essa posição [%i]\n", i);
        }
    }
}