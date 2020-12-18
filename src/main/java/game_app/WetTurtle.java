package game_app;

import javafx.scene.image.Image;

/**<b>REFACTOR</b>:
 * <p>. self encapsulating field to avoid direct access of field even within own class<br>
 * . create setter and getter for encapsulated field or objects<br>
 * . remove unused field and unused import packages<br>
 * . constructor in default access</p>
 */
public class WetTurtle extends Sprites{

	private Image turtle1;
	private Image turtle2;
	private Image turtle3;
	private Image turtle4;
	private Image turtle5;
	private int speed;
	private boolean sunk = false;
	private int dir;
	
//*****************************CONTROLLER*************************************
	/**
	 *? move according to speed set<br> 
	 *? reset x coordinate to -200 if more than 600 while moving to right<br>
	 *? reset x coordinate to 600 if less than -75 while moving to left<br>
	 * <b>REFACTOR</b>:
	 * consolidate duplicate conditional fragments for setSunk(false)<br>
	 * <b>EXTENSION</b>:<br>
	 * ? added animation for turtles to swim in left to right direction<br>
	 * ? original code only has right to left animation
	 */
	public void act(long now) {
				if(now/900000000 %4 != 3) {
					if (now/900000000  % 4 ==0) {
						setImage(getTurtle2());			
					}
					else if (now/900000000 % 4 == 1) {
						if(getDir() == 1) { // LR
							setImage(getTurtle5());
						}
						else {
							setImage(getTurtle1());
						}	
					}
					else if (now/900000000 %4 == 2) {
						setImage(getTurtle3());				
					}
					setSunk(false);	
				}
				else if (now/900000000 %4 == 3) {
					setImage(getTurtle4());
					setSunk(true);		
				}
				move(getSpeed() , 0);
				
				if (getX() > 600 && getSpeed()>0)
					setX(-200);
				if (getX() < -75 && getSpeed()<0)
					setX(600);
	}

	/**? Construct wet turtle sprites<br>
	 * ? <b>EXTENSION</b>: added new parameter dir to determine movement direction
	 * @param xpos : x coordinate to put sprite
	 * @param ypos : y coordinate to put sprite
	 * @param s    : speed for sprite
	 * @param w    : width for sprite
	 * @param h    : height for sprite
	 * @param dir  : direction in which sprite moves
	 */
	WetTurtle(int xpos, int ypos, int s, int w, int h,int dir) {
		setDir(dir);
		if(getDir() == 1) { // 1= LR
			setTurtlesLR(w,h);
		}
		else { // not 1 = RL
			setTurtlesRL(w,h);
		}
		setX(xpos);
		setY(ypos);
		setSpeed(s);
		setImage(getTurtle2());
	}
	
//*****************************MODEL*************************************
	/** <b>EXTENSION</b>:
	 * method to determine movement direction of sprite
	 * @return boolean : condition flag to determine wet turtles moving to left
	 */
	public boolean moveLeft() { 
		return getSpeed() < 0;
	}	

	public void setSpeed(int sp) {
		speed = sp;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSunk(boolean b) {
		sunk = b;
	}
	
	public boolean isSunk() {
		return sunk;
	}
	
	/**set up wet turtles image for right to left animation
	 * @param w0 : width of image 
	 * @param h0 : height of image
	 */
	public void setTurtlesRL(int w0, int h0){
		turtle1 = new Image("file:src/main/resources/TurtleAnimation1.png", w0, h0, true, true);
		turtle2 = new Image("file:src/main/resources/TurtleAnimation2Wet.png", w0, h0, true, true);
		turtle3 = new Image("file:src/main/resources/TurtleAnimation3Wet.png", w0, h0, true, true);
		turtle4 = new Image("file:src/main/resources/TurtleAnimation4Wet.png", w0, h0, true, true);
	}

	/**set up wet turtles image for left to right animation
	 * @param w0 : width of image
	 * @param h0 : height of image
	 */
	public void setTurtlesLR(int w0, int h0){
		turtle5 = new Image("file:src/main/resources/TurtleAnimation1LR.png", w0, h0, true, true);
		turtle2 = new Image("file:src/main/resources/TurtleAnimation2Wet.png", w0, h0, true, true);
		turtle3 = new Image("file:src/main/resources/TurtleAnimation3Wet.png", w0, h0, true, true);
		turtle4 = new Image("file:src/main/resources/TurtleAnimation4Wet.png", w0, h0, true, true);
	}
	
	public Image getTurtle1(){
		return turtle1; 
	}
	
	public Image getTurtle2(){
		return turtle2;
	}

	public Image getTurtle3(){
		return turtle3;
	}
	
	public Image getTurtle4(){
		return turtle4;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public Image getTurtle5() {
		return turtle5;
	}
}
