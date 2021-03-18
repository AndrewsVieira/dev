#include <stdlib.h>
#define LENGHT 10

typedef struct List_ {
    quantity;
    elements[LENGHT];
} List;

List *create_list() {
    List *list = (List *)malloc(sizeof(List));
    if (list != NULL)
    {
        list->quantity = 0;
    }
    return list;
}



int insert_begin(List *list, int element) {
    if (LENGHT == list->quantity)
        return 0;
    for (int i = 0; i < list->quantity; i++) {
        list->elements[i+1] = list->elements[i];
    }
    list->elements[0] = element;
    return 1;
}

int remove_begin(List *list, int *element) {
    if (list->quantity > 0)
    {
        element = list->elements[0];
        list->quantity--;
        for (int i = 0; i < list->quantity; i++)
        {
            list->elements[i] = list->elements[i + 1];
        }
        return 1;
    }
    return 0;
}

int get_begin(List *list, int *element) {
    if (list->quantity > 0)
    {
        element = list->elements[0];
        return 1;
    }
    return 0;
}

int insert_end(List *list, int element) {
    if (LENGHT == list->quantity)
        return 0;
    list->elements[list->quantity++] = element;
    return 1;
}

int remove_end(List *list, int *element) {
    if (list->quantity > 0)
    {
        element = list->elements[--(list->quantity)];
        return 1;
    }
    return 0;
}

int get_end(List *list, int *element) {
    if (list->quantity > 0)
    {
        element = list->elements[list->quantity -1];
        return 1;
    }
    return 0;
}

void free_list(List *list) {
    free(list);
}