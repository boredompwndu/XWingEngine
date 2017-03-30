package shipCore;

import gameCore.DiceRoll;
import gameCore.GameConstants;

public abstract class Weapon implements GameConstants{
	
	protected boolean restrictedToFiringArc = true;
	protected boolean isPrimaryWeapon = true;
	protected boolean ignoresAttackRangeBonus = false;
	protected boolean ignoresDefenseRangeBonus = false;
	
	protected boolean active = true;
	
	protected int baseDiceCount = 0;
	protected double minRange = 0;
	protected double maxRange = GameConstants.range3;
	
	
	public Weapon(int baseDiceCount){
		this.baseDiceCount = baseDiceCount;
	}
	
	public abstract void resolveDamage(ShipBase targShip, DiceRoll finalDamage);
	
	public void resolveDamageNormally(ShipBase targShip, DiceRoll finalDamage){
		while(finalDamage.getResultCount(GameConstants.DiceResult.HIT)>0){
			if(targShip.getShield()>0){
				targShip.setShield(targShip.getShield()-1);
			} else {
				targShip.setHull(targShip.getHull()-1);
			}
			finalDamage.removeDie(GameConstants.DiceResult.HIT);
		}
		
		//TODO: Make crit results mean something
		while(finalDamage.getResultCount(GameConstants.DiceResult.CRIT)>0){
			if(targShip.getShield()>0){
				targShip.setShield(targShip.getShield()-1);
			} else {
				targShip.setHull(targShip.getHull()-1);
			}
			finalDamage.removeDie(GameConstants.DiceResult.CRIT);
		}
	}
	

	public boolean isRestrictedToFiringArc() {
		return restrictedToFiringArc;
	}

	public void setRestrictedToFiringArc(boolean restrictedToFiringArc) {
		this.restrictedToFiringArc = restrictedToFiringArc;
	}

	public boolean isPrimaryWeapon() {
		return isPrimaryWeapon;
	}

	public void setPrimaryWeapon(boolean isPrimaryWeapon) {
		this.isPrimaryWeapon = isPrimaryWeapon;
	}

	public boolean isIgnoresAttackRangeBonus() {
		return ignoresAttackRangeBonus;
	}

	public void setIgnoresAttackRangeBonus(boolean ignoresAttackRangeBonus) {
		this.ignoresAttackRangeBonus = ignoresAttackRangeBonus;
	}

	public boolean isIgnoresDefenseRangeBonus() {
		return ignoresDefenseRangeBonus;
	}

	public void setIgnoresDefenseRangeBonus(boolean ignoresDefenseRangeBonus) {
		this.ignoresDefenseRangeBonus = ignoresDefenseRangeBonus;
	}

	public int getBaseDiceCount() {
		return baseDiceCount;
	}

	public void setBaseDiceCount(int baseDiceCount) {
		this.baseDiceCount = baseDiceCount;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public double getMinRange() {
		return minRange;
	}

	public void setMinRange(double minRange) {
		this.minRange = minRange;
	}

	public double getMaxRange() {
		return maxRange;
	}

	public void setMaxRange(double maxRange) {
		this.maxRange = maxRange;
	}
	
	
}
