package weapons;

import gameCore.DiceRoll;
import shipCore.*;

public class PrimaryWeapon extends Weapon{

	public PrimaryWeapon(ShipBase sb) {
		super(sb.getAttack());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void resolveDamage(ShipBase targShip, DiceRoll finalDamage) {
		resolveDamageNormally(targShip, finalDamage);
	}
	
}
