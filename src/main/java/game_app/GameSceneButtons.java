/**@Refactor
 * buttons in game scene
 */
package game_app;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class GameSceneButtons extends Parent {
	private Button gamepause;
	private Button gameexit;
	private VBox gamebox;
	
	public GameSceneButtons() {
		//game scene buttons
		setGamebox(new VBox(5));
		getGamebox().setTranslateX(5);
		getGamebox().setTranslateY(5);
		setGamepause(Button.createButton("PAUSE",150,30));
		setGameexit(Button.createButton("EXIT",150,30));
		getGamebox().getChildren().addAll(getGamepause(),getGameexit());
		getChildren().addAll(getGamebox());
	}

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
