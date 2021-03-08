/*
Crie dois vetores, um por declaração de tipo simples e outro com ponteiro com
20 números quaisquer. Navegue pelos vetores imprimindo o maior elemento (do
vetor de ponteiro ou do vetor simples) de mesmo índice.[pratica2.c]
*/

#include <stdio.h>
#include <stdlib.h>

int main() {
    int simples[20];
    int *ponteiros;
    int i;
    int maiorSimples;
    int maiorPonteiro;

    ponteiros = (int *)malloc(20 * sizeof(int));

    printf("simples\tponteiros\n");

    for (i = 0; i < 20; i++) {
        simples[i] = rand() % 100;

        *ponteiros = rand() % 100;
        ponteiros += 1;
    }

    ponteiros -= 20;

    maiorPonteiro = ponteiros[0];
    maiorSimples = simples[0];

    for (i = 0; i < 20; i++) {
        printf("%d\t%d\n", simples[i], ponteiros[i]);
        
        if (simples[i] > maiorSimples) {
            maiorSimples = simples[i];
        }

        if (ponteiros[i] > maiorPonteiro) {
            maiorPonteiro = ponteiros[i];
        }
    }

    printf("o maior inteiro da lista simples é %d.\n", maiorSimples);
    printf("o maior inteiro da lista ponteiros é %d.\n", maiorPonteiro);
    printf("a soma desses inteiros é %d.\n", maiorPonteiro + maiorSimples);

    free(ponteiros);
}