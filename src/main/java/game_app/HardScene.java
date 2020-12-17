package game_app;

import javafx.scene.Scene;
/** <b>Extension</b>:
 * <p>. Extra level, similar to easy mode scene(original from Main.java)<br>
 * . Changed speed,position and direction of safe platforms and obstacles<br>
 * . Added snake as another new obstacle<br>
 * . Level that is meant to be quite difficult compared to easy mode</p>
 */
public class HardScene{
	private AnimationHandler ah3;
	private GamePane gameroot3;
	private Frog frog3;
	private Scene scenegame3;
	private BackgroundImage froggerbackground3;
	private final String fp3 = "scoreboard3.txt";//D:\\(A)Y2_CSAI\\software maintenance\\COMP2042_CW2020_E-SHEN_GAN\\Frogger\\

//*****************************************************************VIEW****************************************************************
	/**Construct game scene and sprites for hard mode 
	 */
	HardScene() { 
		setGameroot3( new GamePane());
		setFroggerbackground3(SpriteFactory.createBackgroundImage("file:src/main/resources/backdropfrogger600x800.jpg"));
		setFrog3(SpriteFactory.createFrog("file:src/main/resources/froggerUp.png","HARD"));
		getGameroot3().add(getFroggerbackground3());
		getGameroot3().add(SpriteFactory.createDigit(0, 40, 360, 25)); 
		buildLogs();
		buildTurtles();
		buildFrogHome();
		getGameroot3().add(getFrog3());//DO NOT EVER MOVE THIS method to other place		
		buildVehicles();
    	getGameroot3().add(SpriteFactory.createSnake(0, 445, -6, 80, 80,2));
		setScenegame3(new Scene(getGameroot3(),598,745));
	}
//****************************************************************************CONTROLLER*************************************************
	/**method to start everything in game scene
	 */
	public void start() { 
		getGameroot3().start();
		getGameroot3().playMusic();
		setAh3(new AnimationHandler(getFrog3(), getGameroot3(),fp3));
		getAh3().getAt().start();
    }

	/**method to stop/pause everything in game scene
	 */
    public void stop() { 
    	getGameroot3().stop();
    	getGameroot3().stopMusic();
    	getAh3().getAt().stop();
    }
   
    /**<b>REFACTOR</b>:<br>
     * ? extracted methods:buildFrogHome()<br>
     * ? method hiding of extracted methods
     */
	private void buildFrogHome() {
		int ax3 = 13 , bx3= 141 , cx3=269;
		int dx3 = 398, ex3=527;
		int y3 = 96;
		getGameroot3().add(SpriteFactory.createHome(ax3, y3));
		getGameroot3().add(SpriteFactory.createHome(bx3, y3));
		getGameroot3().add(SpriteFactory.createHome(cx3, y3));
		getGameroot3().add(SpriteFactory.createHome(dx3, y3));
		getGameroot3().add(SpriteFactory.createHome(ex3, y3));
	}
	
	/**<b>REFACTOR</b>:<br>
	 * ? extracted methods:buildLogs()<br>
	 * ? method hiding of extracted methods
	 */
	private void buildLogs() {

		getGameroot3().add(SpriteFactory.createLog("file:src/main/resources/log2.png", 190, 50, 166, 1.75));
		//getGameroot3().add(SpriteFactory.createLog("file:src/main/resources/log2.png", 190, 470, 276, -3));
		getGameroot3().add(SpriteFactory.createLog("file:src/main/resources/logs.png", 300, 0, 276, -3));	
		//getGameroot3().add(SpriteFactory.createLog("file:src/main/resources/logs.png", 300, 400, 329, 1.75));
		getGameroot3().add(SpriteFactory.createLog("file:src/main/resources/log3.png", 150, 0, 329, 1.75));
		//getGameroot3().add(SpriteFactory.createLog("file:src/main/resources/log2.png", 190, 490, 329, 1.75));
	}
	
	/**<b>REFACTOR</b>:<br>
	 * ? extracted methods:buildTurtles()<br>
	 * ? method hiding of extracted methods
	 */
	private void buildTurtles() {
		getGameroot3().add(SpriteFactory.createTurtle(600, 217, -3, 130, 130,2));//500,376
		//getGameroot3().add(SpriteFactory.createTurtle(400, 217, -3, 130, 130));//300,376
		//getGameroot3().add(SpriteFactory.createWetTurtle(200, 217, -3, 130, 130));//700,376
		//getGameroot3().add(SpriteFactory.createWetTurtle(400,376, 3, 130, 130));//600, 217 //needs new animation
		getGameroot3().add(SpriteFactory.createWetTurtle(200,376, 3, 130, 130,1));//400, 217 //needs new animation
		//getGameroot3().add(SpriteFactory.createWetTurtle(700,376, 3, 130, 130));//200, 217 //needs new animation
	
	}
	
	/**<b>REFACTOR</b>:<br>
	 * ? extracted methods:buildVehicles()<br>
	 * ? method hiding of extracted methods
	 */
	private void buildVehicles() {
		getGameroot3().add(SpriteFactory.createVehicles("file:src/main/resources/truck2Right.png", 0, 649, 3, 200, 200));
		getGameroot3().add(SpriteFactory.createVehicles("file:src/main/resources/car1right.png", 250, 649, 3, 50, 50));
		getGameroot3().add(SpriteFactory.createVehicles("file:src/main/resources/car1right.png", 350, 649, 3, 50, 50));
		//getGameroot3().add(SpriteFactory.createVehicles("file:src/main/resources/car1right.png", 500, 649, 3, 50, 50));
		//getGameroot3().add(SpriteFactory.createVehicles("file:src/main/resources/car1right.png", 700, 649, 3, 50, 50));
		getGameroot3().add(SpriteFactory.createVehicles("file:src/main/resources/car1Left.png", 100, 597, -4, 50, 50));
		getGameroot3().add(SpriteFactory.createVehicles("file:src/main/resources/truck1Left.png", 190, 597, -4, 120, 120));
		getGameroot3().add(SpriteFactory.createVehicles("file:src/main/resources/truck1Left.png", 380, 597, -4, 120, 120));
		//getGameroot3().add(SpriteFactory.createVehicles("file:src/main/resources/car1Left.png", 535, 597, -3, 50, 50));
		getGameroot3().add(SpriteFactory.createVehicles("file:src/main/resources/truck2Left.png", 200, 540, -5, 200, 200));
		getGameroot3().add(SpriteFactory.createVehicles("file:src/main/resources/car1Left.png", 450, 540, -5, 50, 50));
		//getGameroot3().add(SpriteFactory.createVehicles("file:src/main/resources/truck1Left.png", 600, 540, -4, 120, 120));
		getGameroot3().add(SpriteFactory.createVehicles("file:src/main/resources/car1right.png", 500, 490, 10, 50, 50));
		getGameroot3().add(SpriteFactory.createVehicles("file:src/main/resources/truck1Right.png", 0, 490, 10, 120, 120));
		 	
	}
	
//*****************************************************MODEL*************************************************************
	public GamePane getGameroot3() {
		return gameroot3;
	}
	
	
	public void setGameroot3(GamePane gameroot3) {
		this.gameroot3 = gameroot3;
	}
	
	public Frog getFrog3() {
		return frog3;
	}
	
	
	public void setFrog3(Frog frog3) {
		this.frog3 = frog3;
	}
	
	public Scene getScenegame3() {
		return scenegame3;
	}
	
	
	public void setScenegame3(Scene scenegame3) {
		this.scenegame3 = scenegame3;
	}
	
	public BackgroundImage getFroggerbackground3() {
		return froggerbackground3;
	}
	
	
	public void setFroggerbackground3(BackgroundImage froggerbackground3) {
		this.froggerbackground3 = froggerbackground3;
	}

	public AnimationHandler getAh3() {
		return ah3;
	}

	public void setAh3(AnimationHandler ah3) {
		this.ah3 = ah3;
	}
}
