#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node *left;
    struct Node *right;
} Node;

Node *createNode(int value);
Node *insert(Node *root, int value);
Node *deleteNode(Node *root, int value);
Node *findMin(Node *root);
Node *findMax(Node *root);
void search(Node *root, int value);
void preOrder(Node *root);
void inOrder(Node *root);
void postOrder(Node *root);
void displayMenu();
int findHeight(Node *root);
int findSize(Node *root);

int main() {
    Node *root = NULL;
    int choice, value;

    while (1) {
        displayMenu();
        if (scanf("%d", &choice) != 1) {
            while (getchar() != '\n');
            continue;
        }

        switch (choice) {
            case 1:
                printf("Enter value to insert: ");
                scanf("%d", &value);
                root = insert(root, value);
                printf("Inserted %d.\n", value);
                break;
            case 2:
                printf("Enter value to delete: ");
                scanf("%d", &value);
                root = deleteNode(root, value);
                printf("Deleted %d (if it existed).\n", value);
                break;
            case 3:
                printf("Enter value to search: ");
                scanf("%d", &value);
                search(root, value);
                break;
            case 4:
                printf("Pre-order: ");
                preOrder(root);
                printf("\n");
                break;
            case 5:
                printf("In-order: ");
                inOrder(root);
                printf("\n");
                break;
            case 6:
                printf("Post-order: ");
                postOrder(root);
                printf("\n");
                break;
            case 7:
                if (root != NULL)
                    printf("The minimum of the tree: %d\n", findMin(root)->data);
                else
                    printf("Tree is empty.\n");
                break;
            case 8:
                if (root != NULL)
                    printf("The maximum of the tree: %d\n", findMax(root)->data);
                else
                    printf("Tree is empty.\n");
                break;
            case 9:
                printf("The height of the tree: %d\n", findHeight(root));
                break;
            case 10:
                printf("The size of the tree: %d\n", findSize(root));
                break;
            case 11:
                printf("Exiting...\n");
                return 0;
            default:
                printf("Invalid choice. Please try again.\n");
        }
        printf("\n"); 
    }
    return 0;
}

Node *createNode(int value) {
    Node *newNode = (Node*)malloc(sizeof(Node));
    if (newNode == NULL) return NULL;
    newNode->data = value;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

Node *findMin(Node *root) {
    if (root == NULL) return NULL;
    while (root->left != NULL)
        root = root->left;
    return root;
}

Node *findMax(Node *root) {
    if (root == NULL) return NULL;
    while (root->right != NULL)
        root = root->right;
    return root;
}

Node *insert(Node *root, int value) {
    if (root == NULL)
        return createNode(value);
        
    if (value < root->data)
        root->left = insert(root->left, value);
    else if (value > root->data)
        root->right = insert(root->right, value);
    return root;
}

Node *deleteNode(Node *root, int value) {
    if (root == NULL) return root;

    if (value < root->data)
        root->left = deleteNode(root->left, value);
    else if (value > root->data)
        root->right = deleteNode(root->right, value);
    else {
        if (root->left == NULL) {
            Node *temp = root->right;
            free(root);
            return temp;
        } else if (root->right == NULL) {
            Node *temp = root->left;
            free(root);
            return temp;
        }
        Node *temp = findMin(root->right);
        root->data = temp->data;
        root->right = deleteNode(root->right, temp->data);
    }
    return root;
}

void search(Node *root, int value) {
    if (root == NULL) {
        printf("Value %d not found.\n", value);
        return;
    }
    if (root->data == value)
        printf("Value %d found in the tree.\n", value);
    else if (value < root->data)
        search(root->left, value);
    else 
        search(root->right, value);
}

// Traversal Functions
void preOrder(Node *root) {
    if (root == NULL) return;
    printf("%d ", root->data);
    preOrder(root->left);
    preOrder(root->right);
}

void inOrder(Node *root) {
    if (root == NULL) return;
    inOrder(root->left);
    printf("%d ", root->data);
    inOrder(root->right);
}

void postOrder(Node *root) {
    if (root == NULL) return;
    postOrder(root->left);
    postOrder(root->right);
    printf("%d ", root->data);
}

int findHeight(Node *root) {
    if (root == NULL) return -1;
    int leftHeight = findHeight(root->left);
    int rightHeight = findHeight(root->right);
    return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
}

int findSize(Node *root) {
    if (root == NULL) return 0;
    return 1 + findSize(root->left) + findSize(root->right);
}

void displayMenu() {
    printf("--- BST Menu ---\n");
    printf("1. Insert\n2. Delete\n3. Search\n");
    printf("4. Pre-order\n5. In-order\n6. Post-order\n");
    printf("7. Display the min.\n8. Display the max.\n");
    printf("9. Find height\n10. Find size\n11. Exit\n");
    printf("Choice: ");
}