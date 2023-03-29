#include <stdio.h>

long Fibonacci( unsigned long n){
  unsigned long nbr1 = 0, nbr2 = 1, suivant, i;
  for (i = 0; i < n; i++)
  {
    if (i <= 1)
      suivant = i;
    else
    {
      suivant = nbr1 + nbr2;
      nbr1 = nbr2;
      nbr2 = suivant;
    }
    printf("%d\n", suivant);
  }
}


int main()
{
  printf("Les premiers termes de la série de Fibonacci sont:\n");
  Fibonacci(189876098);
  return 0;
}
