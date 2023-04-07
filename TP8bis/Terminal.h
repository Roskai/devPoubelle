#ifndef TERMINAL_H
#define TERMINAL_H


#include <iostream>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>

#define ESC '\033'
#define TRUE 1
#define FALSE 0

#define abs(i) (i < 0 ? -i : i)

using namespace std;

////////////////////////////// Terminal
class Terminal {

public:

	/*void clear () {
	  cout << ESC << "[H" << ESC << "[2J"<<endl;
	};

	static void charplot (int l, int c, char motif) {
	  cout << ESC << '[' << l << ';' << c << 'H' << motif<<endl;
	};

	void stringplot (int l, int c, string chaine) {
	  cout << ESC << '[' << l << ';' << c << 'H' << chaine;
	};*/

	void clear ()
	{
	    cout << "Ecran effacee" << endl;
	}

	static void charplot (int l, int c, char motif)
	{
	    cout << "Ligne "+to_string(l)+" Colonne "+to_string(c)+" motif "+motif<<endl;
	}
};

#endif // TERMINAL_H
