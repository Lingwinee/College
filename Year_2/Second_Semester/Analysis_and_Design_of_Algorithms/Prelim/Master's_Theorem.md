# Master Theorem

## 📋 Summary
* **Core Concept:** A direct method to determine the asymptotic complexity (Big O) of recurrence relations commonly found in divide-and-conquer algorithms without drawing recursion trees.

> **Takeaways:**
> * It solves recurrences of the form $T(n) = aT(n/b) + f(n)$.
> * It works by comparing the cost of the work done at the root ($f(n)$) with the cost of the work done at the leaves ($n^{\log_b a}$).
> * There are three specific cases; if a recurrence falls into one, the solution is immediate.


## 📖 Definition

* **Recurrence Relation:** An equation that defines a sequence based on a rule that gives the next term as a function of the previous terms.
* **Divide-and-Conquer:** An algorithm design paradigm that recursively breaks a problem into two or more sub-problems of the same or related type ($a$ subproblems of size $n/b$).
* **Requirements:**
    * $a \geq 1$ (constants indicating the number of subproblems).
    * $b > 1$ (constant factor by which the subproblem size decreases).
    * $f(n)$ must be a positive function (the work done to divide and combine).


## 📊 Complexity Analysis

The complexity depends on the comparison between $f(n)$ and critical exponent $n^{\log_b a}$.

| Case | Condition | Result $T(n)$ |
| :--- | :--- | :--- |
| **Case 1** | $f(n) = O(n^{\log_b a - \epsilon})$ | $\Theta(n^{\log_b a})$ |
| **Case 2** | $f(n) = \Theta(n^{\log_b a})$ | $\Theta(n^{\log_b a} \log n)$ |
| **Case 3** | $f(n) = \Omega(n^{\log_b a + \epsilon})$ | $\Theta(f(n))$ |

* **Case 1 (Leaves Dominate):** The work required to solve the subproblems at the bottom of the tree grows faster than the work to split/combine at the top.
* **Case 2 (Balanced):** The work is evenly distributed across the recursion levels.
* **Case 3 (Root Dominates):** The work to split/combine the problem dominates the total cost (requires regularity condition: $af(n/b) \leq cf(n)$ for $c < 1$).


## ❓ Why we use it

* **Efficiency:** It eliminates the need to manually expand recursion trees or use mathematical induction for standard divide-and-conquer relations.
* **Standardization:** It provides a unified framework for analyzing standard algorithms like Merge Sort, Binary Search, and Strassen's Matrix Multiplication.


## ⚙️ How it works
1. **Step 1:** Identify the constants $a$, $b$, and the function $f(n)$ from the given recurrence.
2. **Step 2:** Calculate the critical exponent: $E = \log_b a$.
3. **Step 3:** Compare $n^E$ with $f(n)$.
   $$T(n) = aT\left(\frac{n}{b}\right) + f(n)$$
4. **Step 4:** Determine which case applies:
    * If $n^E$ is polynomially larger than $f(n)$, use **Case 1**.
    * If $n^E$ is equal to $f(n)$, use **Case 2**.
    * If $f(n)$ is polynomially larger than $n^E$, use **Case 3**.


## 💻 Usage / Program Example
```python
# Example: Merge Sort
# Relation: T(n) = 2T(n/2) + n
# Here: a = 2, b = 2, f(n) = n

def merge_sort(arr):
    if len(arr) > 1:
        mid = len(arr) // 2       # Divide step
        L = arr[:mid]
        R = arr[mid:]

        merge_sort(L)             # Recursive call 1 (T(n/2))
        merge_sort(R)             # Recursive call 2 (T(n/2))

        # Merge step (Linear time O(n))
        i = j = k = 0
        while i < len(L) and j < len(R):
            if L[i] < R[j]:
                arr[k] = L[i]
                i += 1
            else:
                arr[k] = R[j]
                j += 1
            k += 1
        # ... (remaining cleanup loops)

# Analysis:
# log_b(a) = log_2(2) = 1
# Compare n^1 with f(n) = n. They are equal.
# Apply Case 2: T(n) = Theta(n^1 * log n) = Theta(n log n)
```

## References

* [Introduction to Algorithms (CLRS)](https://en.wikipedia.org/wiki/Introduction_to_Algorithms) — Cormen, Leiserson, Rivest, and Stein, Chapter 4.
* [Master theorem (analysis of algorithms)](https://en.wikipedia.org/wiki/Master_theorem_(analysis_of_algorithms)) — Wikipedia, General Definition and Cases.