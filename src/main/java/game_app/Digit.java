/**@Refactor
 * removed unused field and imported packages
 * act(long now) method pulled to superclass
 * self encapsulating field to avoid direct access of field even within own class
 * create setter and getter for encapsulated field
 * constructor is in default access
 */
package game_app;

import javafx.scene.image.Image;

public class Digit extends Sprites{

	private Image im1;
	
//*****************************************************CONTROLLER**************************************************************
	Digit(int n, int dim, int x, int y) {
		setIm1(n,dim);
		setImage(getIm1());
		setX(x);
		setY(y);
	}
	
	//**************************************************MODEL****************************************************************
	public void setIm1(int num, int size) {
		im1 = new Image("file:src/main/resources/"+num+".png", size, size, true, true);
	}
	
	public Image getIm1() {
		return im1;
	}
	
}
