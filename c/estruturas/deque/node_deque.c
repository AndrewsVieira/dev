#include "linear_deque.h"
#include "../node/double_node.h"
#include <stdlib.h>

#define TRUE 1
#define FALSE 0

struct Deque_ {
    Double_node* begin;
    Double_node* end;
};


Deque* create_deque() {
    Deque* deque = (Deque*)malloc(sizeof(struct Deque_));
    if(deque != NULL) {
        deque->begin = NULL;
        deque->end = NULL;
    }
    return deque;
}
int insert_begin(Deque *deque, int element) {
    if(deque == NULL) return FALSE;
    Double_node* node = create_double_node(element);
    if(deque->begin == NULL) {
        deque->end = node;
    } else {
        set_next(node, deque->begin);
        set_previous(deque->begin, node);
    }
    deque->begin = node;
    return TRUE;
}
int remove_begin(Deque *deque, int *element) {
    if(deque == NULL) return FALSE;
    *element = get_data(deque->begin);
    Double_node* temp = deque->begin;
    deque->begin = get_next(deque->begin);
    if(deque->begin == NULL) {
        deque->end = NULL;
    } else {
        set_previous(deque->begin, NULL);
    }
    free(temp);
    return TRUE;
}
int get_begin(Deque *deque, int *element) {
    if(deque == NULL) return FALSE;
    *element = get_data(deque->begin);
    return TRUE;
}
int insert_end(Deque *deque, int element) {
    if(deque == NULL) return FALSE;
    Double_node* node = create_double_node(element);
    if(deque->end == NULL) {
        deque->begin = node;
    } else {
        set_next(deque->end, node);
        set_previous(node, deque->end);
    }
    deque->end = node;
    return TRUE;
}
int remove_end(Deque *deque, int *element) {
    if(deque == NULL) return FALSE;
    *element = get_data(deque->end);
    Double_node* temp = deque->end;
    deque->end = get_previous(deque->end);
    if(deque->end == NULL) {
        deque->begin = NULL;
    } else {
        set_next(deque->end, NULL);
    }
    free(temp);
    return TRUE;
}
int get_end(Deque *deque, int *element) {
    if(deque == NULL) return FALSE;
    *element = get_data(deque->end);
    return TRUE;
}
void free_deque(Deque *deque) {
    Double_node* temp;
    while (deque->begin != NULL) {
        temp = deque->begin;
        deque->begin = get_next(deque->begin);
        free(temp);
    }
    free(deque);    
}