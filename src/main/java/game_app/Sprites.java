package game_app;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import java.util.ArrayList;

/**<b>REFACTOR</b>:
 * <p>. Rename Actor.java to Sprites.java<br>
 * . Rename getWorld() to getGamePane()<br>
 * . Pull up act() method from Home.java,BackgroundImage.java ,Digit.java</p>
 */
public abstract class Sprites extends ImageView{

	

//***********************************************************************CONTROLLER*********************************************************************
    /**
     * @param dx : movement of sprite along horizontal axis
     * @param dy : movement of sprite along vertical axis 
     */
	public void move(double dx, double dy) { //view
        setX(getX() + dx);
        setY(getY() + dy);
    }
 
    /**some subclass act method will override this method
     * @param now : parameter of type long
     */
    public void act(long now) {} //view

    public <S extends Sprites> java.util.List<S> getIntersectingObjects(java.lang.Class<S> cls){ //controller
        ArrayList<S> someArray = new ArrayList<S>();
        for (S sprite: getGamePane().getObjects(cls)) {
            if (sprite != this && sprite.intersects(this.getBoundsInLocal())) {
                someArray.add(sprite);
            }
        }
        return someArray;
    }
    
    public  void manageInput(InputEvent e) { // controller
        
    }

    public <S extends Sprites> S getOneIntersectingObject(java.lang.Class<S> cls) { //controller
        ArrayList<S> someArray = new ArrayList<S>();
        for (S sprite: getGamePane().getObjects(cls)) {
            if (sprite != this && sprite.intersects(this.getBoundsInLocal())) {
                someArray.add(sprite);
                break;
            }
        }
        return someArray.get(0);
    }

//***********************************************************************MODEL**********************************************************************
    public GamePane getGamePane() { // model
        return (GamePane) getParent();
    }

    public double getWidth() { //model
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() { //model
        return this.getBoundsInLocal().getHeight();
    }
}
