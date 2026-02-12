#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX 100

typedef struct stack {
    char data;
    struct stack *next;
} stack;

void push(stack **, char);
char pop(stack **);
char peek(stack *);
int isEmpty(stack *);
int precedence(char);
int isOperator(char);
void infixToPostfix(char*, char*, stack**);

int main(void) {
    stack *top = NULL;
    char infix[MAX];
    char postfix[MAX];
    char again;

    do {
        printf("\nEnter an Infix Expression: ");
        fgets(infix, sizeof(infix), stdin);
        infix[strcspn(infix, "\n")] = '\0';

        infixToPostfix(infix, postfix, &top);

        printf("\nPostfix Expression is: %s\n", postfix);

        printf("Transact More? (Y/N): ");
        scanf(" %c", &again);
        while(getchar() != '\n');
    } while (again == 'Y' || again == 'y');

    return 0;
}

void push(stack **top, char val) {
    stack *temp = (stack*)malloc(sizeof(stack));
    temp->data = val;
    temp->next = *top;
    *top = temp;
}

char pop(stack **top) {
    if (*top == NULL) return '\0';

    stack *temp = *top;
    char poppedValue = temp->data;
    *top = (*top)->next;
    free(temp);
    return poppedValue;
}

char peek(stack *top) {
    return top ? top->data : '\0';
}

int isEmpty(stack *top) {
    return top == NULL;
}

int precedence(char ch) {
    switch (ch) {
        case '+': case '-': return 1;
        case '*': case '/': return 2;
        default: return 0;
    }
}

int isOperator(char ch) {
    return ch == '+' || ch == '-' || ch == '*' || ch == '/';
}

void infixToPostfix(char infix[], char postfix[], stack **top) {
    int j = 0;

    for (int i = 0; i < strlen(infix); i++) {
        char token = infix[i];

        if (token == ' ' || token == '\t') continue;

        if (isalnum(token)) //(IV) 
            postfix[j++] = token;
        else if (token == '(') //(II)
            push(top, token);
        else if (token == ')') { //(III)
            while (!isEmpty(*top) && peek(*top) != '(')
                postfix[j++] = pop(top);
            pop(top); // '('
        }
        else if (isOperator(token)) { //(I) 
            while (!isEmpty(*top) && precedence(peek(*top)) >= precedence(token))
                postfix[j++] = pop(top);
            push(top, token);
        }
    }

    while (!isEmpty(*top)) // remaining
        postfix[j++] = pop(top);
    postfix[j] = '\0';
}