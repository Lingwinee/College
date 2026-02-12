# Prime Factorization

## 📋 Summary
* **Core Concept:** The process of decomposing a composite number into a product of prime numbers.
* **Takeaways:**
    > * According to the Fundamental Theorem of Arithmetic, this decomposition is unique for every integer greater than 1.
    > * For small numbers, it is trivial; for large numbers, it is computationally hard.

## 📖 Definition
* **Prime Factorization:** Expressing an integer $n > 1$ as $p_1^{a_1} p_2^{a_2} \dots p_k^{a_k}$, where $p$ are prime numbers and $a$ are their exponents.
* **Fundamental Theorem of Arithmetic:** Every integer greater than 1 is either a prime itself or can be represented as the product of prime numbers in a unique way, disregarding the order.

## 📊 Complexity Analysis

| Notation | Name | Growth Rate |
| :--- | :--- | :--- |
| $O(\sqrt{n})$ | Square Root | Fair (Trial Division) |
| $O(\log n)$ | Logarithmic | Very Good (Space) |

* **Worst-Case ($O$):** $O(\sqrt{n})$ using Trial Division. If $n$ is a product of two large primes, the loop runs until $\sqrt{n}$.
* **Best-Case ($\Omega$):** $O(1)$. This occurs if $n$ is even (divisible by 2 immediately).
* **Average-Case ($\Theta$):** Depends heavily on the properties of $n$, but generally approaches the worst-case for semi-primes used in cryptography.

## ❓ Why we use it
* **Number Theory:** Used to calculate the Least Common Multiple (LCM) and Greatest Common Divisor (GCD).
* **Simplification:** Essential for simplifying square roots and algebraic expressions.
* **Cybersecurity:** The difficulty of factoring large semi-prime numbers is the basis of RSA security.

## ⚙️ How it works
1. **Step 1:** Initialize a divisor $d=2$.
2. **Step 2:** Locate the **Basic Operation**, which is the trial division ($n \% d == 0$).
3. **Step 3:** Set up the process model:
   While $d^2 \leq n$:
   If $n$ is divisible by $d$, divide $n$ by $d$ and store $d$.
   Else, increment $d$.
4. **Step 4:** If $n > 1$ after the loop, the remaining $n$ is a prime factor.

## 💻 Usage / Program Example

```python
# PYTHON
def prime_factors_iterative(n):
    factors = []
    divisor = 2
    # Optimization: Iterate only up to square root of n
    while divisor * divisor <= n:
        while n % divisor == 0:
            factors.append(divisor)
            n //= divisor
        divisor += 1
    if n > 1:
        factors.append(n)
    return factors

# Output for 60: [2, 2, 3, 5]
```

```c
// C
#include <stdio.h>

void prime_factors_iterative(int n) {
    // Handle divisibility by 2 separately to optimize for odd numbers later
    while (n % 2 == 0) {
        printf("%d ", 2);
        n = n / 2;
    }
    
    // Check for odd primes
    for (int i = 3; i * i <= n; i = i + 2) {
        while (n % i == 0) {
            printf("%d ", i);
            n = n / i;
        }
    }
    
    // If n is a prime greater than 2
    if (n > 2)
        printf("%d", n);
}
```

## References
* [GeeksforGeeks](https://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/) — Prime Factorization logic and code.
* [Discrete Mathematics and Its Applications] — Kenneth Rosen, Chapter 4.