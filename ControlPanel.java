// Final Project || Lamberto Alberici and Alae Chahid || CSC 125  || 2nd of December 2024
// Control Panel: Displays the control panel (Start Button, Score Label and Quit Button) on the bottom of the GUI
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class ControlPanel extends JPanel{
	
	// Declares all instances
	
	private JToggleButton start_pause_button;
	private JButton quit_button;
	private static JLabel score_label;
	private String gameState;
	
	

	public ControlPanel()
	{
		super();
		super.setLayout(new GridLayout(1,3));
		super.setBackground(Color.BLACK);
		
		Color buttonsForeground = new Color (84, 8, 94);
		
		
		// Instantiate all instances
		gameState = "Not Started";
		
		start_pause_button = new JToggleButton("Start", false);
		start_pause_button.setFont(new Font("Serif", Font.BOLD, 40));
		start_pause_button.setBackground(Color.BLACK);
		start_pause_button.setOpaque(true);
		start_pause_button.setBorderPainted(false);
		start_pause_button.setForeground(buttonsForeground);
		
		score_label = new JLabel("Score: ", SwingConstants.CENTER);
		score_label.setFont(new Font("Serif", Font.BOLD, 40));
		score_label.setBackground(Color.BLACK);
		score_label.setOpaque(true);
		score_label.setForeground(buttonsForeground);
		
		quit_button = new JButton("Quit");
		quit_button.setFont(new Font("Serif", Font.BOLD, 40));
		quit_button.setBackground(Color.BLACK);
		quit_button.setOpaque(true);
		quit_button.setBorderPainted(false);
		quit_button.setForeground(buttonsForeground);
		
		
		// ActionListener for quit button (Quits the app)
		quit_button.addActionListener(new ActionListener() { // Quits the app
			  public void actionPerformed(ActionEvent e) { 
			    System.exit(0);
			  } 
			} );
		
		// ItemListener for the Toggle button of staring and pausing
		start_pause_button.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				if(start_pause_button.isSelected())
				{
					start_pause_button.setText("Pause");
					actionPanel.start(); // Calls method from actionPanel
				}
				else
				{
					start_pause_button.setText("Start");
					actionPanel.stop(); // Calls method from actionPanel
				}
				
			}
			});
		
		
		
		
		super.add(start_pause_button);
		super.add(score_label);
		super.add(quit_button);
		
	}
	
	// Method to change the score Label 
	public static void setScore(int newScore)
	{
		score_label.setText("Score: " + newScore);
	}
}
