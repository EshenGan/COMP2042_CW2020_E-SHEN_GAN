package game_app;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**<b>EXTENSION</b>:<br>
 * <p>. new class for start screen and buttons<br>
 * . PLAY button will drop down 3 other buttons to choose level of difficulty<br>
 * . MANUAL button generates INFO screen<br>
 * . BGM button will drop down 3 other buttons to choose background music<br>
 * . EXIT button exits application</p>
 */
public class MenuScene{
	private Button menuplay;
	private Button easyplay;
	private Button mediumplay;
	private Button hardplay;
	private Button menumanual;
	private Button menuchoosebgm;
	private Button acdc;
	private Button crazyfrog;
	private Button froggersong;
	private Button menuexit;
	private Scene scenemenu;
	private Pane menuroot;
	private VBox playdropdown;
	private VBox bgmdropdown;
	private HBox menuhbox;
	private ImageView img4menu;
	private Rectangle menurect;
	private static String song;

//***************************************************CONTROLLER***************************************************************
	/**Construct main menu/start screen and buttons
	 */
	MenuScene() {
		// main menu scene
        setMenuroot(new Pane());
        getMenuroot().setPrefSize(800, 600);
        Image menuimg = new Image("file:src/main/resources/wallpaper-frogger-boxart-800x600.jpg",800,600,true,true);
        setImg4menu(new ImageView(menuimg));
        getMenuroot().getChildren().addAll(getImg4menu());
	    
	    // menu bar buttons
	    setMenuhbox(new HBox(10));       
	    getMenuhbox().setTranslateX(85);
	    getMenuhbox().setTranslateY(300);
	    setMenuplay(new Button("PLAY",150,30));
	    setMenumanual(new Button("MANUAL",150,30));
	    setMenuchoosebgm(new Button("BGM",150,30));
	    setMenuexit(new Button("EXIT",150,30));
	    getMenuhbox().getChildren().addAll(getMenuplay(), getMenumanual(),getMenuchoosebgm(),getMenuexit());
	    
	    // drop down for bgm button
	    setBgmdropdown(new VBox(10));
	    getBgmdropdown().setTranslateX(405);
	    getBgmdropdown().setTranslateY(345);
	    setAcdc(new Button ("Thunderstruck",125,30));
	    setCrazyfrog(new Button("Crazy Frog",100,30));
	    setFroggersong(new Button("Frogger",100,30));
	    getBgmdropdown().getChildren().addAll(getAcdc(),getCrazyfrog(),getFroggersong());
	    
	    //drop down for play button
	    setPlaydropdown(new VBox(10));
	    getPlaydropdown().setTranslateX(85);
	    getPlaydropdown().setTranslateY(345);
	    setEasyplay(new Button("EASY",100,30));
	    setMediumplay(new Button("MEDIUM",100,30));
	    setHardplay(new Button("HARD",100,30));
	    getPlaydropdown().getChildren().addAll(getEasyplay(), getMediumplay(), getHardplay());
	    
	    setMenurect(new Rectangle(800, 600));
	    getMenurect().setFill(Color.BLUE);
	    getMenurect().setOpacity(0.2);
	    getMenuroot().getChildren().addAll(getMenurect(), getMenuhbox(),getPlaydropdown(),getBgmdropdown());
	    
	    setScenemenu(new Scene(getMenuroot()));
	    
	    getPlaydropdown().setVisible(false); 
	    getMenuplay().setOnMouseClicked(event -> {
			getPlaydropdown().setDisable(false);
			getPlaydropdown().setVisible(true);
	    });
	    
	    getBgmdropdown().setVisible(false);
	    getMenuchoosebgm().setOnMouseClicked(event ->{
	    	getBgmdropdown().setDisable(false);
	    	getBgmdropdown().setVisible(true);
	    });
	    
	    getAcdc().setOnMouseClicked(event ->{
	    	setSong("src/main/resources/ACDC - Thunderstruck (Official Video).mp3");
	    	getBgmdropdown().setVisible(false);
	    });
	    
	    getCrazyfrog().setOnMouseClicked(event ->{
	    	setSong("src/main/resources/Crazy Frog - Axel F (Official Video).mp3");
	    	getBgmdropdown().setVisible(false);
	    });
		
	    getFroggersong().setOnMouseClicked(event ->{
	    	setSong("src/main/resources/Frogger Main Song Theme (loop).mp3");
	    	getBgmdropdown().setVisible(false);
	    });
	}

//***********************************************************MODEL***********************************************************
	public Scene getScenemenu() {return scenemenu;}
	
	public void setScenemenu(Scene scenemenu) {this.scenemenu = scenemenu;}

	public Button getMenuplay() {return menuplay;}


	public void setMenuplay(Button menuplay) {this.menuplay = menuplay;}


	public Button getMenumanual() {return menumanual;}


	public void setMenumanual(Button menumanual) {this.menumanual = menumanual;}


	public Button getMenuexit() {return menuexit;}


	public void setMenuexit(Button menuexit) {this.menuexit = menuexit;}

	public Pane getMenuroot() {return menuroot;}

	public void setMenuroot(Pane menuroot) {this.menuroot = menuroot;}

	public Button getEasyplay() {return easyplay;}

	public void setEasyplay(Button easyplay) {this.easyplay = easyplay;}

	public Button getMediumplay() {return mediumplay;}

	public void setMediumplay(Button mediumplay) {this.mediumplay = mediumplay;}

	public Button getHardplay() {return hardplay;}

	public void setHardplay(Button hardplay) {this.hardplay = hardplay;}

	public VBox getPlaydropdown() {return playdropdown;}

	public void setPlaydropdown(VBox playdropdown) {this.playdropdown = playdropdown;}

	public HBox getMenuhbox() {return menuhbox;}

	public void setMenuhbox(HBox menuhbox) {this.menuhbox = menuhbox;}

	public ImageView getImg4menu() {return img4menu;}

	public void setImg4menu(ImageView img4menu) {this.img4menu = img4menu;}

	public Rectangle getMenurect() {return menurect;}

	public void setMenurect(Rectangle menurect) {this.menurect = menurect;}

	public Button getMenuchoosebgm() {return menuchoosebgm;}

	public void setMenuchoosebgm(Button menuchoosebgm) {this.menuchoosebgm = menuchoosebgm;}

	public Button getAcdc() {return acdc;}

	public void setAcdc(Button acdc) {this.acdc = acdc;}

	public Button getCrazyfrog() {return crazyfrog;}

	public void setCrazyfrog(Button crazyfrog) {this.crazyfrog = crazyfrog;}

	public Button getFroggersong() {return froggersong;}

	public void setFroggersong(Button froggersong) {this.froggersong = froggersong;}

	public VBox getBgmdropdown() {return bgmdropdown;}

	public void setBgmdropdown(VBox bgmdropdown) {this.bgmdropdown = bgmdropdown;}

	public static String getSong() {return song;}

	public static void setSong(String song) {MenuScene.song = song;}

}
