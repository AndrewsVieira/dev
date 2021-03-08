/*
Crie um ponteiro que receba 5 valores inteiros (10, 20, 30, 40, 50). Crie um
vetor de 5 posições e copie os valores do ponteiro para o vetor. Imprima os
valores de cada item lado a lado. [fixacao8.c]
*/

#include <stdio.h>
#include <stdlib.h>

int main()
{
    int *p;
    int v[5];
    int i;
    int cont = 10;

    p = (int *)malloc(5 * sizeof(int));

    for (i = 0; i < 5; i++)
    {
        *p = cont;
        cont += 10;
        printf("Ponteiro: %d\t", *p);

        v[i] = *p;
        p++;

        printf("Vetor: %d\n", v[i]);
    }
    p -= 5;
    free(p);
}