<aside>

# Summary

</aside>

- **Algorithm:** A sequence of clear instructions for solving a problem that produces the required output for any valid input in a finite amount of time.
- **Asymptotic Notations:** Mathematical tools used to describe algorithm efficiency as input size $n$ approaches infinity.
    - **$O(g(n))$ (Big-oh):** Functions that grow no faster than $g(n)$ (upper bound).
    - **$\Omega(g(n))$ (Big-omega):** Functions that grow at least as fast as $g(n)$ (lower bound).
    - **$\Theta(g(n))$ (Big-theta):** Functions that have the same order of growth as $g(n)$ (tight bound).

## **Complexity Analysis**

The framework focuses on the **Order of Growth** of an algorithm's running time or memory usage as the input size $n$ increases.

**Basic Efficiency Classes (from lowest to highest growth):**

1. **Constant:** $1$
2. **Logarithmic:** $\log n$
3. **Linear:** $n$
4. **Linearithmic:** $n \log n$
5. **Quadratic:** $n^2$
6. **Cubic:** $n^3$
7. **Exponential:** $2^n$
8. **Factorial:** $n!$

## Types of Efficiency

- **Worst-Case:** The maximum number of steps an algorithm takes for any input of size $n$. This provides a guaranteed upper bound on performance.
- **Best-Case:** The minimum number of steps an algorithm takes for any input of size $n$.
- **Average-Case:** The number of steps expected on a "typical" or random input. This requires probabilistic assumptions about the input distribution.
- **Amortized:** The average cost of an operation over a sequence of operations, where a single expensive operation is balanced by many inexpensive ones.

## Why do we Use it

- **Performance Prediction:** It allows for estimating how much longer an algorithm will take if the input size increases (e.g., doubling $n$ for a quadratic algorithm increases time by four times).
- **Hardware Independence:** It provides a standardized way to compare algorithms regardless of the specific computer speed or compiler quality used for implementation.
- **Scalability:** Efficiency analysis identifies algorithms that remain practical as data volumes grow, which is critical in fields like Machine Learning and Big Data.

---

<aside>

# 1. Introduction to Algorithms

</aside>

## **Definition and Requirements**

An algorithm is a sequence of unambiguous instructions for solving a problem that produces the required output for any valid input in a finite amount of time.

- **Unambiguity:** Each step must be clear and lead to only one possible action.
- **Range of Inputs:** The set of valid inputs must be clearly defined.
- **Finiteness:** The algorithm must terminate for all valid inputs.

---

## **Fundamental Problem Types**

- **Sorting:** Rearranging items in nondecreasing order (e.g., Selection Sort, Bubble Sort).
- **Searching:** Finding a search key in a given set (e.g., Sequential Search, Binary Search).
- **String Processing:** Handling sequences of characters (e.g., String Matching).
- **Graph Problems:** Dealing with vertices and edges (e.g., Traversal, Shortest Path).
- **Combinatorial Problems:** Finding objects like permutations or subsets that satisfy constraints.
- **Geometric Problems:** Dealing with points, lines, and polygons (e.g., Convex Hull).
- **Numerical Problems:** Solving continuous mathematical problems (e.g., solving equations).

---

<aside>

# 2. The Analysis Framework

</aside>

- Efficiency is analyzed based on two resources: **Time** (running time) and **Space** (extra memory used).

<aside>

## **Measuring Input Size**

Efficiency is measured as a function of input size $n$.

- For lists, $n$ is the number of elements.
- For graphs, size is typically measured by vertices $|V|$ and edges $|E|$.
- For numerical problems, size is often the number of bits $b = \lfloor \log_2 n \rfloor + 1$.
</aside>

<aside>

## **Units for Measuring Running Time**

Instead of measuring seconds, we count how many times the **basic operation** is executed.

- **Basic Operation:** The most time-consuming operation in the algorithm's innermost loop (e.g., a comparison in sorting).
- **Formula:** $T(n) \approx c_{op} C(n)$, where $c_{op}$ is the time to execute one basic operation and $C(n)$ is the count.
</aside>

<aside>

## **Orders of Growth**

Analysis focuses on how the function grows for large $n$, ignoring multiplicative constants.

- **Logarithmic:** $\log n$ (very fast)
- **Linear:** $n$
- **Linearithmic:** $n \log n$
- **Quadratic:** $n^2$
- **Cubic:** $n^3$
- **Exponential:** $2^n$ (impractical for large $n$)
- **Factorial:** $n!$ (extremely slow)
</aside>

<aside>

## **Best, Worst, and Average Case**

- **Worst-Case:** Efficiency for the input of size $n$ that takes the longest to run.
- **Best-Case:** Efficiency for the input of size $n$ that runs the fastest.
- **Average-Case:** Behavior on a typical or random input.
</aside>

---

<aside>

# 3. Asymptotic Notations

</aside>

These notations define the order of growth of an algorithm.

<aside>

## **Big-oh:**

**$O(g(n))$**

- **Meaning:** $t(n)$ grows no faster than $g(n)$ (upper bound).
- **Definition:** $t(n) \le c \cdot g(n)$ for all $n \ge n_0$.
</aside>

<aside>

## **Big-omega:**

 **$\Omega(g(n))$**

- **Meaning:** $t(n)$ grows at least as fast as $g(n)$ (lower bound).
- **Definition:** $t(n) \ge c \cdot g(n)$ for all $n \ge n_0$.
</aside>

<aside>

## **Big-theta:**

 **$\Theta(g(n))$**

- **Meaning:** $t(n)$ and $g(n)$ have the same order of growth (tight bound).
- **Definition:** $c_2 \cdot g(n) \le t(n) \le c_1 \cdot g(n)$ for all $n \ge n_0$.
</aside>

---

<aside>

# 4. Mathematical Analysis of Algorithms

</aside>

<aside>

## **Analysis of Nonrecursive Algorithms**

1. Identify the input size parameter $n$.
2. Identify the basic operation.
3. Check if the execution count depends only on $n$ or also on specific input values.
4. Set up a summation $\sum$ representing the count.
5. Simplify the sum using standard formulas (e.g., $\sum_{i=1}^{n} i = \frac{n(n+1)}{2}$).
</aside>

<aside>

## **Analysis of Recursive Algorithms**

1. Identify the input size parameter $n$.
2. Identify the basic operation.
3. Set up a **recurrence relation** and an initial condition (base case).
4. Solve the recurrence (e.g., using backward substitution or the Master Theorem).
    
    **Example: Fibonacci Numbers**
    
    - **Definition:** $F(n) = F(n-1) + F(n-2)$ with $F(0)=0, F(1)=1$.
    - **Recursive Efficiency:** Extremely inefficient ($O(\phi^n)$ where $\phi \approx 1.618$) due to redundant calculations.
    - **Iterative Efficiency:** Linear ($O(n)$) because it computes each number once.
</aside>

---

<aside>

# 5. Summary of Analysis Plan

</aside>

- **Understand the Problem:** Read the description and work through small examples by hand.
- **Choose Computational Means:** Sequential (RAM model) vs. Parallel.
- **Algorithm Design:** Use known techniques (Brute Force, Divide-and-Conquer, etc.).
- **Verify:** Prove correctness (often via mathematical induction).
- **Code:** Implement and perform empirical analysis to verify the mathematical model.

---

<aside>

# References

</aside>

[]()

---