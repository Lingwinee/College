/*
Lejuene B. Delantar BSCS-1 
*/

#include <stdio.h>

int main()																			{
    float x, y																		;
    printf("Input x & y coordinates of a point: ")									;
    scanf("%f %f", &x, &y)															;
    if (x == 0 && y == 0) 															{
        printf("(%.1f, %.1f) is at the origin.\n", x, y)							;}
	else if (x == 0) 																{
        printf("(%.1f, %.1f) is on the y-axis.\n", x, y)							;} 
	else if (y == 0) 																{																
        printf("(%.1f, %.1f) is on the x-axis.\n", x, y)							;}
    else if (x > 0 && y > 0) 														{
        printf("(%.1f, %.1f) is in the first quadrant.\n", x, y)					;}
    else if (x < 0 && y > 0)														{
        printf("(%.1f, %.1f) is in the second quadrant.\n", x, y)					;}
    else if (x < 0 && y < 0)														{			
        printf("(%.1f, %.1f) is in the third quadrant.\n", x, y)					;}
    else if (x > 0 && y < 0)														{
        printf("(%.1f, %.1f) is in the fourth quadrant.\n", x, y)					;}
    return 0																		;
																					}

