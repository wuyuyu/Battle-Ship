battleship2

[========== Backlog ==========]
[>] Mise en place de l'environnement
- choix du langage parmi Python, PHP, Java et C
- creation d'un depot GIT
- creation du projet initial (programme en ligne de commande) qui affiche un message de bienvenue au lancement
[>] Plateau de jeu
- creation d'une fonction qui initialise un tableau 10x10 vide
- creation d'une fonction qui affiche le contenu du tableau sur la console (le type de valeur ainsi que les valeurs dans le tableau sont libres)
- le programme se lance et affiche le tableau initialisé
- le code doit etre archivé sous GIT (ou autre outil de gestion de configuration)
- tous les morceaux de code, ainsi que les commentaires doivent être en anglais
- une documentation des fonctions doit être fournie avec le code (cf. équivalent Java Doc mais sans formalisme particulier)
[>] Mise en place des bateaux
- creation d'une fonction qui rempli le tableau avec les différents bateaux positionnés aleatoirement (5 bateaux de longueurs 5, 4, 3, 3 et 2)
- a chaque lancement le programme affiche la nouvelle grille aléatoire de bateaux
- le code doit etre archivé sous GIT (ou autre outil de gestion de configuration)
- tous les morceaux de code, ainsi que les commentaires doivent être en anglais
- une documentation des fonctions doit être fournie avec le code (cf. équivalent Java Doc mais sans formalisme particulier)
[>] Jouer sur le plateau
- creation d'une fonction qui converti une position (ex 'C5') en index de tableaux (ex '2,4' pour 'ligne,colonne')
- creation d'une fonction qui demande à entrer une position sur le clavier, et récupère l'entrée du joueur. Si l'entrée est incorrecte, le programme redemande à nouveau d'entrer une position
- creation d'une fonction qui va "jouer" sur un plateau. elle prend en paramètre un index ligne, un index colonne et un tableau dans lequel jouer et retourne un booléen qui indique si le coup a touché ou non
  cette fonction va également afficher un message si le coup est touché, dans l'eau ou bien déjà touché précédemment
- le programme va demander en boucle de rentrer une position, puis jouer sur le plateau, et bien sur afficher le resultat
- le code doit etre archivé sous GIT (ou autre outil de gestion de configuration)
- tous les morceaux de code, ainsi que les commentaires doivent être en anglais
- une documentation des fonctions doit être fournie avec le code (cf. équivalent Java Doc mais sans formalisme particulier)
[>] Adversaire ordinateur
- création d'une fonction "IA" qui va jouer une position automatiquement (dans un premier temps, elle renvoie une position aléatoire)
- création d'une fonction qui fait joueur l'humain : demande la position et joue cette position sur le plateau de l'adversaire
- créer une fonction qui fait jouer le PC (l'ordi fournit une position et la joue sur le plateau de l'adversaire)
- le programme va maintenant créer 2 tableaux et faire jouer alternativement le joueur humain et l'ordinateur, et les faire rejouer quand un coup est touché au but
- le code doit etre archivé sous GIT (ou autre outil de gestion de configuration)
- tous les morceaux de code, ainsi que les commentaires doivent être en anglais
- une documentation des fonctions doit être fournie avec le code (cf. équivalent Java Doc mais sans formalisme particulier)
[>] Vérification de la condition de fin
- création d'une fonction qui va vérifier qu'un tableau a atteint la condition de fin (tous les bateaux détruits)
- le programme vérifie qu'un joueur a gagné entre chaque coup et affiche le message correspondant
- le programme demande si l'on veut refaire une partie ou bien quitter (et effectue l'action de l'utilisateur)
- le code doit etre archivé sous GIT (ou autre outil de gestion de configuration)
- tous les morceaux de code, ainsi que les commentaires doivent être en anglais
- une documentation des fonctions doit être fournie avec le code (cf. équivalent Java Doc mais sans formalisme particulier)
[>] Améliorations IA
- modification de la fonction qui créé les bateaux pour ne pas coller des bateaux les uns à coté des autres
- pour la fonction "IA" maintenant stockez l'historique pour ne pas rejouer là où vous avez déjà joué
- pour la fonction "IA" quand vous touchez un point, stockez cette position pour rejouer à coté pour les prochains tours (toujours en tenant compte de l'historique)
- le code doit etre archivé sous GIT (ou autre outil de gestion de configuration)
- tous les morceaux de code, ainsi que les commentaires doivent être en anglais
- une documentation des fonctions doit être fournie avec le code (cf. équivalent Java Doc mais sans formalisme particulier)
[========== Déroulé du sprint ==========]
- Chaque groupe choisira son langage pour ce sprint parmi ceux proposé
- chaque story doit respecter les critères d'acceptation avant de passer à la suivante, et ne doit pas apporter de régressions sur les précédentes
- la présentation du projet se fera le Jeudi 31/10 après midi