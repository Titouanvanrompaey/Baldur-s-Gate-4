package jeu

import personnage.Personnage


class Bombe ( val nombreDeDes: Int,
              var maxDe: Int,
              val nom: String,
              var description: String,
              val personnage: Personnage) {
    fun utiliser(cible: Personnage){
        // Création d'un objet TirageDes pour simuler un lancé de dés 3d8
        val des = TirageDes(this.nombreDeDes, this.maxDe)

        // Utilisation de la méthode lance() pour obtenir le résultat du lancé
        var resultat = TirageDes(3, 8).lance()
            println(" result = $resultat")
        var resulat = resultat - this.personnage.defense
        var pointDeVie = this.personnage.pointDeVie - resultat
            println("l'adversaire a " +pointDeVie +"restant")
    }
}
