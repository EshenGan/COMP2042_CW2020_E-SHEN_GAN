/**@Refactor
 * act(long now) method pulled to superclass
 * constructor is in default access
 */
package game_app;

import javafx.scene.image.Image;

public class BackgroundImage extends Sprites{

//**************************************************CONTROLLER****************************************************************
	 BackgroundImage(String imageLink) { 
		setImage(new Image(imageLink,600,800, true, true));
		
	}

}
