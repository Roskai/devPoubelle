<?php $this->assign('MonTitre','Ajout d\' un article'); ?>
<?php
echo $this->Form->create('Article');
// Ajout d'une zone de texte associée à un champ de la table ici name et
//valorisation de sa balise label et de sa valeur par défaut
echo $this->Form->input('name',array('label'=>'Libellé
article','placeholder'=>'Jeu'));
echo $this->Form->input('slug',array('label'=>'Slug','placeholder'=>'jeu'));
// Ajout d'un bouton Submit et fermeture du formulaire
echo $this->Form->submit('Enregistrer l\'article');
echo $message;

?>
