import item.Qualite
import jeu.Jeu
import personnage.Personnage

//instanciation des qualités des objets
val qualiteCommun = Qualite("commun", 0, "\u001B[32m")
val qualiteRare = Qualite("rare", 1, couleur = "\u001B[34m")
val qualiteEpic = Qualite("epic", 2, "\u001B[35m")
val qualiteLegendaire = Qualite("legendaire", 3, "\u001B[33m")
val sortDeSoin = object : Sort("Sort de Soin", 80) {
    override fun effet(caster: Personnage, cible: Personnage) {
        val tirageDes = TirageDes(nbDe = 1, maxDe = 6)
        var soin = tirageDes.lance()
        soin = maxOf(a = 1, b = soin + 80)
        cible.pointDeVie(soin)
        println("Le sort de soin a soigné ${cible.nom} de $soin points de vie.")
    }
}
val armeMagique = object : Arme("Épée Magique", 50) {
    override fun attaquer(cible: Personnage) {
        val degats = this.puissance - cible.defense
        if (degats > 0) {
            cible.recevoirDegats(degats)
            println("${this.nom} inflige $degats points de dégâts à ${cible.nom} !")
        } else {
            println("${this.nom} est inefficace contre ${cible.nom} à cause de sa défense élevée !")
        }
    }
}
val armureMagique = object : Armure("Armure Magique", 30) {
    override fun encaisserDegats(degats: Int) {
        val degatsReduits = maxOf(1, degats - this.defense)
        println("${this.nom} absorbe $degatsReduits points de dégâts !")
    }
}

fun monstres(args: Array<String>) {
    //Instantiation des monstres
    val gobelin = Personnage(
        "Damien",
        pointDeVie = 40,
        pointDeVieMax = 40,
        attaque = 10,
        defense = 4,
        vitesse = 11,
        endurance = 6)

    val Basilic = Personnage(
        "Heboros",
        pointDeVie = 100,
        pointDeVieMax = 100,
        attaque = 30,
        defense = 15,
        vitesse = 6,
        endurance = 8)

    val Minotor_squelette = Personnage(
        "vasar",
        pointDeVie = 120,
        pointDeVieMax = 120,
        attaque = 40 ,
        defense = 12,
        vitesse = 12,
        endurance = 9)

    val Yeenoghu = Personnage(
        "bald",
        pointDeVie = 600,
        pointDeVieMax = 600,
        attaque = 60 ,
        defense = 23,
        vitesse = 15,
        endurance = 9)
    // TODO Intermission 1 Ajouter d'autres monstres
    //On ajoute les monstres a la liste de monstres du jeu
    val jeu = Jeu(listOf( gobelin, Basilic, Minotor_squelette, Yeenoghu))
    //Lancement du jeu
    jeu.lancerCombat()
}
