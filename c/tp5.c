#include <stdio.h>
#include <stdlib.h>
#include <error.h>
#include <signal.h>

int main(int argc, char const *argv[]) {
  unsigned long nbr1 = 0, nbr2 = 1, suivant;
  while(1) {
      suivant = nbr1 + nbr2;
      nbr1 = nbr2;
      nbr2 = suivant;
      printf("%lu\n", suivant);
    }
  return 0;
}
