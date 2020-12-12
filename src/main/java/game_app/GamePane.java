/**@Refactor
 * remove all unused import packages
 * rename World to GamePane
 * self encapsulating field to avoid direct access of field  even within own class
 * create setter and getter for encapsulated field
 *  Bgm class not subclass , replace inheritance with aggregation
 */
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



public class GamePane extends Pane {

    private AnimationTimer timer;
    private Bgm bgm;    
//****************************************************CONTROLLER********************************************************************
    public void act(long now) {} 
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

    public void start() {
    	createTimer();
        getTimer().start();
    }

    public void stop() {
        getTimer().stop();
    }
    
    public void playMusic() {
    	getBgm().playMusic();
    }
    
    public void stopMusic() {
    	getBgm().stopMusic();
    }
    
//****************************************************MODEL***********************************************************
    public void add(Sprites sprite) {
        getChildren().add(sprite);
    }

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
    
    public AnimationTimer getTimer() {
    	return timer;
    }
    
    public Bgm getBgm() {
  		return bgm;
  	}
  	public void setBgm(Bgm bgm) {
  		this.bgm = bgm;
  	}
}
