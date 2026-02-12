/*
Lejuene B. Delantar BSCS - 1

Tony Sparks likes to jog in the morning. As he jogs, he counts the number of strides he makes during the first minute and then again during
the last minute of his jogging. Tony then averages these two and calls this average the number of strides he makes in a minute when he jogs.
Write a program that accepts this average and the total time Tony spends jogging in minutes and then displays the distance Tony has jogged in miles.
Assume Tony’s stride is 2.5 feet. There are 5280 feet in a mile.
*/

#include <stdio.h>
					

int main(void){
	float avrgStridesMinutes, joggingTimeMinutes, totalStrides, totalDistanceFeet, totalDistanceMiles;
	const float STRIDE_LENGTH_FEET = 2.5, FEET_PER_MILE = 5280;
	
    printf("Input the Average strides per Minute: ");
    scanf("%f", &avrgStridesMinutes);
    
    printf("Input the total time spend Jogging in Minutes: ");
    scanf("%f", &joggingTimeMinutes);
    
    //calculate the total Strides
    totalStrides = avrgStridesMinutes * joggingTimeMinutes;
    //calculate the total distance in feet
    totalDistanceFeet = totalStrides * STRIDE_LENGTH_FEET;
    //Convert total distance into Miles
    totalDistanceMiles = totalDistanceFeet / FEET_PER_MILE;
    
    printf("\nTony has jogged a total of %.2f Miles", totalDistanceMiles);
    
    return 0;
}
