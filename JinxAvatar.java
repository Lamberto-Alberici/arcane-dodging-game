// Final Project || Lamberto Alberici and Alae Chahid || CSC 125  || 2nd of December 2024
// Class for one of the avatar's options (Self Explanatory)

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JinxAvatar extends JLabel{

	private ImageIcon image;
	
	public JinxAvatar() 
	{
		super();
		try {
			image = new ImageIcon(getClass().getResource("JINX_avatar_resized.png"));
			super.setIcon(image);
			
			
		} catch(Exception e) {
			System.out.println("Image cannot be found");
		}
		
	}
	
	
};