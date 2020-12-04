package game_app;

import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ManualPage extends Parent{
    private Button manualplay;
    private Button manualexit;
    private Button manualmenu;

		public ManualPage () {

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
	        getChildren().addAll(rect1, manualhbox);
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
}
