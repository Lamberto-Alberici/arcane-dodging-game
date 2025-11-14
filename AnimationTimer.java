// Final Project || Lamberto Alberici and Alae Chahid || CSC 125  || 2nd of December 2024
// Class for the animation timer for moving the enemies

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationTimer extends Timer{
	
	private actionPanel _dp;
	
	public AnimationTimer(actionPanel dp) {
		super(100, null);
		
		this._dp = dp;
		this.addActionListener(new MoveListener());
	}
	
	// Calls the actionPanel method move() that moves the enemies;
	public class MoveListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			_dp.move();
			
		}
		
	}
}