# Projet informatique : Mon logigramme vectoriel

## Objectif du projet
Un logigramme est la représentation graphique ou picturale d'un algorithme à l'aide de différents symboles, formes et flèches pour démontrer un processus ou un programme. Avec les algorithmes, nous pouvons facilement comprendre un programme. L'objectif principal d'un logigramme est d'analyser différents processus. Plusieurs graphiques standards sont appliqués dans un logigramme. Le logigramme permet une lecture graphique et simplifiée d’un algorithme. L’objectif de ce projet est de tracer le logigramme d’un algorithme fourni en entrée au programme. Le logigramme devra être dessiné sous un format d’image vectorielle. Une image vectorielle est une image numérique composée de plusieurs objets géométriques individuels (droites, polygones, arcs de cercle). Dans ce projet nous essayerons de développer l’image avec un codage Tikz. Tikz est un langage destiné à la production de graphiques vectoriels. Le tout sera élaboré et visualisé à travers la plateforme Overleaf, outil en ligne permettant la rédaction et la compilation de documents Tikz.


## Travail demandé :
Le projet consiste à programmer cet outil de génération de logigramme en Java. Le programme prend en entrée un algorithme écrit sous format textuel. L’algorithme contiendra des instructions d’entrée sortie (Lire et Ecrire), des instructions d'affectation1 et des structures conditionnelles de type si...fin si.
Votre programme devra analyser l’algorithme et tracer le logigramme en mettant les structures conditionnelles et itératives dans des losanges et les autres instructions dans un rectangle en s’assurant du bon chaînage entre les formes géométriques. 

## Répartition du projet :
- Victor : fonctions (selon, si/sinon)
- Aurélien : flèches
- Luc : sélecteur de couleur (et interface)

- Si temps restant : téléchargement du visuel en PDF automatiquement

## Avancement du projet :
#### Version V1.0 (30/10/2023) :
- Lecture d'un fichier txt ligne par ligne, puis conversion en un tableau de chaînes de caractères.
- Création d'un fichier txt de sortie, qui sera utilisé pour le code Tikz et régénéré à chaque exécution du code (pas de duplication).
- Création du début du code Tikz (formatage, couleurs et taille par défaut).
- Gestion de la structure conditionnelle "tantque".

#### Version V1.1 (31/10/2023) :
- Gestion de toutes les opérations,  variables et structures conditionnelles dans le code Tikz en sortie.
- Affichage de tous les noeuds sur le logigramme visuel Overleaf. Pour le moment, sans flèches ou liens visuels.

#### Version V1.2 (20/11/2023) :
- Demande à l'utilisateur le nom du fichier texte à convertir en logigramme (obsolète depuis version V1.3).

#### Version V1.3 (30/11/2023) :
- Conversion des parties du code en fonction JAVA.
- Création d'une interface pour sélectionner manuellement le fichier source texte.
- Ouverture automatique du code Tikz généré.

#### Version V1.4 (15/12/2023) :
- Création d'un sélecteur de couleur pour choisir les couleurs pour le carré et losange.
- Implémentation de ces couleurs dans le code Tikz.

#### Version V1.5 (17/12/2023) :
- Création des flèches entre les blocs d'intructions
- Début de création des flèches contourant depuis le "tantque"

#### Version V1.6 (19/12/2023) :
- Flèches fonctionnelles pour le "tantque"

#### Version V1.6 (19/12/2023) :
- insérer le "non" à côté de la flèche du "tantque"

#### Version V1.7 (21/12/2023) :
- début du "si-sinon"

#### Version V1.8 (23/12/2023) :
- "si-sinon" presque fonctionnel
- début de : possibilité de différentes structures conditionnelles

#### Version V1.9 (27/12/2023) :
- "si-sinon" fonctionnel (normalement)
- début de : possibilité de différentes structures conditionnelles
- amélioration du "si" et "tantque" : possible de mettre autant d'instructions que l'on veut pour chaque (aussi bien avant, dedans ou après la condition)
  -> a améliorer : pas encore top de combiner "si" et "tantque"
  
## Sources du projet :
- Lire et écrire un fichier texte (.txt) ligne par ligne : https://www.youtube.com/watch?v=ScUJx4aWRi0
- Supprimer un fichier existant : https://docs.oracle.com/javase/tutorial/essential/io/delete.html
- Fonction qui retourne un tableau : https://openclassrooms.com/forum/sujet/fonction-return-un-tableau-36255
