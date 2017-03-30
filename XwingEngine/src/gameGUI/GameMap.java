package gameGUI;

import java.awt.*;
import java.awt.Event.*;
import javax.swing.*;
import gameCore.GameConstants;

public class GameMap extends JPanel implements GameConstants{
	
public GameMap(){
	setBackground(Color.BLACK);
	setSize(new Dimension((int) coreBoxTableSize,(int) coreBoxTableSize));
}

}
