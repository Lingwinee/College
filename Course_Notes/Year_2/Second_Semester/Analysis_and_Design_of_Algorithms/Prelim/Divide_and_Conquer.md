# Divide and Conquer Strategy

## 📋 Summary

* **Core Concept:** An algorithmic paradigm that solves complex problems by breaking them into smaller, self-similar sub-problems, solving them recursively, and combining the results.
* **Takeaways:**
    > * It relies on recursion and a base case to stop.
    > * It often improves time complexity from Quadratic ($O(n^2)$) to Linearithmic ($O(n \log n)$) or Logarithmic ($O(\log n)$).
    > * It consists of three main phases: Divide, Conquer, and Combine.

## 📖 Definition

**Divide and Conquer** is a strategy where a problem is partitioned into disjoint sub-problems. These sub-problems are solved recursively (Conquer), and their solutions are merged to form the solution to the original problem (Combine).

**Key Characteristics:**
* **Recursive Structure:** The problem is defined in terms of smaller instances of itself.
* **Base Case:** A condition where the problem is small enough to be solved directly without further division.
* **Non-Overlapping:** Unlike Dynamic Programming, the sub-problems in Divide and Conquer generally do not overlap.

## 📊 Complexity Analysis

The complexity of Divide and Conquer algorithms is often determined using the **Master Theorem** or recursion trees. Below is a comparison of common algorithms using this strategy.

| Algorithm | Best Use Case | Time Complexity (Avg) | Space Complexity |
| :--- | :--- | :--- | :--- |
| **Merge Sort** | Stable sorting, Linked Lists | $O(n \log n)$ | $O(n)$ |
| **Quick Sort** | General in-memory sorting | $O(n \log n)$ | $O(\log n)$ |
| **Binary Search** | Searching sorted arrays | $O(\log n)$ | $O(1)$ / $O(\log n)$ |
| **Closest Pair** | Geometric problems | $O(n \log n)$ | $O(n)$ |

* **Worst-Case ($O$):**
    * **Quick Sort:** $O(n^2)$ if the pivot selection is poor (e.g., already sorted array with last element as pivot).
    * **Merge Sort:** consistently $O(n \log n)$.
* **Best-Case ($\Omega$):**
    * **Binary Search:** $O(1)$ if the target is the middle element.
* **Average-Case ($\Theta$):**
    * Most Divide and Conquer sorting algorithms achieve $O(n \log n)$.

## ❓ Why we use it

* **Efficiency:** It significantly reduces the computational time for large datasets compared to iterative brute-force methods.
* **Parallelism:** Sub-problems are independent, making this strategy ideal for parallel execution on multi-core processors.
* **Memory Handling:** Algorithms like Quick Sort are cache-friendly and can be implemented in-place, optimizing memory usage.

## ⚙️ How it works

The strategy follows three clear steps. We can describe the running time using a recurrence relation: $T(n) = aT(n/b) + f(n)$.

1.  **Divide:** Break the original problem of size $n$ into $a$ sub-problems, each of size $n/b$.
2.  **Conquer:** Solve the sub-problems recursively. If the problem size is small (Base Case), solve it directly.
3.  **Combine:** Merge the solutions of the sub-problems into the final solution, taking $f(n)$ time.

## 💻 Usage / Program Example

Below are implementations of standard Divide and Conquer algorithms in C.

### 1. Merge Sort
Sorts an array by recursively splitting it into halves and merging the sorted halves.

```c
#include <stdio.h>
#include <stdlib.h>

// Merges two subarrays of arr[].
// First subarray is arr[l..m]
// Second subarray is arr[m+1..r]
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

    // Copy remaining elements of L[]
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    // Copy remaining elements of R[]
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
```

### 2. Quick Sort
Sorts by partitioning the array around a "pivot" element.

```c
#include <stdio.h>

void swap(int* a, int* b) {
    int t = *a;
    *a = *b;
    *b = t;
}

// This function takes the last element as pivot, places
// the pivot element at its correct position in sorted array,
// and places all smaller to left of pivot and all greater to right
int partition(int arr[], int low, int high) {
    int pivot = arr[high]; 
    int i = (low - 1); 

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

void quickSort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);

        // Separately sort elements before and after partition
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}
```

### 3. Binary Search
Efficiently finds an item in a sorted array by repeatedly dividing the search interval in half.

```c
#include <stdio.h>

int binarySearch(int arr[], int l, int r, int x) {
    if (r >= l) {
        int mid = l + (r - l) / 2;

        if (arr[mid] == x)
            return mid;

        if (arr[mid] > x)
            return binarySearch(arr, l, mid - 1, x);

        return binarySearch(arr, mid + 1, r, x);
    }
    return -1;
}
```

### 4. Closest Pair of Points
Finds the two points with the smallest distance between them in a 2D plane.

```c
#include <stdio.h>
#include <float.h>
#include <math.h>
#include <stdlib.h>

struct Point { int x, y; };

// Needed for qsort
int compareX(const void* a, const void* b) {
    return (((struct Point*)a)->x - ((struct Point*)b)->x);
}
int compareY(const void* a, const void* b) {
    return (((struct Point*)a)->y - ((struct Point*)b)->y);
}

float dist(struct Point p1, struct Point p2) {
    return sqrt(pow(p1.x - p2.x, 2) + pow(p1.y - p2.y, 2));
}

float min(float x, float y) { return (x < y) ? x : y; }

// Utility to find distance in the strip
float stripClosest(struct Point strip[], int size, float d) {
    float min_val = d;
    qsort(strip, size, sizeof(struct Point), compareY);

    for (int i = 0; i < size; ++i)
        for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < min_val; ++j)
            if (dist(strip[i], strip[j]) < min_val)
                min_val = dist(strip[i], strip[j]);

    return min_val;
}

// Recursive function
float closestUtil(struct Point P[], int n) {
    // Base case: Use brute force for small n
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

    // Divide and Conquer
    float dl = closestUtil(P, mid);
    float dr = closestUtil(P + mid, n - mid);
    float d = min(dl, dr);

    // Build the strip
    struct Point strip[n];
    int j = 0;
    for (int i = 0; i < n; i++)
        if (abs(P[i].x - midPoint.x) < d)
            strip[j] = P[i], j++;

    return min(d, stripClosest(strip, j, d));
}
```

## References

* [GeeksforGeeks: Divide and Conquer Algorithm](https://www.geeksforgeeks.org/divide-and-conquer-algorithm-introduction/) — Comprehensive overview of the paradigm.
* [Introduction to Algorithms] — Cormen, Leiserson, Rivest, and Stein, Chapter 4.