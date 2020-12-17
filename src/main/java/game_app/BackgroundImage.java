package game_app;

import javafx.scene.image.Image;
/**<b>REFACTOR</b>:
 * <p>. act(long now) method pulled to superclass<br>
 * . constructor is in default access</p>
 */
public class BackgroundImage extends Sprites{

//**************************************************CONTROLLER****************************************************************

	/**Constructor for BackgroundImage class
	 * @param imageLink as image directory
	 */ 
	BackgroundImage(String imageLink) { 
		setImage(new Image(imageLink,600,800, true, true));
		
	}

}
