
package game_app;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;

/**<b>EXTENSION</b>:
 * Class for  pause and exit buttons in all game scenes: easy , medium and hard mode
 */
public class GameSceneButtons extends Parent {
	private Button gamepause;
	private Button gameexit;
	private VBox gamebox;
//**************************************************CONTROLLER*******************************************************	
	/**? Construct pause and exit buttons using Button class<br>
	 * ? PAUSE button pauses the game <br>
	 * ? EXIT button exits the entire application
	 */
	public GameSceneButtons() {
		//game scene buttons
		setGamebox(new VBox(5));
		getGamebox().setTranslateX(5);
		getGamebox().setTranslateY(5);
		setGamepause(new Button("PAUSE",150,30));
		setGameexit(new Button("EXIT",150,30));
		getGamebox().getChildren().addAll(getGamepause(),getGameexit());
		getChildren().addAll(getGamebox());
	}

	/**method to enable pause and exit buttons
	 */
	public void enable() {
		getGamepause().setDisable(false);
		getGameexit().setDisable(false);	
	}
	
	/**method to disable pause and exit buttons
	 */
	public void disable() {
        getGamepause().setDisable(true);
        getGameexit().setDisable(true);
	}
	
//***********************************************************MODEL****************************************************
	public Button getGamepause() {
		return gamepause;
	}

	public void setGamepause(Button gamepause) {
		this.gamepause = gamepause;
	}

	public Button getGameexit() {
		return gameexit;
	}

	public void setGameexit(Button gameexit) {
		this.gameexit = gameexit;
	}

	public VBox getGamebox() {
		return gamebox;
	}

	public void setGamebox(VBox gamebox) {
		this.gamebox = gamebox;
	}

}
