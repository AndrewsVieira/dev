/**
 * Implemente uma aplicação que receba uma sequência de 10
números de ponto flutuante. Ao final deve ser apresentado o
resultado da divisão dos elementos em ordem inversa de sua
inserção na estrutura.
exemplo:
inserindo:
1.0, 2.0, 4.0, 48.0
teremos que calcular:
48.0 / 4.0 / 2.0 / 1.0;
resultado = 6.0
*/

#include <stdio.h>
#include "linear_stack_float.h"

int main() {
    Stack *stack;
    stack = create_stack();
    int i;
    for (i = 0; i < LENGTH; i++) {
        push(stack, (i+1)*(i+1));
    }
    float value;
    float divisao;
    if(!top(stack, &divisao)) printf("pilha não existe!\n");
    for (i = 0; i < LENGTH; i++) {
        if (pop(stack, &value)) {
            if (divisao != value) {
                printf("%f / %f = ", divisao, value);
                divisao = divisao / value;
                printf("%f\n", divisao);
            }
        }
    }
    free_stack(stack);
}