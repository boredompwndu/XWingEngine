package shipCore;
import geometry.*;
//import gameCore.GameConstants;
/*
 * A hull zone has several attributes known to it. It knows:
 * 1) Its shield count
 * 2) The ship its on
 * 3) its firing arc origin's offset relative to ship center
 * 4) its line of sight offset relative to ship center
 * 5) Its arc lines relative to the ship's facing
 * 6) Its dice pool
 */

public class FiringArc {
	//fields
	protected ShipBase sb = null;
	protected PolarCoord firingArcOffset = null;
	protected double firingArcLeftBound = 0;
	protected double firingArcRightBound = 0;
	
	public FiringArc (ShipBase sb, PolarCoord firingArcOffset, double firingArcLeftBound, double firingArcRightBound){
		this.sb = sb;
		this.firingArcOffset = firingArcOffset;
		this.firingArcLeftBound = firingArcLeftBound;
		this.firingArcRightBound = firingArcRightBound;
	}
	
	public boolean isShipInArc(ShipBase targShip){
		return false;
	}
	
	public double getShipRangeInArc(ShipBase targShip){
		if(isShipInArc(targShip)){
			return 0;
		}
		return -1;
	}
	
}
