#include "2_SelectionSort.h"

void trocar(int vetor[], int posicao1, int posicao2) {
    int tmp = vetor[posicao1];
    vetor[posicao1] = vetor[posicao2];
    vetor[posicao2] = tmp;
}

int encontrar_posicao_do_menor_elemento(int vetor[], int tamanho, int pivo) {
    int posicao = pivo;
    for(pivo; pivo < tamanho; pivo++) {
        if(vetor[pivo] < vetor[posicao]) {
            posicao = pivo;
        }
    }
    return posicao;
}

void selectionSort(int vetor[], int tamanho) {
    if(tamanho > 0) {
    int i, posicao;
        for(i = 0; i < tamanho - 1; i++) {
            posicao = encontrar_posicao_do_menor_elemento(vetor, tamanho, i);
            trocar(vetor, i, posicao);
        }
    }
}