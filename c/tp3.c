#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <error.h>

#define DIX_MILLION 10000000

unsigned long cpt = 0;

pthread_t thread1, thread2;
pthread_attr_t attrThread1, attrThread2;

pthread_mutex_t verrou = PTHREAD_MUTEX_INITIALIZER;

void compteur() {
  unsigned long tmp;
  for (size_t i = 0; i < DIX_MILLION; i++) {
    pthread_mutex_lock (&verrou);
    tmp = cpt;
    tmp++;
    cpt = tmp;
    pthread_mutex_unlock (&verrou);
  }
}


int main(int argc, char const *argv[]) {



  pthread_attr_init (&attrThread1);
  pthread_attr_init (&attrThread2);

  pthread_create (&thread1, &attrThread1, (void *)compteur, NULL );
  pthread_create (&thread2, &attrThread2, (void *)compteur, NULL );

  printf("Les deux Threads sont lancé.\n");

  pthread_join (thread1, NULL);
  pthread_join (thread2, NULL);
  pthread_mutex_destroy (&verrou);

  printf("valeur finale du compteur =  %lu \n", cpt );
  return 0;
}
