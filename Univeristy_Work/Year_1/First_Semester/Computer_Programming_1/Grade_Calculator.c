#include <stdio.h>

int main(void){
	int quizScore1, quizScore2, quizScore3, midTermScore, finalExamScore;
	const int QUIZ_MAX_POINTS = 10,EXAM_MAX_POINTS = 100, NORMALIZE_QUIZ = 10, QUIZ_AVERAGE = 3;
	float averageQuiz, averageQuizNormalized, weightedMidterm, weightedFinal, weightedQuiz, averageWeightedGrade;
	const float MIDTERMS_WEIGHT = 0.25, QUIZ_WEIGHT = 0.25, FINALS_WEIGHT = 0.50;
	
	printf("Input three quiz scores: ");
	scanf("%d %d %d", &quizScore1, &quizScore2, &quizScore3);
	
	printf("Input Midterm score: ");
	scanf("%d", &midTermScore);
	
	printf("Input Final Exam score: ");
	scanf("%d", &finalExamScore);
	
	
	averageQuiz = (float)(quizScore1+quizScore2+quizScore3) / QUIZ_AVERAGE;
	averageQuizNormalized = averageQuiz * NORMALIZE_QUIZ;
	
	weightedQuiz = averageQuizNormalized * QUIZ_WEIGHT;
	weightedMidterm = (float)midTermScore * MIDTERMS_WEIGHT;
	weightedFinal = (float)finalExamScore * FINALS_WEIGHT;
	
	averageWeightedGrade = weightedQuiz + weightedMidterm + weightedFinal;
	printf("Average weighted grade: %.2f", averageWeightedGrade);
	
	if(averageWeightedGrade < 100 && averageWeightedGrade > 0){
		if(averageWeightedGrade <= 100 && averageWeightedGrade >= 90){
			printf("Your grade is 'A'");
		}else if(averageWeightedGrade <= 90 && averageWeightedGrade >= 80){
			printf("Your grade is 'B'");
		}else if(averageWeightedGrade <= 80 && averageWeightedGrade >= 70){
			printf("Your grade is 'C'");
		}else if(averageWeightedGrade <= 70 && averageWeightedGrade >= 60){	
			printf("Your grade is 'D'");
		}else{
			printf("Your grade is 'F'");
		}
	}else{printf("Error Calculations.");}	
	return 0;
}