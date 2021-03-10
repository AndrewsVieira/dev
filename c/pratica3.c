/*
Construa um programa que aceite dez alunos com as
seguintes informações: 

nome, 
matricula e 
até 10 notas.

Apresente a lista dos alunos com a sua média - a ser
calculada.[pratica3.c]
*/

#include <stdio.h>
#include <stdlib.h>
//#include <string.h>

int main() {
    typedef struct Aluno_{
        char nome[50];
        int matricula;
        float notas[10];
    } Aluno;
    
    int i;
    int j;
    char strNotas[10*sizeof(int)];
    float soma;
    float media;

    Aluno *alunos;
    alunos = (Aluno *)malloc(10 * sizeof(Aluno));

    for (i = 0; i < sizeof(alunos); i++) {
        snprintf(alunos[i].nome, 50, "%s %d", "ALUNO", i+1);
        alunos[i].matricula = rand();
        soma = 0;
        for (j = 0; j < sizeof(alunos[i].notas); j++) {
            alunos[i].notas[j] = j + 7;
            soma += alunos[i].notas[j];
            if (j == sizeof(alunos[i].notas) - 1) {
                media = soma / 10;
            }
        }    

        printf("%-10d: %s -> Média: %-5.2f\n", alunos[i].matricula, alunos[i].nome, media);
    }

    free(alunos);    
}