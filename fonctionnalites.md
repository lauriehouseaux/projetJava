# Projet JAVA
### Cahier des charges

## Fonctionnalités recherchées :

- visualisation brute des fichiers git
  - ( en particulier .git/objects )

- affichage de l'ensemble des clés de hachage

- navigation entre les fichiers et affichage du contenu
( voir [git cat-file](https://git-scm.com/docs/git-cat-file) )

- pas un outil d'historique ou de diff




## Dossiers  .git de base :

1. ) dossier branches :
  - ce dossier n'est pas utilisé par les versions récentes de git
  - (nous allons donc l'ignorer)

2. ) fichier config :
  - contient les options de configuration spécifiques au projet git.

3. ) fichier description :
  - utilisé par GitWeb
  - (nous ignorerons ce fichier)

4. ) fichier HEAD :
  * ce fichier pointe sur la branche qui est couramment checked out (sur laquelle on travaille)

5. ) dossier hooks :
  - contains your client- or server-side hook scripts
  - ces scripts sont exécutés lorsques certaines actions importantes se produisent
  - (commit, merge, push, …)
  - (ce dossier sera ignoré)

6. ) dossier info :
  - contient un fichier « exclude » global pour les fichiers qu'on ne veut pas suivre dans un .gitignore

7. ) dossier objects :
  - Tout le contenu des données est présent ici
  - (**Notre dossier principal**)
  - commandes pour test :
    - echo 'test content' | git [hash-object](https://git-scm.com/docs/git-hash-object) -w --stdin
      - (stocke un fichier contenant le texte 'test content' et renvoie la clé de hachege)
  - dossier info :
    -
  - dossier pack :
    -



8. ) dossier refs :
  - pointeurs vers des objets commit

9. ) fichier index :
  - informations de staging (git add …. )
