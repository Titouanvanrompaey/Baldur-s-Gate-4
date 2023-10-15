package item

import Item
import jeu.TirageDes
import personnage.Personnage

class Arme(nom: String, val type: TypeArme, val qualite: Qualite, description: String):Item(nom, description) {


    fun calculDegat(): Int {
        var desDegats = TirageDes(this.type.nombreDes, 8).lance()
        val deCritique = TirageDes(1, 20).lance()
        if (deCritique >= this.type.activationCritique) {
            // desDegats * this.type.multiplicateurCritique +   this.qualite.bonusRarete

            desDegats *= this.type.multiplicateurCritique
            println("Coup critique")


        }

            desDegats+= this.qualite.bonusRarete

        return desDegats
    }


    override fun utiliser(cible: Personnage) {

    }


}