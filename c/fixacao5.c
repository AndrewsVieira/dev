#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a;
    int b;
    int *p;
    int *q;

    a = 1;
    b = 2;
    p = (int *)malloc(sizeof(int));
    q = (int *)malloc(sizeof(int));

    *p = 5;
    *q = 6;
}
