package it.tennis.model.tennis;

import java.util.Scanner;

import it.tennis.model.Game;
import it.tennis.model.IGame;
import it.tennis.model.Player;
 
/***
 * 
 * @author maxp
 *
 */
public class MainTennis {
	
	
	/***
	 * 
	 * @param args
	 */
	public static void main (String[] args){
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("player 1: ");
	    String playerOneName = scanner.nextLine();
	 
	    System.out.print("player 2: ");
	    String playerTwoName = scanner.nextLine();
	 
		Player player1 = new Player(playerOneName);
		Player player2 = new Player(playerTwoName);
		
		
		IGame game = new Game( player1 , player2 );
		String score = game.score();
		System.out.print("score : "+score);
		
	}
}
