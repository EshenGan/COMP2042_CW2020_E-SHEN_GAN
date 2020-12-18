package game_app;

import javafx.scene.image.Image;

/**<b>EXTENSION</b>:
 * new class to act as obstacles, similar to vehicles
 */
public class Snake extends Sprites{

	private int speed;
	private Image s1;
	private Image s2;
	private Image s3;
	private Image s4;
	private int direction;
	
//*****************************CONTROLLER******************************************
	/** movement and animation of snake in both direction
	 */
	public void act(long now) {
		if(getDirection() == 1) {
			if (now/900000000  % 4 ==0) {
				setImage(gets1());	
			}
			else if (now/900000000 % 4 == 1) {
				setImage(gets2());
			}
			else if (now/900000000 % 4 == 2) {
				setImage(gets1());
			}
			else if (now/900000000 % 4 == 3) {
				setImage(gets2());
			}			
		}
		else {
			if (now/900000000  % 4 ==0) {
				setImage(getS3());	
			}
			else if (now/900000000 % 4 == 1) {
				setImage(getS4());
			}
			else if (now/900000000 % 4 == 2) {
				setImage(getS3());
			}
			else if (now/900000000 % 4 == 3) {
				setImage(getS4());
			}			
		}

		move(getSpeed() , 0);
		if (getX() > 600 && getSpeed()>0)
			setX(-200);
		if (getX() < -50 && getSpeed()<0)
			setX(600);
	}
	
	/**Construct snake sprite
	 * @param xpos       : x coordinate to put snake 
	 * @param ypos       : y coordinate  to put snake
	 * @param s          : speed value for snake
	 * @param w          : width of snake sprite
	 * @param h          : height of snake sprite
	 * @param direction  : direction of which snake sprite move
	 */
	Snake(int xpos, int ypos, int s, int w, int h,int direction) {
		setDirection(direction); //1== LR 
		if(getDirection() == 1) {
			setSnakesLR(w,h);
			setImage(gets1());
		}
		else { //RL
			setSnakesRL(w,h);
			setImage(getS3());
		}
		setX(xpos);
		setY(ypos);
		setSpeed(s);
	}
	
//*****************************MODEL***************************************
	public int getSpeed() { 
		return speed;
	}
	
	public void setSpeed(int sp) {
		speed = sp;
	}

	/**set up snake objects for movement animation from left to right
	 * @param ws : width of snake image
	 * @param hs : height of snake image
	 */
	public void setSnakesLR(int ws, int hs){
		s1 = new Image("file:src/main/resources/snake1new.png", ws, hs, true, true);
		s2 = new Image("file:src/main/resources/snake2new.png", ws, hs, true, true);
	}
	
	/**set up snake objects for movement animation from right to left
	 * @param ws : width of snake image
	 * @param hs : height of snake image
	 */
	public void setSnakesRL(int ws, int hs){
		s3 = new Image("file:src/main/resources/snake1RLnew.png", ws, hs, true, true);
		s4 = new Image("file:src/main/resources/snake2RLnew.png", ws, hs, true, true);
	}
	
	public Image gets1(){
		return s1; 
	}
	
	public Image gets2(){
		return s2;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public Image getS3() {
		return s3;
	}

	public void setS3(Image s3) {
		this.s3 = s3;
	}

	public Image getS4() {
		return s4;
	}

	public void setS4(Image s4) {
		this.s4 = s4;
	}
}
