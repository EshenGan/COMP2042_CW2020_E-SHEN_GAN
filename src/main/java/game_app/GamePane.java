package game_app;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;//observers
import javafx.beans.value.ObservableValue;//subjects
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;


/**<b>REFACTOR</b>:<br>
 * <p>. Rename World.java to GamePane.java<br>
 * . Self encapsulating field to avoid direct access of field  even within own class<br>
 * . Create setter and getter for encapsulated field<br>
 *  . Bgm class not subclass , replace inheritance with aggregation</p>
 */
public class GamePane extends Pane {

    private AnimationTimer timer;
    private Bgm bgm;    
//****************************************************CONTROLLER********************************************************************
    public void act(long now) {} 
    
    /**
     * Constructs Pane for all game scenes , controls how frog sprite move in the scene on key pressed n released
     */
    public GamePane() {
    	setBgm(new Bgm());
    	
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
    
    /**
     * Method to create a timer and start it
     */
    public void start() {
    	createTimer();
        getTimer().start();
    }

    /**
     * Method to stop timer
     */
    public void stop() {
        getTimer().stop();
    }
    
    /**<b>EXTENSION</b>:
     * method to play background music
     */
    public void playMusic() {
    	getBgm().playMusic();
    }
    /**<b>EXTENSION</b>:
     * method to stop background music
     */   
    public void stopMusic() {
    	getBgm().stopMusic();
    }
    
//****************************************************MODEL***********************************************************
    /** Method that adds sprite into current GamePane
     * @param sprite : object of type Sprites
     */
    public void add(Sprites sprite) {
        getChildren().add(sprite);
    }

    /**Method that removes sprite from current GamePane
     * @param sprite : object of type Sprites
     */
    public void remove(Sprites sprite) {
        getChildren().remove(sprite);
    }

    @SuppressWarnings("unchecked")
	public <S extends Sprites> List<S> getObjects(Class<S> cls) {
        ArrayList<S> someArray = new ArrayList<S>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
    				someArray.add((S)n);
            }
        }
      return someArray;
    }
    
    /**method to create Animation Timer
     */
    public void createTimer() {
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
    
    /**@return timer object of type AnimationTimer
     */
    public AnimationTimer getTimer() {
    	return timer;
    }
    
    /**@return bgm object of type Bgm
     */
    public Bgm getBgm() {
  		return bgm;
  	}
    /**@param bgm : Bgm object instantiated
     */
  	public void setBgm(Bgm bgm) {
  		this.bgm = bgm;
  	}
}
