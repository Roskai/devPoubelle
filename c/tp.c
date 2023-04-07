
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <pthread.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <signal.h>

int cpt;
int seconde;
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

void compteur()
{
    pthread_mutex_lock(&mutex);
    cpt++;
    pthread_mutex_unlock(&mutex);
}

void thread1()
{
    while(cpt!=3)
    {
        if(cpt==1)
        {
            printf("Vous avez 10 secondes pour finir \n");
            while(seconde!=10)
            {
                sleep(1);
                seconde++;
                if(cpt==3)
                {
                    pthread_exit(NULL);
                }
            }
            printf("Les 10 secondes sont écoulées \n");
            pthread_mutex_lock(&mutex);
            seconde=0;
            cpt=0;
            pthread_mutex_unlock(&mutex);
        }
    }
}

int main()
{
    cpt=0;
    seconde=0;

    struct sigaction signalNew,signalOld;
    signalNew.sa_handler=compteur;

    sigaction(SIGINT,&signalNew,&signalOld);

    pthread_attr_t attr1;
    pthread_t id1;
    pthread_attr_init(&attr1);
    pthread_create(&id1,&attr1,(void*)thread1,NULL);

    while(cpt!=3)
    {
        sleep(1);
    }

    pthread_join(id1,NULL);
    pthread_mutex_destroy(&mutex);

    return 0;
}
