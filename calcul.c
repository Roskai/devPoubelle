#define ADDITION 1
#define SOUSTRACT 2
#define MULTIPLY 3
#define DIVIDE 4
#include <stdlib.h>


void calcul(int *operationPointer, double *first_valuePointer, double *second_valuePointer, double *resultPointer)
{
	switch(*operationPointer)
	{
		case ADDITION:
			*resultPointer = *first_valuePointer + *second_valuePointer;
			break;
		case SOUSTRACT:
			*resultPointer = *first_valuePointer - *second_valuePointer;
			break;
		case MULTIPLY:
			*resultPointer = *first_valuePointer * *second_valuePointer;
			break;
		case DIVIDE:
			if (*second_valuePointer == 0) {
						printf("division par 0.\nFin du programme");
						 exit(0);
				 }
				 *resultPointer = *first_valuePointer / *second_valuePointer;
				 break;
		default:
			printf("Opération inconnue.\nFin du programme", );
			exit(0);
	}
}
