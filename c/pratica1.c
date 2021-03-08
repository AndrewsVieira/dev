/*
Construa um programa com dois vetores, um de números pares de 2 a 20 e
outro de impares de 1 a 20. Some os elementos de mesmo índice e imprima o
resultado. [pratica1.c]
*/

#include <stdio.h>

int main() {
    int pares[10];
    int impares[10];
    int contador;
    int indicePar = 1;
    int indiceImpar = 1;

    for(contador = 1; contador <= 20; contador++) {
        if(contador % 2 == 0) {
            pares[indicePar-1] = contador;
            indicePar++;
            
        } else {
            impares[indiceImpar-1] = contador;
            indiceImpar++;
        }   
    }

    for(contador = 0; contador < 10; contador++) {
        printf("%d + %d = %d\n", pares[contador], impares[contador], pares[contador] + impares[contador]);
    }
}