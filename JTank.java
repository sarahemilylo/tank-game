import java.awt.*;
import javax.swing.*;

public class JTank extends JPanel{
	// Properties
	int intTankLX = (int)(Math.random()*500) + 1; 
	int intTankRX = (int)(Math.random()*500) + 701;
	int intAngleL = 135;
	int intAngleR = 45;
	double dblBulletX = 0;
	double dblBulletY = 0;
	double dblBulletDeltaX = 0;
	double dblBulletDeltaY = 0;
	boolean blnBulletFlying = false;
	int intPowerL = 10;
	int intPowerR = 10;
	int intPlayerTurn = 1;
	int intFired = 0;
	String strWinner = "";
	boolean blnGameOver = false;
	
	// Methods
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		// Sky
		g.setColor(new Color(135, 206, 235));
		g.fillRect(0, 0, 1280, 720);

		// Sun
		g.setColor(Color.YELLOW);
		g.fillOval(1050, 60, 90, 90);

		// Clouds
		g.setColor(Color.WHITE);
		g.fillRect(150, 90, 120, 35);
		g.fillRect(180, 65, 70, 35);

		g.fillRect(500, 130, 140, 35);
		g.fillRect(535, 105, 70, 35);

		// Grass
		g.setColor(new Color(60, 150, 60));
		g.fillRect(0, 600, 1280, 200);

		// Grass Tips
		g.setColor(new Color(40, 180, 40));
		g.fillRect(0, 600, 1280, 20);
		
		// Left Tank
		g.setColor(Color.RED);
		g.fillRect(intTankLX, 565, 90, 35);
		g.setColor(new Color(150, 0, 0));
		g.fillRect(intTankLX + 15, 545, 60, 25);
		
		// Left Tank Turret
		g.setColor(Color.BLACK);
		int intLeftEndX = (intTankLX + 65) - (int)(Math.cos(Math.toRadians(intAngleL)) * 50); 
		int intLeftEndY = 555 - (int)(Math.sin(Math.toRadians(intAngleL)) * 50);
		g2.setStroke(new BasicStroke(7));
		g2.drawLine((intTankLX + 65), 555, intLeftEndX, intLeftEndY);
		g2.setStroke(new BasicStroke(1));
		
		// Right Tank
		g.setColor(Color.BLUE);
		g.fillRect(intTankRX, 565, 90, 35);
		g.setColor(new Color(0, 0, 150));
		g.fillRect(intTankRX + 15, 545, 60, 25);
		
		// Right Tank Turret
		g.setColor(Color.BLACK);
		int intRightEndX = (intTankRX+15) - (int)(Math.cos(Math.toRadians(intAngleR)) * 50); 
		int intRightEndY = 555 - (int)(Math.sin(Math.toRadians(intAngleR)) * 50);
		g2.setStroke(new BasicStroke(7));
		g2.drawLine((intTankRX + 15), 555, intRightEndX, intRightEndY);
		g2.setStroke(new BasicStroke(1));

		// Bullet
		if(blnBulletFlying == true){
			g.setColor(Color.BLACK);
			g.fillOval((int)dblBulletX, (int)dblBulletY, 10, 10);
		}
		
		// Power
		g.setFont(new Font("Arial", Font.BOLD, 36));
		g.drawString("Player 1 Power: " + intPowerL, 50, 75);
		g.drawString("Player 2 Power: " + intPowerR, 920, 75);
		
		// Turn & Win
		if(blnGameOver == false){
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("Player " + intPlayerTurn + "'s Turn", 550, 215);
		}else{
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD, 60));
			g.drawString(strWinner, 395, 300);
		}
	}
	
	// Constructor
	public JTank(){
		super();
	}
	
	
}
