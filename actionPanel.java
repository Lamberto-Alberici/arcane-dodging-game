// Final Project || Lamberto Alberici and Alae Chahid || CSC 125  || 2nd of December 2024
// Class for the most important panel: The Action Panel

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class actionPanel extends JPanel{

	// Declares all enemies and Avatars
	private static ViAvatar vi;
	private static JinxAvatar jinx;
	private static CaitlinAvatar caitlyn;
	private static String cAvatar;
	private static Boolean gameStarted;
	private static int numOfEnemies;
	private static String difficulty;
	
	private static ArrayList<EnemyAvatar> enemies;
	private static ArrayList<Integer> randoms;
	
	private static AnimationTimer _timer;
	private static Timer showingTimer;
	private static Timer scoreTimer;
	
	private static int score;
	
	private static JLabel finalLabel;
	
	private static int dif_when_started;
	
	
	public actionPanel()
	{
		super();
		super.setPreferredSize(new Dimension(1000, 800));
		super.setLayout(null);
		Color newBackgroundColor = new Color (26, 2, 54);
		super.setBackground(newBackgroundColor);
		
		
		// Instatiates all instances
		cAvatar = "Vi";
		gameStarted = false;
		
		
		
		vi = new ViAvatar();
		Dimension size = vi.getPreferredSize();
		vi.setBounds(800, 250, size.width, size.height);
		super.add(vi);

		
		
		jinx = new JinxAvatar();
		Dimension size2 = jinx.getPreferredSize();
		jinx.setBounds(750, 250, size2.width, size2.height);
		jinx.setVisible(false);
		super.add(jinx);
		
		
		caitlyn = new CaitlinAvatar();
		Dimension size3 = caitlyn.getPreferredSize();
		caitlyn.setBounds(800, 250, size3.width, size3.height);
		caitlyn.setVisible(false);
		super.add(caitlyn);
		
		
		// Add mouseMotionListener to checked for drag and lets the user drag the selected avatar only up and down
		addMouseMotionListener(new MouseAdapter() { 
			
			public void mouseDragged(MouseEvent e)
			{
				if (cAvatar == "Vi")
				{
					if(e.getX() >= vi.getX() && e.getX() <= vi.getX()+82 && e.getY() >= vi.getY() && e.getY() < vi.getY()+200)
					{
						vi.setBounds(vi.getX(), e.getY()-66, size.width, size.height);
					}
				}
				else if (cAvatar == "Jinx")
				{
					if(e.getX() >= jinx.getX() && e.getX() <= jinx.getX()+266 && e.getY() >= jinx.getY() && e.getY() < jinx.getY()+150)
					{
						jinx.setBounds(jinx.getX(), e.getY()-49, size2.width, size2.height);
					}
				}
				else if (cAvatar == "Caitlyn")
				{
					if(e.getX() >= caitlyn.getX() && e.getX() <= caitlyn.getX()+137 && e.getY() >= caitlyn.getY() && e.getY() < caitlyn.getY()+200)
					{
						caitlyn.setBounds(caitlyn.getX(), e.getY()-66, size3.width, size3.height);
					}
				}
			}
		});
		

		
		score = 0;
		// Timer to update the label score as time passes
		scoreTimer = new Timer();
		TimerTask taskScore = new TimerTask() {
			
            public void run() {
                // If out of bounds updated score
            	int total = 0;
            	for(int i = 0; i < numOfEnemies; i++)
            	{
            		if(enemies.get(i).getX() > 1200)
            		{
            			total += 1;
            		}
            	}
            	score = total;
            	// Change the Label
            	ControlPanel.setScore(score);
            	if(score == numOfEnemies)
            	{
            		finalLabel.setText("YOU WON!!!");
            		finalLabel.setVisible(true);
            		
            	}
            }
        };
        
        scoreTimer.scheduleAtFixedRate(taskScore, 100, 100);
				

		randoms = new ArrayList<Integer>(); // Arraylist for randomized directions of the enemies
		enemies = new ArrayList<EnemyAvatar>(); // Arraylist to hold all the enemies
		
		for(int i = 0; i < 25; i++)
		{
			EnemyAvatar enemy = new EnemyAvatar();
			enemies.add(enemy);
		}
		
		// Sets the bound for all enemies and adds them to the panel
		for(int i = 0; i < enemies.size(); i++)
		{
			super.add(enemies.get(i));
			int yLocation = (int)(Math.random()*600);
    		Dimension size4 = enemies.get(i).getPreferredSize();
    		enemies.get(i).setBounds(10, yLocation, size4.width, size4.height);
			enemies.get(i).setVisible(false);
			int randNum = (int)((Math.random()*40)-20);
			randoms.add(randNum);
		}
		
		numOfEnemies = EnemiesScrollbarPanel.getNumOfEnemies();
		
		// Instantiate the label to display if game is won or lost
		finalLabel = new JLabel("Game Over: You Lost", SwingConstants.CENTER);
		finalLabel.setFont(new Font("Serif", Font.BOLD, 40));
		Dimension size0 = finalLabel.getPreferredSize();
		finalLabel.setBounds(300, 250, size0.width, size0.height);
		finalLabel.setBackground(newBackgroundColor);
		finalLabel.setOpaque(true);
		finalLabel.setForeground(Color.WHITE);
		finalLabel.setVisible(false);
		super.add(finalLabel);
		
		
		// Component Listener to check if one enemies touches the avatar and changes the label to Game Over if it does
		for(int i = 0; i < enemies.size(); i ++)
		{
			EnemyAvatar temp = enemies.get(i);
			temp.addComponentListener(new ComponentAdapter() {
				public void componentMoved(ComponentEvent e) {					
					
					if(cAvatar == "Vi")
					{
		            	Rectangle bounds1 = temp.getBounds();
		            	Rectangle bounds2 = vi.getBounds();
		            	if (bounds1.intersects(bounds2)) {
		            		_timer.stop();
		            		
		            		showingTimer.cancel();
		            		showingTimer.purge();
		            		
		            		scoreTimer.cancel();
		            		scoreTimer.purge();
		            		finalLabel.setVisible(true);
		            	}
					}
					else if(cAvatar == "Jinx")
					{
		            	Rectangle bounds1 = temp.getBounds();
		            	Rectangle bounds2 = jinx.getBounds();
		            	if (bounds1.intersects(bounds2)) {
		            		_timer.stop();
		            		
		            		showingTimer.cancel();
		            		showingTimer.purge();
		            		
		            		scoreTimer.cancel();
		            		scoreTimer.purge();
		            		finalLabel.setVisible(true);
		            	}
					}
					else if(cAvatar == "Caitlyn")
					{
						Rectangle bounds1 = temp.getBounds();
		            	Rectangle bounds2 = caitlyn.getBounds();
		            	if (bounds1.intersects(bounds2)) {
		            		_timer.stop();
		            		
		            		showingTimer.cancel();
		            		showingTimer.purge();
		            		
		            		scoreTimer.cancel();
		            		scoreTimer.purge();
		            		finalLabel.setVisible(true);
		            	}
					}
					
	               
	            }
			});
		}
		
		
		
		
		// Starts timer for moving and showing the enemies
		_timer = new AnimationTimer(this);
		_timer.start();
		
		showingTimer = new Timer();
			
	}
	
	
	// Method to check if game is running
	public static Boolean getGameState()
	{
		return gameStarted;
	}
	
	public static void start()
	{
		// Method to implement the game if it never started before
		if(gameStarted == false)
		{
			
			
			gameStarted = true;
			numOfEnemies = EnemiesScrollbarPanel.getNumOfEnemies();
			difficulty = DifficultyPanel.getDif();
			
			// Checks the difficulty level and sets the time interval at which enemies are shown
			int dif = 0;
			if(difficulty == "Easy")
			{
				dif = 2000;
				dif_when_started = 2000;
			}
			else if(difficulty == "Normal")
			{
				dif = 1000;
				dif_when_started = 1000;
			}
			else
			{
				dif = 500;
				dif_when_started = 500;
			}
			
			// Shows the enemies at the time interval set by the difficulty level
			for(int i = 0; i < numOfEnemies; i++)
			{
				int index = i;
				Dimension size = enemies.get(i).getPreferredSize();
				TimerTask task = new TimerTask() {
					
		            public void run() {
		                enemies.get(index).setVisible(true);
		            }
		        };
		        
		        showingTimer.schedule(task, i*dif);
				
			}
				
		}
	
		else // This code takes place if the game is pause and the resumed
		{
			// Restarts the timer and creates a new timer for showing the remaining enemies 
			_timer.start();
			showingTimer = new Timer();
			
			
			int remaining = 0;
			for(int i = 0; i < numOfEnemies; i++)
			{
				if(enemies.get(i).getX() == 10)
				{
					remaining += 1;
				}
			}
			System.out.println(remaining);
			
		
			
			for(int i = numOfEnemies - remaining; i < numOfEnemies; i++)
			{
				int index = i;
				Dimension size = enemies.get(i).getPreferredSize();
				TimerTask task2 = new TimerTask() {
					
		            public void run() {
		                enemies.get(index).setVisible(true);
		            }
		        };
		        
		        showingTimer.schedule(task2, i*dif_when_started);
				
			}

			
		}
	}
	
	
	public static void stop()
	{
		// Stops all timers and therefore stops the enemies from moving and showing
		_timer.stop();
		
		
		showingTimer.cancel();
		showingTimer.purge();
		
	}
	
	public void move()
	{
		// Code for moving the enemies based on the difficulty level set
		Dimension size = enemies.get(0).getPreferredSize();
		
		
		for(int i = 0; i < numOfEnemies; i++)
		{
			if(difficulty == "Easy")
			{
				if(enemies.get(i).isVisible())
				{
					Rectangle bounds1 = enemies.get(i).getBounds();
					Rectangle bounds2 = super.getBounds();

	            	if (bounds1.getMinY() <= bounds2.getMinY()-60) 
	            	{
	            		randoms.set(i, -randoms.get(i));
	            		enemies.get(i).setBounds(enemies.get(i).getX()+15, enemies.get(i).getY()-randoms.get(i), size.width, size.height);
	            	}
	            	else if(bounds1.getMaxY() >= bounds2.getMaxY()-65)
	            	{
	            		randoms.set(i, -randoms.get(i));
	            		enemies.get(i).setBounds(enemies.get(i).getX()+15, enemies.get(i).getY()-randoms.get(i), size.width, size.height);
	            	}
	            	else
	            	{
	            		enemies.get(i).setBounds(enemies.get(i).getX()+15, enemies.get(i).getY()-randoms.get(i), size.width, size.height);
	            	}
						
				}
			}
			else if(difficulty == "Normal")
			{
				if(enemies.get(i).isVisible())
				{
					Rectangle bounds1 = enemies.get(i).getBounds();
					Rectangle bounds2 = super.getBounds();
	
	            	if (bounds1.getMinY() <= bounds2.getMinY()-60) 
	            	{
	            		randoms.set(i, -randoms.get(i));
	            		enemies.get(i).setBounds(enemies.get(i).getX()+25, enemies.get(i).getY()-randoms.get(i), size.width, size.height);
	            	}
	            	else if(bounds1.getMaxY() >= bounds2.getMaxY()-65)
	            	{
	            		randoms.set(i, -randoms.get(i));
	            		enemies.get(i).setBounds(enemies.get(i).getX()+25, enemies.get(i).getY()-randoms.get(i), size.width, size.height);
	            	}
	            	else
	            	{
	            		enemies.get(i).setBounds(enemies.get(i).getX()+25, enemies.get(i).getY()-randoms.get(i), size.width, size.height);
	            	}
				}
			}
			else
			{
				if(enemies.get(i).isVisible())
				{
					Rectangle bounds1 = enemies.get(i).getBounds();
					Rectangle bounds2 = super.getBounds();

	            	if (bounds1.getMinY() <= bounds2.getMinY()-60) 
	            	{
	            		randoms.set(i, -randoms.get(i));
	            		enemies.get(i).setBounds(enemies.get(i).getX()+35, enemies.get(i).getY()-randoms.get(i), size.width, size.height);
	            	}
	            	else if(bounds1.getMaxY() >= bounds2.getMaxY()-65)
	            	{
	            		randoms.set(i, -randoms.get(i));
	            		enemies.get(i).setBounds(enemies.get(i).getX()+35, enemies.get(i).getY()-randoms.get(i), size.width, size.height);
	            	}
	            	else
	            	{
	            		enemies.get(i).setBounds(enemies.get(i).getX()+35, enemies.get(i).getY()-randoms.get(i), size.width, size.height);
	            	}
				}
			}
			
		}
		
		
	}
	
	
	// Methods to show and hide the avatar objects
	public static void showVi()
	{
		vi.setVisible(true);
	}
	public static void showJinx()
	{
		jinx.setVisible(true);
	}
	public static void showCaitlyn()
	{
		caitlyn.setVisible(true);
	}
	
	public static void hideVi()
	{
		vi.setVisible(false);
	}
	public static void hideJinx()
	{
		jinx.setVisible(false);
	}
	public static void hideCaitlyn()
	{
		caitlyn.setVisible(false);
	}
	
	public static void setCurAvatar(String newAvatar)
	{
		cAvatar = newAvatar;
	}
	
	
}
