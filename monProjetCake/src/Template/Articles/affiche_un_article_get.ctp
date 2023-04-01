<?php $this->assign('MonTitre',$article->name); ?>
<h1>Cette vue affiche l'article dont l'id est passé en paramètre GET dans l'URL.</h1>
<p>id : <?php echo $article->id; ?> <p>
<p>name : <?php echo $article->name; ?></p>
<p>slug : <?php echo $article->slug; ?></p>
