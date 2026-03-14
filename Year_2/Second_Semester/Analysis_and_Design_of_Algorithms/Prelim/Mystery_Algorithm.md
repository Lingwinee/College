# Mystery Algorithm (Binary Search)

## 📋 Summary
* **Core Concept:** A search algorithm that finds the position of a target value within a sorted array by repeatedly dividing the search interval in half.

> **Takeaways:** It is significantly faster than linear search for large datasets but requires the input data to be sorted beforehand.


## 📖 Definition

* **Binary Search:** An efficient algorithm for finding an item from a sorted list of items by narrowing down the search range.
* **Divide and Conquer:** The paradigm used where the problem is broken into smaller sub-problems until they become simple enough to solve directly.
* **Requirements:** * The collection must be **sorted** (ascending or descending).
    * The collection must allow **random access** to elements (e.g., an array).


## 📊 Complexity Analysis

| Notation | Name | Growth Rate |
| :--- | :--- | :--- |
| $O(1)$ | Constant | Excellent |
| $O(\log n)$ | Logarithmic | Very Good |
| $O(n)$ | Linear | Good |

* **Worst-Case ($O$):** $O(\log n)$ occurs when the target is at the ends of the search space or not present at all.
* **Best-Case ($\Omega$):** $O(1)$ occurs when the middle element is the target value on the first iteration.
* **Average-Case ($\Theta$):** $O(\log n)$ is the expected performance for a random target within the array.


## ❓ Why we use it

* **Efficiency:** For an array of 1,000,000 elements, it takes at most 20 comparisons, whereas linear search could take 1,000,000.
* **Scalability:** It handles massive datasets effectively due to its logarithmic growth rate.


## ⚙️ How it works
1. **Step 1:** Initialize two pointers, `low` at the first index and `high` at the last index.
2. **Step 2:** Calculate the middle index: `mid = low + (high - low) / 2`.
3. **Step 3:** Compare the target value to the element at `mid`.
4. **Step 4:** Set up the mathematical model for the number of comparisons:
   $$T(n) = T(n/2) + 1$$
   Using the Master Theorem, this simplifies to $O(\log n)$.
5. **Step 5:** If the target is smaller, repeat on the left half; if larger, repeat on the right half.



## 💻 Usage / Program Example
```c
#include <stdio.h>

// Binary Search implementation in C
int binarySearch(int arr[], int low, int high, int target) {
    while (low <= high) {
        int mid = low + (high - low) / 2; // Basic Operation: Comparison/Division

        // Check if target is present at mid
        if (arr[mid] == target)
            return mid;

        // If target greater, ignore left half
        if (arr[mid] < target)
            low = mid + 1;
        // If target smaller, ignore right half
        else
            high = mid - 1;
    }

    // Target is not present in array
    return -1;
}

int main() {
    int arr[] = {2, 3, 4, 10, 40};
    int n = sizeof(arr) / sizeof(arr[0]);
    int target = 10;
    int result = binarySearch(arr, 0, n - 1, target);
    
    if (result != -1)
        printf("Element found at index %d\n", result);
    else
        printf("Element not found\n");
    return 0;
}
```

## References

* [Introduction to Algorithms](https://mitpress.mit.edu/9780262046305/introduction-to-algorithms/) — Cormen, Leiserson, Rivest, and Stein (CLRS).
* [GeeksforGeeks Binary Search](https://www.geeksforgeeks.org/binary-search/) — Detailed explanation and implementation variants.