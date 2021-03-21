#include <stdio.h>
#include <stdlib.h>
#include "linear_deque.h"

int main() {
    Deque* deque;
    int elements[] = {1,2,3,4,5,6,7,8,9,10};

    deque = create_deque();

    

    free_deque(deque);
}