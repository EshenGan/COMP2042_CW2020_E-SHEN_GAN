/**@Remove
 * remove all unused imports
 */
package game_app;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;



public abstract class World extends Pane {
	/**@Refactor
	 * self encapsulating field to avoid direct access of field  even within own class
	 * create setter and getter for encapsulated field
	 */
    private AnimationTimer timer;

  //****************************************************VIEW***********************************************************
    //public abstract void act(long now);
    /** @Refactor
     * pull up method from subclass MyStage
     */
    public void act(long now) {} //view

//****************************************************CONTROLLER***********************************************************
    public World() { //controller
    	
    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Sprites> mySprites = getObjects(Sprites.class);
							for (Sprites aSprite: mySprites) {
								if (aSprite.getOnKeyReleased() != null) {
									aSprite.getOnKeyReleased().handle(event);
								}
							}
						}
						
					}); 	
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Sprites> mySprites = getObjects(Sprites.class);
							for (Sprites aSprite: mySprites) {
								if (aSprite.getOnKeyPressed() != null) {
									aSprite.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
			}
    		
		});
    }

    public void start() { //controller
    	createTimer();
        getTimer().start();
    }

    public void stop() {//controller
        getTimer().stop();
    }
    
  //****************************************************MODEL***********************************************************
    public void add(Sprites sprite) {//model
        getChildren().add(sprite);
    }

    public void remove(Sprites sprite) {//model
        getChildren().remove(sprite);
    }

    /** @refactor 
     * remove assignments to parameters 
     *  assigned (A)n to variable a of type A before passing a to .add()
     *  instead of someArray.add((A)n);
     *  added try and catch
     */
    public <S extends Sprites> List<S> getObjects(Class<S> cls) {//model
        ArrayList<S> someArray = new ArrayList<S>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
            	try {
                	@SuppressWarnings("unchecked")
					S s = (S)n;
    				someArray.add(s);
            	}
            	catch(Exception e) {
            		e.getStackTrace();
            	}

            	
            }
        }
        return someArray;
    }
    
    public void createTimer() {//model
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Sprites> sprites = getObjects(Sprites.class);
                
                for (Sprites aSprite: sprites) {
                	aSprite.act(now);
                }
      
            }
        };
    }
    
    public AnimationTimer getTimer() {//model
    	return timer;
    }
}
