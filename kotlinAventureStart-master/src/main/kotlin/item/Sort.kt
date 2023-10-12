package item;
import personnage.Mage
import personnage.Personnage
import jeu.Combat
open class Sort(val nom: String,val effet :(Personnage,Personnage)->Unit, val puissance: Int, val coutMana: Int, val description: String) {
    override fun toString(): String {
        return "$nom (Puissance: $puissance, Coût en mana: $coutMana)"
    }

}



