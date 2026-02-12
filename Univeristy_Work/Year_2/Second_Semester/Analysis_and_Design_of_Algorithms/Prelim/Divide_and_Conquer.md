<aside>

# Summary

</aside>

Divide and Conquer is a fundamental strategy in Computer Science. It breaks complex problems into smaller, manageable sub-problems.

**Key Characteristics:**

**Recursive Structure:** The problem is solved by breaking it into smaller instances of itself.
• **Base Case:** A stopping condition prevents infinite recursion.
• **Efficiency:** Often reduces time complexity from quadratic ($O(n^2)$) to linearithmic ($O(n \log n)$) or logarithmic ($O(\log n)$).

**Comparison Table**

| **Algorithm** | **Best Use Case** | **Time Complexity** | **Space Complexity** |
| --- | --- | --- | --- |
| **Merge Sort** | Stable sorting, Linked Lists | $O(n \log n)$ | $O(n)$ |
| **Quick Sort** | General purpose in-memory sorting | $O(n \log n)$ (avg) | $O(\log n)$ |
| **Binary Search** | Searching in sorted arrays | $O(\log n)$ | $O(1)$ / $O(\log n)$ |

---

<aside>

# Definition

</aside>

The **Divide and Conquer** paradigm is an algorithm design strategy that solves a problem by breaking it into smaller sub-problems, solving them recursively, and then combining their solutions to form the final result.

This approach generally follows three steps:

1. **Divide:** Break the original problem into a small number of sub-problems that are smaller instances of the same problem.
2. **Conquer:** Solve the sub-problems recursively. If the sub-problems are small enough (base case), solve them directly.
3. **Combine:** Merge the solutions of the sub-problems to create the solution for the original problem.

---

<aside>

## 1. Merge Sort

</aside>

### Definition

Merge Sort is a sorting algorithm that splits an array into two halves, sorts each half recursively, and then merges the sorted halves back together.

### Complexity

- **Time Complexity:** $O(n \log n)$ in all cases (Best, Average, and Worst).
- **Space Complexity:** $O(n)$ (requires auxiliary space for the temporary arrays used during merging).

### Why we use it

- **Predictability:** It guarantees $O(n \log n)$ performance regardless of the input data order.
- **Stability:** It preserves the relative order of equal elements, which is useful when sorting complex data structures.
- **Large Datasets:** It is efficient for sorting linked lists and datasets that are too large to fit entirely in memory (external sorting).

### How it works

1. Find the middle point of the array to divide it into two halves.
2. Call `mergeSort` for the first half.
3. Call `mergeSort` for the second half.
4. Merge the two sorted halves into a single sorted array.

### Program Example (C)

```c
#include <stdio.h>
#include <stdlib.h>

// Function to merge two subarrays
void merge(int arr[], int l, int m, int r) {
    int i, j, k;
    int n1 = m - l + 1;
    int n2 = r - m;

    // Create temporary arrays
    int L[n1], R[n2];

    // Copy data to temp arrays
    for (i = 0; i < n1; i++)
        L[i] = arr[l + i];
    for (j = 0; j < n2; j++)
        R[j] = arr[m + 1 + j];

    // Merge the temp arrays back into arr[l..r]
    i = 0; 
    j = 0; 
    k = l; 
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

    // Copy the remaining elements of L[], if any
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    // Copy the remaining elements of R[], if any
    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

// Main Merge Sort function
void mergeSort(int arr[], int l, int r) {
    if (l < r) {
        int m = l + (r - l) / 2;

        // Sort first and second halves
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);

        merge(arr, l, m, r);
    }
}

int main() {
    int arr[] = {12, 11, 13, 5, 6, 7};
    int arr_size = sizeof(arr) / sizeof(arr[0]);

    printf("Given array is \n");
    for (int i = 0; i < arr_size; i++)
        printf("%d ", arr[i]);

    mergeSort(arr, 0, arr_size - 1);

    printf("\nSorted array is \n");
    for (int i = 0; i < arr_size; i++)
        printf("%d ", arr[i]);
    
    return 0;
}
```

---

<aside>

## 2. Quick Sort

</aside>

### Definition

Quick Sort is a sorting algorithm that selects a "pivot" element from the array and partitions the other elements into two sub-arrays: those less than the pivot and those greater than the pivot. The sub-arrays are then sorted recursively.

### Complexity

- **Time Complexity:**
    - **Best/Average Case:** $O(n \log n)$
    - **Worst Case:** $O(n^2)$ (Occurs when the pivot is always the smallest or largest element, though this is rare with good pivot selection).
- **Space Complexity:** $O(\log n)$ due to the recursive stack space.

### Why we use it

- **Speed:** In practice, it is often faster than Merge Sort for randomized data because it operates in-place (does not require copying data to new arrays).
- **Memory Efficiency:** It is an in-place sort, meaning it requires very little extra memory compared to Merge Sort.

### How it works

1. **Pick a Pivot:** Select an element (e.g., the last element).
2. **Partition:** Reorder the array so that all elements with values less than the pivot come before it, and all elements greater come after it.
3. **Recursion:** Recursively apply the above steps to the sub-array of elements with smaller values and the sub-array of elements with greater values.

### Program Example (C)

```c
#include <stdio.h>

// Function to swap two elements
void swap(int* a, int* b) {
    int t = *a;
    *a = *b;
    *b = t;
}

// Partition function
int partition(int arr[], int low, int high) {
    int pivot = arr[high]; // Pivot
    int i = (low - 1); // Index of smaller element

    for (int j = low; j <= high - 1; j++) {
        // If current element is smaller than the pivot
        if (arr[j] < pivot) {
            i++; 
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[high]);
    return (i + 1);
}

// Main Quick Sort function
void quickSort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);

        // Separately sort elements before
        // partition and after partition
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

int main() {
    int arr[] = {10, 7, 8, 9, 1, 5};
    int n = sizeof(arr) / sizeof(arr[0]);
    
    printf("Given array: \n");
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);

    quickSort(arr, 0, n - 1);
    
    printf("\nSorted array: \n");
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    
    return 0;
}
```

---

<aside>

## 3. Binary Search

</aside>

### Definition

Binary Search is an efficient algorithm for finding an item from a sorted list of items. It works by repeatedly dividing the portion of the list that could contain the item in half until the possible locations are reduced to just one.

### Complexity

- **Time Complexity:** $O(\log n)$
- **Space Complexity:** $O(1)$ (Iterative) or $O(\log n)$ (Recursive).

### Why we use it

- **Efficiency:** It is significantly faster than Linear Search ($O(n)$) for large datasets.
- **Simplicity:** It is easy to implement and understand for searching problems.

### How it works

1. Compare the target value to the middle element of the array.
2. If they are equal, the search is successful.
3. If the target is less than the middle element, search the lower half.
4. If the target is greater than the middle element, search the upper half.
5. Repeat until the element is found or the sub-array is empty.

### Program Example (C)

```c
#include <stdio.h>

// Recursive Binary Search
int binarySearch(int arr[], int l, int r, int x) {
    if (r >= l) {
        int mid = l + (r - l) / 2;

        // If the element is present at the middle itself
        if (arr[mid] == x)
            return mid;

        // If element is smaller than mid, then it can only be present in left subarray
        if (arr[mid] > x)
            return binarySearch(arr, l, mid - 1, x);

        // Else the element can only be present in right subarray
        return binarySearch(arr, mid + 1, r, x);
    }

    // We reach here when element is not present in array
    return -1;
}

int main() {
    int arr[] = {2, 3, 4, 10, 40};
    int n = sizeof(arr) / sizeof(arr[0]);
    int x = 10;
    
    int result = binarySearch(arr, 0, n - 1, x);
    
    if (result == -1)
        printf("Element is not present in array");
    else
        printf("Element is present at index %d", result);
        
    return 0;
}
```

---

<aside>

# OTHER ONES

</aside>

<aside>

## 1. Strassen's Matrix Multiplication

</aside>

### Definition

Strassen’s algorithm is an efficient method for multiplying two square matrices. It reduces the number of recursive multiplications required compared to the standard "row-by-column" method.

---

<aside>

## 2. Karatsuba Algorithm (Fast Multiplication)

</aside>

### Definition

The Karatsuba algorithm is a fast multiplication procedure for large integers. It breaks down the multiplication of two $n$-digit numbers into three multiplications of smaller numbers.

---

<aside>

## 3. Closest Pair of Points

</aside>

### Definition

Given a set of $n$ points in a 2D plane, this algorithm finds the two points that are the shortest distance apart.

### Complexity

- **Time Complexity:** $O(n \log n)$
- **Space Complexity:** $O(n)$
- *Note: A brute-force approach checking every pair would be $O(n^2)$.*

### How it works

1. **Divide:** Sort points by x-coordinate and split the set into two halves by a vertical line.
2. **Conquer:** Recursively find the smallest distance ($d$) in the left and right halves.
3. **Combine:** Check if there is a pair of points where one is in the left half and the other is in the right half with a distance smaller than $d$. This only requires checking a thin "strip" around the dividing line.

### Program Example (C)

Below is a simplified representation of the "Divide" and "Combine" logic for finding the minimum distance.

```c
#include <stdio.h>
#include <float.h>
#include <math.h>
#include <stdlib.h>

struct Point { int x, y; };

// Helper to find distance between two points
float dist(struct Point p1, struct Point p2) {
    return sqrt((p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y));
}

// Simple min function
float min(float x, float y) { return (x < y) ? x : y; }

// Divide and Conquer function
float closestUtil(struct Point P[], int n) {
    // Base case: If there are 2 or 3 points, use brute force
    if (n <= 3) {
        float min_val = FLT_MAX;
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j)
                if (dist(P[i], P[j]) < min_val)
                    min_val = dist(P[i], P[j]);
        return min_val;
    }

    // Find middle point
    int mid = n / 2;
    struct Point midPoint = P[mid];

    // Divide: find smallest distance in left and right halves
    float dl = closestUtil(P, mid);
    float dr = closestUtil(P + mid, n - mid);

    // Combine: find the smaller of two distances
    float d = min(dl, dr);

    // (Note: In a full implementation, you would then check the "strip")
    return d;
}
```

```c
#include <stdio.h>
#include <float.h>
#include <math.h>
#include <stdlib.h>

struct Point { int x, y; };

// Sort by X-coordinate for the initial divide
int compareX(const void* a, const void* b) {
    return (((struct Point*)a)->x - ((struct Point*)b)->x);
}

// Sort by Y-coordinate for the strip check
int compareY(const void* a, const void* b) {
    return (((struct Point*)a)->y - ((struct Point*)b)->y);
}

float dist(struct Point p1, struct Point p2) {
    return sqrt((p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y));
}

float min(float x, float y) { return (x < y) ? x : y; }

// The "Combine" step: Handles points near the vertical dividing line
float stripClosest(struct Point strip[], int size, float d) {
    float min_val = d;
    qsort(strip, size, sizeof(struct Point), compareY);

    for (int i = 0; i < size; ++i)
        for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < min_val; ++j)
            if (dist(strip[i], strip[j]) < min_val)
                min_val = dist(strip[i], strip[j]);

    return min_val;
}

float closestUtil(struct Point P[], int n) {
    // Base case: Brute force for small sets
    if (n <= 3) {
        float min_val = FLT_MAX;
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j)
                if (dist(P[i], P[j]) < min_val)
                    min_val = dist(P[i], P[j]);
        return min_val;
    }

    int mid = n / 2;
    struct Point midPoint = P[mid];

    float dl = closestUtil(P, mid);
    float dr = closestUtil(P + mid, n - mid);
    float d = min(dl, dr);

    // Build the "strip" of points closer than d to the vertical line
    struct Point strip[n];
    int j = 0;
    for (int i = 0; i < n; i++)
        if (abs(P[i].x - midPoint.x) < d)
            strip[j] = P[i], j++;

    // Find the closest points in the strip and return the overall minimum
    return min(d, stripClosest(strip, j, d));
}

int main() {
    struct Point P[] = {{2, 3}, {12, 30}, {40, 50}, {5, 1}, {12, 10}, {3, 4}};
    int n = sizeof(P) / sizeof(P[0]);
    
    // Crucial: The points MUST be sorted by X for the utility to work
    qsort(P, n, sizeof(struct Point), compareX);
    
    printf("The smallest distance is %f\n", closestUtil(P, n));
    return 0;
}
```

---

## Summary of Advanced D&C Algorithms

| **Algorithm** | **Domain** | **Complexity** | **Optimization** |
| --- | --- | --- | --- |
| **Strassen's** | Linear Algebra | $O(n^{2.81})$ | Reduces matrix multiplications |
| **Karatsuba** | Arithmetic | $O(n^{1.58})$ | Faster large integer multiplication |
| **Closest Pair** | Geometry | $O(n \log n)$ | Avoids $O(n^2)$ point comparisons |
| **Fast Fourier Transform** | Signal Processing | $O(n \log n)$ | Converts time-domain to frequency-domain |



<aside>

# References

</aside>

[]()

---