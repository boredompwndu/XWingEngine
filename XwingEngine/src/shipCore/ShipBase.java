package shipCore;

import geometry.*;
import java.util.ArrayList;
import gameCore.*;


public class ShipBase implements GameConstants{
	

	protected ComplexShape basePlate = new ComplexShape(new ShapeBase[5]);
	protected double facing = 0;
	protected FiringArc[] firingArcs;
	protected ArrayList<DiceModification> diceMods = new ArrayList<>();
	
	
	protected int attack = 0;
	protected int defense = 0;
	protected int hull = 0;
	protected int shield = 0;
	
	protected ArrayList<Weapon> weapons = new ArrayList<>();
	protected ArrayList<Token> tokens = new ArrayList<>();
	
	/*
	 * Constructor. First builds the ship base, then adds firing arcs, weapons, and dice mods
	 */
	public ShipBase(double shipLength, double shipWidth){
		//ship base
		Coordinate[] shipCoords = new Coordinate[4];
		shipCoords[0] = new Coordinate(shipLength/2,shipWidth/2);
		shipCoords[1] = new Coordinate(-shipLength/2,shipWidth/2);
		shipCoords[2] = new Coordinate(-shipLength/2,-shipWidth/2);
		shipCoords[3] = new Coordinate(shipLength/2,-shipWidth/2);
		basePlate.getChildShapes()[1] = new Polygon(shipCoords);
		
		//firing arcs
		
		//weapons
		
		//dice mods
		diceMods.add(new Focus(this));
		
	}
	
	public void translate (double diffX, double diffY){
		basePlate.translate(diffX,diffY);
	}
	
	public boolean checkShipOverlap(ShipBase other){
		return basePlate.detectOverlap(other.basePlate);
	}
	
	public double findRange(ShipBase targShip, boolean nubs){
		LineSegment tempSeg = null;
		if(!nubs){
			tempSeg = basePlate.getChildShapes()[1].findClosestPoints((Polygon)targShip.getBasePlate().getChildShapes()[1]);
		}
		else {
			tempSeg = basePlate.findClosestPoints(targShip.getBasePlate());
		}
		return tempSeg.getLength();
	}
	
	/*
	 * Token methods
	 */
	
	//Does a ship have a certain token?
	public boolean hasToken(Token targ){
		for (int i = 0; i<tokens.size();i++){
			if(tokens.get(i).equals(targ)){
				return true;
			}
		}
		return false;
	}
	//How many of a certain token does a ship have?
	public int getTokenCount(Token targ){
		int returnThis = 0;
		for (int i =0; i<tokens.size();i++){
			if(tokens.get(i).equals(targ)){
				returnThis+=1;
			}
		}
		return returnThis;
	}
	//adds a token to the ship
	public boolean addToken(Token targ){
		tokens.add(targ);
		return true;
	}
	
	//removes a token from the ship
	public boolean removeToken(Token targ){
		for(int i = 0;i<tokens.size();i++){
			if(tokens.get(i).equals(targ)){
				tokens.remove(i);
				return true;
			}
		}
		return false;
	}
	//can we remove a token from the ship?
	//Checks to see that the token exists
	public boolean canRemoveToken(Token targ){
		for(int i =0; i< tokens.size();i++){
			if(tokens.get(i).equals(targ)){
				return true;
			}
		}
		return false;
	}
	
	/*
	 * The "Spend Focus" Modifer. Converts all focus results to hits or evades. Requires 1 focus token, spends 1 focus token
	 */
	private class Focus extends DiceModification{
		
		public Focus(ShipBase sb){
			this.name = "Spend Focus";
			this.sb=sb;
		}
		@Override
		protected boolean canPerformModification() {
			if(sb.hasToken(Token.FOCUS)){
				return true;
			} else {
				return false;
			}
		}

		@Override
		protected boolean performModification(DiceRoll roll) {
			if (canPerformModification()) {
				sb.removeToken(Token.FOCUS);
				if (roll.roll.size() > 0) {
					for (int i = 0; i < roll.roll.size(); i++) {
						DiceBase activeDie = roll.roll.get(i);
						if (activeDie.facing.equals(DiceResult.FOCUS)) {
							if (activeDie.color.equals(Colors.RED)) {
								activeDie.facing = DiceResult.HIT;
							} else {
								if (activeDie.color.equals(Colors.GREEN)) {
									activeDie.facing = DiceResult.EVADE;
								}
							}
						}
					}

				}
				return true;
			}

			return false;
		}
		
	}

	//getters and setters
	public void rotate(double r){
		facing+=r;
		basePlate.rotate(r);
	}
	public double getFacing() {
		return facing;
	}

	public void setFacing(double facing) {
		this.facing = facing;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getHull() {
		return hull;
	}

	public void setHull(int hull) {
		this.hull = hull;
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(ArrayList<Weapon> weapons) {
		this.weapons = weapons;
	}

	public ComplexShape getBasePlate() {
		return basePlate;
	}

	public void setBasePlate(ComplexShape basePlate) {
		this.basePlate = basePlate;
	}

	public FiringArc[] getFiringArcs() {
		return firingArcs;
	}

	public void setFiringArcs(FiringArc[] firingArcs) {
		this.firingArcs = firingArcs;
	}
	

}
