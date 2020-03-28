Pour compiler et lancer le JEU
En etant dans le dossier (ex: ~/Documents/Captain_Sonar/Captain_sonar)
La où se trouve ce fichier taper les commandes suivantes :

javac -d bin/ src/autrevent/* src/Captain_sonar/* src/Captain_sonar_modele/* src/Captain_sonar_salon/*

cd bin

java Captain_sonar_salon.GUI


--------------------------------------

Pour tester les autres Vues
dans le fichier /src/Captain_sonar_salon.java
modifier le parametre de la ligne 34 : (Entre 0 et 3,Capitaine Second Mecano Detecteur)

	vg.changementDeVue(2);
