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
           var grimoire:MutableList<Sort> = mutableListOf(),
           inventaire: MutableList<Item> = mutableListOf())
    :Personnage(nom, pointDeVie, pointDeVieMax, attaque, defense, endurance, vitesse, armePrincipal, armure, inventaire)
{
    fun afficherGrimoire() {
        var compteur=0
        println("Affichage du grimoire du mage $nom :")
        for (leSort in this.grimoire){
            println("$compteur => ${leSort.nom}")
            compteur+=1
        }
    }
    fun choisirEtLancerSort(adv:Personnage) {
        afficherGrimoire()
        do {


            println("Veuillez choisir un sort en entrant son numéro d'index :")
            val choixSort = readln().toInt()


            if (choixSort in 0 until grimoire.size) {
                val sortChoisi = grimoire[choixSort]
                println("Choisissez la cible du sort :")
                println("1 => Joueur")
                println("2 => Monstre")
                val choixCible = readln().toInt()
                if (choixCible == 1) {
                    println("$nom lance ${sortChoisi.nom} sur ${this.nom} !")
                    sortChoisi.effet(this, this)
                }
                else if (choixCible == 2) {
                    println("$nom lance ${sortChoisi.nom} sur ${adv.nom} !")
                    sortChoisi.effet(this, adv) // Lance l'effet du sort
                }
            } else {

                    println("Index de sort invalide. Veuillez choisir un sort valide.")
                    //rajouter le code du dessus pour qu'il puisse rechoisir un sort


            }
        }
        while (choixSort < 0 || choixSort > inventaire.size)
    }
}
