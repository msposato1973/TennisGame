package it.tennis.model;

public interface IGame {
	
	public void playerOneScores();
	public void playerTwoScores();
	public String score() ;
	public boolean isPlayerOneWinner();
	
	public String playerWins(Player player) ;
	public boolean isPlayerTwoWinner() ;

	public boolean hasPlayerOneAdvantage();
	public boolean hasPlayerTwoAdvantage() ;
	public String hasPlayerAdvantage(String playerName) ;
	public boolean isDeuce() ;
	public String getRegularScore() ;

	public String getScoreStringWhenEqualityScores() ;
	public String getScoreStringWhenDifferentScores();

}
