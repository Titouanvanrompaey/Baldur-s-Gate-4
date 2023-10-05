package personnage

import item.Arme
import item.Armure
import item.Item
import java.nio.file.attribute.GroupPrincipal

class Personnage(
    val nom: String,
    var pointDeVie: Int,
    val pointDeVieMax: Int,
    var attaque: Int,
    var defense: Int,
    var endurance: Int,
    var vitesse: Int,
    var armePrincipal: Arme?=null


) {

val hero = Personnage("hero", 20, 40, 12, 8, 10, 7)
     fun calculeDefense():Int{
         //TODO Mission 4.2
        return this.defense/2;


     }


    // Méthode pour attaquer un adversaire
     fun attaque(adversaire: Personnage) {
        //TODO Mission 4.1
       var degats= this.attaque/2


         if (armePrincipal != null){
             degats= this.armePrincipal!!.calculDegat()


        }
         else{

             println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degats points de dégâts.")
         }
         var degats_infliges =degats-adversaire.calculeDefense()
        println("Les dégats infligés sont {$degats_infliges}")
         //

         if (degats<1)
        {
            degats=1
        }
        println("Les dégats infligés sont {$degats}")
         //

         println("Le nombre de dégats est ${degats}, affligé par ${this.nom} ")
         adversaire.pointDeVie-=degats

    }

    fun equipe(arme: Arme ) {

        this.armePrincipal = arme
        println("$nom equipe {$armePrincipal}")
    }

        return "$nom (PV: $pointDeVie/$pointDeVieMax, Attaque: $attaque, Défense: $defense, Endurance: $endurance, Vitesse: $vitesse)"
    }
}
