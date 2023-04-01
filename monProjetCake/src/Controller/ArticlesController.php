<?php
namespace App\Controller ;
class ArticlesController extends AppController{
  public function afficheAccueil($nom, $prenom) {
      $this->set('nom', $nom);
      $this->set('prenom', $prenom);
  }




  public function afficheMessage($libelle){
      echo "           L'article : ",$libelle;
  }

    /*
    public function index() {
        debug($this->request->getParam('controller'));
        debug($this->request->getParam('action'));
        debug($this->request->getQuery('categorie'));
        debug($this->request->getQuery('libelle'));
        debug($this->request->getQueryParams());
        debug($this->request->getParam('pass'));
        debug($this->request->getParam('data'));
    }*/
    public function afficherEgalTrois() {
      $objQuery = $this->Articles->find();
      $objQuery->select(['id','name','slug']);
      $objQuery->where(['id >' => 3]);
      $lesArticles = $objQuery->toArray();
      $this->set('lesArticles',$lesArticles);
  }
  public function requeteUn(){
    $articles = $this->Articles->find()
        ->select(['name', 'created'])
        ->limit(2)
        ->toArray();

    $this->set(compact('articles'));
}

public function requeteDeux(){
    $count = $this->Articles->find()
        ->where(['id' => 3])
        ->count();

    $this->set(compact('count'));
}
public function testMethodesMagiques(){
    $objTableArticles = $this->Articles;
    $objQuery = $objTableArticles->findById('1');
    $recupEntityArticle = $objQuery->first();
    debug($recupEntityArticle);

  }
public function afficheUnArticle($id){
    $article = $this->Articles->findById($id)->select(['id','name', 'slug'])->first();
    $this->set('article', $article);
}
public function AfficheUnArticleGet() {
    $id = $this->request->getQuery('id');
    $article = $this->Articles->findById($id)->select(['id','name', 'slug'])->first();

    $this->set('article', $article);
}

  public function ajouteUnArticle() {
    if ($this->request->is('POST')) {
        $tabPOST = $this->request->getData();

        $objArticlesTable = $this->Articles;
        $existingArticle = $objArticlesTable->findByname($tabPOST['slug'])->first();

        if ($existingArticle) {
            $message = "Cet article existe déjà dans la base.";
            $this->set('message', $message);
            $this->render('ajoute_un_article');
        } else {
            echo 'Cet article est inexistant dans la base, il va être créé';
            $objNvArticleEntity = $objArticlesTable->newEntity();
            $objNvArticleEntity->name = $tabPOST['name'];
            $objNvArticleEntity->slug = $tabPOST['slug'];
            $objArticlesTable->save($objNvArticleEntity);
            $message = "Article ajouté";
            $this->set('message', $message);
            $this->render('ajoute_un_article_success');
        }
    }
  }
  public function supprimeArticle3() {
    $objArticlesTable = $this->Articles;
    $objArticleEntity = $objArticlesTable->get(3);
    $objArticlesTable->delete($objArticleEntity);
    $message = "Article supprimé";
    $this->set('message', $message);
    $this->render('supprime_article_success');
  }
  public function supprimeUnArticle() {
    $id = $this->request->getQuery('id');
    $objArticlesTable = $this->Articles;
    $article = $this->Articles->findById($id);
    $objArticlesTable->delete($article);
    $message = "Article supprimé";
    $this->set('message', $message);
    $this->render('supprime_un_article_success');
}


}





 ?>
