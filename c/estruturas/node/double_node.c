#include "double_node.h"
#include <stdlib.h>

struct Double_node_ {
    int data;
    struct Double_node_ *next;
    struct Double_node_ *previous;
};

Double_node* create_double_node(int data) {
    Double_node* node = (Double_node*)malloc(sizeof(struct Double_node_));
    if(node != NULL) {
        node->data = data;
        node->next = NULL;
        node->previous = NULL;
    }
    return node;
}
Double_node* get_next(Double_node* node) {
    if(node != NULL) return node->next;
}
void set_next(Double_node* node, Double_node* node_next) {
    if(node != NULL) node->next = node_next;
}
Double_node* get_previous(Double_node* node) {
    if(node != NULL) return node->previous;
}
void set_previous(Double_node* node, Double_node* node_previous) {
    if(node != NULL) node->previous= node_previous;
}
int get_data(Double_node* node) {
    if(node != NULL) return node->data;
}