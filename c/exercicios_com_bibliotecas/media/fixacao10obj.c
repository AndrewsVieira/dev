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

/*OBJETO*/

#include <stdlib.h>
#include "fixacao10.h"

struct CalculadoraMedia_ {
    int vetor[TAMANHO];
};

// receber um vetor de inteiros
CalculadoraMedia* criarMedia() {
    CalculadoraMedia* calc = (CalculadoraMedia*)malloc(sizeof(CalculadoraMedia));
    if(calc != NULL) {
        for (int i = 0; i < TAMANHO; i++) {
            calc->vetor[i] = 0;
        }        
    }
    return calc;
}
// preencher vetor
void preencherVetor(CalculadoraMedia* calc, int inteiros[TAMANHO]) {
    for (int i = 0; i < TAMANHO; i++) {
        calc->vetor[i] = inteiros[i];
    }    
}
// funcao pra calcular a media
float calcularMedia(CalculadoraMedia* calc) {
    float total = 0;
    for (int i = 0; i < TAMANHO; i++) {
        total += calc->vetor[i];
    }
    return (total / TAMANHO);   
}
// funcao pra calcular o desvio padrao
float calcularMediaDesvioPadrao(CalculadoraMedia* calc) {
    float total = 0;
    float totalQuadrado = 0;
    for (int i = 0; i < TAMANHO; i++) {
        total += calc->vetor[i];
        totalQuadrado += calc->vetor[i] * calc->vetor[i];
    }
    return ((totalQuadrado - ((total * total) / TAMANHO)) / (TAMANHO - 1));    
}
// funcao que limpa a memoria
void liberarCalculadoraMedia(CalculadoraMedia* calc) {
    free(calc);
}