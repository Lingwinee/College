<aside>

# Summary

</aside>

- Details…

---

<aside>

# Definition

<aside>

## Closest Pair

</aside>

Given $n$ points, find a pair $(p_i, p_j)$ That minimizes the Euclidean distance between them.

### **Complexity Analysis**

- **Time Complexity:** $O(n^2)$ For the exhaustive approach (checking every pair).
- **Space Complexity:** $O(1)$ (excluding input storage).

### **Why We Use It**

Used in air traffic control to identify potential collisions and in computational geometry problems.

### **How It Works**

1. Compare every point $i$ with every other point $j$.
2. Calculate the distance $d = \sqrt{(x_2-x_1)^2 + (y_2-y_1)^2}$.
3. Update the minimum distance if $d$ is smaller than the current minimum.

### Code Example

```c
#include <stdio.h>
#include <float.h>
#include <math.h>

struct Point { int x, y; };

float distance(struct Point p1, struct Point p2) {
    return sqrt(pow(p1.x - p2.x, 2) + pow(p1.y - p2.y, 2));
}

void findClosest(struct Point p[], int n) {
    float min = FLT_MAX;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            float d = distance(p[i], p[j]);
            if (d < min) min = d;
        }
    }
    printf("Minimum Distance: %f\n", min);
}
```

---

<aside>

## Convex-Hull

</aside>

Find the subset of points that forms a boundary such that all other points lie inside or on the boundary.

### **Complexity Analysis**

- **Time Complexity:** $O(n^3)$ for the brute force approach.
- **Space Complexity:** $O(n)$ to store the boundary points.

### **Why do we Use it**

Essential in pattern recognition, geographic information systems (GIS), and collision detection.

### **How it Works**

1. For every pair of points $(P_i, P_j)$, form a line.
2. Check if all other points $P_k$ lie on the same side of this line.
3. If they do, the line segment $(P_i, P_j)$ is part of the Convex Hull.

```c
#include <stdio.h>

struct Point { int x, y; };

void bruteConvexHull(struct Point p[], int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i == j) continue;
            int positive = 0, negative = 0;
            for (int k = 0; k < n; k++) {
                // cross product to find orientation
                int val = (p[j].x - p[i].x) * (p[k].y - p[i].y) - 
                          (p[j].y - p[i].y) * (p[k].x - p[i].x);
                if (val > 0) positive++;
                if (val < 0) negative++;
            }
            if (positive == 0 || negative == 0) {
                printf("Boundary Edge: (%d,%d) to (%d,%d)\n", p[i].x, p[i].y, p[j].x, p[j].y);
            } else {
						    printf("Not a convex hull\n"); 
						}
        }
    }
}
```

---

<aside>

# References

</aside>

[]()

---