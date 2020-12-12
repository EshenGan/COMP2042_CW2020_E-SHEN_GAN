/**@Refactor
 * rename End class to Home class, setEnd() to reachHome()
 * encapsulate field and created setter and getter method
 * act(long now) method pulled to superclass Sprites
 * constructor is in default access
 */
package game_app;

import javafx.scene.image.Image;

public class Home extends Sprites{
	private boolean activated = false;
	
//**************************************************CONTROLLER****************************************************************
	Home(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/main/resources/End.png", 60, 60, true, true));
	}
	

	public void reachHome() {
		setImage(new Image("file:src/main/resources/FrogEnd.png", 60, 60, true, true));
		setActivated(true);
	}
//**************************************************MODEL****************************************************************	
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	

}
