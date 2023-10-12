package jeu

import personnage.Guerrier
import personnage.Mage
import personnage.Personnage
import personnage.Voleur


class Jeu(monstres: List<Personnage>) {
    lateinit var joueur: Personnage
    var combats: MutableList<Combat> = mutableListOf()
    var score: Int = 0

    // Corps du constructeur
    init {
        // Lancement de la création du personage du joueur
        this.creerPersonnage()
        // Pour chaque monstre dans la liste de monstres
        for (unMonstre in monstres) {
            // On créer un combat
            val unCombat = Combat(this, unMonstre)
            combats.add(unCombat)
        }
    }

    fun lancerCombat() {
        for (unCombat in this.combats) {
            unCombat.executerCombat()
            // Mettre à jour le score en fonction du nombre de tours
            val tours = unCombat.nombreTours
            score += calculerScore(tours)
        }
        println("Score final du joueur: $score")
    }

    private fun calculerScore(tours: Int): Int {
        // Par exemple, vous pouvez attribuer plus de points pour moins de tours
        return 500 - tours * 10
    }

    /**
     *  Méthode pour créer le personnage du joueur en demandant les informations à l'utilisateur
     *
     */
    fun creerPersonnage(): Personnage {
        println("Création votre personnage:")
        // TODO Mission 1.1
        //val hero = Personnage("", 0, 0, 0, 0, 0, 0)

        println("Saisir le nom du personnage")
        var nomPerso = readln().toString()
        println("Choisir la classe que $nomPerso doit avoir. Entrez le nombre correspondant")
        println("1. Guerrier")
        println("2. Mage")
        println("3. Voleur")
        var choixClasse= readln().toInt()
        var pointsARepartir=40
        println("Saisir le score de l'attaque il reste $pointsARepartir points à répartir parmi l'attaque, la défense, l'endurance, et la vitesse.")
        var scoreAtq = readln().toInt()
        pointsARepartir-=scoreAtq
        println("Saisir le score de défense il reste $pointsARepartir points à répartir parmi la défense, l'endurance, et la vitesse.")
        var scoreDef = readln().toInt()
        pointsARepartir-=scoreDef
        println("Saisir le score d'endurance il reste $pointsARepartir points à répartir parmi l'endurance, et la vitesse.")
        var scoreEnd = readln().toInt()
        pointsARepartir-=scoreEnd
        println("Saisir le score de vitesse il reste $pointsARepartir points maximum à attribuer dans la vitesse.")
        var scoreVit = readln().toInt()
        var pointDeVieMax =50+ (scoreEnd * 10)

        while (scoreAtq+ scoreDef + scoreEnd + scoreVit > 40) {
            println("Erreur vous avez mis plus de point qu'autorisé")
            println("Saisir le nom du personnage")
            nomPerso = readln().toString()
            println("Choisir la classe que $nomPerso doit avoir. Entrez le nombre correspondant")
            println("1. Guerrier")
            println("2. Mage")
            println("3. Voleur")
            choixClasse= readln().toInt()
            pointsARepartir=40
            println("Saisir le score de l'attaque il reste $pointsARepartir points à répartir parmi l'attaque, la défense, l'endurance, et la vitesse.")
            scoreAtq = readln().toInt()
            pointsARepartir-=scoreAtq
            println("Saisir le score de défense il reste $pointsARepartir points à répartir parmi la défense, l'endurance, et la vitesse.")
            scoreDef = readln().toInt()
            pointsARepartir-=scoreDef
            println("Saisir le score d'endurance il reste $pointsARepartir points à répartir parmi l'endurance, et la vitesse.")
            scoreEnd = readln().toInt()
            pointsARepartir-=scoreEnd
            println("Saisir le score de vitesse il reste $pointsARepartir points maximum à attribuer dans la vitesse.")
            scoreVit = readln().toInt()
            pointDeVieMax = 50+ (scoreEnd * 10)
            }
   var heros :Personnage
   if (choixClasse==1)
       heros=Guerrier(nomPerso, pointDeVieMax, pointDeVieMax, scoreAtq, scoreDef, scoreEnd, scoreVit)
   else if (choixClasse==2)
       heros=Mage(nomPerso, pointDeVieMax, pointDeVieMax, scoreAtq, scoreDef, scoreEnd, scoreVit)
   else
       heros= Voleur(nomPerso, pointDeVieMax, pointDeVieMax, scoreAtq, scoreDef, scoreEnd, scoreVit)
   println(heros)
   this.joueur = heros
   return heros
    }



    }

    


