package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;

public class GameEngine {
    Board board;
    ArrayList<Player> playerList = new ArrayList<>();

    public GameEngine(Board board, ArrayList<Player> players){
        this.board = board;
        this.playerList = players;
    }

    public void launchGame(){
        int indexPlayer = 0;
        int nbTour = 1;
        while(true){
            System.out.println("<       > Tour numero : "+nbTour+" <       >");
            this.playerList.get(indexPlayer).play();
            if (this.playerList.get(indexPlayer).getPoint() >= 9){
                printWinner(this.playerList.get(indexPlayer));
                break;
            }
            indexPlayer +=1;
            if(indexPlayer == this.playerList.size()){
                indexPlayer=0;
                nbTour++;
            }
        }
    }
    public void printWinner(Player p){
        System.out.println("Le joueur est gagnant est : "+p.getNom()+" avec un score de "+p.getPoint()+" points marqués");
    }
}
