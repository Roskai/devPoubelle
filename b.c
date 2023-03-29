#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <time.h>

int main (int argc, char * argv[]){
	pid_t pid1;
	while (1){
		pid1 = fork();
		sleep(10);
	}
}
