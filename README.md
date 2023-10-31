# Projet informatique : Mon logigramme vectoriel

## Objectif du projet
Un logigramme est la représentation graphique ou picturale d'un algorithme à l'aide de différents symboles, formes et flèches pour démontrer un processus ou un programme. Avec les algorithmes, nous pouvons facilement comprendre un programme. L'objectif principal d'un logigramme est d'analyser différents processus. Plusieurs graphiques standards sont appliqués dans un logigramme. Le logigramme permet une lecture graphique et simplifiée d’un algorithme. L’objectif de ce projet est de tracer le logigramme d’un algorithme fourni en entrée au programme. Le logigramme devra être dessiné sous un format d’image vectorielle. Une image vectorielle est une image numérique composée de plusieurs objets géométriques individuels (droites, polygones, arcs de cercle). Dans ce projet nous essayerons de développer l’image avec un codage Tikz. Tikz est un langage destiné à la production de graphiques vectoriels. Le tout sera élaboré et visualisé à travers la plateforme Overleaf, outil en ligne permettant la rédaction et la compilation de documents Tikz.


## Travail demandé :
Le projet consiste à programmer cet outil de génération de logigramme en Java. Le programme prend en entrée un algorithme écrit sous format textuel. L’algorithme contiendra des instructions d’entrée sortie (Lire et Ecrire), des instructions d'affectation1 et des structures conditionnelles de type si...fin si.
Votre programme devra analyser l’algorithme et tracer le logigramme en mettant les structures conditionnelles et itératives dans des losanges et les autres instructions dans un rectangle en s’assurant du bon chaînage entre les formes géométriques. 

## Avancement du projet :
- Lecture d'un fichier txt ligne par ligne, puis conversion en un tableau de chaînes de caractères.
- Création d'un fichier txt de sortie, qui sera utilisé pour le code Tikz et régénéré à chaque exécution du code (pas de duplication).
- Création du début du code Tikz (formatage, couleurs et taille par défaut).
- Gestion de la structure conditionnelle "tantque".

## Sources du projet :
- Lire et écrire un fichier texte (.txt) ligne par ligne : https://www.youtube.com/watch?v=ScUJx4aWRi0
- Supprimer un fichier existant : https://docs.oracle.com/javase/tutorial/essential/io/delete.html
