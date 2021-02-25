#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a;
    int *p;

    a = 10;
    p = (int *)malloc(sizeof(int));
    *p = 100;

    printf("A soma de %d e %d é %d\n", a, *p, a + *p);

    free(p);

    printf("Fim\n");
}
