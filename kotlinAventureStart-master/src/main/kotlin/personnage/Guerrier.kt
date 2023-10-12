package personnage

import item.Arme
import item.Armure


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


   override fun equipe(uneArme:Arme)
   {
println("Choisissez où vous voulez placer l'arme:")
       var choix = readln().toInt()
       var a = when(choix){
            1 -> {
                armePrincipal?.let { super.equipe(it) }
            }
            2 -> {
                if (uneArme in this.inventaire) {
                    this.armeSecondaire=uneArme
                } else {
                    println("Erreur de saisie")
                }
            }


           else -> {
              "Erreur de saisie"

          }


      }

//      fun attaque(adversaire: Personnage)
//       {
//          var degats = this.attaque / 2
//           fun totaDefense()
//           {
//               var degatot : Int
//               if (armeSecondaire != null)
//               {
//              degatot = this.attaque - this.defense
//               }
//               else{
//                   degatot =this.attaque - this.defense
//               }
//               if (degatot > 1)
//               {
//                   adversaire.pointDeVie -= degatot
//                   println("Les dégats infligés sont {$degatot}")
//               }
//               else{
//                   degatot = 1
//               }
      }


       }





