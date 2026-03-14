# Convex Hull (Brute Force)

## 📋 Summary
* **Core Concept:** The Convex Hull is the smallest convex polygon that contains all points in a set. It can be visualized as the shape formed by a rubber band stretched around a set of pins.
> **Takeaways:** While the brute-force approach is geometrically intuitive, its cubic complexity ($O(n^3)$) makes it impractical for large-scale computational geometry compared to $O(n \log n)$ alternatives.

## 📖 Definition
* **Convex Hull:** The intersection of all convex sets containing a given subset of Euclidean space.
* **Orientation:** The relative position of a point to a directed line (left, right, or collinear), determined via cross-product.



## 📊 Complexity Analysis

| Notation | Name | Growth Rate |
| :--- | :--- | :--- |
| $O(n^3)$ | Cubic | Very Poor |
| $O(n)$ | Linear | Good |

* **Worst-Case ($O$):** $O(n^3)$ because the algorithm checks $n(n-1)$ pairs and validates each against $n-2$ points.
* **Best-Case ($\Omega$):** $\Omega(n^3)$ as the exhaustive check does not terminate early in the basic brute-force version.
* **Average-Case ($\Theta$):** $\Theta(n^3)$ due to the triple nested loop structure.

## ❓ Why we use it
* **Pattern Recognition:** Defining the shape and boundary of a cluster of data.
* **Collision Detection:** Simplifying complex objects into convex shapes for faster intersection testing in physics engines.
* **GIS Analysis:** Finding the boundary area of a set of geographic coordinates.

## ⚙️ How it works
1. **Step 1:** Select two points $P_i$ and $P_j$ to form a directed line.
2. **Step 2:** For all other points $P_k$, calculate the orientation using the cross product:
   $$val = (x_j - x_i)(y_k - y_i) - (y_j - y_i)(x_k - x_i)$$
3. **Step 3:** If all points $P_k$ yield a $val \ge 0$ (or all $\le 0$), the segment $(P_i, P_j)$ is part of the hull.
4. **Step 4:** Repeat for all possible pairs $(P_i, P_j)$.

## 💻 Usage / Program Example
```c
#include <stdio.h>

struct Point { 
    int x, y; 
};

void bruteConvexHull(struct Point p[], int n) {
    if (n < 3) return;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i == j) continue;

            int positive = 0;
            int negative = 0;

            // Basic Operation: Orientation test for point k relative to line ij
            for (int k = 0; k < n; k++) {
                if (k == i || k == j) continue;

                int val = (p[j].x - p[i].x) * (p[k].y - p[i].y) - 
                          (p[j].y - p[i].y) * (p[k].x - p[i].x);

                if (val > 0) positive++;
                if (val < 0) negative++;
            }

            // Segment is part of the hull if no points lie on one of the sides
            if (positive == 0 || negative == 0) {
                printf("Boundary Edge: (%d,%d) to (%d,%d)\n", 
                        p[i].x, p[i].y, p[j].x, p[j].y);
            }
        }
    }
}
```

## References
* [Computational Geometry: Algorithms and Applications] — Mark de Berg.
* [Introduction to Algorithms] — Cormen, Leiserson, Rivest, and Stein (CLRS).