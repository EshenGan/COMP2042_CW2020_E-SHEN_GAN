package game_app;
import javafx.scene.Scene;
/** <b>EXTENSION</b>:
 * <p>. Extra levels,similar to easy mode<br>
 * . Changed speed,position and direction of safe platforms and obstacles<br>
 * . Added snake as another new obstacle<br>
 * . Level that is meant to be slightly more difficult than easy mode</p>
 */
public class MediumScene{
	private AnimationHandler ah2;
	private GamePane gameroot2;
	private Frog frog2;
	private Scene scenegame2;
	private BackgroundImage froggerbackground2;
	private final String fp2 = "scoreboard2.txt";//D:\\(A)Y2_CSAI\\software maintenance\\COMP2042_CW2020_E-SHEN_GAN\\Frogger\\
//*****************************************************************CONTROLLER****************************************************************
	/**Construct game scene  and sprites for medium mode 
	 */
	MediumScene() { 
		setGameroot2( new GamePane());
		setFroggerbackground2(SpriteFactory.createBackgroundImage("file:src/main/resources/backdropfrogger600x800.jpg"));
		setFrog2(SpriteFactory.createFrog("file:src/main/resources/froggerUp.png","MEDIUM"));
		getGameroot2().add(getFroggerbackground2());
		getGameroot2().add(SpriteFactory.createDigit(0, 40, 360, 25)); 
		buildLogs();
		buildTurtles();
		buildFrogHome();
		getGameroot2().add(getFrog2());//DO NOT EVER MOVE THIS method to other place		
		buildVehicles();
    	getGameroot2().add(SpriteFactory.createSnake(0, 445, 4, 80, 80,1));
		setScenegame2(new Scene(getGameroot2(),598,745));
	}

	/** method to start everything in game scene
	 */
	public void start() { 
		getGameroot2().start();
		getGameroot2().playMusic();
		setAh2(new AnimationHandler(getFrog2(), getGameroot2(),fp2));
		getAh2().getAt().start();
    }
	
	/**
	 * method to stop/pause everything in game scene
	 */
    public void stop() { 
    	getGameroot2().stop();
    	getGameroot2().stopMusic();
		getAh2().getAt().stop();
    }

	/**<b>REFACTOR</b>:<br>
	 * ? extracted methods:buildFrogHome()<br>
	 * ? method hiding of extracted methods
	 */
	private void buildFrogHome() {
		int ax2 = 13 , bx2= 141 , cx2=269;
		int dx2 = 398, ex2=527;
		int y2 = 96;
		getGameroot2().add(SpriteFactory.createHome(ax2, y2));
		getGameroot2().add(SpriteFactory.createHome(bx2, y2));
		getGameroot2().add(SpriteFactory.createHome(cx2, y2));
		getGameroot2().add(SpriteFactory.createHome(dx2, y2));
		getGameroot2().add(SpriteFactory.createHome(ex2, y2));
	}

	/**<b>REFACTOR</b>:<br>
	 * ? extracted methods:buildLogs()<br>
	 * ? method hiding of extracted methods
	 */
	private void buildLogs() {
		getGameroot2().add(SpriteFactory.createLog("file:src/main/resources/log3.png", 150, 550, 166, -1.25));
		//getGameroot2().add(SpriteFactory.createLog("file:src/main/resources/log3.png", 150, 440, 276, -2.50));
		getGameroot2().add(SpriteFactory.createLog("file:src/main/resources/logs.png", 300, 0, 276, -2.50));
		//getGameroot2().add(SpriteFactory.createLog("file:src/main/resources/logs.png", 300, 150, 166, -1.25));
		getGameroot2().add(SpriteFactory.createLog("file:src/main/resources/log3.png", 150, 50, 329, 1.25));
		//getGameroot2().add(SpriteFactory.createLog("file:src/main/resources/log3.png", 150, 270, 329, 1.25));
		getGameroot2().add(SpriteFactory.createLog("file:src/main/resources/log2.png", 190, 510, 329, 1.25));
	}

	/**<b>REFACTOR</b>:<br>
	 * ? extracted methods:buildTurtles()<br>
	 * ? method hiding of extracted methods
	 */
	private void buildTurtles() {
		getGameroot2().add(SpriteFactory.createTurtle(550, 376, 2, 130, 130,1)); //needs new animation
		getGameroot2().add(SpriteFactory.createWetTurtle(250, 376, 2, 130, 130,1)); //needs new animation
		getGameroot2().add(SpriteFactory.createTurtle(600, 217, -2, 130, 130,2));
		getGameroot2().add(SpriteFactory.createWetTurtle(400, 217, -2, 130, 130,2));
		//getGameroot2().add(SpriteFactory.createWetTurtle(200, 217, -2, 130, 130));
	
	}

	/**<b>REFACTOR</b>:<br>
	 * ? extracted methods:buildVehicles()<br>
	 * ? method hiding of extracted methods
	 */
	private void buildVehicles() {
		getGameroot2().add(SpriteFactory.createVehicles("file:src/main/resources/truck1Left.png", 200, 597, -2, 120, 120));//649
		getGameroot2().add(SpriteFactory.createVehicles("file:src/main/resources/truck1Left.png", 400, 597, -2, 120, 120));
		getGameroot2().add(SpriteFactory.createVehicles("file:src/main/resources/truck1Left.png", 600, 597, -2, 120, 120));
		getGameroot2().add(SpriteFactory.createVehicles("file:src/main/resources/car1right.png", 100, 649, 3, 50, 50));//597
		getGameroot2().add(SpriteFactory.createVehicles("file:src/main/resources/car1right.png", 250,649, 3, 50, 50));
		getGameroot2().add(SpriteFactory.createVehicles("file:src/main/resources/car1right.png", 400, 649, 3, 50, 50));
		getGameroot2().add(SpriteFactory.createVehicles("file:src/main/resources/car1right.png", 550, 649, 3, 50, 50));
		getGameroot2().add(SpriteFactory.createVehicles("file:src/main/resources/truck2Left.png", 400, 490, -4, 200, 200));//540
		getGameroot2().add(SpriteFactory.createVehicles("file:src/main/resources/truck2Left.png", 650, 490, -4, 200, 200));
		getGameroot2().add(SpriteFactory.createVehicles("file:src/main/resources/car1right.png", 500, 540, 8, 50, 50)); //490  	
	}
	
//************************************************************MODEL*******************************************************************************
	public GamePane getGameroot2() {
		return gameroot2;
	}
	
	
	public void setGameroot2(GamePane gameroot2) {
		this.gameroot2 = gameroot2;
	}
	
	public Frog getFrog2() {
		return frog2;
	}
	
	
	public void setFrog2(Frog frog2) {
		this.frog2 = frog2;
	}
	
	public Scene getScenegame2() {
		return scenegame2;
	}
	
	
	public void setScenegame2(Scene scenegame2) {
		this.scenegame2 = scenegame2;
	}
	
	public BackgroundImage getFroggerbackground2() {
		return froggerbackground2;
	}
	
	
	public void setFroggerbackground2(BackgroundImage froggerbackground2) {
		this.froggerbackground2 = froggerbackground2;
	}

	public AnimationHandler getAh2() {
		return ah2;
	}

	public void setAh2(AnimationHandler ah2) {
		this.ah2 = ah2;
	}
}
