package item;
import personnage.Personnage

open class Sort(
    val nom: String,
    val effet: (Personnage,Personnage) -> Unit, val puissance: Int=0, val coutMana: Int=0, val description: String="") {
    override fun toString(): String {
        return "$nom (Puissance: $puissance, Coût en mana: $coutMana)"
    }

}
