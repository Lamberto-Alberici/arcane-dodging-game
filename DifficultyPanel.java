// Final Project || Lamberto Alberici and Alae Chahid || CSC 125  || 2nd of December 2024
// Difficulty Panel: Displays the difficulty panel (Easy, normal, hard buttons) on the bottom of the GUI

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DifficultyPanel extends JPanel{
	
	private JRadioButton easy_button, normal_button, hard_button;
	private static String curDif;
	
	public DifficultyPanel()
	{
		super();
		super.setLayout(new GridLayout(1,3));
		super.setBackground(Color.DARK_GRAY);
		super.setPreferredSize(new Dimension(300,50));
		
		curDif = "Easy";
		
		
		// Instantiates all buttons 
		easy_button = new JRadioButton("Easy");
		easy_button.setHorizontalAlignment(SwingConstants.CENTER);
		easy_button.setPreferredSize(new Dimension(100,30));
		easy_button.setFont(new Font("Times New Roman", Font.BOLD, 40));
		easy_button.setBackground(Color.DARK_GRAY);
		easy_button.setOpaque(true);
		easy_button.setBorderPainted(false);
		easy_button.setForeground(Color.BLACK);
		easy_button.setSelected(true);
		
		normal_button = new JRadioButton("Normal");
		normal_button.setHorizontalAlignment(SwingConstants.CENTER);
		normal_button.setPreferredSize(new Dimension(100,30));
		normal_button.setFont(new Font("Times New Roman", Font.BOLD, 40));
		normal_button.setBackground(Color.DARK_GRAY);
		normal_button.setOpaque(true);
		normal_button.setBorderPainted(false);
		normal_button.setForeground(Color.BLACK);
		
		hard_button = new JRadioButton("Hard");
		hard_button.setHorizontalAlignment(SwingConstants.CENTER);
		hard_button.setPreferredSize(new Dimension(100,30));
		hard_button.setFont(new Font("Times New Roman", Font.BOLD, 40));
		hard_button.setBackground(Color.DARK_GRAY);
		hard_button.setOpaque(true);
		hard_button.setBorderPainted(false);
		hard_button.setForeground(Color.BLACK);
		
		
		
		// Action Listener for the easy button. If clicked sets the other buttons to False and sets the "curDif" to the right state
		// Same with the normal and hard button
		easy_button.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    if (easy_button.isSelected())
			    {
			    	normal_button.setSelected(false);
			    	hard_button.setSelected(false);
			    	curDif = "easy";
			    }
			  } 
			} );

		normal_button.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    if (normal_button.isSelected())
			    {
			    	easy_button.setSelected(false);
			    	hard_button.setSelected(false);
			    	curDif = "Normal";
			    }
			  } 
			} );

		hard_button.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    if (hard_button.isSelected())
			    {
			    	normal_button.setSelected(false);
			    	easy_button.setSelected(false);
			    	curDif = "Hard";
			    }
			  } 
			} );
		
		
		
		
		
		super.add(easy_button);
		super.add(normal_button);
		super.add(hard_button);
		
		
	}
	
	// Returns the current Difficulty level
	public static String getDif()
	{
		return curDif;
	}

}
