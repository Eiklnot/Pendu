# Jeu du Pendu

Le jeu du Pendu est un jeu dans lequel le joueur doit deviner un mot en proposant des lettres. Le jeu affiche un mot caché avec des tirets représentant chaque lettre du mot. Le joueur propose des lettres pour essayer de deviner le mot. À chaque proposition incorrecte, une nouvelle partie du dessin du pendu est affichée. Si le joueur devine le mot avant que le dessin du pendu soit complet, il gagne. Sinon, il perd.

## Fonctionnalités

- Lecture d'un fichier CSV contenant une liste de mots.
- Sélection aléatoire d'un mot à deviner à partir du fichier CSV.
- Affichage du mot caché avec des tirets.
- Saisie utilisateur des lettres proposées.
- Comparaison des lettres proposées avec les lettres du mot à deviner.
- Mise à jour du mot caché en remplaçant les tirets par les lettres correctement devinées.
- Affichage de différentes étapes du dessin du pendu en cas de proposition incorrecte.
- Gestion du nombre de vies restantes pour le joueur.
- Gestion de la fin de partie lorsque le joueur a deviné le mot ou a perdu toutes ses vies.
- Possibilité de rejouer une nouvelle partie.

## Prérequis

- Java 8 ou une version ultérieure

## Comment exécuter le jeu

1. Clonez le repository du projet.
2. Assurez-vous d'avoir Java installé sur votre système.
3. Compilez les fichiers source à l'aide de la commande suivante : 
"javac App.java CSVHandler.java Ascii.java NumLetters.java Game.java"
4. Exécutez le programme à l'aide de la commande suivante : "Java App"
5. Le menu du jeu sera affiché avec les options "1- play" et "2- quit".
6. Saisissez `1` pour commencer une partie ou `2` pour quitter le jeu.
7. Si vous choisissez de commencer une partie, le mot à deviner sera affiché sous forme de tirets. Saisissez une lettre à chaque tour pour essayer de deviner le mot.
8. Le dessin du pendu et le mot caché seront mis à jour en fonction de vos propositions.
9. Continuez à deviner jusqu'à ce que vous ayez deviné le mot ou que le dessin du pendu soit complet.
10. Une fois la partie terminée, vous serez informé si vous avez gagné ou perdu.
11. Vous aurez ensuite la possibilité de rejouer une nouvelle partie ou de quitter le jeu.

# Structure du code

Le code du jeu est divisé en plusieurs classes :

- `App.java` : Point d'entrée du programme. Il gère l'affichage du menu et l'initialisation du jeu.
- `CSVHandler.java` : Cette classe est responsable de la lecture du fichier CSV contenant les mots à deviner. Elle sélectionne un mot aléatoire à partir de la liste.
- `Ascii.java` : Cette classe contient une collection d'art ASCII représentant les différentes étapes du dessin du pendu. Elle renvoie l'art correspondant à un nombre d'étapes spécifié.
- `NumLetters.java` : Cette classe gère la conversion du mot aléatoire en tirets pour l'affichage du mot caché. Elle remplace chaque lettre par un tiret bas (_).
- `Game.java` : Cette classe est responsable de l'exécution du jeu. Elle gère la boucle principale du jeu, la saisie utilisateur, la comparaison des lettres proposées avec le mot à deviner, la mise à jour du mot caché et l'affichage du dessin du pendu. Elle gère également la fin de partie et la possibilité de rejouer une nouvelle partie.