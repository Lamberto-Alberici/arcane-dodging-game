// Final Project || Lamberto Alberici and Alae Chahid || CSC 125  || 2nd of December 2024
// Class for one of the final frame: Holds all the layouts and displays them using a border Layout

import java.awt.BorderLayout;
import javax.swing.*;

public class MyApp extends JFrame{
	
	private AvatarPanel avatarPanel;
	private ControlPanel controlPanel;
	private DisplayPanel displayPanel;
	
	
	public MyApp()
	{
		super("Final Project Game");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(new BorderLayout());
		
		
		
		
	    avatarPanel = new AvatarPanel();
	    controlPanel = new ControlPanel();
	    displayPanel = new DisplayPanel();
	  
	    
	    super.add(avatarPanel, BorderLayout.EAST);
	    super.add(controlPanel, BorderLayout.SOUTH);
	    super.add(displayPanel, BorderLayout.WEST);
	    
	    super.pack();
	    super.setVisible(true);
	}

	
	
	public static void main(String[] args) {
		new MyApp();

	}

}
