<aside>

# Summary

</aside>

A Java array is an object created at runtime to store a fixed number of variables of the same type, which can be primitives or object references. Arrays are dynamically allocated on the heap, while their reference variables reside on the stack. A multi-dimensional array functions as an "array of arrays," organizing data in a tabular, row-major format. Key concepts include declaration, instantiation, initialization, and the use of the `.length` property to retrieve the array's size.

---

<aside>

# Definition

</aside>

A **Java array** is an object that stores multiple variables of the same type.

- It functions as a container for both primitive types and object references.
- It is distinct because it is dynamic and created during runtime.

**Key Features:**

- **Object Status:** Arrays are objects in Java.
- **Storage:** They can hold references to other objects.
- **Memory:** Created on the heap.
- **Size:** The length is fixed once created.

---

<aside>

## Why do we Use it

</aside>

- To store multiple variables of the same type within a single object reference.
- To organize data in tabular forms (matrices) using multi-dimensional arrays.

---

<aside>

## How it Works

</aside>

**Memory Allocation (Stack vs. Heap):**

- **Declaration:** Declaring `int[] firstArray;` creates a reference variable on the **stack** but does not create the array object yet.
- **Creation:** Executing `new int[5]` allocates memory for the array elements on the **heap**.
- **Reference:** The variable on the stack (`firstArray`) points to the array object on the heap.

**Multi-dimensional Arrays:**

- Conceptually, a 2D array (e.g., `new int[3][4]`) acts like a matrix with 3 rows and 4 columns.
- In reality, it is an **array of arrays**: the main array holds references to other array objects.

---

<aside>

## Step-by-step Implementation

</aside>

<aside>

### **1. Declaring an Array**

Define the variable type and name. This creates a reference on the stack.

- Syntax A: `int[] firstArray;`
- Syntax B: `int firstArray[];`
</aside>

<aside>

### **2. Creating an Array**

Use the `new` keyword to allocate memory on the heap.

- Example: `firstArray = new int[5];`
- *Note:* Elements are initialized to 0 by default upon creation.
</aside>

<aside>

### **3. Initializing an Array**

You can declare, create, and assign values simultaneously.

- Example: `int[] secondArray = {1, 2, 3, 4, 5};`.
- This assigns specific values to indices (e.g., 1 at index 0).
</aside>

<aside>

### **4. Accessing Size**

Use the `.length` property to return the size of a single-dimensional array.

</aside>

---

<aside>

## Program Example

</aside>

<aside>

### **Single-Dimensional Array**

```java
// Declaration and Creation
// Memory is allocated on the heap; elements default to 0
int[] firstArray = new int[5]; 

// Initialization with specific values
// Creates an array of size 5 with values 1 through 5
int[] secondArray = {1, 2, 3, 4, 5};

// Getting size
// Uses the .length property to print the size (5)
System.out.println("Size = " + secondArray.length);
```

</aside>

<aside>

### **Multi-Dimensional Array**

```java
// Creating a 2D array (3 rows, 4 columns)
// Conceptually a matrix, actually an array of arrays
int[][] twoDimArray = new int[3][4];

// Creating a 3D array
int[][][] threeDimArray = new int[2][3][4];
```

</aside>

<aside>

### **Visualizing 2D Arrays**

For `A = new int[3][4]`:

- **Conceptual View:** A matrix.
- **Actual View:** `A` holds a reference to an array of 3 items. Each of those 3 items is a reference to an array of 4 integers.
</aside>

---

<aside>

## References

</aside>

[java arrays.pdf](https://drive.google.com/file/d/1_BN29NgRNVjk9dNQDhEwznnIDtJ88RNW/view?usp=sharing)

---