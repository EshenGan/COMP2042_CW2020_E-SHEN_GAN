/**
 * @Refactor 
 *  renaming of package and Main java file with meaningful name
 *  remove unused imports
 *  move png  jpg piskel etc "media" files to src/main/resources
 *  edited background color for all digits and also edited background for game scene
 */
package game_app;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
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


	private int pauseflag;
	private MenuPage menu;
	private ManualPage manual;
	private EasyScene easyscene;
	private GameSceneButtons gamescenebuttons;
	private PauseScene pausescene;
	

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
		
		//menu screen
		setMenu(new MenuPage());
		getMenu().getMenuplay().setOnMouseClicked(event -> {
			primaryStage.setScene(getEasyscene().getScenegame1());
			getEasyscene().start();
  		});
	
  		getMenu().getMenumanual().setOnMouseClicked(event -> {
  			primaryStage.setScene(getManual().getScenemanual());
  		});
  
  		getMenu().getMenuexit().setOnMouseClicked(event -> {
  			System.exit(0);
  		});
		
  		//user guide/INFO screen
  		setManual(new ManualPage());
        getManual().getManualplay().setOnMouseClicked(event -> {
        	primaryStage.setScene(getEasyscene().getScenegame1());
        	getEasyscene().start();
        });
        
        getManual().getManualmenu().setOnMouseClicked(event -> {
            primaryStage.setScene(getMenu().getScenemenu());
        });

       getManual().getManualexit().setOnMouseClicked(event -> {
            System.exit(0);
          
        });
        
        //frogger game scene in easy mode,game scene buttons, pause scene and buttons
        setEasyscene(new EasyScene());
		setGamescenebuttons(new GameSceneButtons());
		getEasyscene().getGameroot1().getChildren().addAll(getGamescenebuttons());
		setPausescene(new PauseScene());
		getGamescenebuttons().getGamepause().setOnMouseClicked(event ->{
			if(getPauseflag() == 0) {
				getEasyscene().getGameroot1().getChildren().addAll(getPausescene());
				setPauseflag(1);
			}
			if(getGamescenebuttons().getGamepause().isDisabled() == false) {
			getEasyscene().getGameroot1().stop();
			getEasyscene().getGameroot1().stopMusic();
			getEasyscene().stop();
			getPausescene().getPauselayer().setDisable(false);
			getPausescene().getPauselayer().setFill(Color.DARKBLUE);
			getPausescene().getGameresume().setVisible(true);
			getPausescene().getGameExit().setVisible(true);
			getPausescene().getGameresume().setDisable(false);
			getPausescene().getGameExit().setDisable(false);			
	        getGamescenebuttons().getGamepause().setDisable(true);
	        getGamescenebuttons().getGameexit().setDisable(true);

			}
		});

		getGamescenebuttons().getGameexit().setOnMouseClicked(event ->{
			System.exit(0);
		});  
		
		getPausescene().getGameresume().setOnMouseClicked(event ->{
			if(getPausescene().getGameresume().isDisabled() == false) {
				getPausescene().getPauselayer().setFill(Color.TRANSPARENT);
				getPausescene().getPauselayer().setDisable(true);
				getPausescene().getGameresume().setVisible(false);
				getPausescene().getGameExit().setVisible(false);
				primaryStage.setScene(getEasyscene().getScenegame1());
				getEasyscene().start();
				getGamescenebuttons().getGamepause().setDisable(false);
				getGamescenebuttons().getGameexit().setDisable(false);	
				getPausescene().getGameresume().setDisable(true);
				getPausescene().getGameExit().setDisable(true);
			}			

		});
		getPausescene().getGameExit().setOnMouseClicked(event ->{
			System.exit(0);
		});
        
        //make frogger game scene in medium mode
        //make frogger game scene in hard mode
				
		primaryStage.setScene(getMenu().getScenemenu());
		primaryStage.show();
	}

	protected void setEasyscene(EasyScene easyscene) {
		this.easyscene = easyscene;
	}
	
	protected EasyScene getEasyscene() {
		return easyscene;
	}
	
	protected void setPauseflag(int pauseflag) {
		this.pauseflag = pauseflag;
	}

	protected int getPauseflag() {
		return pauseflag;
	}
	
	protected void setMenu(MenuPage menu) {
		this.menu = menu;
	}

	protected MenuPage getMenu() {
		return menu;
	}

	protected void setManual(ManualPage manual) {
		this.manual = manual;
	}	

	protected ManualPage getManual() {
		return manual;
	}

	public GameSceneButtons getGamescenebuttons() {
		return gamescenebuttons;
	}

	public void setGamescenebuttons(GameSceneButtons gamescenebuttons) {
		this.gamescenebuttons = gamescenebuttons;
	}

	public PauseScene getPausescene() {
		return pausescene;
	}

	public void setPausescene(PauseScene pausescene) {
		this.pausescene = pausescene;
	}

}


 


