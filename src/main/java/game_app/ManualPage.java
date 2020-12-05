/**@Refactor
 * manual page and buttons
 */
package game_app;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ManualPage extends Parent{
    private Button manualplay;
    private Button manualexit;
    private Button manualmenu;
	private Scene scenemanual;
	private Pane manualroot;

		public ManualPage () {
	        //user guide scene
	        setManualroot(new Pane());
	        getManualroot().setPrefSize(800, 525);
	        Image img1 = new Image("file:src/main/resources/user_guide.png",800,525,true,true);
	        ImageView img4manual = new ImageView(img1);
	        getManualroot().getChildren().addAll(img4manual);

	        //user guide buttons
	        HBox manualhbox = new HBox(20);
	        manualhbox.setTranslateX(5);
	        manualhbox.setTranslateY(490);
	        setManualplay(Button.createButton("PLAY",240,30));
	        setManualexit(Button.createButton("EXIT",240,30));
	        setManualmenu(Button.createButton("BACK TO MENU",240,30));
	        manualhbox.getChildren().addAll(getManualplay(), getManualmenu(), getManualexit());
	        Rectangle rect1 = new Rectangle(800, 50);
	        rect1.setFill(Color.DARKCYAN);
	        rect1.setOpacity(0.8);
	        rect1.setTranslateY(480);
	        getManualroot().getChildren().addAll(rect1, manualhbox);
	        
	        setScenemanual(new Scene(getManualroot()));
		}

		public Button getManualplay() {
			return manualplay;
		}

		public void setManualplay(Button manualplay) {
			this.manualplay = manualplay;
		}

		public Button getManualexit() {
			return manualexit;
		}

		public void setManualexit(Button manualexit) {
			this.manualexit = manualexit;
		}

		public Button getManualmenu() {
			return manualmenu;
		}

		public void setManualmenu(Button manualmenu) {
			this.manualmenu = manualmenu;
		}

		public Scene getScenemanual() {
			return scenemanual;
		}

		public void setScenemanual(Scene scenemanual) {
			this.scenemanual = scenemanual;
		}
	
		public Pane getManualroot() {
			return manualroot;
		}

		public void setManualroot(Pane manualroot) {
			this.manualroot = manualroot;
		}
}
