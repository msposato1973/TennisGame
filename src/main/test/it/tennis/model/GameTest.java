package it.tennis.model;

import static org.junit.Assert.*;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

public class GameTest extends TestCase{
	 
	Player victor;
    Player sarah;
    Game game;
 
    @Before
    public void beforeGameTest() {
        victor = new Player("Victor");
        sarah = new Player("Sarah");
        game = new Game(victor, sarah);
    }
 
    @Test
    public void loveShouldBeDescriptionForScore0() {
        Game game = new Game(victor, sarah);
        assertThat(game, hasProperty("score", is("love, love")));
    }
 
    @Test
    public void fifteenShouldBeDescriptionForScore1() {
        sarah.winBall();
        assertThat(game, hasProperty("score", is("love, fifteen")));
    }
    
    @Test
    public void deuceShouldBeDescriptionWhenAtLeastThreePointsHaveBeenScoredByEachPlayerAndTheScoresAreEqual() {
        for(int index = 1; index <= 3; index++) {
            victor.winBall();
        }
        for(int index = 1; index <= 3; index++) {
            sarah.winBall();
        }
       
    }
 
    @Test
    public void thirtyShouldBeDescriptionForScore2() {
        victor.winBall();
        victor.winBall();
        sarah.winBall();
        assertThat(game, hasProperty("score", is("thirty, fifteen")));
    }
 
    
   

	
 
    
}
