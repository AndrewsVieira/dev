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

/*INTERFACE*/
#define TAMANHO 5

typedef struct CalculadoraMedia_ CalculadoraMedia;

// receber um vetor de inteiros
CalculadoraMedia* criarMedia();
// preencher vetor
void preencherVetor(CalculadoraMedia* calc, int inteiros[TAMANHO]);
// funcao pra calcular a media
float calcularMedia(CalculadoraMedia* calc);
// funcao pra calcular o desvio padrao
float calcularMediaDesvioPadrao(CalculadoraMedia* calc);
// funcao que limpa a memoria
void liberarCalculadoraMedia(CalculadoraMedia* calc);