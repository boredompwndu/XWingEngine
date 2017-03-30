package gameCore;

import shipCore.*;

public class AttackModel {

	public static boolean performAttack(ShipBase attacker, ShipBase defender, Weapon wep){
		double attackRange = 0;
		
		/*
		 * If the ship can perform the attack
		 */
		if(wep.isRestrictedToFiringArc()){
			boolean inRangeInArc = false;
			for(int i = 0; i<attacker.getFiringArcs().length;i++){
				if(attacker.getFiringArcs()[i].isShipInArc(defender)){
					attackRange = attacker.getFiringArcs()[i].getShipRangeInArc(defender);
					if(attackRange> wep.getMinRange()&&attackRange<=wep.getMaxRange()){
						inRangeInArc = true;
					}
				}
			}
			if(!inRangeInArc){
				return false;
			}
			
		}else{
		attackRange =attacker.findRange(defender, false);
			if(!(attackRange>wep.getMinRange()&&attackRange<=wep.getMaxRange())){
				return false;
			}
		}
		/*
		 * having passed validity checks, form the dice pools
		 */
		
		int redDiceCount = wep.getBaseDiceCount();
		if(!wep.isIgnoresAttackRangeBonus()){
			if(attackRange<=GameConstants.range1){
				redDiceCount+=1;
			}
		}
		
		int greenDiceCount = defender.getDefense();
		if(!wep.isIgnoresDefenseRangeBonus()){
			if(attackRange>GameConstants.range2){
				greenDiceCount+=1;
			}
		}
		
		//Step 1, roll attack dice
		DiceRoll attackDice = new DiceRoll(GameConstants.Colors.RED,redDiceCount);
		
		//step 2, defender modifies attack dice
		
		//step 3, attacker modfies red dice
		
		//step 4, roll defense dice
		
		DiceRoll defenseDice = new DiceRoll(GameConstants.Colors.GREEN,greenDiceCount);
		
		//step 5, attacker modifies green dice
		
		//step 6, defender modifies green dice
		
		/*
		 * Compare Results step.
		 */if(defenseDice.getResultCount(GameConstants.DiceResult.EVADE)>0){
			 while(defenseDice.getResultCount(GameConstants.DiceResult.EVADE)>0){
				 if(attackDice.getResultCount(GameConstants.DiceResult.HIT)>0){
					 attackDice.removeDie(GameConstants.DiceResult.HIT);
				 }
				 if(attackDice.getResultCount(GameConstants.DiceResult.CRIT)>0){
					 attackDice.removeDie(GameConstants.DiceResult.CRIT);
				 }
				 defenseDice.removeDie(GameConstants.DiceResult.EVADE);
			}
		}
		return true;
	}
}
