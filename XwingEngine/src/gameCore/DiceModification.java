package gameCore;

import shipCore.ShipBase;

public abstract class DiceModification {
	
	protected String name;
	protected ShipBase sb;
	
	protected abstract boolean canPerformModification();
	protected abstract boolean performModification(DiceRoll roll);
	

}
