#ifndef GRAPHIQUE_H
#define GRAPHIQUE_H

#include <iostream>
#include "Terminal.h"

using namespace std;

class Graphique{

public:
    virtual bool ajouter (Graphique*);
    virtual bool supprimer (Graphique*);
    virtual bool jeSuisCompose () { return false;};

public:
    virtual void afficher () =0;
    virtual void effacer () =0;
    virtual void deplacerDe (int, int) = 0;

};
#endif // GRAPHIQUE_H
