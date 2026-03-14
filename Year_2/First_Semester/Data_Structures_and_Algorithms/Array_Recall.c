// LEJUENE B. DELANTAR BSCS-2

#include <stdio.h>
#include <ctype.h>
#define MAX_ARR 10

void Insert(int*, int);
void DisplayResult(int*, int);

int main(void){
	int Entries[MAX_ARR], count = 0;
	char choice = ' ';
	
	do{
		(count == 0) ? printf("Enter a number: ") : printf("Enter another number: ");
		Insert(Entries, count);
		count++;
		if(count == 10){
			break;
		}
		printf("Another node(y/n)? ");
		scanf(" %c", &choice);
	}while(toupper(choice) == 'Y');
	DisplayResult(Entries, count);
	return 0;
}

void Insert(int arr[], int index){
	scanf("%d", &arr[index]);
}

void DisplayResult(int arr[], int count){
	printf("\nThe numbers are:\n");
	for(int i = 0; i < count; i++){
		printf("%d\n", arr[i]);
	}
}