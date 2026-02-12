#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node *next;	
} nd;

void push(nd **head);
void pop(nd **head);
void peek(nd *head);
void displayStack(nd *head);
void displayMenu();

int main(void) {
    nd *head = NULL;
    int ch;
    while(1){
        displayMenu();
        if(scanf("%d", &ch) != 1){
    		while(getchar() != '\n');
		}
        switch (ch) {
            case 1:
                push(&head);
                break;
            case 2:
                pop(&head);
                break;
            case 3:
                displayStack(head);
                break;
            case 4:
                printf("Exiting program...\n");
                return 0;
            default:
                printf("\nInvalid choice.\n\n");
        }
    }
}

void displayMenu() {
    printf("---- STACK MENU ----\n");
    printf("[1] PUSH\t| Insert an integer at the top of the stack.\n");
    printf("[2] POP\t\t| Delete the integer at the top of the stack.\n");
    printf("[3] DISPLAY\t| Display all contents of the stack.\n");
    printf("[4] QUIT\t| Exit the program.\n");
    printf("Enter your choice (1-4): ");
}

void push(nd **head) {
    int val;
    nd *temp = (nd*)malloc(sizeof(nd));

    printf("Enter value to push: ");
    scanf("%d", &val);

    temp->data = val;
    temp->next = *head;
    *head = temp;
    
    printf("\n%d pushed onto the stack.\n\n", val);
}

void pop(nd **head) {
    if (*head == NULL) {
        printf("\nStack underflow! Nothing to pop.\n\n");
        return;
    }
    nd *temp = *head;
    printf("\n%d popped from the stack.\n\n", temp->data);
    *head = (*head)->next;
    free(temp);
}

void displayStack(nd *head) {
    if (!head) {
        printf("\nStack is empty.\n\n");
        return;
    }
    printf("\nStack contents (top to bottom):\n");
	for(nd *p = head; p; p = p->next)
		printf("%d\n", p->data);
	printf("\n");
}