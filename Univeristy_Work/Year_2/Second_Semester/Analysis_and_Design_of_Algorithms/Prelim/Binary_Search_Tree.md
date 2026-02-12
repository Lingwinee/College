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
```