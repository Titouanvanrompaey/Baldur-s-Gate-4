package jeu

import personnage.Mage
import personnage.Personnage
import personnage.Voleur

class Combat(
    val jeu :Jeu,
    val monstre: Personnage
) {
    var nombreTours: Int = 1

    // Méthode pour simuler un tour de combat du joueur
    fun tourDeJoueur() {
        println("\u001B[34m ---Tour de ${this.jeu.joueur.nom} (pv: ${this.jeu.joueur.pointDeVie}) ---")
       //TODO Mission 1.2
        println("Qu'allez vous faire ?")
        println("1. Attaquer")
        println("2. Boire une potion")
        println("3. lancer un sort")
        println("4. Voler")
        println("5. Passer votre tour")
        var choixOption = readln()
        while (choixOption!="1" && choixOption!="2" && choixOption!="3" && choixOption!="4" && choixOption!="5"){
            println("Qu'allez vous faire ?")
            println("1. Attaquer")
            println("2. Boire une potion")
            println("3. Lancer un sort")
            println("4. Voler")
            println("5. Passer votre tour")
            choixOption = readln()
        }
        when (choixOption) {
            "1" -> {
                this.jeu.joueur.attaque(monstre)
            }
            "2" -> {
                this.jeu.joueur.boirePotion()
            }
            "3" -> {
                val mage=this.jeu.joueur as Mage
                mage.choisirEtLancerSort(monstre)
            }
            "4" -> {
                val voleur= this.jeu.joueur as Voleur
                voleur.voler(monstre)
            }
            "5" -> {
                println("Le joueur passe son tour.")
            }
        }
        println("\u001b[0m")
    }

// Méthode pour simuler un tour de combat du monstre
   fun tourDeMonstre() {
        println("\u001b[31m Le monstre est en plein dilemme ")
        println("\u001b[0m")
        val  nb= (1..100).random()
        if (nb <= 70) {
            println("\u001B[25m ---Tour de ${monstre.nom} (pv: ${monstre.pointDeVie}) ---")
            //TODO Mission 1.3
            this.monstre.attaque(this.jeu.joueur)
            println("\u001B[0m")

        }
        else {
            println(" \u001B[31m le monstre ne fait rien")
            println("\u001b[0m")

        }
    }


    // Méthode pour exécuter le combat complet
    fun executerCombat() {
        println("Début du combat : ${this.jeu.joueur.nom} vs ${monstre.nom}")
        //La vitesse indique qui commence
        var tourJoueur = this.jeu.joueur.vitesse >= this.monstre.vitesse
        //Tant que le joueur et le monstre sont vivants
        while (this.jeu.joueur.pointDeVie > 0 && monstre.pointDeVie > 0) {
            println("Tours de jeu : ${nombreTours}")
            if (tourJoueur) {
                tourDeJoueur()
            } else {
                tourDeMonstre()
            }
            nombreTours++
            tourJoueur = !tourJoueur // Alternance des tours entre le joueur et le monstre
            println("${this.jeu.joueur.nom}: ${this.jeu.joueur.pointDeVie} points de vie | ${monstre.nom}: ${monstre.pointDeVie} points de vie")
            println("")
        }

        if (this.jeu.joueur.pointDeVie <= 0) {
            println("Game over ! ${this.jeu.joueur.nom} a été vaincu !")
            println("Le combat recommence")

            this.jeu.joueur.pointDeVie = this.jeu.joueur.pointDeVieMax
            this.monstre.pointDeVie = this.monstre.pointDeVieMax
            this.executerCombat()
        } else {
            println("BRAVO ! ${monstre.nom} a été vaincu !")
        }
    }
}
