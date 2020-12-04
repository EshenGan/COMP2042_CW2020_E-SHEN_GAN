package game_app;

import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MenuPage extends Parent{
	private Button menuplay;
	private Button menumanual;
	private Button menuexit;
	
	
	public MenuPage() {
	    
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
	    getChildren().addAll(rect, menuhbox);
		
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

	

}
