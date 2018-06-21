package it.tennis.model;

import java.util.HashMap;
import java.util.Map;

import it.tennis.util.Constant;


/**
 * 
 * @author maxp
 *
 */
public class Game implements IGame{
	
	private static final Map<Integer, String> SCORE_NAMES = new HashMap<>();

    public static final String DEUCE = Constant.DEUCE;
    static {
        SCORE_NAMES.put(0, Constant.LOV);
        SCORE_NAMES.put(1, Constant.FIF);
        SCORE_NAMES.put(2, Constant.THI);
        SCORE_NAMES.put(3, Constant.FOUR);
    }

    private final String PLAYER_ONE_NAME;
    private final String PLAYER_TWO_NAME;

    private Player player1;
    private Player player2;
    
    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    /**
     * Costructor
     * 
     * @param player1
     * @param player2
     */
    public Game(Player player1, Player player2) {
    	
    	this.player1 = player1;
    	this.player2 = player2;
    	
    	this.player1.setScore(playerOneScore);
        this.player2.setScore(playerTwoScore);
        
    	this.PLAYER_ONE_NAME = player1.getPlayerName();
        this.PLAYER_TWO_NAME = player2.getPlayerName();
        
        
    }

    
    public void playerOneScores() {
    	playerOneScore++;
     	this.player1.setScore(playerOneScore);
    }

    public void playerTwoScores() {
    	playerTwoScore++;
    	this.player2.setScore(playerTwoScore);
    }

    public String score() {
        String score;
        if (isPlayerOneWinner()) {
            score = playerWins(player1);
        } else if (isPlayerTwoWinner()) {
            score = playerWins(player2);
        } else if (hasPlayerOneAdvantage()) {
            score = hasPlayerAdvantage(PLAYER_ONE_NAME);
        } else if (hasPlayerTwoAdvantage()) {
            score = hasPlayerAdvantage(PLAYER_TWO_NAME);
        } else if (isDeuce()) {
            score = DEUCE;
        } else {
            score = getRegularScore();
        }
        return score;
    }

    public boolean isPlayerOneWinner() {
        return playerOneScore > playerTwoScore + 1 && playerOneScore > Constant.TREE;
    }

    public String playerWins(Player player) {
        return player.getPlayerName() + Constant.WIN;
    }

    public boolean isPlayerTwoWinner() {
        return playerTwoScore > playerOneScore + 1 && playerTwoScore > Constant.TREE;
    }

    public boolean hasPlayerOneAdvantage() {
        return playerOneScore == playerTwoScore + 1 && playerOneScore > Constant.TREE;
    }

    public boolean hasPlayerTwoAdvantage() {
        return playerTwoScore == playerOneScore + 1 && playerTwoScore > Constant.TREE;
    }

    public String hasPlayerAdvantage(String playerName) {
        return "Advantage " + playerName;
    }

    public boolean isDeuce() {
        return playerOneScore == playerTwoScore && playerOneScore >= Constant.TREE;
    }

    public String getRegularScore() {
        return playerOneScore == playerTwoScore ? getScoreStringWhenEqualityScores() : getScoreStringWhenDifferentScores();
    }

    public String getScoreStringWhenEqualityScores() {
        return String.format("%s "+Constant.ALL, SCORE_NAMES.get(playerOneScore));
    }

    public String getScoreStringWhenDifferentScores() {
        return String.format(Constant.S_FORMAT, SCORE_NAMES.get(playerOneScore), SCORE_NAMES.get(playerTwoScore));
  }
    
    
    public Player getLeadPlayer() {
        return (player1.getScore() > player2.getScore()) ? player1 : player2;
    }
}
