/* TP4 de FrontEnd - Tom REDON - Groupe 2 */
/* tom.redon@edu.univ-eiffel.fr */

En premier lieu, je me suis occupé de lancer le serveur comme demandé, via le serveur de test
donné. Pour cela, j'ai suivi toutes les instructions données. 
J'avais oublié d'utiliser la commande adb reverse tcp:2021 tcp:2021 et c'est l'unique "problème"
que j'ai rencontré.

J'ai ensuite inclu les permissions préliminaires dans le fichier gradle.

Ensuite, je me suis occupé de réaliser le layout demandé, en suivant les indications communiquées.

J'ai par la suite créé la classe Message que l'on nous demandait de créer.

J'ai ensuite programmé les fonctions demandées pour avoir les actions disponibles dans l'application.

Enfin, j'ai utilisé un recycler view, et cela a été sûrement la partie de TP la plus
complexe que j'ai eu à réaliser.
J'ai donc implanté un adapter et un viewHolder. J'ai implanté toutes les fonctions 
nécessaires à leur fonctionnement et cela a finalement marché.
Le plus gros problème de cette partie était plus de comprendre la mise en pratique
de la théorie qu'autre chose.

Enfin, en suivant les consignes j'ai implanté la communication avec le serveur en
se servant du protocole websocket.
J'ai ajouté les dépendances demandées dans le fichier gradle et la fonction 
startWatching comme énoncé.
J'ai donc créé la classe MessageListener comme demandé.

J'ai implémenté la réception et l'envoi de message. Je me suis servi des 
consignes données, mais j'ai du chercher la façon de gérer les Gson avec Java car
je n'ai pas programmé en Kotlin.
J'ai ensuite fait en sorte que le programme envoie le bon message à la connexion du
client (@@@hello:N@@@).
Puis j'ai programmé les envois de message en suivant les instructions données.

Enfin, j'ai implanté le démarrage et l'arrêt de la connexion avec le serveur, ainsi que
la géolocalisation automatique, encore une fois, en suivant les instructions demandées.
J'ai réussi à trouver dans la documentation la façon de demander les bonnes permissions à 
l'utilisateur et cela m'a permis de réaliser la dernière partie sans grande difficulté.
Je n'ai pas rencontré de problème pour cette étape.

J'ai donc essayé de réaliser les énoncés demandés pour répondre aux consignes du TP.
