#include <iostream>

#include "Terminal.h"
#include "Graphique.h"
#include "GraphiqueCompose.h"
#include "Point.h"
#include "GraphiqueSimple.h"
using namespace std;

int main()
{
    //QUESTION 8
    GraphiqueCompose* GC = new GraphiqueCompose();
    Point* p1 = new Point(1 , 1 , 'A');
    Point* p2 = new Point(2 , 2 , 'B');
    Point* p3 = new Point(3 , 3 , 'C');

    GC->ajouter(p1);
    GC->ajouter(p2);
    GC->ajouter(p3);

    //MAIN FINAL
    Terminal t;
    cout<<"//**CLEAR**//"<<endl;
    t.clear();
    cout<<"//**AFFICHER**//"<<endl;
    GC->afficher();
    cout<<"//**EFFACER**//"<<endl;
    GC->effacer();
    cout<<"//**AFFICHER AVEC MOTIF EFFACES**//"<<endl;
    GC->afficher();
    cout<<"//**SUPPRIMER P1**//"<<endl;
    GC->supprimer(p1);
    cout<<"//**AFFICHER SANS P1**//"<<endl;
    GC->afficher();
}
