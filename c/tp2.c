#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <error.h>
void routineThread1(/* arguments */) {
  while(1) {
      printf(".\n");
      sleep(1);
  }
}

void routineThread2(/* arguments */) {
  printf("Tapez un caractere :\n");
  char leCar;
  getchar();
  pthread_exit(NULL);
}
pthread_t thread1, thread2;
pthread_attr_t attrThread1, attrThread2;

int main(int argc, char const *argv[]) {
  pthread_attr_init (&attrThread1);
  pthread_attr_init (&attrThread2);

  pthread_create (&thread1, &attrThread1, (void *)routineThread1, NULL );
  pthread_create (&thread2, &attrThread2, (void *)routineThread2, NULL );

  printf("Les deux Threads sont lancé.");

  pthread_join (thread2, NULL);

  printf("On va s'arrêter là. \n" );
  return 0;
}
