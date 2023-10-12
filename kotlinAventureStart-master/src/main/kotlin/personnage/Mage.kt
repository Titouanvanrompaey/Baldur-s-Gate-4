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
    {
        fun afficherGrimoire() {
            println("Affichage du grimoire du mage $nom :")
            inventaire.filterIsInstance<Sort>().forEachIndexed { index, sort ->
                println("${index + 1}. ${sort.nom} - Puissance : ${sort.puissance}, Coût en mana : ${sort.coutMana}")
            }
        }
        fun choisirEtLancerSort() {
            afficherGrimoire()
            println("Veuillez choisir un sort en entrant son numéro d'index :")
            val choixSort = readLine()?.toIntOrNull()

            if (choixSort != null && choixSort in 0 until inventaire.size) {
                val sortChoisi = inventaire[choixSort] as? Sort

                if (sortChoisi != null) {
                    println("Choisissez la cible du sort :")
                    println("1 => Joueur")
                    println("2 => Monstre")
                    val choixCible = readLine()?.toIntOrNull()

                    if (choixCible != null && (choixCible == 1 || choixCible == 2)) {
                        val cible = if (choixCible == 1) {
                            this
                        } else {
                            // Remplacez Monstre par la classe de votre monstre si nécessaire
                            Monstre()
                        }

                        println("$nom lance ${sortChoisi.nom} sur ${cible.nom} !")
                        sortChoisi.effet(this, cible) // Lance l'effet du sort
                    } else {
                        println("Choix de cible invalide. Veuillez choisir une cible valide.")
                    }
                } else {
                    println("Cet objet n'est pas un sort. Veuillez choisir un sort valide.")
                }
            } else {
                println("Index de sort invalide. Veuillez choisir un sort valide.")
            }
        }
    }
