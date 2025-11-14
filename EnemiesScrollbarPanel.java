// Final Project || Lamberto Alberici and Alae Chahid || CSC 125  || 2nd of December 2024
// ScrollBar Panel (Slider): Lets the user select the number of enemies they want 


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EnemiesScrollbarPanel extends JPanel{

	private JLabel numEnemies;
	private static JSlider enemies_scrollbar;

	
	public EnemiesScrollbarPanel()
	{
		super();
		super.setLayout(new BorderLayout());
		
		// Initializes the instances
		enemies_scrollbar = new JSlider(0,5,25,15);
		enemies_scrollbar.setPreferredSize(new Dimension(800,30));
		enemies_scrollbar.setBackground(Color.DARK_GRAY);
		enemies_scrollbar.setOpaque(true);
		enemies_scrollbar.setForeground(Color.BLACK);
		
		numEnemies = new JLabel("Number of Enemies", SwingConstants.CENTER);
		numEnemies.setFont(new Font("Times New Roman", Font.BOLD, 25));
		numEnemies.setBackground(Color.DARK_GRAY);
		numEnemies.setOpaque(true);
		
		numEnemies.setText("Number of Enemies: " + enemies_scrollbar.getValue());
		
		
		// Change listener that sets the label to the current number of enemies selected on the slider
		enemies_scrollbar.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				
				numEnemies.setText("Number of Enemies: " + enemies_scrollbar.getValue());
			}
        });

		super.add(numEnemies, BorderLayout.NORTH);
		super.add(enemies_scrollbar, BorderLayout.SOUTH);
	}

	
	// Returns the value on the scrollbar (A.K.A. number of enemies)
	public static int getNumOfEnemies()
	{
		return enemies_scrollbar.getValue();
	}
}
