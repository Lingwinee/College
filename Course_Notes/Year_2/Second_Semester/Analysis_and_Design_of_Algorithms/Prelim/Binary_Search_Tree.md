# Binary Search Tree (BST)

## 📋 Summary

* **Core Concept:** A Binary Search Tree (BST) is a hierarchical data structure where each node satisfies the ordering property: left subtree values are smaller and right subtree values are larger than the parent node.

> **Takeaways:**
>
> * Supports efficient search, insertion, and deletion in average ( $O(\log n$) ).
> * Performance degrades to ($ O(n) $) if the tree becomes skewed.
> * Inorder traversal of a BST produces sorted output.

## 📖 Definition

* **Binary Search Tree (BST):** A binary tree in which for every node:

  * All values in the left subtree are strictly less than the node’s value.
  * All values in the right subtree are strictly greater than the node’s value.
* **Node:** A structure containing:

  * `data`
  * pointer to `left` child
  * pointer to `right` child
* **Height (Level):** The number of nodes on the longest path from root to a leaf.
* **Leaf Node:** A node with no children.

**Requirements:**

* The BST ordering property must hold for every node.
* No duplicate elements (in this implementation).

## 📊 Complexity Analysis

| Notation    | Name        | Growth Rate |
| :---------- | :---------- | :---------- |
| $O(1)$      | Constant    | Excellent   |
| $O(\log n)$ | Logarithmic | Very Good   |
| $O(n)$      | Linear      | Good        |
| $O(n^2)$    | Quadratic   | Poor        |

### For BST Operations (Search, Insert, Delete):

* **Worst-Case ($O(n)$):**
  Occurs when the tree becomes completely skewed (like a linked list).

* **Best-Case ($\Omega(\log n)$):**
  When the tree is perfectly balanced.

* **Average-Case ($\Theta(\log n)$):**
  For randomly distributed insertions.


## ❓ Why we use it

* Maintains elements in sorted order dynamically.
* Faster lookup than linear structures (arrays, linked lists).
* Supports hierarchical representation.
* Foundation for advanced trees (AVL, Red-Black, B-Trees).


## ⚙️ How it works

### Insertion

1. Start at the root.
2. Compare value with current node (**Basic Operation: Comparison**).
3. If smaller → move left. If larger → move right.
4. Repeat until a `NULL` position is found.
5. Insert the new node.

### Search

1. Compare target with current node.
2. Traverse left or right depending on comparison.
3. Stop when found or `NULL`.

### Deletion

There are **three cases**:

1. **Leaf Node:**
   Remove directly.

2. **One Child:**
   Replace node with its child.

3. **Two Children:**

   * Find inorder successor (smallest in right subtree).
   * Replace node’s value with successor.
   * Delete successor recursively.

### Mathematical Model

For balanced BST:

$$T(n) = T(n/2) + c$$

Solving:

$$T(n) = O(\log n)$$

For skewed BST:

$$T(n) = T(n-1) + c$$

Solving:

$$T(n) = O(n)$$



## 💻 Usage / Program Example (C)

```c
#include <stdio.h>
#include <stdlib.h>

/* Type Definitions */
typedef struct Node {
    int data;
    struct Node *left;
    struct Node *right;
} Node, *NodePtr;

/* Function Prototypes */
NodePtr createNode(int value);
NodePtr insert(NodePtr root, int value);
void preOrder(NodePtr root);
void inOrder(NodePtr root);
void postOrder(NodePtr root);
int leafCount(NodePtr root);
int getLevel(NodePtr root);
NodePtr findSmallest(NodePtr root);
NodePtr findLargest(NodePtr root);
NodePtr searchAnElement(NodePtr root, int key);
NodePtr deleteNode(NodePtr root, int key);

/* Main Execution */
int main() {
    NodePtr root = NULL;

    // Creating the BST
    root = insert(root, 50);
    insert(root, 30);
    insert(root, 20);
    insert(root, 40);
    insert(root, 70);
    insert(root, 60);
    insert(root, 80);

    printf("InOrder Traversal: ");
    inOrder(root);
    printf("\n");

    printf("Leaf Count: %d\n", leafCount(root));
    printf("Max Level (Height): %d\n", getLevel(root));

    NodePtr smallest = findSmallest(root);
    if (smallest) printf("Smallest Element: %d\n", smallest->data);

    NodePtr largest = findLargest(root);
    if (largest) printf("Largest Element: %d\n", largest->data);

    return 0;
}

/* Function Definitions */

NodePtr createNode(int value) {
    NodePtr newNode = (NodePtr)malloc(sizeof(Node));
    if (newNode != NULL) {
        newNode->data = value;
        newNode->left = NULL;
        newNode->right = NULL;
    }
    return newNode;
}

NodePtr insert(NodePtr root, int value) {
    if (root == NULL) {
        return createNode(value);
    }
    if (value < root->data) {
        root->left = insert(root->left, value);
    } else if (value > root->data) {
        root->right = insert(root->right, value);
    }
    return root;
}

// Traversals
void preOrder(NodePtr root) {
    if (root == NULL) return;
    printf("%d ", root->data);
    preOrder(root->left);
    preOrder(root->right);
}

void inOrder(NodePtr root) {
    if (root == NULL) return;
    inOrder(root->left);
    printf("%d ", root->data);
    inOrder(root->right);
}

void postOrder(NodePtr root) {
    if (root == NULL) return;
    postOrder(root->left);
    postOrder(root->right);
    printf("%d ", root->data);
}

// Leaf Counting
int leafCount(NodePtr root) {
    if (root == NULL) return 0;
    if (root->left == NULL && root->right == NULL) return 1;
    return leafCount(root->left) + leafCount(root->right);
}

// Level/Height Calculation
int getLevel(NodePtr root) {
    if (root == NULL) return 0;
    int leftHeight = getLevel(root->left);
    int rightHeight = getLevel(root->right);
    return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
}

// Finding Extremes
NodePtr findSmallest(NodePtr root) {
    if (root == NULL || root->left == NULL) return root;
    return findSmallest(root->left);
}

NodePtr findLargest(NodePtr root) {
    if (root == NULL || root->right == NULL) return root;
    return findLargest(root->right);
}

// Searching
NodePtr searchAnElement(NodePtr root, int key) {
    if (root == NULL || root->data == key) return root;
    if (key < root->data) return searchAnElement(root->left, key);
    return searchAnElement(root->right, key);
}

NodePtr deleteNode(NodePtr root, int key) {
    if (root == NULL) return root;

    if (key < root->data)
        root->left = deleteNode(root->left, key);

    else if (key > root->data)
        root->right = deleteNode(root->right, key);

    else {
        /* Case 1: No Child */
        if (root->left == NULL && root->right == NULL) {
            free(root);
            return NULL;
        }

        /* Case 2: One Child */
        else if (root->left == NULL) {
            NodePtr temp = root->right;
            free(root);
            return temp;
        }
        else if (root->right == NULL) {
            NodePtr temp = root->left;
            free(root);
            return temp;
        }

        /* Case 3: Two Children */
        NodePtr temp = findSmallest(root->right);
        root->data = temp->data;
        root->right = deleteNode(root->right, temp->data);
    }

    return root;
}
```


## References

* Cormen, T. H., et al. *Introduction to Algorithms* — Binary Search Trees.
* Weiss, M. A. *Data Structures and Algorithm Analysis in C*.
* Knuth, D. E. *The Art of Computer Programming, Vol. 3*.
