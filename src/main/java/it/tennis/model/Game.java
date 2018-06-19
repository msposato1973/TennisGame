package it.tennis.model;

public class Game {
	private Player player1;
    private Player player2;
    
    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    
    
    public String getScore() {
    	String sScore = "";
    	
        if (player1.getScore() >= 3 && player2.getScore() >= 3) {
            if (Math.abs(player2.getScore() - player1.getScore()) >= 2) {
            	sScore = getLeadPlayer().getName() + " won";
            } else if (player1.getScore() == player2.getScore()) {
            	sScore = "deuce";
            } else {
            	sScore = "advantage " + getLeadPlayer().getName();
            }
        } else {
        	sScore = player1.getScoreDescription() + ", " + player2.getScoreDescription();
        }
        
        return sScore;
    }

    public Player getLeadPlayer() {
        return (player1.getScore() > player2.getScore()) ? player1 : player2;
    }
}
