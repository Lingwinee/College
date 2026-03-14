// LEJUENE B. DELANTAR BSCS-2
#include <stdio.h>
#define n 10 

int Insert(int A[n], int NoOfItems, int position, int num) {
    for (int i = NoOfItems - 1; i >= position - 1; --i) {
        A[i + 1] = A[i];
    }
    A[position - 1] = num;
    ++NoOfItems;
    return NoOfItems;
}
int InputArray(int A[n]) {
    int NoOfItems;
    printf("Enter number of items in array (max %d): ", n - 1);
    scanf("%d", &NoOfItems);
    printf("Enter %d elements:\n", NoOfItems);
    for (int i = 0; i < NoOfItems; i++) {
        scanf("%d", &A[i]);
    }
    return NoOfItems;
}
void PrintArray(int A[n], int NoOfItems) {
    printf("Array elements:\n");
    for (int i = 0; i < NoOfItems; i++) {
        printf("%d ", A[i]);
    }
    printf("\n");
}
int main(void) {
    int A[n], NoOfItems, position, num;
    NoOfItems = InputArray(A);
    printf("Enter the element to insert: ");
    scanf("%d", &num);
    printf("Enter the position to insert (1 to %d): ", NoOfItems + 1);
    scanf("%d", &position);
    if (position < 1 || position > NoOfItems + 1) {
        printf("Invalid position!\n");
        return 1;
    }
    NoOfItems = Insert(A, NoOfItems, position, num);
    PrintArray(A, NoOfItems);
    return 0;
}
