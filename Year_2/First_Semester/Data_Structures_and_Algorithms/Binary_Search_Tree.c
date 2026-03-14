#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

typedef struct treeNode {
    int data;
    struct treeNode* left;
    struct treeNode* right;
} tree;

tree *createNode(int data);
tree *findMin(tree* node);

void insert(tree**, int);
void delete(tree**, int);
void search(tree*, int);

void preOrder(tree* root);
void inOrder(tree* root);
void postOrder(tree* root);

void displayMenu();
void setColor(int);

int main(void) {
    tree* root = NULL;
    int choice, value;

    while(1) {
        system("cls");
        displayMenu();
        choice = 0;

        if(scanf("%d", &choice) != 1)
            while(getchar() != '\n');

        switch(choice) {
            case 1:
                printf("\nEnter value to insert: "); scanf("%d", &value);
                insert(&root, value);
                setColor(10); printf("Node %d inserted.\n", value);
                getch(); break; 
            case 2:
                printf("\nEnter value to delete: "); scanf("%d", &value);
                delete(&root, value);
                setColor(10); printf("Node %d deleted if it existed.\n", value);
                getch(); break;
            case 3:
                printf("\nEnter value to search: "); scanf("%d", &value);
                search(root, value); getch(); break;
            case 4:
                setColor(11); printf("\nPre-order Traversal: ");
                preOrder(root); getch(); break;
            case 5:
                setColor(11); printf("\nIn-order Traversal: ");
                inOrder(root); getch(); break;
            case 6:
                setColor(11); printf("\nPost-order Traversal: ");
                postOrder(root); getch(); break;
            case 7:
                setColor(15); printf("Exiting Program\n"); return 0;
            default:
                setColor(12); printf("\nInvalid choice.\n"); getch(); break;
        }
    
    }
    return 0;
}

void setColor(int color) {
    SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), color);
}

void displayMenu() {
    setColor(13);
    printf("\n--- BST Operations Menu ---");
    setColor(10);
    printf("\n1. Insert Node");
    printf("\n2. Delete Node");
    printf("\n3. Search Node");
    printf("\n4. Pre-order Traversal");
    printf("\n5. In-order Traversal");
    printf("\n6. Post-order Traversal");
    setColor(12); printf("\n7. Exit");
    setColor(15); printf("\nEnter your choice: ");
}

tree* findMin(tree* node) {
    while (node->left != NULL)
        node = node->left;
    return node;
}

void insert(tree **root, int value) {
    if (*root == NULL) {
        tree* newNode = (tree*)malloc(sizeof(tree));
        newNode->data = value;
        newNode->left = NULL;
        newNode->right = NULL;
        *root = newNode;
        return;
    }
    if (value < (*root)->data)
        insert(&(*root)->left, value);
    else if (value > (*root)->data)
        insert(&(*root)->right, value);
}

void delete(tree **root, int value) {
    if (*root == NULL) {
        setColor(12); printf("Value %d not found in the tree.\n", value);
        return;
    }
    if (value < (*root)->data)
        delete(&(*root)->left, value);
    else if (value > (*root)->data)
        delete(&(*root)->right, value);
    else { // Node found
        if ((*root)->left == NULL) { // One child (right)
            tree* temp = *root;
            *root = (*root)->right;
            free(temp);
        } else if ((*root)->right == NULL) { // One child (left)
            tree* temp = *root;
            *root = (*root)->left;
            free(temp);
        } else { // Two children
            tree* temp = findMin((*root)->right);
            (*root)->data = temp->data; // Copy inorder successor's value
            delete(&(*root)->right, temp->data); // Delete the leftmost node in right subtree
        }
    }
}

void search(tree* root, int value) {
    if (root == NULL) {
        setColor(12); printf("Value %d not found in the tree.\n", value);
        return;
    }
    if (value < root->data) 
        search(root->left, value);
    else if (value > root->data)
        search(root->right, value);
    else {
        setColor(10); printf("Value %d found in the tree.\n", value);
    }
}

void preOrder(tree* root) {
    if (root == NULL) return;
    printf("%d ", root->data);
    preOrder(root->left);
    preOrder(root->right);
}
void inOrder(tree* root) {
    if (root == NULL) return;
    inOrder(root->left);
    printf("%d ", root->data);
    inOrder(root->right);
}
void postOrder(tree* root) {
    if (root == NULL) return;
    postOrder(root->left);
    postOrder(root->right);
    printf("%d ", root->data);
}