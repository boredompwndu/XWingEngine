package gameGUI;

import java.awt.*;
import java.awt.Event.*;
import javax.swing.*;
/*
 * The Game Window contains all information and interaction points for the game. 
 * Inside this will be 2 side-bars for the player's ships' conditions,
 * the command card (bottom left)
 * the map (center)
 * and a game log (bottom right)
 */
public class GameWindow extends JFrame {
	
	//The map of the game
	protected GameMap map = new GameMap();
	
	public GameWindow(){
		setSize(1000,1000);
		setBackground(Color.RED);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(map,BorderLayout.CENTER);
		setTitle(" Dudeseph's X-wing Engine");
		setVisible(true);
		
	}

}
