package personnage

import item.Arme
import item.Armure

// Création de la class "Guerrier"
class Guerrier(
    nom: String,
    pointDeVie: Int,
    pointDeVieMax: Int,
    attaque: Int,
    defense: Int,
    endurance: Int,
    vitesse: Int,
    armePrincipal: Arme?=null,
    var armeSecondaire: Arme?=null,
    inventaire: Armure?=null)
    :Personnage(nom, pointDeVie, pointDeVieMax,attaque,defense, endurance, vitesse, armePrincipal, inventaire) {

    //méthode equipe

    override fun equipe(arme: Arme) {
        println("Choisissez où vous voulez placer l'arme:")
        // méthode attaque
        fun attaque(adversaire: Personnage) {
            val bonusattaque = this.attaque / 2
                super.attaque(adversaire)
                var degatot: Int
                if (armeSecondaire != null) {
                    degatot = armeSecondaire!!.calculDegat() + bonusattaque - adversaire.calculeTotalDefense()
                } else {
                    degatot = bonusattaque- adversaire.calculeTotalDefense()
                }
                if (degatot > 1) {
                    adversaire.pointDeVie -= degatot
                    println("Les dégats infligés sont {$degatot}")
                } else {
                    degatot = 1
                    adversaire.pointDeVie -= degatot
                    println("Les dégats infligés sont {$degatot}")
                }
            }
        
    }
}











