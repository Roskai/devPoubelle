<?php $this->assign('MonTitre','Liste des articles'); ?>

<table>
    <tr>
        <th>Nom</th>
        <th>Date de création</th>
    </tr>
    <?php foreach ($articles as $article): ?>
        <tr>
            <td><?= h($article->name) ?></td>
            <td><?= h($article->created) ?></td>
        </tr>
    <?php endforeach; ?>
</table>
