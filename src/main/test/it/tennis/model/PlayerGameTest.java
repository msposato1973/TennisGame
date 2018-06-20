package it.tennis.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerGameTest    {
	
	private IGame game;
    private String playerOneName;
    private String playerTwoName;

    @Before
    public void setUp() throws Exception {
        playerOneName = "Player One";
        playerTwoName = "Player Two";
        
        
        game = new Game(new Player(playerOneName), new Player(playerTwoName));
    }

    @Test
    public void newGameScoreShouldBeLoveAll() {
        assertEquals("Love all", game.score());
    }

    @Test
    public void whenPlayerOneWinsFirstBallScoreReturnsFifteenLove() throws Exception {
        setScore(1, 0);
        assertEquals("Fifteen, Love", game.score());
    }

    @Test
    public void whenAllPlayerScoresOnceScoreMustBeFifteenAll() throws Exception {
        setScore(1, 1);
        assertEquals("Fifteen all", game.score());
    }

    @Test
    public void whenPlayerOneScoresTwiceScoreMustBeThirtyLove() throws Exception {
        setScore(2, 0);
        assertEquals("Thirty, Love", game.score());
    }

    @Test
    public void whenPlayerTwoScoresThreeTimesScoreMustBeLoveFourty() throws Exception {
        setScore(0, 3);
        assertEquals("Love, Fourty", game.score());
    }

    @Test
    public void whenAllPlayersScoresThreeTimesScoreMustReturnDeuce() throws Exception {
        setScore(3, 3);
        assertEquals("Deuce", game.score());
    }

    @Test
    public void whenPlayerOneScoresFourTimesThenPlayerOneWinsTheGame() throws Exception {
        setScore(4, 0);
        assertEquals(playerOneName + " wins", game.score());
    }

    @Test
    public void whenPlayerTwoScoresFourTimesThenPlayerTwoWinsTheGame() throws Exception {
        setScore(0, 4);
        assertEquals( playerTwoName +" wins", game.score());
    }

    @Test
    public void whenPlayersScoresFourTimesThenScoreMustBeDeuce() throws Exception {
        setScore(4, 4);
        assertEquals("Deuce", game.score());
    }

    @Test
    public void whenPlayerOneHasAdvantageScoreShouldBeAdvantagePlayerOne() throws Exception {
        setScore(4, 3);
        assertEquals("Advantage " + playerOneName, game.score());
    }

    @Test
    public void whenPlayerTwoHasAdvantageScoreShouldBeAdvantagePlayerTwo() throws Exception {
        setScore(3, 4);
        assertEquals("Advantage " + playerTwoName, game.score());
    }

    @Test
    public void whenPlayerOneWinsFromAdvantage() throws Exception {
        setScore(5, 3);
        assertEquals(playerOneName + " wins", game.score());
    }

    @Test
    public void whenPlayerTwoWinsFromAdvantage() throws Exception {
        setScore(3, 5);
        assertEquals(playerTwoName + " wins", game.score());
    }

    private void setScore(int playerOneScore, int playerTwoScore) {
        for (int i = 0; i < playerOneScore; i++) {
            game.playerOneScores();
        }
        for (int i = 0; i < playerTwoScore; i++) {
            game.playerTwoScores();
        }

}

	 
}
