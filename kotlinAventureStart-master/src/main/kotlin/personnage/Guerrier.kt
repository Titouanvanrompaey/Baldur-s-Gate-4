package personnage

import item.Arme
import item.Armure

// Création de la class "Guerrier"
class Guerrier(
    var armeSecondaire: Arme?,
    nom: String,
    description: String,
    pointDeVie: Int,
    pointDeVieMax: Int,
    attaque: Int,
    defense: Int,
    endurance: Int,
    vitesse: Int,
    armePrincipal: Arme?,
    inventaire: Armure?,
) : Personnage(nom, pointDeVie, pointDeVieMax,attaque,defense, endurance, vitesse, armePrincipal, inventaire) {

    //méthode equipe

    override fun equipe(uneArme: Arme) {
        println("Choisissez où vous voulez placer l'arme:")
        var choix = readln().toInt()
        var a = when (choix) {
            1 -> {
                armePrincipal?.let { super.equipe(it) }
            }

            2 -> {
                if (uneArme in this.inventaire) {
                    this.armeSecondaire = uneArme
                } else {
                    println("Erreur de saisie")
                }
            }


            else -> {
                "Erreur de saisie"

            }


        }

        // méthode attaque
        fun attaque(adversaire: Personnage) {
            var bonusattaque = this.attaque / 2
                super.attaque(adversaire)
                var degatot: Int
                if (armeSecondaire != null) {
                    degatot = armeSecondaire!!.calculDegat() + bonusattaque - adversaire.calculeDefense()
                } else {
                    degatot = bonusattaque- adversaire.calculeDefense()
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











