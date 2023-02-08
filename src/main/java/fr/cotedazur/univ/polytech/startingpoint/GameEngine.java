package fr.cotedazur.univ.polytech.startingpoint;

import fr.cotedazur.univ.polytech.startingpoint.bots.Bot;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.*;

public class GameEngine {
    Board board;
    List<Bot> playerList = new ArrayList<>();

    public GameEngine(Board board, List<Bot> players){
        this.board = board;
        this.playerList = players;
    }

    public void launchGame(){
    //On boucle sur le jeu
        int indexPlayer = 0;
        int nbTour = 1;
        boolean isGameFinished = false;
        while(true){
            Main.LOGGER.info("<       > Tour numero : "+nbTour+" <       >");
            this.playerList.get(indexPlayer).play();
            if (this.playerList.get(indexPlayer).getNbObjectifsRealises() >=9){
                isGameFinished = true;
                this.playerList.get(indexPlayer).setPoint(playerList.get(indexPlayer).getPoint()+2);
            }
            indexPlayer +=1;
            if(indexPlayer == this.playerList.size()){
                indexPlayer=0;
                nbTour++;
            }
            if(nbTour == 100000){
                Main.LOGGER.info("Nombre de tour max atteint");
                break;
            }
            if(isGameFinished){
                int points = -1;
                boolean verif = false;
                Bot ret = null;
                for(Bot b : playerList){
                    if(b.getPoint()>points){
                        ret = b;
                        points = b.getPoint();
                    }else if(b.getPoint()==points){
                        verif = true;
                    }
                }
                playerList.remove(ret);
                printWinner(ret,verif,playerList.get(0).getPoint());
                break;
            }
        }
    }

    public void printWinner(Bot p, boolean isEgality, int pointsPerdant){
        if(!isEgality) Main.LOGGER.info("Le joueur est gagnant est : "+p.getNom()+" avec un score de "+p.getPoint()+" points marques \nLe perdant possède "+pointsPerdant+" points");
        else Main.LOGGER.info("Egalite entre les deux joueurs ! ");
    }
}
