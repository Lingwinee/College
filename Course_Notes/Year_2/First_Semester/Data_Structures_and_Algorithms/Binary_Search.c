#include <stdio.h>
#define MaxIndex 10

int BinarySearch(int x, int a[]) {
    int l, r, MidPoint;

    l = 0;
    r = MaxIndex - 1;

    while (l <= r) {
        MidPoint = (l + r) / 2;

        if (x == a[MidPoint])
            return MidPoint;
        else if (x > a[MidPoint])
            l = MidPoint + 1;
        else
            r = MidPoint - 1;
    }

    return -1; // Not found
}

int main(void) {
    int arr[MaxIndex];
    int target, result;

    printf("Enter %d elements in ascending order:\n", MaxIndex);
    for (int i = 0; i < MaxIndex; i++) {
        printf("Element %d: ", i);
        scanf("%d", &arr[i]);
    }

    printf("Enter a number to search: ");
    scanf("%d", &target);

    result = BinarySearch(target, arr);

    if (result != -1)
        printf("Found %d at index %d.\n", target, result);
    else
        printf("%d not found in the array.\n", target);

    return 0;
}
