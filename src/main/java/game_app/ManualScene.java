/**@Extension
 * new class for manual/info scene and buttons
 */
package game_app;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ManualScene{
    private Button manualexit;
    private Button manualmenu;
	private Scene scenemanual;
	private Pane manualroot;
	private ImageView img4manual;
	private HBox manualhbox;
	private Rectangle manualrect;

//**********************************************CONTROLLER*******************************************************
		ManualScene () {
	        //user guide scene
	        setManualroot(new Pane());
	        getManualroot().setPrefSize(800, 525);
	        Image manualimg = new Image("file:src/main/resources/user_guide_new.png",800,525,true,true);
	        setImg4manual(new ImageView(manualimg));
	        getManualroot().getChildren().addAll(getImg4manual());

	        //user guide buttons
	        setManualhbox(new HBox(20));
	        getManualhbox().setTranslateX(5);
	        getManualhbox().setTranslateY(490);

	        setManualexit(new Button("EXIT",240,30));
	        setManualmenu(new Button("BACK TO MENU",240,30));
	        getManualhbox().getChildren().addAll(getManualmenu(), getManualexit());
	        
	        setManualrect(new Rectangle(800, 50));
	        getManualrect().setFill(Color.DARKCYAN);
	        getManualrect().setOpacity(0.8);
	        getManualrect().setTranslateY(480);
	        getManualroot().getChildren().addAll(getManualrect(), getManualhbox());
	        
	        setScenemanual(new Scene(getManualroot()));
		}
		
//**************************************MODEL*********************************************************************

		public Button getManualexit() {return manualexit;}

		public void setManualexit(Button manualexit) {this.manualexit = manualexit;}

		public Button getManualmenu() {return manualmenu;}

		public void setManualmenu(Button manualmenu) {this.manualmenu = manualmenu;}

		public Scene getScenemanual() {return scenemanual;}

		public void setScenemanual(Scene scenemanual) {this.scenemanual = scenemanual;}
	
		public Pane getManualroot() {return manualroot;}

		public void setManualroot(Pane manualroot) {this.manualroot = manualroot;}

		public ImageView getImg4manual() {return img4manual;}

		public void setImg4manual(ImageView img4manual) {this.img4manual = img4manual;}

		public HBox getManualhbox() {return manualhbox;}

		public void setManualhbox(HBox manualhbox) {this.manualhbox = manualhbox;}

		public Rectangle getManualrect() {return manualrect;}

		public void setManualrect(Rectangle manualrect) {this.manualrect = manualrect;}
}
