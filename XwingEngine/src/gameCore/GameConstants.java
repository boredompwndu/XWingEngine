package gameCore;

public interface GameConstants {

	public static final double range1 = 100;
	public static final double range2 = 200;
	public static final double range3 = 300;
	public static final double range4 = 400;
	public static final double range5 = 500;

public static final double smallShipBase = 40;
public static final double largeShipBase = 80;
	
	public static enum DiceResult {
		BLANK, FOCUS, HIT, CRIT, EVADE
	};
	public static enum Colors {
		RED, GREEN
	};
	
	public static enum GamePhase {
		DIALS, ACTIVATION_START, ACTIVATION, ACTIVATION_END, COMBAT_START, COMBAT, COMBAT_END, STATUS
	}
	
	public static enum Token {
		FOCUS,EVADE
	}

}
