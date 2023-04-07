#ifndef GRAPHIQUESIMPLE_H
#define GRAPHIQUESIMPLE_H

#include <iostream>
#include "Graphique.h"

using namespace std;

class GraphiqueSimple : public Graphique
{
public:
    void afficher ();
    void effacer ();
    virtual void deplacerDe (int, int) =0;
    virtual void dessiner(bool)=0;

};
#endif // GRAPHIQUE_H
