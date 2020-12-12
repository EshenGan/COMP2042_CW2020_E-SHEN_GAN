/**@Refactor
 * remove all unused import packages
 * rename Actor.java to Sprites.java 
 * rename getWorld() to getGamePane()
 * pull up act() method from Home.java,BackgroundImage.java ,Digit.java
 */
package game_app;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import java.util.ArrayList;


public abstract class Sprites extends ImageView{

	

//***********************************************************************CONTROLLER*********************************************************************
    public void move(double dx, double dy) { //view
        setX(getX() + dx);
        setY(getY() + dy);
    }
 
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
