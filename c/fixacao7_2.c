/*
Crie uma estrutura compra que contenha nome com 10
posições e valor real. Um vetor de 10 posições que
representará a lista de compras. Insira dez produtos com
nome (nome0, nome1, ...) e valores (10.25, 11.50, 12.75,
...). Use um ponteiro para navegar no vetor e imprima a
lista de compras com o valor total no final - os valores
devem ter duas casas decimais e alinhados na
apresentação. [fixacao7.c]
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    typedef struct ListaCompras_{
        char produto[10];
        float valorProduto;
    } ListaCompra;

    typedef struct Compra_{
        char nome[15];
        float valor;
        ListaCompra lista[10];        
    } Compra;

    int i;
    int c;

    Compra *compra;
    compra = (Compra *)malloc(sizeof(Compra));

    strcpy(compra->nome, "MERCADO TONINHO");

    strcpy(compra->lista[0].produto, "ÁGUA");
    compra->lista[0].valorProduto = 1.80;

    strcpy(compra->lista[1].produto, "COCA-COLA");
    compra->lista[1].valorProduto = 3.50;

    printf("----%s----\n", compra->nome);
    printf("%s %-10s\t%s\n", "Item", "Produto", "Valor");
    printf("-----------------------\n");
    
    compra->valor = 0.0;
    for (i = 0; i < 2; i++) {
        compra->valor += compra->lista[i].valorProduto;

        printf("%-4d%-10s\t%.2f\n", i+1, compra->lista[i].produto, compra->lista[i].valorProduto);
    }

    printf("-----------------------\n");
    printf("%-10s\t%.2f\n", "TOTAL", compra->valor);

    free(compra);
}