<?php echo $this->assign('monTitre','Affichage des articles dont id est supérieur à trois');?>
<h1> Voici les articles de la base de données : </h1>
<table class="table-bordered">
<tr><th>id</th><th>Nom</th><th>Slug</th></tr>
<tr><td> <?php echo $lArticle->id ?></td>
<td><?php echo $lArticle->name ?></td>
<td><?= $lArticle->slug ?></td>
</tr>
</table>
