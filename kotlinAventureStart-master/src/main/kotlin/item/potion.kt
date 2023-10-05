package item
import personnage.Personnage
import jeu.TirageDes
class Potion ( val nom: String,
               var soin: Int,
               val description: String,) {
    private val inventaire: MutableList<String> = mutableListOf()

    fun ajouterPotion(potion: String) {
        inventaire.add(potion)
    }

    fun avoirPotion(): Boolean {
        return inventaire.contains("potion")
    }

    fun main() {
        val personnage = Personnage()
        personnage.ajouterPotion(Personnage.Potion("Potion de guérison", 30))

        if (personnage.avoirPotion()) {
            println("Le personnage a au moins une potion dans son inventaire.") }
        else {
            println("Le personnage n'a pas de potion dans son inventaire.")
        }
    }
    class Personnage {
         val inventaire: MutableList<Potion> = mutableListOf()
         var pointsDeVie: Int = 100 // Points de vie initiaux du personnage
         val pointsDeVieMax: Int = 100 // Points de vie maximum du personnage

        data class Potion(val nom: String, val montantDeSoin: Int)

        fun ajouterPotion(potion: Potion) {
            inventaire.add(potion)
        }

        fun avoirPotion(): Boolean {
            return inventaire.isNotEmpty()
        }

        fun boirePotion() {
            if (avoirPotion()) {
                val potion = inventaire.first()
                val montantDeSoin = potion.montantDeSoin
                pointsDeVie += montantDeSoin

                if (pointsDeVie > pointsDeVieMax) {
                    pointsDeVie = pointsDeVieMax
                }

                println("Le personnage boit la potion ${potion.nom} et récupère $montantDeSoin points de vie.")
                inventaire.removeAt(0)
            } else {
                println("Le personnage n'a pas de potion dans son inventaire.")
            }
        }
    }

    fun main2() {
        val personnage = Personnage()
        personnage.ajouterPotion(Personnage.Potion("Potion de guérison", 30))
        personnage.boirePotion() // Le personnage boit la potion de guérison et récupère 30 points de vie.
        personnage.boirePotion() // Le personnage n'a pas de potion dans son inventaire.
    }

}
