package gameGUI;


import java.awt.*;
import java.awt.Event.*;
import javax.swing.*;
import shipCore.ShipBase;
/*
 * The ship Panel Displays all of the information about a ship, such as ship and pilot names, stats, upgrades,
 * and possibly evenutally the dial itself.
 * The panel should look like:
 * +-------------------+
 * | <Pilot Name Here> |
 * +-------------------+
 * | <Ship Name Here>  |
 * +---+---+---+---+---+
 * | P | A | D | S | H |
 * +---+---+---+---+---+
 * | <Upgrades>        |
 * |				   |
 * | <Crits?>          |
 * +-------------------+
 */


public class ShipPanel extends JPanel{
	
	protected ShipBase ship = null;
	
	protected JLabel psPanel = new JLabel("");
	protected JLabel attackPanel = new JLabel("");
	protected JLabel defensePanel = new JLabel("");
	protected JLabel shieldPanel = new JLabel("");
	protected JLabel hullPanel = new JLabel("");
	protected JLabel shipNamePanel = new JLabel("");
	protected JLabel pilotNamePanel = new JLabel("");
	
	
	protected JPanel infoBar = null;
	protected JPanel shipNumPanel = null;
	
	
	
	
	public ShipPanel(ShipBase sb){
		/*
		 *get the ship from the contructor;
		 */
		ship = sb;
		
		/*
		 * Update the numbers based on the ship we now have
		 */
		updateNumberLabels();
		
		/*
		 * Update the names
		 */
		shipNamePanel.setText(ship.getShipName());
		pilotNamePanel.setText(ship.getPilotName());
		
		/*
		 * Assemble the panels, I guess
		 */
		
		//info bar first
		infoBar = new JPanel();
		infoBar.setLayout(new BorderLayout());
		infoBar.add(pilotNamePanel,BorderLayout.NORTH);
		infoBar.add(shipNamePanel,BorderLayout.CENTER);
		
		//numbers panel
		shipNumPanel = new JPanel();
		shipNumPanel.setLayout(new GridLayout (1,5));
		shipNumPanel.add(psPanel);
		shipNumPanel.add(attackPanel);
		shipNumPanel.add(defensePanel);
		shipNumPanel.add(hullPanel);
		shipNumPanel.add(shieldPanel);
		//add the numbers panel to the info panel
		infoBar.add(shipNumPanel);
		
		setLayout(new BorderLayout());
		add(infoBar);
		
	}
	
	public void updateNumberLabels(){
		attackPanel.setText(" "+ship.getAttack() + " ");
		defensePanel.setText(" "+ship.getDefense() + " ");
		hullPanel.setText(" "+ship.getHull() + " ");
		shieldPanel.setText(" "+ship.getShield() + " ");
		psPanel.setText(" "+ship.getPilotSkill() + " ");
	}
	

	
	

}
