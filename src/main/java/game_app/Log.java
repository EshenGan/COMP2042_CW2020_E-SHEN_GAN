
package game_app;

import javafx.scene.image.Image;
/**<b>REFACTOR</b>:
 * <p>. Self encapsulating field to avoid direct access of field even within own class,
 * create setter and getter for encapsulated field<br>
 * . Constructor in default access</p>
 */
public class Log extends Sprites {
	private double speed;
	
//*****************************CONTROLLER*******************************************
	/**
	 *?  move according to speed set<br> 
	 *? reset x coordinate to -180 if more than 600 while moving to right<br>
	 *? reset x coordinate to 700 if less than -300 while moving to left
	 */
	public void act(long now) { 
		move(getSpeed() , 0);
		if (getX()>600 && getSpeed()>0)
			setX(-180);
		if (getX()<-300 && getSpeed()<0)
			setX(700);
	}
	/**Construct log sprite in any game scenes
	 * @param imageLink : image directory for log
	 * @param size      : height and width of image
	 * @param xpos      : x coordinate for log
	 * @param ypos      : y coordinate for log
	 * @param s         : speed value of log
	 */
	Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		setSpeed(s);
		
	}
	
//*****************************MODEL********************************************

	/**Rename getLeft() to moveLeft()
	 *  @return boolean : condition flag to determine log moving to left
	 */
	public boolean moveLeft() { 
		return getSpeed() < 0;
	}
	
	
	/**@return speed object of type double
	 */
	public double getSpeed() { 
		return speed;
	}
	
	/**@param sp : object of type double instantiated
	 */
	public void setSpeed(double sp) { 
		speed = sp;
	}
}
