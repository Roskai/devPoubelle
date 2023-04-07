#ifndef GRAPHIQUECOMPOSE_H
#define GRAPHIQUECOMPOSE_H

#include "Graphique.h"
#include <set>

class GraphiqueCompose : public Graphique{

private:
    set <Graphique*> enfants;

public:
    GraphiqueCompose();
    virtual bool ajouter (Graphique*);
    virtual bool supprimer (Graphique*);
    virtual bool jeSuisCompose () {return true;};

public:
    virtual void afficher();
    virtual void effacer();
    virtual void deplacerDe(int,int);

};
#endif // GRAPHIQUECOMPOSE_H
