/**@Refactor
 * menu page and buttons
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

public class MenuPage extends Parent{
	private Button menuplay;
	private Button menumanual;
	private Button menuexit;
	private Scene scenemenu;
	private Pane menuroot;

	
	public MenuPage() {
		// main menu scene
        setMenuroot(new Pane());
        getMenuroot().setPrefSize(800, 600);
        Image img0 = new Image("file:src/main/resources/wallpaper-frogger-boxart-800x600.jpg",800,600,true,true);
        ImageView img4menu = new ImageView(img0);
        getMenuroot().getChildren().addAll(img4menu);
	    
	    // menu bar buttons
	    HBox menuhbox = new HBox(10);       
	    menuhbox.setTranslateX(15);
	    menuhbox.setTranslateY(300);
	    setMenuplay(Button.createButton("PLAY",250,30));
	    setMenumanual(Button.createButton("MANUAL",250,30));
	    setMenuexit(Button.createButton("EXIT",250,30));
	    menuhbox.getChildren().addAll(getMenuplay(), getMenumanual(), getMenuexit());
	    Rectangle rect = new Rectangle(800, 600);
	    rect.setFill(Color.BLUE);
	    rect.setOpacity(0.2);
	    getMenuroot().getChildren().addAll(rect, menuhbox);
	    setScenemenu(new Scene(getMenuroot()));
		
	}

	public Scene getScenemenu() {
		return scenemenu;
	}
	
	public void setScenemenu(Scene scenemenu) {
		this.scenemenu = scenemenu;
	}

	public Button getMenuplay() {
		return menuplay;
	}


	public void setMenuplay(Button menuplay) {
		this.menuplay = menuplay;
	}


	public Button getMenumanual() {
		return menumanual;
	}


	public void setMenumanual(Button menumanual) {
		this.menumanual = menumanual;
	}


	public Button getMenuexit() {
		return menuexit;
	}


	public void setMenuexit(Button menuexit) {
		this.menuexit = menuexit;
	}

	public Pane getMenuroot() {
		return menuroot;
	}

	public void setMenuroot(Pane menuroot) {
		this.menuroot = menuroot;
	}

	

}
