#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <ctype.h>

int main(int argc, char const *argv[]) {
  char leCaraEntrant;
  char leCaraSortant;
  int tube [2];
  int fils;


  if (pipe(tube)==-1) {
    printf("Création du tube impossible\n");
    exit (EXIT_FAILURE);
  }

  fils = fork();

  switch (fils) {
    case -1:
      exit(EXIT_FAILURE);
    case 0:
      while (read(tube[0], &leCaraEntrant, sizeof(char)) != 0) {
        //toupper renvoie la variable en majuscule
        leCaraEntrant = toupper(leCaraEntrant);
        if (leCaraEntrant != "$"){
            printf("%c\n", leCaraEntrant);
          }
        }
        close (pipe[0]);
        exit(EXIT_SUCCESS);
        break;
    default:
    while (leCaraSortant != "$")
       {
           leCaraSortant = getchar();
           write(pipe[1], &leCaraSortant, sizeof(char));
       }
     break;
    }

  return EXIT_SUCCESS;
}
