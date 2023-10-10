package item;

import personnage.Mage
import personnage.Personnage
open class Sort(val nom: String, val coutMana: Int, val degats: Int) {
    // Méthode pour lancer l'effet du sort sur une cible
    fun lancerEffet(cible: Personnage) {
        cible.pointsDeVie -= degats
        println("${cible.nom} subit $degats points de dégâts.")
    }
}
