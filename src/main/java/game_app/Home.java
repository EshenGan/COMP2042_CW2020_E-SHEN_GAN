package game_app;

import javafx.scene.image.Image;

/**<b>REFACTOR</b>:
 * <p>. Rename End.java to Home.java<br>
 * . Encapsulate field and created setter and getter method<br>
 * . act(long now) method pulled to superclass Sprites<br>
 * . Constructor is in default access</p>
 */
public class Home extends Sprites{
	private boolean activated = false;
	
//**************************************************CONTROLLER****************************************************************
	Home(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/main/resources/End.png", 60, 60, true, true));
	}
	
	/** Rename from setEnd() to reachHome()
	 */
	public void reachHome() {
		setImage(new Image("file:src/main/resources/FrogEnd.png", 60, 60, true, true));
		setActivated(true);
	}
//**************************************************MODEL****************************************************************	
	/**@return activated object of type boolean
	 */
	public boolean isActivated() {
		return activated;
	}
	
	/**@param activated : boolean object instantiated
	 */
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	

}
