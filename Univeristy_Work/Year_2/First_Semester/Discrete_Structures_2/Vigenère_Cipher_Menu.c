#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

#define MAX_LEN 256

void showMenu(); void showTable(); void getInput(const char *prompt, char *text);
int validateAlpha(const char *str); void processVigenere(const char *text, const char *, int isEncrypt);

int main(void) {
    char text[MAX_LEN];
    char key[MAX_LEN];
    int ch;

    while (1) {
        showMenu();
        
        if (scanf("%d", &ch) != 1) {
            while(getchar() != '\n');
            ch = 0;
        } else {
            while(getchar() != '\n'); 
        }

        switch(ch) {
            case 1: 
            case 2: 
                getInput("Enter text: ", text);
                getInput("Enter key (alphabets only): ", key);

                if (!validateAlpha(key)) {
                    printf("\n[ERROR] Key must only be alphabetic characters.\n");
                } else {
                    processVigenere(text, key, ch == 1);
                }
                break;
            case 3:
                showTable();
                break;
            case 4:
                printf("\nExiting program.\n");
                exit(0);
            default:
                printf("\nInvalid option. Please try again.\n");
        }
    }
    return 0;
}

void showMenu() {
    printf("\n=== Vigenère Cipher Menu ===");
    printf("\n1. Encrypt Text");
    printf("\n2. Decrypt Text");
    printf("\n3. View Lookup Table");
    printf("\n4. Exit");
    printf("\nChoose an option (1-4): ");
}

void showTable() {
    printf("\n=== Vigenère Cipher Lookup Table ===\n# | ");
    for (char c = 'A'; c <= 'Z'; c++) printf("%c ", c);
    printf("\n");
    for (char row = 'A'; row <= 'Z'; row++) {
        printf("%c |", row);
        for (char col = 'A'; col <= 'Z'; col++) {
            printf(" %c", ((row - 'A') + (col - 'A')) % 26 + 'A');
        }
        printf("\n");
    }
}

void getInput(const char *prompt, char *buffer) {
    printf("%s", prompt);
    fgets(buffer, MAX_LEN, stdin);
    buffer[strcspn(buffer, "\n")] = 0;
}

int validateAlpha(const char *str) {
    for (int i = 0; str[i] != '\0'; i++)
        if (!isalpha(str[i])) return 0;
    return 1;
}

void processVigenere(const char *text, const char *key, int isEncrypt) {
    char output[MAX_LEN] = "";
    int textLen = strlen(text), keyLen = strlen(key);
    int keyIndex = 0;

    printf("\n--- OUTPUT ---\n");
    printf("%-15s %-15s %-15s\n", "Plain/Ciph", "Key Char", "Result");

    int i;
    for (i = 0; i < textLen; i++) {
        char c = text[i];

        if (isalpha(c)) {
            char base = isupper(c) ? 'A' : 'a';
            int shift = toupper(key[keyIndex % keyLen]) - 'A'; 
            int val = toupper(c) - 'A';
            char resultChar;
            
            if (isEncrypt)
                resultChar = (val + shift) % 26;
            else
                resultChar = (val - shift + 26) % 26;
            resultChar = resultChar + base;

            printf("%-15c %-15c %-15c\n", c, key[keyIndex % keyLen], resultChar);
            output[i] = resultChar;
            keyIndex++;
        } else {
            output[i] = c;
            printf("%-15c %-15s %-15c\n", c, "N/A", c);
        }
    }
    output[i] = '\0';
    printf("\nOriginal Input: %s\n", text);
    printf("Key Used:         %s\n", key);
    printf("Final Output:     %s\n", output);
}