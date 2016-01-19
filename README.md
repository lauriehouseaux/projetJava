# A faire une seule fois :

### Sur Github :

	- fork le dépôt (bouton en haut à droite sur github)
		le dépôt est maintenant "copié" sur votre espace personnel

### en LOCAL (client git) :

	- recuperer le depot (git clone https://github.com/<< nom github >>/projetJava.git
		le dossier "projetJava" est maintenant créé, se déplacer dedans (cd projetJava)

	- configurer git remote pour pouvoir mettre à jour votre dépôt depuis celui-ci
		git remote add upstream https://github.com/AdrienJarretier/projetJava.git

# Avant de travailler (A chaque fois) :

### en LOCAL (client git) :

	- se rendre dans le dossier de travail ( cd .../projetJava )
	- mettre le dossier de travail à jour (git pull upstream master)
