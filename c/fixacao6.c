/*
Crie um vetor de dez posições que recebam números impares com valor inicial
55 e os demais com decréscimo de 4. Para imprimir, use um ponteiro e use
aritmética de vetores para navegar pelos elementos do vetor. [fixacao6.c]
*/

#include <stdio.h>

int main()
{
    int v[10];

    int i;
    int cont = 55;

    for (i = 0; i < 10; i++)
    {
        v[i] = cont;

        printf("Com ponteiro %d: %d\n", i, v[i]);

        cont -= 4;
    }
}