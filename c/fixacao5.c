/*
Construa um programa com duas variáveis inteiras (a, b) e
dois ponteiros de inteiros (p, q). Atribua valores iniciais
para eles e imprima na tela. Faça com que p aponte para
a e q aponte para b. Imprima seus valores na tela.
[fixacao5.c]
*/

#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a;
    int b;
    int *p;
    int *q;

    printf("a = %d, b = %d, p = %d, q = %d\n", a, b, p, q);

    a = 1;
    b = 2;
    p = (int *)malloc(sizeof(int));
    q = (int *)malloc(sizeof(int));

    *p = 5;
    *q = 6;

    printf("a = %d, b = %d, p = %d, q = %d\n", a, b, *p, *q);

    free(p);
    free(q);

    printf("Fim\n");
}
