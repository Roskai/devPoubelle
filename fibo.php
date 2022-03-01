<?php

Fibonacci($n)
{

  for ($i=0; $i < $n; $i++) {
    if ($i <= 1)
      $suivant = i;
    else
    {
      $suivant = $nbr1 + $nbr2;
      $nbr1 = $nbr2;
      $nbr2 = $suivant;
    }
  }
  echo $suivant;
}
echo "Les premiers termes de la série de Fibonacci sont:\n";
Fibonacci(189876098);

?>
