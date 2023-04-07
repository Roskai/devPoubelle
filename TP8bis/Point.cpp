#include "Point.h"

Point::Point(int a,int b,char c)
{
    this->motif=c;
    this->definir(a,b);
}

void Point::definir (int a,int b)
{
    this->ligne=a;
    this->colonne=b;
}

void Point::deplacerDe(int a,int b)
{
    this->definir(this->ligne+a, this->colonne+b);
}

void Point::dessiner(bool a)
{
    Terminal::charplot(ligne,colonne,(a ? motif : ' '));
}
