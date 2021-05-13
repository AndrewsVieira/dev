#include "linear_list.h"
#include "../node/double_node.h"
#include <stdlib.h>
#include <stdio.h>

#define TRUE 1
#define FALSE 0

struct List_ {
    int quantity;
    Double_node* begin;
    Double_node* end;
};

List *create_list() {
    List* list = (List*)malloc(sizeof(struct List_));
    if(list != NULL) {
        list->quantity = 0;
        list->begin = NULL;
        list->end = NULL;
    }
    return list;
}
void empty(List *list) {}
void full(List *list) {}
int insert_head(List *list, int element) {
    if(list == NULL) return FALSE;
    Double_node* node = create_double_node(element);
    if(list->begin == NULL) {
        list->end = node;
    } else {
        set_next(node, list->begin);
        set_previous(list->begin, node);
    }
    list->begin = node;
    list->quantity++;
    return TRUE;
}
int insert_tail(List *list, int element) {
    if(list == NULL) return FALSE;
    Double_node* node = create_double_node(element);
    if(list->end == NULL) {
        list->begin = node;
    } else {
        set_next(list->end, node);
        set_previous(node, list->end);
    }
    list->end = node;
    list->quantity++;
    return TRUE;
}
int insert_position(List *list, int element, int position) {
    if((position - 1) > list->quantity || position < 1) return 0;
    int i;
    if(position == 1) {
        if(insert_head(list, element)) {
            printf("inseriu o elemento [%d] na posição [%d] pelo primeiro if e quantity = [%d]\n", element, position, list->quantity);
            return TRUE;
        }
    }
    if((position-1) == list->quantity) {
        if(insert_tail(list, element)) {
            printf("inseriu o elemento [%d] na posição [%d] pelo segundo if e quantity = [%d]\n", element, position, list->quantity);
            return TRUE;
        }
    }
    Double_node* cursor;
    Double_node* new_node = create_double_node(element);
    if((list->quantity / 2) > position) {
        cursor = list->begin;
        for(i = 1; i < position-1; i++) {
            cursor = get_next(cursor);
            printf("cursor = %d no primeiro for\n", get_data(cursor));
        } 
    } else {
        cursor = list->end;
        for(i = list->quantity; i > position-1; i--) {
            cursor = get_previous(cursor);
        printf("cursor = %d no segundo for\n", get_data(cursor));
        } 
    }
    Double_node* temp = get_next(cursor);
    set_previous(new_node, cursor);
    set_next(new_node, temp);
    set_next(cursor, new_node);
    set_previous(temp, new_node);
    list->quantity++;
    printf("new_node = [%d]\n", get_data(new_node));
    printf("anterior do new_node = [%d]\n", get_data(get_previous(new_node)));
    printf("inseriu o elemento [%d] na posição [%d] e quantity = [%d]\n", element, position, list->quantity);
    printf("próximo do new_node = [%d]\n", get_data(get_next(new_node)));
    return 1;
}
int remove_head(List *list, int *element) {

}
int remove_tail(List *list, int *element) {

}
int remove_position(List *list, int *element, int position) {

}
int get_head(List *list, int *element) {
    if(list == NULL) return FALSE;
    *element = get_data(list->begin);
    printf("log do elemento [%d] da primeira posição\n", *element);
    return TRUE;
}
int get_tail(List *list, int *element) {
    if(list == NULL) return FALSE;
    *element = get_data(list->end);
    printf("log do elemento [%d] da última posição\n", *element);
    return TRUE;
}
int get_position(List *list, int *element, int position) {
    if(position >= list->quantity || position == 0) return FALSE;
    int i;
    if(position == 1) {
        return get_head(list, element);
    } else if((list->quantity-1) == position) {
        return get_tail(list, element);
    }
    Double_node* cursor;
    if((list->quantity / 2) > position) {
        cursor= list->begin;
        for(i = 1; i < position; i++) {
            cursor = get_next(cursor);
        }
    } else {
        cursor= list->end;
        for(i = list->quantity; i > position; i--) {
            cursor = get_previous(cursor);
        }
    }
    *element = get_data(cursor);
    printf("log do elemento [%d] da posição [%d]\n", *element, position);
    return 1;
}
void free_list(List *list) {

}