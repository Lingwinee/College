#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* next;
}nd;

void insertSorted(nd**, int);
int deleteElem(nd**, int);
void displayStats(nd*);
void displayMenu();

int main(void) {
    nd *head = NULL;
    int ch, val;

    while (1) {
        displayMenu();
        scanf("%d", &ch);
        switch (ch){
            case 1:
                printf("\nEnter item: ");
                scanf("%d", &val);
                insertSorted(&head, val);
                break;
            case 2:
                printf("\nEnter item: ");
                scanf("%d", &val);
                printf("\n%s", deleteElem(&head, val) ? "Element Deleted" : "Element not Found");
                break;
            case 3:
                if(!head){ printf("\nList is Empty.\n"); continue; }
                for(nd *p = head; p; p = p->next)
                    printf("%d\n", p->data);
                displayStats(head);
                break;
            case 4:
                return 0;
            default:
                printf("Invalid choice.\n");
        }
    }
}

void insertSorted(nd **head, int val) {
    nd *p = *head, *temp = (nd*)malloc(sizeof(nd));
    
    temp->data = val;
    temp->next = NULL;

    if (!*head || (*head)->data > val) {
        temp->next = *head;
        *head = temp;
        return;
    }
    
    while (p->next && p->next->data < val)
        p = p->next;

    temp->next = p->next;
    p->next = temp;
}

int deleteElem(nd **head, int val) {
    if (!*head) return 0;
    nd *p = *head;

    if (p->data == val) {
        *head = p->next;
        free(p);
        return 1;
    }

    while (p->next && p->next->data != val)
        p = p->next;

    if (!p->next) return 0;

    nd *temp = p->next;
    p->next = temp->next;
    free(temp);
    return 1;
}

void displayStats(nd *head) {
    int sum = 0, count = 0, min = head->data, max = head->data;
    for(nd *p = head; p; p = p->next){
        sum += p->data;
        if(p->data > max) max = p->data;
        count++;
    }
    printf("\nSum: %d", sum);
    printf("\nAverage: %.2f", (float)sum / count);
    printf("\nMinimum: %d", min);
    printf("\nMaximum: %d\n", max);
}

void displayMenu() {
    printf("\nChoose an operation\n[1] - Add an Element\n[2] - Delete an Element\n[3] - Display the Elemets\n[4] - Exit\nEnter your choice (1-4): ");
}