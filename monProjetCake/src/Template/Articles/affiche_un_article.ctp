<?php $this->assign('MonTitre',$article->name); ?>
<h1>Cette vue affiche l'article dont l'id est passé en paramètre : <?php echo $article->id; ?></h1>
<p>name : <?php echo $article->name; ?></p>
<p>slug : <?php echo $article->slug; ?></p>
