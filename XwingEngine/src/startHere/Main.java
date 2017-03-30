package startHere;

import geometry.*;
import shipCore.*;
import gameCore.*;
import gameGUI.*;

public class Main {

	public static void main(String[] args) {
	DiceRoll dice = new DiceRoll(GameConstants.Colors.RED,1000);
	System.out.println("Blank: " + dice.getResultCount(GameConstants.DiceResult.BLANK));
	System.out.println("Focus: " + dice.getResultCount(GameConstants.DiceResult.FOCUS));
	System.out.println("Hit: " + dice.getResultCount(GameConstants.DiceResult.HIT));
	System.out.println("Crit: " + dice.getResultCount(GameConstants.DiceResult.CRIT));
	
	new GameWindow();
	}

}
