package item
import jeu.TirageDes
import personnage.Personnage

open class Item

class Bombe(
    val nombreDeDes: Int,
    var maxDe: Int,
    val nom: String,
    var description: String,
    val monstre: Personnage
) {
    fun utiliser(cible: Personnage) {
        // Création d'un objet TirageDes pour simuler un lancé de dés 3d8
        val des = TirageDes(this.nombreDeDes, this.maxDe)

        // Utilisation de la méthode lance() pour obtenir le résultat du lancé
        val resultat = des.lance()
        println("Résultat = $resultat")

        // Supposez que la classe Personnage ait des propriétés defense et pointDeVie
        // que vous pouvez utiliser ici
        val resultatFinal = resultat - this.monstre.defense
        val pointsDeVieRestants = this.monstre.pointDeVie - resultatFinal

        println("L'adversaire a $pointsDeVieRestants points de vie restants.")
    }
}

class Personnage {
    private val inventaire: MutableList<String> = mutableListOf()

    fun ajouterBombe(bombe: String) {
        inventaire.add(bombe)
    }

    fun avoirBombe(): Boolean {
        return inventaire.contains("bombe")
    }

    fun main() {
        val personnage = Personnage()
        personnage.ajouterBombe("bombe explosive")

        if (personnage.avoirBombe()) {
            println("Le personnage a au moins une bombe dans son inventaire.")
        } else {
            println("Le personnage n'a pas de bombe dans son inventaire.")
        }
    }
}
