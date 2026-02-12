/**
Lejuene B. Delantar BSCS
NUM: 34
**/


#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <conio.h>

int main() {
    int userChoice;
	int firstNumber, secondNumber;

    do {
        system("cls");
        printf("Mathematical Operations:\n");
        printf("[1] Addition\n");
        printf("[2] Subtraction\n");
        printf("[3] Multiplication\n");
        printf("[4] Division\n");
        printf("[5] Modulo Division\n");
        printf("[6] Exponentiation\n");
        printf("[7] Exit\n");
        printf("Input your choice [1-7]: ");
        scanf("%d", &userChoice);

		//break to exit the loop
        if (userChoice == 7) break;
        
        switch (userChoice) {
            case 1:
                printf("Input addends: ");
                scanf("%d %d", &firstNumber, &secondNumber);
                printf("%d + %d = %d\n", firstNumber, secondNumber, firstNumber + secondNumber);
                break;
            case 2:
                printf("Input minuend and subtrahend: ");
                scanf("%d %d", &firstNumber, &secondNumber);
                printf("%d - %d = %d\n", firstNumber, secondNumber, firstNumber - secondNumber);
                break;
            case 3:
                printf("Input multiplicand and multiplier: ");
                scanf("%d %d", &firstNumber, &secondNumber);
                printf("%d * %d = %d\n", firstNumber, secondNumber, firstNumber * secondNumber);
                break;
            case 4:
                printf("Input dividend and divisor: ");
                scanf("%d %d", &firstNumber, &secondNumber);
                if (secondNumber == 0) {
                    printf("Division by zero is not allowed.\n");
                } else {
                    printf("%d / %d = %.2f\n", firstNumber, secondNumber, (double)firstNumber / secondNumber);
                }
                break;
            case 5:
                printf("Input dividend and divisor: ");
                scanf("%d %d", &firstNumber, &secondNumber);
                if (secondNumber == 0) {
                    printf("Modulo by zero is not allowed.\n");
                } else {
                    printf("The remainder of %d divided by %d is %d\n", firstNumber, secondNumber, firstNumber % secondNumber);
                }
                break;
            case 6:
                printf("Input base and exponent: ");
                scanf("%d %d", &firstNumber, &secondNumber);
                printf("%d raised to the power %d is %.0f\n", firstNumber, secondNumber, pow(firstNumber, secondNumber));
                break;
            default:
            	printf("Invalid input!\n");
            	printf("Press any key to continue...");
            	_getch();
            	continue;
        }

        printf("Press any key to continue...");
        _getch();

    } while (userChoice != 7);

    return 0;
}
