package game_app;

import javafx.scene.image.Image;

public class End extends Sprites{
	/**@Refactor
	 * encapsulate field and created setter and getter method
	 * act(long now) method pulled to superclass
	 */
	private boolean activated = false;
	
//**************************************************CONTROLLER****************************************************************
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/main/resources/End.png", 60, 60, true, true));
	}
	
//**************************************************MODEL****************************************************************
	public void setEnd() {
		setImage(new Image("file:src/main/resources/FrogEnd.png", 60, 60, true, true));
		setActivated(true);
	}
	
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	

}
