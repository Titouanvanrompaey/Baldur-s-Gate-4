package item;

import personnage.Personnage

class Armure (nom:String, description:String, val type:TypeArmure, val qualite: Qualite):Item(nom,description){
    fun calculProtection(): Int {
        val bonusProtection=this.type.bonusType+this.qualite.bonusRarete
        return bonusProtection
    }
    override fun utiliser(cible: Personnage) {

    }
}
