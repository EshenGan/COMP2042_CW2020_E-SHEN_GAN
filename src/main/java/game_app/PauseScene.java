/**@Refactor
 * pause scene and buttons
 */
package game_app;



import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PauseScene extends Parent {
	private VBox pausebox;
	private Button gameresume;
	private Button gameExit;
	private Button backtomenu;
	private Rectangle pauselayer;

	
	public PauseScene() {
		//pauselayer buttons
		setPausebox(new VBox(30));
		getPausebox().setTranslateX(185);
		getPausebox().setTranslateY(300);
		setGameresume(Button.createButton("RESUME",250,30));
		setGameExit(Button.createButton("EXIT",250,30));
		setBacktomenu(Button.createButton("MENU", 250, 30));
		getPausebox().getChildren().addAll(getGameresume(),getBacktomenu(),getGameExit());
		setPauselayer(new Rectangle(598,745));
        getPauselayer().setOpacity(0.8);
        getChildren().addAll(getPauselayer(), getPausebox());
        
 
        
	}

	public void enable() {
		getPauselayer().setDisable(false);
		getPauselayer().setFill(Color.DARKBLUE);
		getGameresume().setVisible(true);
		getBacktomenu().setVisible(true);
		getGameExit().setVisible(true);
		getGameresume().setDisable(false);
		getBacktomenu().setDisable(false);
		getGameExit().setDisable(false);		
	}
	
	public void disable() {
		getPauselayer().setFill(Color.TRANSPARENT);
		getPauselayer().setDisable(true);
		getGameresume().setVisible(false);
		getBacktomenu().setVisible(false);
		getGameExit().setVisible(false);
		getGameresume().setDisable(true);
		getBacktomenu().setDisable(true);
		getGameExit().setDisable(true);
	}
	public VBox getPausebox() {
		return pausebox;
	}

	public void setPausebox(VBox pausebox) {
		this.pausebox = pausebox;
	}

	public Button getGameresume() {
		return gameresume;
	}

	public void setGameresume(Button gameresume) {
		this.gameresume = gameresume;
	}

	public Button getGameExit() {
		return gameExit;
	}

	public void setGameExit(Button gameExit) {
		this.gameExit = gameExit;
	}

	public Rectangle getPauselayer() {
		return pauselayer;
	}

	public void setPauselayer(Rectangle pauselayer) {
		this.pauselayer = pauselayer;
	}

	public Button getBacktomenu() {
		return backtomenu;
	}

	public void setBacktomenu(Button backtomenu) {
		this.backtomenu = backtomenu;
	}

//	public Button getBacktomenu() {
//		return backtomenu;
//	}
//
//	public void setBacktomenu(Button backtomenu) {
//		this.backtomenu = backtomenu;
//	}
}
