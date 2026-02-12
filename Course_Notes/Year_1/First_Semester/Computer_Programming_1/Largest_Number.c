#include <stdio.h>

int main(void){
	int num1, num2, num3;
	
	printf("Iput three different numbers separated by space: ");
	scanf("%d %d %d", &num1, &num2, &num3);
	
	if (num1 > num2 && num1 > num3){
		printf("%d is the largest number.", num1);
	}else if(num2 > num3){
		printf("%d is the largest number.", num2);
	}else{
		printf("%d is the largest number.", num3);
	}
}