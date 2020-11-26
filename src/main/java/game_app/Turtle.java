package game_app;

import javafx.scene.image.Image;

public class Turtle extends Sprites{
	/**@Refactor
	 * self encapsulating field to avoid direct access of field 
	 * even within own class
	 * create setter and getter for encapsulated field
	 * remove unused field 
	 */
	private Image turtle1;
	private Image turtle2;
	private Image turtle3;
	private int speed;
	
//*****************************VIEW*************************************
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(getTurtle2());
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(getTurtle1());
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(getTurtle3());
					
				}
			
		move(getSpeed() , 0);
		if (getX() > 600 && getSpeed()>0)
			setX(-200);
		if (getX() < -75 && getSpeed()<0)
			setX(600);
	}
	
//*****************************CONTROLLER*************************************
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		setTurtles(w,h);
		setX(xpos);
		setY(ypos);
		setSpeed(s);
		setImage(turtle2);
	}
	
//*****************************MODEL**************************************
	public void setSpeed(int sp) {
		speed = sp;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setTurtles(int w0, int h0){
		turtle1 = new Image("file:src/main/resources/TurtleAnimation1.png", w0, h0, true, true);
		turtle2 = new Image("file:src/main/resources/TurtleAnimation2.png", w0, h0, true, true);
		turtle3 = new Image("file:src/main/resources/TurtleAnimation3.png", w0, h0, true, true);
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
	
}
