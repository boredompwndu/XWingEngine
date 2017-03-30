package gameCore;

import java.util.Random;


public class DiceBase implements GameConstants{
	/*
	 * enumerated fields. results are the available results the game
	 * understands; Color pertains to the color of the die. mostly affects the
	 * rolltables used;
	 */




	protected DiceResult[] rollTable = new DiceResult[8];
	Random rd = new Random();
	public DiceResult facing = null;
	public Colors color = null;

	public DiceBase(Colors color) {
		populateRollTable(color);
		facing = roll();
		this.color = color;
	}

	public DiceBase(Colors color, DiceResult result) {
		populateRollTable(color);
		if (isOnRollTable(result)) {
			facing = result;
			this.color = color;
		} else {
			System.out.println("Something just tried to add a result that the die can't have." + color + " " + result);
		}
	}
	
	public String toString(){
		return (color + " " + facing);
	}

	/*
	 * Rolls a die. Looks up a random value on the roll table and returns that
	 * value
	 */
	public DiceResult roll() {
		return rollTable[rd.nextInt(rollTable.length)];
	}

	public int getDamageValue() {
		switch (facing) {
		case HIT:
		case CRIT:
			return 1;
		default:
			return 0;

		}
	}
	
	public int getEvadeValue() {
		switch(facing) {
		case EVADE:
			return 1;
		default:
			return 0;
		}
		
	}


	public boolean isOnRollTable(DiceResult r) {
		for (int i = 0; i < rollTable.length; i++) {
			if (rollTable[i].equals(r)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * populates the die's rolltable according to its color
	 */
	public void populateRollTable(Colors color) {
		switch (color) {
		case RED:
			rollTable[0] = DiceResult.BLANK;
			rollTable[1] = DiceResult.BLANK;
			rollTable[2] = DiceResult.FOCUS;
			rollTable[3] = DiceResult.FOCUS;
			rollTable[4] = DiceResult.HIT;
			rollTable[5] = DiceResult.HIT;
			rollTable[6] = DiceResult.HIT;
			rollTable[7] = DiceResult.CRIT;
			break;
		case GREEN:
			rollTable[0] = DiceResult.BLANK;
			rollTable[1] = DiceResult.BLANK;
			rollTable[2] = DiceResult.BLANK;
			rollTable[3] = DiceResult.FOCUS;
			rollTable[4] = DiceResult.FOCUS;
			rollTable[5] = DiceResult.EVADE;
			rollTable[6] = DiceResult.EVADE;
			rollTable[7] = DiceResult.EVADE;
			break;

		}// end switch(color)
	}
}
