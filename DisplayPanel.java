// Final Project || Lamberto Alberici and Alae Chahid || CSC 125  || 2nd of December 2024
// Display Panel: Holds three other panels for layouts purposes

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class DisplayPanel extends JPanel{

	private DifficultyPanel difficultyPanel;
	private EnemiesScrollbarPanel scrollbarPanel;
	private actionPanel _actionPanel;
	
	public DisplayPanel()
	{
		super();
		super.setLayout(new BorderLayout());
		
		
		difficultyPanel = new DifficultyPanel();
		scrollbarPanel = new EnemiesScrollbarPanel();
		_actionPanel = new actionPanel();

		
		super.add(difficultyPanel, BorderLayout.SOUTH);
		super.add(scrollbarPanel, BorderLayout.NORTH);
		super.add(_actionPanel, BorderLayout.CENTER);
	}
	
}
