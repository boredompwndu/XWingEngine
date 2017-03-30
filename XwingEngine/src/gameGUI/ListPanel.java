package gameGUI;

import java.awt.*;
import java.awt.Event.*;
import javax.swing.*;

import shipCore.ShipBase;

public class ListPanel extends JPanel {
	
	protected ShipPanel[] shipPanels;
	protected ShipBase[] ships;
	
	public ListPanel(ShipBase[] ships){
		this.ships = ships;
		shipPanels = new ShipPanel[this.ships.length];
		for(int i = 0 ; i< shipPanels.length;i++){
			shipPanels[i] = new ShipPanel(ships[i]);
		}
		
		setLayout(new GridLayout(0,1));
		setAlignmentX(Component.TOP_ALIGNMENT);
		for(int i = 0; i < ships.length;i++){
			add(shipPanels[i]);
		}		
		
	}

}
