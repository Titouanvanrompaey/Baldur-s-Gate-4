package personnage

import item.Arme
import item.Armure
import Item
import personnage.Personnage
class Voleur(nom: String,
             pointDeVie: Int,
             pointDeVieMax: Int,
             attaque: Int,
             defense: Int,
             endurance: Int? = null,
             vitesse: Int,
             armePrincipal: Arme? = null,
             armure: Armure? = null,
             inventaire: MutableList<Item> = mutableListOf())
    :Personnage(nom, pointDeVie, pointDeVieMax, attaque, defense, endurance, vitesse, armePrincipal, armure, inventaire) {
        fun voler(cible: Personnage){
            if (cible.inventaire.isEmpty())
                println("L'inventaire de ${cible.nom} est vide. Vous n'avez rien pu voler")
            else{
                val objetVole=(0 until cible.inventaire.size).random()
                val objet=cible.inventaire[objetVole]
                if (cible.armePrincipal==objet){
                    cible.armePrincipal=null
                }
                else if (cible.armure==objet){
                    cible.armure=null
                }
                this.inventaire.add(objet)
                cible.inventaire.remove(objet)
                println("Vous avez réussi à voler $objet à ${cible.nom}")
            }
        }
}
