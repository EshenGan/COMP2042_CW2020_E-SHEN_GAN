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
    public <A extends Sprites> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){ //controller
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    public  void manageInput(InputEvent e) { // controller
        
    }

    public <A extends Sprites> A getOneIntersectingObject(java.lang.Class<A> cls) { //controller
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
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
