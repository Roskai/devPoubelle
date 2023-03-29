function Fibonacci(n) {
    var nbr1 = 0, nbr2 = 1, suivant, i;
    for(i = 0; i <= n; i++){
      if (i <= 1){
        suivant = i;
      }
      else {
        somme = nbr1 + nbr2;
        nbr1 = nbr2;
        nbr2 = suivant;
      }
   }
 console.log(suivant);
}
console.log("Les premiers termes de la série de Fibonacci sont:\n");
console.log(Fibonacci(189876098));
