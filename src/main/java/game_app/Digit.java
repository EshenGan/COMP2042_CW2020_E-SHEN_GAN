
package game_app;

import javafx.scene.image.Image;
/**<b>REFACTOR</b>:
 * <p>. Removed unused field and imported packages<br>
 * . act(long now) method pulled to superclass<br>
 * . Self encapsulating field to avoid direct access of field even within own class,
 * create setter and getter for encapsulated field<br>
 * . Constructor is in default access</p>
 */
public class Digit extends Sprites{

	private Image im1;
	
//*****************************************************CONTROLLER**************************************************************
	/**Construct score sprite
	 *  @param n   : digit to display as image
	 * @param dim  : height and width of digit image
	 * @param x    : x coordinate of digit 
	 * @param y    : y coordinate of digit
	 */
	Digit(int n, int dim, int x, int y) {
		setIm1(n,dim);
		setImage(getIm1());
		setX(x);
		setY(y);
	}
	
//**************************************************MODEL****************************************************************
	/** @param num  : digit to be displayed
	 * @param size : width and height of digit image
	 */
	public void setIm1(int num, int size) {
		im1 = new Image("file:src/main/resources/"+num+".png", size, size, true, true);
	}
	
	/** @return im1 : im1 object of type Image
	 */
	public Image getIm1() {
		return im1;
	}
	
}
