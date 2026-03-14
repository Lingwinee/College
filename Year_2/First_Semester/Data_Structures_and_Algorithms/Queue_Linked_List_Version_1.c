#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <windows.h>

typedef struct q {
    int data;
    struct q *next;
} Queue;

void displayMenu();
void setColor(int);

int isEmpty(Queue *head);
void enqueue(Queue **head, Queue **tail, int val);
int dequeue(Queue **head, Queue **tail);
void displayQueue(Queue *head);

int main(void) {

    Queue *head = NULL;
    Queue *tail = NULL;
    int ch;

    while(1){
        ch = 0;
        displayMenu();
        if(scanf("%d", &ch) != 1)
            while(getchar() != '\n');
    
        switch (ch) {
            case 1: {
                int val;
                printf("\nEnter value to enqueue: ");
                scanf("%d", &val);
                enqueue(&head, &tail, val);
                break;
            }
            case 2:
                if (isEmpty(head)) {
                    setColor(14); printf("\nWarning: Queue is empty. Cannot dequeue.\n");
                } else {
                    int dequeuedValue = dequeue(&head, &tail);
                    setColor(10); printf("\nDequeued value: %d\n", dequeuedValue);
                }
                break;
            case 3:
                displayQueue(head);
                break;
            case 4:
                setColor(15); printf("Exiting Program\n");
                return 0;
            default:
                setColor(12); printf("\nInvalid choice.\n");
        }
    }
}

void setColor(int color) {
    SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), color);
}

void displayMenu() {
    setColor(13); printf("\n---- QUEUE MENU ----\n");
    setColor(10); printf("[1] ENQUEUE\t| Insert an integer at the rear of the queue.\n");
    printf("[2] DEQUEUE\t| Delete the integer at the front of the queue.\n");
    printf("[3] DISPLAY\t| Display all contents of the queue.\n");
    setColor(12); printf("[4] QUIT\t| Exit the program.\n");
    setColor(11); printf("Enter your choice (1-4): ");
}


int isEmpty(Queue *head) {
    return head == NULL;
}

void enqueue(Queue **head, Queue **tail, int val) {
    Queue *temp = (Queue*)malloc(sizeof(Queue));
    temp->data = val;
    temp->next = NULL;

    if (isEmpty(*head)) 
        *head = *tail = temp;
    else {
        (*tail)->next = temp;
        *tail = temp;
    }
}

void displayQueue(Queue *head) {
    if (isEmpty(head)) {
        setColor(14); printf("\nWarning: Queue is empty.\n");
        return;
    }
    
    setColor(13); printf("\nQueue contents: ");

    setColor(10);
    for(Queue *p = head; p; p = p->next) {
        printf("\n\t%d", p->data);
    }
    printf("\n");
}

int dequeue(Queue **head, Queue **tail) {
    Queue *temp = *head;
    int val = temp->data;
    *head = (*head)->next;

    if (*head == NULL)
        *tail = NULL;

    free(temp);
    return val;
}