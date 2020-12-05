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


	private int pauseflag1;
	private int pauseflag2;
	private int pauseflag3;
	private MenuPage menu;
	private ManualPage manual;
	private EasyScene easyscene;
	private MediumScene mediumscene;
	private HardScene hardscene;
	private GameSceneButtons gamescenebuttons;
	private GameSceneButtons gamescenebuttons2;
	private GameSceneButtons gamescenebuttons3;
	private PauseScene pausescene1;
	private PauseScene pausescene2;
	private PauseScene pausescene3;
	
	
	

//*********************************************************************VIEW****************************************************************************
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * @Override
	 * method overriding on application class
	 */
	public void start(Stage primaryStage) throws Exception {
		setPauseflag1(0);
		setPauseflag2(0);
		setPauseflag3(0);
		primaryStage.getIcons().add(new Image("file:src/main/resources/icon-frogger-boxart-96x96.png")); //view
		primaryStage.setTitle("FROGGER ARCADE GAME by E-Shen Gan");  //view
		
		//menu screen
		setMenu(new MenuPage()); //view
		getMenu().getMenuplay().setOnMouseClicked(event -> { //controller
//			primaryStage.setScene(getEasyscene().getScenegame1()); //level 1
//			getEasyscene().start(); //level 1
//			primaryStage.setScene(getMediumscene().getScenegame2()); //level 2
//			getMediumscene().start(); //level 2
			primaryStage.setScene(getHardscene().getScenegame3()); //level 3
			getHardscene().start(); //level 3
  		});
	
  		getMenu().getMenumanual().setOnMouseClicked(event -> {
  			primaryStage.setScene(getManual().getScenemanual());
  		});
  
  		getMenu().getMenuexit().setOnMouseClicked(event -> {
  			System.exit(0);
  		});
		
  		//user guide/INFO screen
  		setManual(new ManualPage()); //view
        getManual().getManualplay().setOnMouseClicked(event -> { //controller
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
        setEasyscene(new EasyScene()); //view
		setGamescenebuttons(new GameSceneButtons()); //view
		getEasyscene().getGameroot1().getChildren().addAll(getGamescenebuttons()); //view
		setPausescene1(new PauseScene());//view
		getGamescenebuttons().getGamepause().setOnMouseClicked(event ->{ //controller
			if(getPauseflag1() == 0) {
				getEasyscene().getGameroot1().getChildren().addAll(getPausescene1());
				setPauseflag1(1);
			}
			if(getGamescenebuttons().getGamepause().isDisabled() == false) {
			getEasyscene().getGameroot1().stop();
			getEasyscene().getGameroot1().stopMusic();
			getEasyscene().stop();
			getPausescene1().getPauselayer().setDisable(false);
			getPausescene1().getPauselayer().setFill(Color.DARKBLUE);
			getPausescene1().getGameresume().setVisible(true);
			getPausescene1().getGameExit().setVisible(true);
			getPausescene1().getGameresume().setDisable(false);
			getPausescene1().getGameExit().setDisable(false);			
	        getGamescenebuttons().getGamepause().setDisable(true);
	        getGamescenebuttons().getGameexit().setDisable(true);

			}
		});

		getGamescenebuttons().getGameexit().setOnMouseClicked(event ->{
			System.exit(0);
		});  
		
		getPausescene1().getGameresume().setOnMouseClicked(event ->{
			if(getPausescene1().getGameresume().isDisabled() == false) {
				getPausescene1().getPauselayer().setFill(Color.TRANSPARENT);
				getPausescene1().getPauselayer().setDisable(true);
				getPausescene1().getGameresume().setVisible(false);
				getPausescene1().getGameExit().setVisible(false);
				primaryStage.setScene(getEasyscene().getScenegame1());
				getEasyscene().start();
				getGamescenebuttons().getGamepause().setDisable(false);
				getGamescenebuttons().getGameexit().setDisable(false);	
				getPausescene1().getGameresume().setDisable(true);
				getPausescene1().getGameExit().setDisable(true);
			}			

		});
		getPausescene1().getGameExit().setOnMouseClicked(event ->{
			System.exit(0);
		});
        
        //make frogger game scene in medium mode
		setMediumscene(new MediumScene());
		setGamescenebuttons2(new GameSceneButtons());
		getMediumscene().getGameroot2().getChildren().addAll(getGamescenebuttons2());
		setPausescene2(new PauseScene());
		getGamescenebuttons2().getGamepause().setOnMouseClicked(event ->{ //controller
			if(getPauseflag2() == 0) {
				getMediumscene().getGameroot2().getChildren().addAll(getPausescene2());
				setPauseflag2(1);
			}
			if(getGamescenebuttons2().getGamepause().isDisabled() == false) {
			getMediumscene().getGameroot2().stop();
			getMediumscene().getGameroot2().stopMusic();
			getMediumscene().stop();
			getPausescene2().getPauselayer().setDisable(false);
			getPausescene2().getPauselayer().setFill(Color.DARKBLUE);
			getPausescene2().getGameresume().setVisible(true);
			getPausescene2().getGameExit().setVisible(true);
			getPausescene2().getGameresume().setDisable(false);
			getPausescene2().getGameExit().setDisable(false);			
	        getGamescenebuttons2().getGamepause().setDisable(true);
	        getGamescenebuttons2().getGameexit().setDisable(true);

			}
		});

		getGamescenebuttons2().getGameexit().setOnMouseClicked(event ->{
			System.exit(0);
		});  
		
		getPausescene2().getGameresume().setOnMouseClicked(event ->{
			if(getPausescene2().getGameresume().isDisabled() == false) {
				getPausescene2().getPauselayer().setFill(Color.TRANSPARENT);
				getPausescene2().getPauselayer().setDisable(true);
				getPausescene2().getGameresume().setVisible(false);
				getPausescene2().getGameExit().setVisible(false);
				primaryStage.setScene(getMediumscene().getScenegame2());
				getMediumscene().start();
				getGamescenebuttons2().getGamepause().setDisable(false);
				getGamescenebuttons2().getGameexit().setDisable(false);	
				getPausescene2().getGameresume().setDisable(true);
				getPausescene2().getGameExit().setDisable(true);
			}			

		});
		getPausescene2().getGameExit().setOnMouseClicked(event ->{
			System.exit(0);
		});
		
        //make frogger game scene in hard mode
		setHardscene(new HardScene());
		setGamescenebuttons3(new GameSceneButtons());
		getHardscene().getGameroot3().getChildren().addAll(getGamescenebuttons3());
		setPausescene3(new PauseScene());
		getGamescenebuttons3().getGamepause().setOnMouseClicked(event ->{ //controller
			if(getPauseflag3() == 0) {
				getHardscene().getGameroot3().getChildren().addAll(getPausescene3());
				setPauseflag3(1);
			}
			if(getGamescenebuttons3().getGamepause().isDisabled() == false) {
			getHardscene().getGameroot3().stop();
			getHardscene().getGameroot3().stopMusic();
			getHardscene().stop();
			getPausescene3().getPauselayer().setDisable(false);
			getPausescene3().getPauselayer().setFill(Color.DARKBLUE);
			getPausescene3().getGameresume().setVisible(true);
			getPausescene3().getGameExit().setVisible(true);
			getPausescene3().getGameresume().setDisable(false);
			getPausescene3().getGameExit().setDisable(false);			
	        getGamescenebuttons3().getGamepause().setDisable(true);
	        getGamescenebuttons3().getGameexit().setDisable(true);

			}
		});

		getGamescenebuttons3().getGameexit().setOnMouseClicked(event ->{
			System.exit(0);
		});  
		
		getPausescene3().getGameresume().setOnMouseClicked(event ->{
			if(getPausescene3().getGameresume().isDisabled() == false) {
				getPausescene3().getPauselayer().setFill(Color.TRANSPARENT);
				getPausescene3().getPauselayer().setDisable(true);
				getPausescene3().getGameresume().setVisible(false);
				getPausescene3().getGameExit().setVisible(false);
				primaryStage.setScene(getHardscene().getScenegame3());
				getHardscene().start();
				getGamescenebuttons3().getGamepause().setDisable(false);
				getGamescenebuttons3().getGameexit().setDisable(false);	
				getPausescene3().getGameresume().setDisable(true);
				getPausescene3().getGameExit().setDisable(true);
			}			

		});
		getPausescene3().getGameExit().setOnMouseClicked(event ->{
			System.exit(0);
		});
		
		primaryStage.setScene(getMenu().getScenemenu()); //view
		primaryStage.show();  //view
	}

	protected void setEasyscene(EasyScene easyscene) { //model
		this.easyscene = easyscene;
	}
	
	protected EasyScene getEasyscene() {
		return easyscene;
	}
	
	protected void setPauseflag1(int pauseflag1) {
		this.pauseflag1 = pauseflag1;
	}

	protected int getPauseflag1() {
		return pauseflag1;
	}
	
	protected int getPauseflag2() {
		return pauseflag2;
	}

	protected void setPauseflag2(int pauseflag2) {
		this.pauseflag2 = pauseflag2;
	}

	protected int getPauseflag3() {
		return pauseflag3;
	}

	protected void setPauseflag3(int pauseflag3) {
		this.pauseflag3 = pauseflag3;
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

	protected GameSceneButtons getGamescenebuttons() {
		return gamescenebuttons;
	}

	protected void setGamescenebuttons(GameSceneButtons gamescenebuttons) {
		this.gamescenebuttons = gamescenebuttons;
	}

	protected PauseScene getPausescene1() {
		return pausescene1;
	}

	protected void setPausescene1(PauseScene pausescene1) {
		this.pausescene1 = pausescene1;
	}

	protected MediumScene getMediumscene() {
		return mediumscene;
	}

	protected void setMediumscene(MediumScene mediumscene) {
		this.mediumscene = mediumscene;
	}

	protected HardScene getHardscene() {
		return hardscene;
	}

	protected void setHardscene(HardScene hardscene) {
		this.hardscene = hardscene;
	}

	protected GameSceneButtons getGamescenebuttons2() {
		return gamescenebuttons2;
	}

	protected void setGamescenebuttons2(GameSceneButtons gamescenebuttons2) {
		this.gamescenebuttons2 = gamescenebuttons2;
	}

	protected GameSceneButtons getGamescenebuttons3() {
		return gamescenebuttons3;
	}

	protected void setGamescenebuttons3(GameSceneButtons gamescenebuttons3) {
		this.gamescenebuttons3 = gamescenebuttons3;
	}

	protected PauseScene getPausescene2() {
		return pausescene2;
	}

	protected void setPausescene2(PauseScene pausescene2) {
		this.pausescene2 = pausescene2;
	}

	protected PauseScene getPausescene3() {
		return pausescene3;
	}

	protected void setPausescene3(PauseScene pausescene3) {
		this.pausescene3 = pausescene3;
	}

}


 


