/*
Construa uma biblioteca para calcular a média e o desvio
padrão de uma série de números inteiros.
Com a biblioteca crie uma aplicação que pegue um vetor com
5 valores, insira na série e calcule a média e o desvio padrão,
imprimindo seus valores lado a lado com duas casas decimais.
Valores: 2, 5, 7, 13, 18, 21.
Dados de suporte:
Fórmula da média:
m = Px ÷ qtde
Fórmula do desvio padrão:
d = (Px^2 − ((Px)^2 ÷ qtde)) ÷ (qtde − 1)
*/

// pra executar esse codigo tem que acrescentar '-ln' para reconhecer o 'pow()'

/*EXECUTAVEL*/

#include <stdio.h>
#include <math.h>
#include "fixacao10.h"

int main() {
    int inteiros[] = {5, 6, 7, 8, 9};
    float media;
    float mediaDesvioPadrao; 

    CalculadoraMedia* calc;

    calc = criarMedia();
    preencherVetor(calc, inteiros);
    media = calcularMedia(calc);
    mediaDesvioPadrao = calcularMediaDesvioPadrao(calc);
    liberarCalculadoraMedia(calc);

    printf("MEDIA: %f\n", media);
    printf("DESVIO PADRAO: %f\n", mediaDesvioPadrao);
}