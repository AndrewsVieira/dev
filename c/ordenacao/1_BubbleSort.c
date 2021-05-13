#include "1_BubbleSort.h""
#define FALSE 0
#define TRUE 1

void trocar(int vetor[], int posicao1, int posicao2) {
    int tmp = vetor[posicao1];
    vetor[posicao1] = vetor[posicao2];
    vetor[posicao2] = tmp;
}

void bubbleSort(int vetor[], int tamanho) {
    int trocou;
    do {
        trocou = FALSE;
        if (tamanho > 1) {
            for(int i = 0; i < tamanho - 1; i++) {
                if(vetor[i] > vetor[i+1]) {
                    trocar(vetor, i+1, i);
                    trocou = TRUE;
                }
            }
        }
    } while (trocou);    
}

