#include "include.h"
#include "header.h"
#include "calcul.c"

int main()
{
	int* operation = NULL;
       	int* calcul_loop = NULL;	
	int* exit_loop = NULL;
	double* first_value = NULL; 
	double* second_value = NULL; 
	double* result = NULL;
	operation = malloc(sizeof(int));
	calcul_loop = malloc(sizeof(int));
	exit_loop = malloc(sizeof(int));
	first_value = malloc(sizeof(double));
	second_value = malloc(sizeof(double));
	result = malloc(sizeof(double));
	if(operation != NULL)
		if(first_value != NULL)
			if(second_value != NULL)
				if(result != NULL)
					if(calcul_loop != NULL)
						if(exit_loop != NULL)
							*calcul_loop = 1;
							while(*calcul_loop == 1)
							{
								printf("Enter first value :\n");
								scanf("%lf", first_value);
								printf("Enter second value :\n");
								scanf("%lf", second_value);
								printf("Enter operation type(addition(1), substraction(2), multiplication(3), division(4)\n");
								scanf("%d", operation);
								calcul(operation, first_value, second_value, result);
								printf("Result is : %f\n", *result);
								*exit_loop = 1;
								while(*exit_loop == 1)
								{
									printf("Press (1) to go back to the start of the loop, Press (0) to exit the program\n");
									scanf("%d", operation);
									switch(*operation)
									{
										case 1:
											printf("Go back to the start of the loop...\n");
											printf("-----------------------------------\n");
											*exit_loop = 0;
											*calcul_loop = 1;
											break;
										case 0:
											printf("Exit the program...\n");
											printf("-------------------\n");
											*exit_loop = 0;
											*calcul_loop = 0;
											break;
										default:
											printf("Error: try again!\n");
									}
								}
							}
	free(operation);
	free(calcul_loop);
	free(exit_loop);
	free(first_value);
	free(second_value);
	free(result);
	return 0;	
}

