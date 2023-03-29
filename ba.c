
#include "header.h"
#include "calcul.c"
#include <stdio.h>
#include <stdlib.h>


int main()
{
    int operation;
    int calcul_loop = 1;
    int exit_loop = 1;
    double first_value;
    double second_value;
    double result;

    while (calcul_loop == 1)
    {
        printf("Enter first value:\n");
        if (scanf("%lf", &first_value) != 1)
        {
            printf("Error: invalid input.\n");
            return EXIT_FAILURE;
        }

        printf("Enter second value:\n");
        if (scanf("%lf", &second_value) != 1)
        {
            printf("Error: invalid input.\n");
            return EXIT_FAILURE;
        }

        printf("Enter operation type (addition(1), substraction(2), multiplication(3), division(4)):\n");
        if (scanf("%d", &operation) != 1)
        {
            printf("Error: invalid input.\n");
            return EXIT_FAILURE;
        }

        calcul(&operation, &first_value, &second_value, &result);

        printf("Result is: %f\n", result);

        while (exit_loop == 1)
        {
            printf("Press (1) to go back to the start of the loop, Press (0) to exit the program\n");
            if (scanf("%d", &operation) != 1)
            {
                printf("Error: invalid input.\n");
                return EXIT_FAILURE;
            }

            switch (operation)
            {
            case 1:
                printf("Go back to the start of the loop...\n");
                printf("-----------------------------------\n");
                exit_loop = 0;
                break;
            case 0:
                printf("Exit the program...\n");
                printf("-------------------\n");
                exit_loop = 0;
                calcul_loop = 0;
                break;
            default:
                printf("Error: invalid input.\n");
                break;
            }
        }
    }

    return EXIT_SUCCESS;
}
