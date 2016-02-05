Git est une base de paires clés/valeurs :
	- A n'importe quelle sorte de données sera associé une clé 
	- pour visualiser ce principe : hash-object

Les sous répértoires sont nommés d'après les 2 premiers caractères de l'empreinte et le fichier d'après les 38 autres caractères :
	- pour visiualiser : cat-file

Git stocke tout sous forme d'arbre ou de blob : 
	- Arbre => répértoire UNIX (contient des blobs)
	- Blob => i-noeud ou contenu d'un fichier
Les objects sont compressés avec zlib.

Pour chaque fichier suivi, Git enregistre des informations telles que sa taille, date de création et date de dernière modification d'un fichier appelé l'indice.

Chaque version de données sont conservées dans la base de donnée de l'objet, qui vit dans le sous-répertoire : git/objects.

Il y a 4 types d'objets qui nous interessent : 
	- Le blob
	- l'arbre
	- le commit
	- le tag



I. BLOB 
Git est adressable par le contenu: les fichiers ne sont pas stockés en fonction de leur nom, mais plutôt par le hachage des données qu'ils contiennent, dans un fichier que nous appelons un objet blob. 
Les fichiers dans .git/objects sont compressées avec zlib de sorte que vous ne devez pas regarder directement. 



II. ARBRE
L'objet tree (mot anglais signifiant « arbre »), qui est une liste d'objets de type blobs et des informations associées à chaque blob, tel que le nom du fichier et les permissions. Cet objet décrit l'arborescence des sources à un instant donné.



III. COMMIT 
L'objet commit, résultant de l'opération du même nom (de l'anglais, « commettre », « perpétrer », « s'engager », « décider », ici dans le sens de « confirmer », « valider ») et, qui donne accès à l'historique d'une arborescence de source. Il contient un message de log, un objet arbre et pointe vers un ou plusieurs objets commit parents.



IV. TAG
L'objet tag (étiquette) qui est une manière de représenter un commit spécifique. Il est en général utilisé pour marquer certains commits, par exemple par un numéro ou un nom de version (2.1 ou bien Hardy Heron). 



V. STOCKAGE DES DOSSIERS
Git ne comporte qu'un seul dossier appelé ".git" à la racine de votre projet : ce dernier contient tout l'historique du projet.

C'est dans le répertoire objects/ que sont stockés tous les objets Git (commits, tags, trees, blobs).
Rappel : c'est la compression "Zlib" qu'utilise Git pour compresser les données et conserver un poids correct. 




