# Euclidean Algorithm

## 📋 Summary
* **Core Concept:** An efficient algorithm used to compute the Greatest Common Divisor (GCD) of two integers by repeatedly applying the division algorithm.
* **Takeaways:**
    > * It is significantly more efficient than finding GCD through prime factorization.
    > * It forms the mathematical backbone of modern cryptographic systems like RSA.

## 📖 Definition
* **Greatest Common Divisor (GCD):** The largest positive integer that divides two or more integers without leaving a remainder.
* **Euclidean Principle:** The GCD of two numbers also divides their difference. Therefore, $\text{GCD}(a, b) = \text{GCD}(b, a \pmod b)$.

## 📊 Complexity Analysis

| Notation | Name | Growth Rate |
| :--- | :--- | :--- |
| $O(1)$ | Constant | Excellent (Space - Iterative) |
| $O(\log n)$ | Logarithmic | Very Good (Time) |

* **Worst-Case ($O$):** $O(\log(\min(a, b)))$. This occurs when the inputs are consecutive Fibonacci numbers (Lamé's Theorem).
* **Best-Case ($\Omega$):** $O(1)$. This occurs when $b$ divides $a$ immediately (e.g., GCD(10, 5)).
* **Average-Case ($\Theta$):** $O(\log n)$. On average, the number of steps is proportional to the number of digits in the smaller integer.

## ❓ Why we use it
* **Efficiency:** It is exponentially faster than prime factorization for very large integers.
* **Cryptography:** It is essential for key generation in the RSA encryption algorithm (finding modular inverses).
* **Mathematics:** It is used to simplify fractions and solve linear Diophantine equations.

## ⚙️ How it works
1. **Step 1:** Identify the two numbers, $a$ (dividend) and $b$ (divisor).
2. **Step 2:** Locate the **Basic Operation**, which is the modulo (remainder) operation.
3. **Step 3:** Set up the mathematical model using the recurrence relation:
   $$r_k = r_{k-2} \pmod{r_{k-1}}$$
   Where the process stops when $r_k = 0$.
4. **Step 4:** The number of steps $k$ is bounded by 5 times the number of digits in the smaller number (base 10).

## 💻 Usage / Program Example

```python
# PYTHON
def gcd_iterative(a, b):
    # Basic Operation: Modulo assignment
    while b != 0:
        a, b = b, a % b
    return a

# Output for (48, 18): 6
```

 ```c
// C
#include <stdio.h>

int gcd_recursive(int a, int b) {
    // Base Case
    if (b == 0) {
        return a;
    }
    // Recursive Step
    return gcd_recursive(b, a % b);
}
```

## References
* [Khan Academy](https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/the-euclidean-algorithm) — Overview of the Euclidean Algorithm.
* [Introduction to Algorithms] — Cormen, Leiserson, Rivest, and Stein, Chapter 31.