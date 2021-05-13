#include "3_InsertionSort.h"

int encontrar_posicao_do_menor_elemento(int vetor[], int tamanho, int pivo) {
    int posicao = pivo;
    for(pivo; pivo < tamanho; pivo++) {
        if(vetor[pivo] < vetor[posicao]) {
            posicao = pivo;
        }
    }
    return posicao;
}

void empurrar_elementos(int vetor[], int pivo, int posicao_limite) {
    int i = posicao_limite;
    while(posicao_limite - pivo > 0) {
        vetor[i] = vetor[i - 1];
        i--;
        pivo++;
    }
}

void insertionSort(int vetor[], int tamanho) {
    int i, posicao, tmp;
    for(i = 0; i < tamanho -1; i++) {
        posicao = encontrar_posicao_do_menor_elemento(vetor, tamanho, i);
        tmp = vetor[posicao];
        empurrar_elementos(vetor, i, posicao);
        vetor[i] = tmp;
    }
}