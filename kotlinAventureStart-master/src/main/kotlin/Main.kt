import item.*
import jeu.Jeu
import personnage.Personnage
import jeu.TirageDes

//instanciation des qualités des objets
val qualiteCommun = Qualite("commun", 0, "\u001B[32m")
val qualiteRare = Qualite("rare", 1, couleur = "\u001B[34m")
val qualiteEpic = Qualite("epic", 2, "\u001B[35m")
val qualiteLegendaire = Qualite("legendaire", 3, "\u001B[33m")
 val sortDeSoin =   Sort("Sort de Soin", { caster, cible->
         run {
             val tirageDes = TirageDes(nbDe = 1, maxDe = 6)
             var soin = tirageDes.lance()
             soin = maxOf(a = 1, b = soin + 80)
             cible.pointDeVie+=soin
             println("Le sort de soin a soigné ${cible.nom} de $soin points de vie.")
         }
     }
 )
val typeEpeeLongue= TypeArme("Epée longue", 2, 10, 60, 5 )
val typeArmureCuir= TypeArmure("Armure en cuir", 3)
val armeMagique= Sort("arme magique", { caster, cible ->
    run {
        val tirageDes=TirageDes(nbDe = 1, maxDe = 20)
        var resultat=tirageDes.lance()
        var qualite=qualiteCommun
        if (resultat<5)
            qualite=qualiteCommun
        else if (resultat<10)
            qualite=qualiteRare
        else if (resultat<15)
            qualite=qualiteEpic
        else
            qualite=qualiteLegendaire
        var arme= Arme("armeMagique", typeEpeeLongue, qualite ,"une arme magique" )
        cible.inventaire.add(arme)
        println("Une arme magique a été ajoutée à l'inventaire.")
        cible.armePrincipal=arme
    }
})
val armureMagique= Sort("armure magique", { caster, cible ->
    run {
        val tirageDes = TirageDes(nbDe = 1, maxDe = 20)
        var resultat = tirageDes.lance()
        var qualite = qualiteCommun
        if (resultat < 5)
            qualite = qualiteCommun
        else if (resultat < 10)
            qualite = qualiteRare
        else if (resultat < 15)
            qualite = qualiteEpic
        else
            qualite = qualiteLegendaire
        var armure = Armure("armure en cuir", "une armure bien sérrée", typeArmureCuir, qualite)
        cible.inventaire.add(armure)
        println("Une armure magique a été ajoutée à l'inventaire.")
        cible.armure = armure
    }
}
)

fun monstres(args: Array<String>) {
    //Instantiation des monstres
    // TODO Intermission 1 Ajouter d'autres monstres
    //On ajoute les monstres a la liste de monstres du jeu
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

    val jeu = Jeu(listOf( gobelin, Basilic, Minotor_squelette, Yeenoghu))
    //Lancement du jeu
    jeu.lancerCombat()
}
