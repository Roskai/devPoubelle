#ifndef POINT_H
#define POINT_H

#include <iostream>
#include "GraphiqueSimple.h"

using namespace std;

class Point : public GraphiqueSimple
{
private:
    int ligne, colonne;
    char motif;

public :
    Point (int,int,char='o');
    void definir (int,int);
    virtual void deplacerDe (int,int);

protected :
    void dessiner (bool);
};
#endif // POINT_H
