/**
 * @Refactor 
 *  renaming of package and Main java file with meaningful name
 *  remove unused imports
 *  move png  jpg piskel etc "media" files to src/main/resources
 *  edited background color for all digits and also edited background for game scene
 */
package game_app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class FroggerApp extends Application {
	/**
	 * @Refactor
	 * set up aggregated field here before instantiating as object in start(Stage primaryStage)
	 * field data encapsulation - OO Core Concept
	 * self encapsulating field to avoid direct access of field even within own class
	 * create setter and getter for encapsulated field
	 * method hiding
	 */
	private Scene scenemenu;
	private Scene scenemanual;
	private int pauseflag;
	private MenuPage menu;
	private ManualPage manual;
	private EasyScene easyscene;
	

//*********************************************************************VIEW****************************************************************************
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * @Override
	 * method overriding on application class
	 */
	public void start(Stage primaryStage) throws Exception {
		setPauseflag(0);
		primaryStage.getIcons().add(new Image("file:src/main/resources/icon-frogger-boxart-96x96.png"));
		primaryStage.setTitle("FROGGER ARCADE GAME by E-Shen Gan");
		// main menu scene
        Pane menuroot = new Pane();
        menuroot.setPrefSize(800, 600);
        setScenemenu(new Scene(menuroot));
        Image img0 = new Image("file:src/main/resources/wallpaper-frogger-boxart-800x600.jpg",800,600,true,true);
        ImageView img4menu = new ImageView(img0);
        setMenu(new MenuPage());
        menuroot.getChildren().addAll(img4menu,getMenu());
 
        //user guide scene
        Pane manualroot = new Pane();
        manualroot.setPrefSize(800, 525);
        setScenemanual(new Scene(manualroot));
        Image img1 = new Image("file:src/main/resources/user_guide.png",800,525,true,true);
        ImageView img4manual = new ImageView(img1);
        setManual(new ManualPage());
        manualroot.getChildren().addAll(img4manual,getManual());
        
        //frogger game scene in easy mode
        setEasyscene(new EasyScene());

//		gameroot2 = new Bgm();
//		scenegame2 = new Scene(gameroot2,598,745);
	
//		gameroot3 = new Bgm();
//		scenegame3 = new Scene(gameroot3,598,745);

		//game scene buttons
		VBox gamebox = new VBox(5);
		gamebox.setTranslateX(5);
		gamebox.setTranslateY(5);
		Button gamepause = Button.createButton("PAUSE",150,30);
		Button gameexit = Button.createButton("EXIT",150,30);
		gamebox.getChildren().addAll(gamepause,gameexit);
		getEasyscene().getGameroot1().getChildren().addAll(gamebox);
		
		//pauselayer buttons
		VBox pausebox = new VBox(30);
		pausebox.setTranslateX(185);
		pausebox.setTranslateY(300);
		Button gameresume = Button.createButton("RESUME",250,30);
		Button gameExit = Button.createButton("EXIT",250,30);
		pausebox.getChildren().addAll(gameresume,gameExit);
		Rectangle pauselayer = new Rectangle(598,745);
        pauselayer.setOpacity(0.8);
		
		primaryStage.setScene(getScenemenu());
		primaryStage.show();
		
		//button actions
		gamepause.setOnMouseClicked(event ->{
			if(getPauseflag() == 0) {
				getEasyscene().getGameroot1().getChildren().addAll(pauselayer,pausebox);
				setPauseflag(1);
			}
			if(gamepause.isDisabled() == false) {
			getEasyscene().getGameroot1().stop();
			getEasyscene().getGameroot1().stopMusic();
			getEasyscene().stop();
			pauselayer.setDisable(false);
			pauselayer.setFill(Color.DARKBLUE);
			gameresume.setVisible(true);
			gameExit.setVisible(true);
	        gameresume.setDisable(false);
	        gameExit.setDisable(false);			
	        gamepause.setDisable(true);
	        gameexit.setDisable(true);

			}
		});
		
		gameresume.setOnMouseClicked(event ->{
			if(gameresume.isDisabled() == false) {
				pauselayer.setFill(Color.TRANSPARENT);
				pauselayer.setDisable(true);
				gameresume.setVisible(false);
				gameExit.setVisible(false);
				primaryStage.setScene(getEasyscene().getScenegame1());
				getEasyscene().start();
				gamepause.setDisable(false);
				gameexit.setDisable(false);	
				gameresume.setDisable(true);
				gameExit.setDisable(true);
			}			

		});
		gameExit.setOnMouseClicked(event ->{
			System.exit(0);
		});
		
		gameexit.setOnMouseClicked(event ->{
			System.exit(0);
		});
		
		menu.getMenuplay().setOnMouseClicked(event -> {
			primaryStage.setScene(getEasyscene().getScenegame1());
			getEasyscene().start();
  		});
	
  		menu.getMenumanual().setOnMouseClicked(event -> {
  			primaryStage.setScene(getScenemanual());
  		});
  
  		menu.getMenuexit().setOnMouseClicked(event -> {
  			System.exit(0);
  		});
        
        manual.getManualplay().setOnMouseClicked(event -> {
        	primaryStage.setScene(getEasyscene().getScenegame1());
        	getEasyscene().start();
        });
        
        manual.getManualmenu().setOnMouseClicked(event -> {
            primaryStage.setScene(getScenemenu());
        });

       manual.getManualexit().setOnMouseClicked(event -> {
            System.exit(0);
          
        });
        
	}

	protected Scene getScenemenu() {
		return scenemenu;
	}

	protected Scene getScenemanual() {
		return scenemanual;
	}

	protected int getPauseflag() {
		return pauseflag;
	}

	protected MenuPage getMenu() {
		return menu;
	}

	protected ManualPage getManual() {
		return manual;
	}

	protected EasyScene getEasyscene() {
		return easyscene;
	}

	protected void setScenemenu(Scene scenemenu) {
		this.scenemenu = scenemenu;
	}

	protected void setScenemanual(Scene scenemanual) {
		this.scenemanual = scenemanual;
	}

	protected void setPauseflag(int pauseflag) {
		this.pauseflag = pauseflag;
	}
	

	protected void setMenu(MenuPage menu) {
		this.menu = menu;
	}

	protected void setManual(ManualPage manual) {
		this.manual = manual;
	}

	protected void setEasyscene(EasyScene easyscene) {
		this.easyscene = easyscene;
	}
	
	

}


 


