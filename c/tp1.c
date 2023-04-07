#include <stdio.h>
#include <unistd.h>

int main(int argc, char const *argv[]) {
  int childpid;
  int count1 = 0, count2 = 0;

  printf("On bifurque\n");
  childpid = fork();

  switch (childpid) {
    case -1:
      printf("c'est cassé\n" );
    case 0:
      printf("c'est le processus fils\n");
      while (count1 < 10) {
        printf("processus fils : %d\n",count1 );
        sleep (1);
        count1 ++;
      }
      break;
    default:
      printf("C'est le processus du papa\n");
      while (count2 < 20) {
        printf("papa : %d\n",count2 );
        sleep (1);
        count2++;
      }
      break;
  }
  return 0;
}
