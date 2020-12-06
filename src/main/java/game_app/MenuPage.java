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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MenuPage extends Parent{
	private Button menuplay;
	private Button easyplay;
	private Button mediumplay;
	private Button hardplay;
	private Button menumanual;
	private Button menuexit;
	private Scene scenemenu;
	private Pane menuroot;
	private VBox playdropdown;

	
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
	    setPlaydropdown(new VBox(10));
	    getPlaydropdown().setTranslateX(15);
	    getPlaydropdown().setTranslateY(345);
	    setEasyplay(Button.createButton("EASY",200,30));
	    setMediumplay(Button.createButton("MEDIUM",200,30));
	    setHardplay(Button.createButton("HARD",200,30));
	    getPlaydropdown().getChildren().addAll(getEasyplay(), getMediumplay(), getHardplay());
	    Rectangle rect = new Rectangle(800, 600);
	    rect.setFill(Color.BLUE);
	    rect.setOpacity(0.2);
	    getMenuroot().getChildren().addAll(rect, menuhbox,getPlaydropdown());
	    setScenemenu(new Scene(getMenuroot()));
	    
	    getPlaydropdown().setVisible(false); 
	    
	    getMenuplay().setOnMouseClicked(event -> {
			getPlaydropdown().setDisable(false);
			getPlaydropdown().setVisible(true);
	    });
		
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

	public Button getEasyplay() {
		return easyplay;
	}

	public void setEasyplay(Button easyplay) {
		this.easyplay = easyplay;
	}

	public Button getMediumplay() {
		return mediumplay;
	}

	public void setMediumplay(Button mediumplay) {
		this.mediumplay = mediumplay;
	}

	public Button getHardplay() {
		return hardplay;
	}

	public void setHardplay(Button hardplay) {
		this.hardplay = hardplay;
	}

	public VBox getPlaydropdown() {
		return playdropdown;
	}

	public void setPlaydropdown(VBox playdropdown) {
		this.playdropdown = playdropdown;
	}

	

}
