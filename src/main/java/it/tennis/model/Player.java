package it.tennis.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Player implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final List<String> pointsDescription = Arrays.asList("love", "fifteen", "thirty", "forty");
	private String playerName;
	private int score;
	
	public Player() { }
	public Player(String playerName) { 
		this.playerName = playerName;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public void winBall() {
        this.score = this.score + 1;
    }
	
	public String getScoreDescription(){
        return pointsDescription.get(score);
    }
	
}
