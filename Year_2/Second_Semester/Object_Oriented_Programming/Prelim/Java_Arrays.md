# Java Arrays

## 📋 Summary
* **Core Concept:** A Java array is a runtime-allocated object that stores a fixed number of variables of the same type (primitives or object references) in contiguous memory on the heap.

> **Takeaways:** Arrays are objects created dynamically during program execution. Multi-dimensional arrays are implemented as "arrays of arrays" with row-major organization. Key operations include declaration (creating stack references), instantiation (heap allocation via `new`), initialization (assigning values), and size retrieval via the `.length` property.

---

## 📖 Definition

* **Array:** An object that functions as a container for multiple variables of identical type.
* **Array Reference:** A variable stored on the stack that points to the array object on the heap.
* **Multi-dimensional Array:** An array whose elements are themselves array references, enabling tabular data organization.

**Requirements:**
* All elements must share the same data type.
* Array size must be specified at creation and remains fixed.
* Memory allocation occurs on the heap via the `new` keyword.

---

## 📊 Memory Model

| Component | Location | Description |
| :--- | :--- | :--- |
| Array Reference | Stack | Variable holding memory address of array object |
| Array Object | Heap | Actual data storage allocated at runtime |
| Array Elements | Heap | Individual values or references within the array |

* **Declaration:** `int[] firstArray;` creates a stack reference without allocating heap memory.
* **Instantiation:** `new int[5]` allocates heap memory for 5 integers (initialized to 0).
* **Reference Assignment:** The stack variable points to the heap-allocated array object.

---

## ❓ Why we use it

* **Batch Storage:** Manage collections of related variables through a single reference.
* **Structured Data:** Organize information in matrices and tables using multi-dimensional arrays.
* **Efficient Access:** Retrieve elements in constant time using index notation.

---

## ⚙️ How it works

1. **Declaration Phase:** Define array type and reference variable name (stack allocation only).
2. **Creation Phase:** Use `new` keyword to allocate fixed-size memory on the heap.
3. **Initialization Phase:** Assign values to array elements (default initialization or explicit values).
4. **Access Phase:** Use `.length` property to retrieve size; use index notation `[i]` to access elements.

**Multi-dimensional Implementation:**
* A 2D array `int[][] matrix = new int[3][4]` creates one array of 3 references.
* Each reference points to a separate array of 4 integers.
* Total heap allocations: 4 array objects (1 parent + 3 child arrays).

---

## 💻 Usage / Program Example

### Single-Dimensional Array
```java
// Declaration and Creation
// Allocates heap memory for 5 integers (default value: 0)
int[] firstArray = new int[5];

// Initialization with specific values
// Creates array of size 5 with values 1 through 5
int[] secondArray = {1, 2, 3, 4, 5};

// Accessing size
// Prints "Size = 5" using the .length property
System.out.println("Size = " + secondArray.length);

// Element access
firstArray[0] = 10; // Assigns 10 to first element
int value = secondArray[2]; // Retrieves 3 from index 2
```

### Multi-Dimensional Array
```java
// Creating a 2D array (3 rows, 4 columns)
// Conceptually a matrix; actually an array of arrays
int[][] twoDimArray = new int[3][4];

// Accessing elements
twoDimArray[1][2] = 42; // Sets row 1, column 2 to 42

// Creating a 3D array
int[][][] threeDimArray = new int[2][3][4];

// Getting dimensions
int rows = twoDimArray.length;       // Returns 3
int cols = twoDimArray[0].length;    // Returns 4
```

### Visualizing 2D Array Structure
For `A = new int[3][4]`:

**Conceptual View (Matrix):**
```
[0][0]  [0][1]  [0][2]  [0][3]
[1][0]  [1][1]  [1][2]  [1][3]
[2][0]  [2][1]  [2][2]  [2][3]
```

**Actual Memory Structure:**
* `A` → Reference to array of 3 elements
* `A[0]` → Reference to array of 4 integers
* `A[1]` → Reference to array of 4 integers
* `A[2]` → Reference to array of 4 integers

---

## References

* [java arrays.pdf](https://drive.google.com/file/d/1_BN29NgRNVjk9dNQDhEwznnIDtJ88RNW/view?usp=sharing) — Original course material on Java array implementation.