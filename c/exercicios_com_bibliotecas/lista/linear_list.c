#include <stdlib.h>
#include "linear_list.h"

#define FALSE 0
#define TRUE 1

struct List_ {
    int quantity;
    int elements[LENGTH];
};

List* create_list() {
    List *list = (List*)malloc(sizeof(List));
    if (list != NULL) {
        list->quantity = 0;
    }
    return list;
}

void empty(List *list) {
    list->quantity = 0;
}

void full(List *list) {
    list->quantity = LENGTH;
}

int insert_head(List *list, int element) {
    if(list->quantity == LENGTH) return FALSE;
    if(list->quantity > 0) {
        int i;
        for(i = list->quantity; i > 0; i--) {
            list->elements[i] = list->elements[i-1];
        }
        list->quantity++;
        list->elements[0] = element;
        return TRUE;
    } else {
        list->quantity++;
        list->elements[0] = element;
        return TRUE;
    }
}

int insert_tail(List *list, int element) {
    if(list->quantity == LENGTH) return FALSE;
    list->elements[list->quantity++] = element;
    return TRUE;
}

int insert_position(List *list, int element, int position) {
    if(list->quantity == LENGTH) return FALSE;
    if(list->quantity > 0) {
        int i;
        for(i = list->quantity; i > position; i--) {
            list->elements[i] = list->elements[i-1];
        }
        list->quantity++;
        list->elements[position] = element;
        return TRUE;
    } else {
        return insert_tail(list, element);
    }
}

int remove_head(List *list, int *element) {
    int i;
    if(list->quantity > 0) {
        *element = list->elements[0];
        for(i = 0; i < list->quantity; i++) {
            list->elements[i] = list->elements[i+1];
        }
        list->quantity--;
        return TRUE;
    }
    return FALSE;
}

int remove_tail(List *list, int *element) {
    if (list->quantity > 0) {
        *element = list->elements[--(list->quantity)];
        return TRUE;
    }
    return FALSE;    
}

int remove_position(List *list, int *element, int position) {
    int i;
    if(list->quantity > 0) {
        *element = list->elements[position];
        for(i = position; i < list->quantity; i++) {
            list->elements[i] = list->elements[i+1];
        }
        list->quantity--;
        return TRUE;
    }
    return FALSE;    
}

int get_head(List *list, int *element) {
    if(list->quantity > 0) {
        *element = list->elements[0];
        return TRUE;
    }
    return FALSE;
}

int get_tail(List *list, int *element) {
    if(list->quantity > 0) {
        *element = list->elements[list->quantity-1];
        return TRUE;
    }
    return FALSE;
}

int get_position(List *list, int *element, int position) {
    if(list->quantity > 0) {
        *element = list->elements[position];
        return TRUE;
    }
    return FALSE;
}

void free_list(List *list) {
    free(list);
}