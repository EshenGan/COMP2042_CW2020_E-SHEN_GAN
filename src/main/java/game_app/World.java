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
							List<Sprites> myActors = getObjects(Sprites.class);
							for (Sprites anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					}); 	
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Sprites> myActors = getObjects(Sprites.class);
							for (Sprites anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
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
    public void add(Sprites actor) {//model
        getChildren().add(actor);
    }

    public void remove(Sprites actor) {//model
        getChildren().remove(actor);
    }

    /** @refactor 
     * remove assignments to parameters 
     *  assigned (A)n to variable a of type A before passing a to .add()
     *  instead of someArray.add((A)n);
     *  added try and catch
     */
    public <A extends Sprites> List<A> getObjects(Class<A> cls) {//model
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
            	try {
                	A a = (A)n;
    				someArray.add(a);
            	}
            	catch(Exception e) {
            		System.out.println(e);
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
                List<Sprites> actors = getObjects(Sprites.class);
                
                for (Sprites anActor: actors) {
                	anActor.act(now);
                }
      
            }
        };
    }
    
    public AnimationTimer getTimer() {//model
    	return timer;
    }
}
