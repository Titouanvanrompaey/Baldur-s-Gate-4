package personnage;
import item.Arme
import item.Armure
import item.Sort
import Item
import personnage.Personnage
class Mage(nom: String,
             pointDeVie: Int,
             pointDeVieMax: Int,
             attaque: Int,
             defense: Int,
             endurance: Int? = null,
             vitesse: Int,
             armePrincipal: Arme? = null,
             armure: Armure? = null,
             inventaire: MutableList<Item> = mutableListOf())
    :Personnage(nom, pointDeVie, pointDeVieMax, attaque, defense, endurance, vitesse, armePrincipal, armure, inventaire)
    :Sort(coutMana, degats)
    fun lancerSort(sort: Sort, cible: Personnage) {
       if (pointsDeMana >= sort.coutMana) {
           println("$nom lance ${sort.nom} sur ${cible.nom}.")
           pointsDeMana -= sort.coutMana
           sort.lancerEffet(cible)
       } else {
           println("$nom n'a pas assez de mana pour lancer ${sort.nom}.")
        }
}
