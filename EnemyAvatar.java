// Final Project || Lamberto Alberici and Alae Chahid || CSC 125  || 2nd of December 2024
// Class for the enemy avatar's (Self Explanatory)

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EnemyAvatar extends JLabel{

	private ImageIcon image;
	
	public EnemyAvatar() 
	{
		super();
		try {
			image = new ImageIcon(getClass().getResource("Enemy_avatar_resized.png"));
			super.setIcon(image);
			
			
		} catch(Exception e) {
			System.out.println("Image cannot be found");
		}
		
	}
	
	
};
