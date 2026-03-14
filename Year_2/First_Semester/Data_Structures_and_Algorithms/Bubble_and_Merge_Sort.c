#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 100

void showMenu();
void bubbleSort(int arr[], int n);
void mergeSort(int arr[], int l, int r);
void merge(int arr[], int l, int m, int r);
void displayArray(int arr[], int n);

int main(void) {
    int arr[MAX_SIZE];
    int n = 0;
    int ch;

    while (1) {
        showMenu();

        if (scanf("%d", &ch) != 1) {
            while (getchar() != '\n');
            ch = 0;
        } else {
            while (getchar() != '\n');
        }

        switch (ch) {
            case 1:
                printf("Enter number of elements: ");
                scanf("%d", &n);
                printf("Enter %d integers:\n", n);
                for (int i = 0; i < n; i++) {
                    scanf("%d", &arr[i]);
                }
                break;
            case 2:
                if (n == 0) {
                    printf("\n[ERROR] Array is empty.\n");
                } else {
                    bubbleSort(arr, n);
                    printf("\nSorted using Bubble Sort:");
                    displayArray(arr, n);
                }
                break;
            case 3:
                if (n == 0) {
                    printf("\n[ERROR] Array is empty.\n");
                } else {
                    mergeSort(arr, 0, n - 1);
                    printf("\nSorted using Merge Sort:");
                    displayArray(arr, n);
                }
                break;
            case 4:
                printf("\nExiting program.\n");
                exit(0);
            default:
                printf("\nInvalid option. Please try again.\n");
        }
    }
    return 0;
}

void showMenu() {
    printf("\n=== Sorting Menu ===");
    printf("\n1. Enter Integers");
    printf("\n2. Bubble Sort");
    printf("\n3. Merge Sort");
    printf("\n4. Exit");
    printf("\nChoose an option (1-4): ");
}

void displayArray(int arr[], int n) {
    printf("\nArray: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

void bubbleSort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

void merge(int arr[], int l, int m, int r) {
    int i, j, k;
    int n1 = m - l + 1;
    int n2 = r - m;

    int L[n1], R[n2];

    for (i = 0; i < n1; i++) L[i] = arr[l + i];
    for (j = 0; j < n2; j++) R[j] = arr[m + 1 + j];

    i = 0; j = 0; k = l;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

void mergeSort(int arr[], int l, int r) {
    if (l < r) {
        int m = l + (r - l) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }
}