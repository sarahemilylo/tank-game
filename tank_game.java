// Tank Game

// Import
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class tank_game implements ActionListener, KeyListener{
	// Properties
	JFrame theFrame = new JFrame("Tank Game");
	JTank thePanel = new JTank();
	Timer theTimer = new Timer(1000/60, this);
	
	// Methods
	public void actionPerformed(ActionEvent evt){	
		// Flying Bullet	
		if(thePanel.blnBulletFlying == true){
			thePanel.dblBulletX += thePanel.dblBulletDeltaX;
			thePanel.dblBulletY += thePanel.dblBulletDeltaY;
			thePanel.dblBulletDeltaY += 0.2;
			
			if(thePanel.dblBulletY > 600 || thePanel.dblBulletX > 1280 || thePanel.dblBulletX < 0 || thePanel.dblBulletY < 0){
				thePanel.blnBulletFlying = false;
			}
		}
		
		// Check if Left Wins
		if(thePanel.intFired == 1 && thePanel.dblBulletX >= thePanel.intTankRX && thePanel.dblBulletX <= (thePanel.intTankRX + 90) && thePanel.dblBulletY >= 545 && thePanel.dblBulletY <= 600){
			thePanel.strWinner = "Player 1 Wins!";
			thePanel.blnGameOver = true;
			thePanel.blnBulletFlying = false;
			theTimer.stop();
		}

		// Check if Right Wins
		if(thePanel.intFired == 2 && thePanel.dblBulletX >= thePanel.intTankLX && thePanel.dblBulletX <= (thePanel.intTankLX + 90) && thePanel.dblBulletY >= 545 && thePanel.dblBulletY <= 600){
			thePanel.strWinner = "Player 2 Wins!";
			thePanel.blnGameOver = true;
			thePanel.blnBulletFlying = false;
			theTimer.stop();
		}
		
        thePanel.repaint();
	}
	
	public void keyReleased(KeyEvent evt){}
	public void keyPressed(KeyEvent evt){
		if(thePanel.blnGameOver == false){
			// LEFT TANK
			if(thePanel.intPlayerTurn == 1){
				// Move Turret Up
				if(evt.getKeyChar() == 'w'){
					thePanel.intAngleL -= 2;
				}
				
				// Move Turret Down
				else if(evt.getKeyChar() == 's'){
					thePanel.intAngleL += 2;
				}
				
				// Increase Power
				else if(evt.getKeyChar() == 'a'){
					if(thePanel.intPowerL < 20){
						thePanel.intPowerL += 2;
					}
				}
				
				// Decrease Power
				else if(evt.getKeyChar() == 'd'){
					if(thePanel.intPowerL > 2){
						thePanel.intPowerL -= 2;
					}
				}
				
				// Launch Bullet
				else if(evt.getKeyChar() == 'q'){
					if(thePanel.blnBulletFlying == false){
						thePanel.dblBulletX = thePanel.intTankLX + 65;
						thePanel.dblBulletY = 555;

						thePanel.dblBulletDeltaX = -Math.cos(Math.toRadians(thePanel.intAngleL)) * thePanel.intPowerL;
						thePanel.dblBulletDeltaY = -Math.sin(Math.toRadians(thePanel.intAngleL)) * thePanel.intPowerL;

						thePanel.blnBulletFlying = true;
					}
					thePanel.intPlayerTurn = 2;
					thePanel.intFired = 1;
				}
				
				// Limit Tank Angle
				if(thePanel.intAngleL < 90){
					thePanel.intAngleL = 90;
				}
				if(thePanel.intAngleL > 160){
					thePanel.intAngleL = 160;
				}
			}
			
			// RIGHT TANK
			if(thePanel.intPlayerTurn == 2){
				// Move Turret Up
				if(evt.getKeyCode() == KeyEvent.VK_UP){
					thePanel.intAngleR += 5;
				}
				
				// Move Turret Down
				else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
					thePanel.intAngleR -= 5;
				}
				
				// Increase Power
				else if(evt.getKeyCode() == KeyEvent.VK_LEFT){
					if(thePanel.intPowerR < 20){
						thePanel.intPowerR += 2;
					}
				}
				
				// Decrease Power 
				else if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
					if(thePanel.intPowerR > 2){
						thePanel.intPowerR -= 2;
					}
				}
				
				// Launch Bullet
				else if(evt.getKeyChar() == '/'){
					if(thePanel.blnBulletFlying == false){
						thePanel.dblBulletX = thePanel.intTankRX + 15;
						thePanel.dblBulletY = 555;

						thePanel.dblBulletDeltaX = -Math.cos(Math.toRadians(thePanel.intAngleR)) * thePanel.intPowerR;
						thePanel.dblBulletDeltaY = -Math.sin(Math.toRadians(thePanel.intAngleR)) * thePanel.intPowerR;

						thePanel.blnBulletFlying = true;
					}
					thePanel.intPlayerTurn = 1;
					thePanel.intFired = 2;
				}
				
				// Limit Tank Angle
				if(thePanel.intAngleR < 20){
					thePanel.intAngleR = 20;
				}
				if(thePanel.intAngleR > 90){
					thePanel.intAngleR = 90;
				}
			}
			// Repaint
			thePanel.repaint();
		}
	}
	public void keyTyped(KeyEvent evt){}
	
	// Constructor
	public tank_game(){
		// Set Panel
		thePanel.setLayout(null);
		thePanel.setPreferredSize(new Dimension(1280, 720));

		// Set Frame
		theFrame.setContentPane(thePanel);
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.pack();
		theFrame.setVisible(true);
		theFrame.addKeyListener(this);
		
		// Start Timer
		theTimer.start();
	}


	// Main Program
	public static void main(String[] args){
		new tank_game();
	}
}
