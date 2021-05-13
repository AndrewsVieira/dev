#include <stdio.h>
#define FALSE 0
#define TRUE 1



// não está pronto

int main() {
    int vetor[] = {4,3,5,6,2,1};
    int tamanho = 6;

    for(int i = 0; i < tamanho; i++) {
        printf("%d;\n", vetor[i]);
    }

    // mergeSort(vetor, tamanho);
    printf("ordenando.......");

    for(int i = 0; i < tamanho; i++) {
        printf("%d;\n", vetor[i]);
    }

    printf("%d\t%d\t%d", 3 / 2, 4 / 2, 4 % 5);
}