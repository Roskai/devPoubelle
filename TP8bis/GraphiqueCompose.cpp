#include "GraphiqueCompose.h"

GraphiqueCompose::GraphiqueCompose()
{
        this->enfants = set<Graphique*>();
}

bool GraphiqueCompose::ajouter(Graphique* g)
{
    pair<set<Graphique*>::iterator,bool> resultat;
    resultat=this->enfants.insert(g);
    return (resultat.second);
}

bool GraphiqueCompose::supprimer(Graphique* g)
{
    if(g!=nullptr)
    {
        int nbSuppr;
        nbSuppr=this->enfants.erase(g);
        return(nbSuppr!=0);
    }
    else
    {
        return false;
    }
}

void GraphiqueCompose::afficher()
{
    set<Graphique*>::iterator iterateurDebut;
    iterateurDebut= this->enfants.begin();
    while(iterateurDebut!=this->enfants.end())
    {
        (*iterateurDebut)->afficher();
        iterateurDebut++;
    }
}

void GraphiqueCompose::effacer()
{
    set<Graphique*>::iterator iterateurDebut;
    iterateurDebut= this->enfants.begin();
    while(iterateurDebut!=this->enfants.end())
    {
        (*iterateurDebut)->effacer();
        iterateurDebut++;
    }
}

void GraphiqueCompose::deplacerDe(int a, int b)
{
     set<Graphique*>::iterator iterateurDebut;
    iterateurDebut= this->enfants.begin();
    while(iterateurDebut!=this->enfants.end())
    {
        (*iterateurDebut)->deplacerDe(a,b);
        iterateurDebut++;
    }
}
