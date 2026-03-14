// LEJUENE B. DELANTAR BSCS-2
#include <stdio.h>
#define n 10 
int Delete(int A[n], int NoOfItems, int num, int *found) {
    int i, j;	*found = 0; 
    for (i = 0; i < NoOfItems; i++) {
        if (A[i] == num) { 
            *found = 1;
            for (j = i; j < NoOfItems - 1; j++) {
                A[j] = A[j + 1];	
            }
            NoOfItems--;  
            break;
        }
    }
    return NoOfItems;
}
int InputArray(int A[n]) {
    int NoOfItems;
    printf("Enter number of items in array (max %d): ", n);
    scanf("%d", &NoOfItems);
    printf("Enter %d elements:\n", NoOfItems);
    for (int i = 0; i < NoOfItems; i++) {
        scanf("%d", &A[i]);
    }
    return NoOfItems;
}

void PrintArray(int A[n], int NoOfItems) {
    if (NoOfItems == 0) {
        printf("Array is empty.\n");
        return;
    }
    printf("Array elements:\n");
    for (int i = 0; i < NoOfItems; i++) {
        printf("%d ", A[i]);
    }
    printf("\n");
}

int main(void) {
    int A[n], NoOfItems, num, found; NoOfItems = InputArray(A);
    printf("Enter the element to delete: "); scanf("%d", &num);
    NoOfItems = Delete(A, NoOfItems, num, &found);
    if (!found) {
        printf("Element %d not found in the array.\n", num);
    }
    PrintArray(A, NoOfItems);
    return 0;
}
