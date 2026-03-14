# Algorithm Analysis and Asymptotic Notations


## 📋 Summary

* **Core Concept:** Algorithm analysis evaluates the efficiency of an algorithm in terms of time and space as input size grows, using asymptotic notations to describe its order of growth.

> **Takeaways:**
>
> * Efficiency is measured relative to input size ( n ).
> * Asymptotic notations (($O$), ($\Omega$), ($\Theta$)) describe growth behavior, not exact runtime.
> * Focus is on scalability, hardware independence, and predictability.

---

## 📖 Definition

* **Algorithm:** A finite, unambiguous sequence of well-defined instructions that transforms input into output.

* **Asymptotic Notations:** Mathematical tools used to describe the limiting growth behavior of functions as ( $n \to \infty$ ).

* **Basic Operation:** The dominant operation executed in the innermost loop, used to model runtime.

* **Input Size (($n$)):** A quantitative measure of problem size (e.g., number of elements, number of vertices/edges, bit-length).

* **Requirements:**

  * **Unambiguity:** Each step must be precisely defined.
  * **Finiteness:** Must terminate for all valid inputs.
  * **Defined Input Range:** Acceptable inputs must be specified.
  * **Correctness:** Produces correct output for every valid input.

---

## 📊 Complexity Analysis

| Notation      | Name         | Growth Rate           |
| :------------ | :----------- | :-------------------- |
| $O(1)$        | Constant     | Excellent             |
| $O(\log n)$   | Logarithmic  | Very Good             |
| $O(n)$        | Linear       | Good                  |
| $O(n \log n)$ | Linearithmic | Acceptable            |
| $O(n^2)$      | Quadratic    | Poor                  |
| $O(n^3)$      | Cubic        | Very Poor             |
| $O(2^n)$      | Exponential  | Impractical           |
| $O(n!)$       | Factorial    | Extremely Impractical |

* **Worst-Case ($O$):** The absolute maximum number of steps required for any input of size ( n ).
* **Best-Case ($\Omega$):** The minimum number of steps required for some input of size ( n ).
* **Average-Case ($\Theta$):** The expected performance assuming a probabilistic input distribution.
* **Amortized Analysis:** Average cost per operation over a sequence of operations.

---

## ❓ Why we use it

* **Performance Prediction:** Estimates runtime changes when input size increases (e.g., doubling ( $n$ ) in ($O(n^2)$) results in approximately fourfold runtime).
* **Hardware Independence:** Abstracts away machine-specific execution time.
* **Scalability Assessment:** Determines feasibility for large-scale systems (e.g., ML pipelines, graph analytics).
* **Algorithm Comparison:** Enables objective evaluation between alternative solutions.

---

## ⚙️ How it works

1. **Identify Input Size Parameter:** Determine what represents ( n ).
2. **Locate the Basic Operation:** Typically the dominant comparison or arithmetic operation.
3. **Set up the Mathematical Model:**
   $$T(n) \approx c_{op} C(n)$$
   where:

   * ($c_{op}$) = time per basic operation
   * ($C(n)$) = number of times the operation executes
4. **Formulate Summation or Recurrence:**

   * Nonrecursive: Use summations
     $$\sum_{i=1}^{n} i = \frac{n(n+1)}{2}$$
   * Recursive: Define recurrence relation
     Example:
     $$T(n) = T(n-1) + T(n-2) + 1$$
5. **Simplify Using Order of Growth:** Retain dominant term and discard constants.

---

## 💻 Usage / Program Example

```python
# Example: Linear Search
# Problem Type: Searching
# Basic Operation: Comparison (arr[i] == target)

def linear_search(arr, target):
    for i in range(len(arr)):
        if arr[i] == target:  # Basic Operation
            return i
    return -1

# Worst-Case: O(n)
# Best-Case: O(1)
# Average-Case: O(n)
```

---

## References

* Cormen, T. H., et al. *Introduction to Algorithms (CLRS)* — Chapters 2–4.
* Levitin, A. *Introduction to the Design and Analysis of Algorithms* — Chapter 2.
