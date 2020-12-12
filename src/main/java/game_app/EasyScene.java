/** @Refactor
 * extracted class from FroggerApp
 * gameroot1.start() is moved into start() from constructor body
 * field data encapsulation - OO Core Concept
 * self encapsulating field to avoid direct access of field even within own class
 * create setter and getter for encapsulated field
 * extracted methods - buildLogs() , buildFrogHome(), buildTurtles(), buildObstacles()
 * method hiding of extracted methods
 */

package game_app;

import javafx.scene.Scene;

public class EasyScene{

	private ScoreHandler scorehandler;
	private GamePane gameroot1;
	private Frog frog1;
	private Scene scenegame1;
	private BackgroundImage froggerbackground;
	private final String fp = "D:\\(A)Y2_CSAI\\software maintenance\\COMP2042_CW2020_E-SHEN_GAN\\Frogger\\scoreboard.txt";


//*****************************************************************CONTROLLER****************************************************************
	EasyScene() { 
		setGameroot1( new GamePane());
		setFroggerbackground(SpriteFactory.createBackgroundImage("file:src/main/resources/backdropfrogger600x800.jpg"));
		setFrog1(SpriteFactory.createFrog("file:src/main/resources/froggerUp.png","EASY"));
		getGameroot1().add(getFroggerbackground());
		getGameroot1().add(SpriteFactory.createDigit(0, 40, 360, 25)); 
		buildLogs();
		buildTurtles();
		buildFrogHome();
		getGameroot1().add(getFrog1());					//DO NOT EVER MOVE THIS method to other place		
		buildObstacles();
		setScenegame1(new Scene(getGameroot1(),598,745));
	}

	public void start() {
		getGameroot1().start();
		getGameroot1().playMusic();
		setScorehandler(new ScoreHandler(getFrog1(), getGameroot1(), fp));
		getScorehandler().getAt().start();
	}

    public void stop() {
    	getGameroot1().stop();
    	getGameroot1().stopMusic();
    	getScorehandler().getAt().stop();

    }

	private void buildFrogHome() {
		int ax = 13 , bx= 141 , cx=269;
		int dx = 398, ex=527;
		int y = 96;
		getGameroot1().add(SpriteFactory.createHome(ax, y));
		getGameroot1().add(SpriteFactory.createHome(bx, y));
		getGameroot1().add(SpriteFactory.createHome(cx, y));
		getGameroot1().add(SpriteFactory.createHome(dx, y));
		getGameroot1().add(SpriteFactory.createHome(ex, y));
	}
	
	private void buildLogs() {
		getGameroot1().add(SpriteFactory.createLog("file:src/main/resources/log3.png", 150, 0, 166, 0.75));
		getGameroot1().add(SpriteFactory.createLog("file:src/main/resources/log3.png", 150, 220, 166, 0.75));
		getGameroot1().add(SpriteFactory.createLog("file:src/main/resources/log3.png", 150, 440, 166, 0.75));
		getGameroot1().add(SpriteFactory.createLog("file:src/main/resources/logs.png", 300, 0, 276, -2));
		getGameroot1().add(SpriteFactory.createLog("file:src/main/resources/logs.png", 300, 400, 276, -2));
		getGameroot1().add(SpriteFactory.createLog("file:src/main/resources/log3.png", 150, 50, 329, 0.75));
		getGameroot1().add(SpriteFactory.createLog("file:src/main/resources/log3.png", 150, 270, 329, 0.75));
		getGameroot1().add(SpriteFactory.createLog("file:src/main/resources/log3.png", 150, 490, 329, 0.75));
	}
	
	private void buildTurtles() {
		getGameroot1().add(SpriteFactory.createTurtle(500, 376, -1, 130, 130));
		getGameroot1().add(SpriteFactory.createTurtle(300, 376, -1, 130, 130));
		getGameroot1().add(SpriteFactory.createWetTurtle(700, 376, -1, 130, 130));
		getGameroot1().add(SpriteFactory.createWetTurtle(600, 217, -1, 130, 130));
		getGameroot1().add(SpriteFactory.createWetTurtle(400, 217, -1, 130, 130));
		getGameroot1().add(SpriteFactory.createWetTurtle(200, 217, -1, 130, 130));
	
	}
	
	private void buildObstacles() {
		getGameroot1().add(SpriteFactory.createVehicles("file:src/main/resources/truck1Right.png", 0, 649, 1, 120, 120));
		getGameroot1().add(SpriteFactory.createVehicles("file:src/main/resources/truck1Right.png", 300, 649, 1, 120, 120));
		getGameroot1().add(SpriteFactory.createVehicles("file:src/main/resources/truck1Right.png", 600, 649, 1, 120, 120));
		getGameroot1().add(SpriteFactory.createVehicles("file:src/main/resources/car1Left.png", 100, 597, -1, 50, 50));
		getGameroot1().add(SpriteFactory.createVehicles("file:src/main/resources/car1Left.png", 250, 597, -1, 50, 50));
		getGameroot1().add(SpriteFactory.createVehicles("file:src/main/resources/car1Left.png", 400, 597, -1, 50, 50));
		getGameroot1().add(SpriteFactory.createVehicles("file:src/main/resources/car1Left.png", 550, 597, -1, 50, 50));
		getGameroot1().add(SpriteFactory.createVehicles("file:src/main/resources/truck2Right.png", 0, 540, 1, 200, 200));
		getGameroot1().add(SpriteFactory.createVehicles("file:src/main/resources/truck2Right.png", 500, 540, 1, 200, 200));
		getGameroot1().add(SpriteFactory.createVehicles("file:src/main/resources/car1Left.png", 500, 490, -5, 50, 50));   	
	}
	
//************************************************************MODEL***************************************************************
	public GamePane getGameroot1() {
		return gameroot1;
	}
	
	
	public void setGameroot1(GamePane gameroot1) {
		this.gameroot1 = gameroot1;
	}
	
	public Frog getFrog1() {
		return frog1;
	}
	
	
	public void setFrog1(Frog frog1) {
		this.frog1 = frog1;
	}

	public Scene getScenegame1() {
		return scenegame1;
	}
	
	
	public void setScenegame1(Scene scenegame1) {
		this.scenegame1 = scenegame1;
	}
	
	public BackgroundImage getFroggerbackground() {
		return froggerbackground;
	}
	
	
	public void setFroggerbackground(BackgroundImage froggerbackground) {
		this.froggerbackground = froggerbackground;
	}

	public ScoreHandler getScorehandler() {
		return scorehandler;
	}

	public void setScorehandler(ScoreHandler scorehandler) {
		this.scorehandler = scorehandler;
	}
}
