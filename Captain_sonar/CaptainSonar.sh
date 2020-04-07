#!/bin/bash

javac -d bin/ src/autrevent/*.java src/Captain_sonar/*.java src/Captain_sonar_modele/*.java src/Captain_sonar_salon/*.java || exit 1

cd bin

for i in `seq 1 8`;
do
	java Captain_sonar_salon.GUI &
done
