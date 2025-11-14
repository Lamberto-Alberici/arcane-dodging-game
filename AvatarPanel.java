// Final Project || Lamberto Alberici and Alae Chahid || CSC 125  || 2nd of December 2024
// AvatarPanel: It displays all choices of avatars to user (Sits at the right of the GUI)
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AvatarPanel extends JPanel{
	
	//instantiate all avatars and respective buttons for choice selection
	private ViAvatar Vi;
	private JinxAvatar Jinx;
	private CaitlinAvatar Caitlin;
	
	private JRadioButton buttonVi, buttonJinx, buttonCaitlin;
	
	// Constructor
	public AvatarPanel()
	{
		super();
		super.setLayout(new GridLayout(3,2,-120,0));
		Color BackgroundColor = new Color (84, 8, 94);
		super.setBackground(BackgroundColor);

		
		// Instantiating avatar image and respective button
		
		Vi = new ViAvatar();
		buttonVi = new JRadioButton("Vi");
		buttonVi.setFont(new Font("Impact", Font.PLAIN, 40));
		buttonVi.setSelected(true); // Shows 
		
		
		// Adds the actionListener to the button that shows the current avatar selected in the actionPanel
		// The same is said for the rest of the class
		buttonVi.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    if (buttonVi.isSelected() && actionPanel.getGameState() == false)
			    {
			    	buttonJinx.setSelected(false);
			    	buttonCaitlin.setSelected(false);
			    	actionPanel.showVi();
			    	actionPanel.hideCaitlyn();
			    	actionPanel.hideJinx();
			    	actionPanel.setCurAvatar("Vi");
			    }
			  } 
			} );
		
		
		
		Jinx = new JinxAvatar();
		buttonJinx = new JRadioButton("Jinx");
		buttonJinx.setFont(new Font("Impact", Font.PLAIN, 40));
		buttonJinx.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    if (buttonJinx.isSelected() && actionPanel.getGameState() == false)
			    {
			    	buttonVi.setSelected(false);
			    	buttonCaitlin.setSelected(false);
			    	actionPanel.showJinx();
			    	actionPanel.hideCaitlyn();
			    	actionPanel.hideVi();
			    	actionPanel.setCurAvatar("Jinx");
			    }
			  } 
			} );
		
		
		
		Caitlin = new CaitlinAvatar();
		buttonCaitlin = new JRadioButton("Caitlyn");
		buttonCaitlin.setFont(new Font("Impact", Font.PLAIN, 40));
		buttonCaitlin.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    if (buttonCaitlin.isSelected() && actionPanel.getGameState() == false)
			    {
			    	buttonVi.setSelected(false);
			    	buttonJinx.setSelected(false);
			    	actionPanel.showCaitlyn();
			    	actionPanel.hideJinx();
			    	actionPanel.hideVi();
			    	actionPanel.setCurAvatar("Caitlyn");
			    }
			  } 
			} );
		
		
		
		
		super.add(buttonVi);
		super.add(Vi);
		super.add(buttonJinx);
		super.add(Jinx);
		super.add(buttonCaitlin);
		super.add(Caitlin);
	}
	
	

}
