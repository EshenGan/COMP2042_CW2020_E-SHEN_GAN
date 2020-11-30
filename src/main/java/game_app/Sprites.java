/**@Remove
 * @Rename
 * remove all unused imports
 * rename Actor.java to Sprites.java 
 */
package game_app;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import java.util.ArrayList;


public abstract class Sprites extends ImageView{

	

	//***********************************************************************VIEW*********************************************************************
    public void move(double dx, double dy) { //view
        setX(getX() + dx);
        setY(getY() + dy);
    }
    /**@Refactor
     * pull up method from End.java,BackgroundImage.java ,Digit.java
     */
        public void act(long now) {} //view

//***********************************************************************CONTROLLER*****************************************************************        
    public <S extends Sprites> java.util.List<S> getIntersectingObjects(java.lang.Class<S> cls){ //controller
        ArrayList<S> someArray = new ArrayList<S>();
        for (S sprite: getWorld().getObjects(cls)) {
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
        for (S sprite: getWorld().getObjects(cls)) {
            if (sprite != this && sprite.intersects(this.getBoundsInLocal())) {
                someArray.add(sprite);
                break;
            }
        }
        return someArray.get(0);
    }

//***********************************************************************MODEL**********************************************************************
    public World getWorld() { // model
        return (World) getParent();
    }

    public double getWidth() { //model
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() { //model
        return this.getBoundsInLocal().getHeight();
    }
}
