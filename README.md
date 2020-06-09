# Mini-Projet POO: Initiation à la cryptographie en Java

Ce mini projet POO se compose de deux parties :

**Partie 1 :**
Implémentation et utilisation d'un protocole de chiffrement simple d’un texte. Il consiste à modifier un caractère donné par un autre. On appelle clé tout couple (car1,car2) où car2 est le caractère substituant et car1 le caractère substitué. Par exemple, si clé=(‘O’, ‘Z’), on remplace O par Z dans le mot à crypter. Ainsi, dans cet exemple, le mot « BONJOUR » est chiffré en « BZNJZUR ». Pour déchiffrer le texte, il suffit d’effectuer la substitution dans le sens inverse (dans l’exemple, on remplace Z par O).

**Partie 2 :**
Une méthode de chiffrement plus robuste basée sur AES – Advanced Encryption Standard qui est un algorithme de chiffrement symétrique. 
AES peut utiliser des longueurs de clés différentes 128-, 192- and 256-bits selon le niveau de sécurité désiré. 
