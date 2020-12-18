package game_app;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**<b>EXTENSION</b>:
 * Create a new class for pause scene and buttons
 */
public class PauseLayer extends Parent {
	private VBox pausebox;
	private Button gameresume;
	private Button gameExit;
	private Button backtomenu;
	private Rectangle pauselayer;

//*************************************************CONTROLLER************************************************************
	/**? Construct pause screen, resume , back to menu and exit buttons<br>
	 * ? BACK TO MENU button includes "auto save last checkpoint" feature<br>
	 * ? RESUME button resumes the game<br>
	 * ? EXIT button exits the application<br>
	 */
	public PauseLayer() {
		//pauselayer buttons
		setPausebox(new VBox(30));
		getPausebox().setTranslateX(185);
		getPausebox().setTranslateY(300);
		setGameresume(new Button("RESUME",250,30));
		setGameExit(new Button("EXIT",250,30));
		setBacktomenu(new Button("MENU", 250, 30));
		getPausebox().getChildren().addAll(getGameresume(),getBacktomenu(),getGameExit());
		setPauselayer(new Rectangle(598,745));
        getPauselayer().setOpacity(0.8);
        getChildren().addAll(getPauselayer(), getPausebox());
        
 
        
	}

	/**
	 * enable pause scene and all buttons in the scene
	 */
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
	
	/**
	 * disable pause scene and all buttons in the scene
	 */
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

//**********************************************************MODEL*******************************************************************
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
}
