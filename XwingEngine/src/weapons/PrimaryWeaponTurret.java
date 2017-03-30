package weapons;

import gameCore.DiceRoll;
import shipCore.*;

public class PrimaryWeaponTurret extends Weapon{

	public PrimaryWeaponTurret(ShipBase sb) {
		super(sb.getAttack());
		restrictedToFiringArc = false;
	}

	@Override
	public void resolveDamage(ShipBase targShip, DiceRoll finalDamage) {
		resolveDamageNormally(targShip,finalDamage);
		
	}

}
