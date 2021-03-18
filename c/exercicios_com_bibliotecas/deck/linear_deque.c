#include <stdlib.h>
#define LENGHT 10

typedef struct Deque_
{
    quantity;
    elements[LENGHT];
} Deque;

Deque *create_deque()
{
    Deque *deque = (Deque *)malloc(sizeof(Deque));
    if (deque != NULL)
    {
        deque->quantity= 0;
    }
    return deque;
}

int insert_begin(Deque *deque, int element)
{
    if (LENGHT == deque->quantity)
        return 0;
    for (int i = deque->quantity; i > 0; i--)
    {
        deque->elements[i] = deque->elements[i-i];
    }
    deque->elements[0] = element;
    return 1;
}

int remove_begin(Deque *deque, int *element)
{
    if (deque->quantity > 0)
    {
        element = deque->elements[0];
        deque->quantity--;
        for (int i = 0; i < deque->quantity; i++)
        {
            deque->elements[i] = deque->elements[i + 1];
        }
        return 1;
    }
    return 0;
}

int get_begin(Deque *deque, int *element)
{
    if (deque->quantity > 0)
    {
        element = deque->elements[0];
        return 1;
    }
    return 0;
}

int insert_end(Deque *deque, int element)
{
    if (LENGHT == deque->quantity)
        return 0;
    deque->elements[deque->quantity++] = element;
    return 1;
}

int remove_end(Deque *deque, int *element) {
    if (deque->quantity > 0)
    {
        element = deque->elements[--(deque->quantity)];
        return 1;
    }
    return 0;
}

int get_end(Deque *deque, int *element) {
    if (deque->quantity > 0)
    {
        element = deque->elements[deque->quantity -1];
        return 1;
    }
    return 0;
}

void free_deque(Deque *deque) {
    free(deque);
}
