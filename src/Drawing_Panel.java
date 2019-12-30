
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Drawing_Panel extends JPanel{	
		protected int angle, speed, time;		
		public Drawing_Panel(int angle, int speed, int time) {
			this.angle = angle;
			this.speed = speed;
			this.time = time;			
			this.setBackground(Color.BLACK); 
		}		
		public int getangle() {
			return angle;
		}
		public int getspeed() {
			return speed;
		}
		public int gettime() {
			return time;
		}
		public void setangle(int newangle) {
			this.angle = newangle;
		}
		public void setspeed(int newspeed) {
			this.speed = newspeed;
		}
		public void settime(int newtime) {
			this.time = newtime;
		}
		
		public void erase() {
			repaint();
		}

		public void drawPath(int type, Color color1, Color color2, Color color3, int size){			
			int finalType = type;
			
			Graphics g = this.getGraphics();
	        g.setColor(color1); //dots are drawn in color1 for all firework types
	        
			double angleRadians = this.getangle()/(180/Math.PI); 
			double yComponent = Math.sin(angleRadians)*this.getspeed();
			double xComponent = Math.cos(angleRadians)*this.getspeed();			
			double finalDistance = (this.gettime()*this.getspeed())/20; //calculating the x distance at which the firework will explode
			double[] timeInterval = new double[(int) finalDistance]; //time intervals are related to the distance 
			int currentYPos;
			/*draws ovals at each time interval using physics calculations for x and y positions at said time
			 * d = rt t = d/r
			 * finalYPos and finalXPos is where the actual explosion is drawn (subtract 5 because that is half the size of the dots - makes it look nicer)
			 *
			 * */
			for (int i = 0; i< finalDistance; i++) { 
				timeInterval[i] = i/xComponent; 
				currentYPos = (int) ((.5*(-9.8)*Math.pow(timeInterval[i], 2) + yComponent*timeInterval[i])*this.getHeight()/16);
				g.fillOval((int) (xComponent*timeInterval[i]*(this.getWidth()/25)), this.getHeight()-currentYPos, 10, 10);
			}
			int finalYPos = (this.getHeight() - (int) ((.5*(-9.8)*Math.pow(timeInterval[(int) (finalDistance-1)], 2) + yComponent*timeInterval[(int) (finalDistance-1)])*this.getHeight()/16))+5;
			int finalXPos = ((int) (finalDistance-1)*(this.getWidth()/25))+5;

			if (finalType == 1) {
				drawType1(finalXPos, finalYPos, color1);
			}else if (finalType == 2) {
				drawType2(finalXPos, finalYPos, color1, color2,color3,size);
			}else if (finalType == 3) {
				drawType3(finalXPos,finalYPos, color1,color2);
			}
		}
		
		public int calculateYPoint(int xPoint, int step, int y) {			
			int yPoint = (int) (1*Math.pow((xPoint-step), 2))+y;	
			return yPoint;
		}
		public void drawType1(int x, int y, Color color1) {
			Graphics g = this.getGraphics();
			g.setColor(color1);
			for (int i = -16; i<=16; i++) {
				g.fillOval(i+x,calculateYPoint(i+x,x, y),6,14);
			}
		}
				
		public void drawType2(int x, int y, Color color1, Color color2, Color color3, int fireWorkWidth) {
			Graphics g = this.getGraphics();
	        int circleDimension = 20; 
			for (int i = 0; i<8; i++) { //8 circles
				if (i == 0) { //changes color based on the value of i
					g.setColor(color1);
				}else if (i== 1) {
					g.setColor(color2);
				}else if (i== 2) {
					g.setColor(color3);
				}else if (i== 3) {
					g.setColor(color1);
				}else if (i== 4) {
					g.setColor(color2);
				}else if (i== 5) {
					g.setColor(color3);
				}
				else if (i== 6) {
					g.setColor(color1);
				}else if (i== 7) {
					g.setColor(color2);
				}else {
					g.setColor(Color.GRAY);
				}
				//draws the oval based on circle dimension, calculations are to center on the center of the screen
			g.drawOval((x-circleDimension/2),(y-circleDimension/2),circleDimension,circleDimension);
			circleDimension += fireWorkWidth;
			}
		}		
		public void drawType3(int x, int y, Color color1, Color color2) {
			Graphics g = this.getGraphics();
			g.setColor(color2);
			for (int w = -20; w<=20; w++) {
				g.fillOval(w+x+27,(calculateYPoint2(w+x,x, y)/16),6,14);
			}
			g.setColor(color1);
			for(int r = 1; r<3; r++) {
				for (int z = -10; z<=10; z++) {
					if (r == 1) {
						g.fillOval(z+x+8,calculateYPoint2(z+x,x, y+40),6,14);
					}else {
						g.fillOval(z+x+50,calculateYPoint2(z+x,x, y+40),6,14);
					}
				}
			}
			g.setColor(color2);
			for (int u = 0; u<4; u++) {
				for (int i = -15; i<=15; i++) {
					g.fillOval(i+x+(u*20),calculateYPoint2(i+x,x, y+150),6,14);
				}
			}
		}
		public int calculateYPoint2(int xPoint, int step, int yDist) {			
			int yPoint = (int) (Math.pow((xPoint-step), 2))+yDist;
			return yPoint;
		}
		
		
}

