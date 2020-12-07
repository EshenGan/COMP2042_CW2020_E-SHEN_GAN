/** @Extension
 * extra levels
 */

package game_app;
import javafx.scene.Scene;

public class HardScene {
	private ScoreHandler scorehandler3;
	private GamePane gameroot3;
	private Frog frog3;
	private Scene scenegame3;
	private BackgroundImage froggerbackground3;
	private final String fp3 = "D:\\(A)Y2_CSAI\\software maintenance\\COMP2042_CW2020_E-SHEN_GAN\\Frogger\\scoreboard3.txt";
	

	public HardScene() { //view
		setGameroot3( new GamePane());
		setFroggerbackground3(new BackgroundImage("file:src/main/resources/backdropfrogger600x800.jpg"));
		/**@RefactorFactoryMethodDesignPattern
		 * Replace constructor with factory method
		 */		
		setFrog3(Frog.createFrog("file:src/main/resources/froggerUp.png"));
		getGameroot3().add(getFroggerbackground3());
		getGameroot3().add(new Digit(0, 40, 360, 25)); //changed xpos to 560 from 360, changed back to 360
		buildLogs();
		buildTurtles();
		buildFrogHome();
		getGameroot3().add(getFrog3());//DO NOT EVER MOVE THIS method to other place		
		buildObstacles();
		setScenegame3(new Scene(getGameroot3(),598,745));
	}

//*****************************************************************************************************************************************************
//****************************************************************************CONTROLLER***************************************************************

	/**@Refactor
	 * gameroot3.start() is moved into start() 
	 */
	public void start() { //controller
		getGameroot3().start();
		getGameroot3().playMusic();
		setScorehandler3(ScoreHandler.createScoreHandler(getFrog3(), getGameroot3(), fp3));
		getScorehandler3().getAt().start();
    }

    public void stop() { //controller
    	getGameroot3().stop();
    	getGameroot3().stopMusic();
    	getScorehandler3().getAt().stop();
    }

//*****************************************************************************************************************************************************	
//************************************************************MODEL*******************************************************************************

/** @Refactor
 * extract method
 */
protected void buildFrogHome() {
	int ax3 = 13 , bx3= 141 , cx3=269;
	int dx3 = 398, ex3=527;
	int y3 = 96;
	getGameroot3().add(new Home(ax3,y3));
	getGameroot3().add(new Home(bx3,y3));
	getGameroot3().add(new Home(cx3,y3));
	getGameroot3().add(new Home(dx3,y3));
	getGameroot3().add(new Home(ex3,y3));
}

/**@Refactor
 * extract method
 */
protected void buildLogs() {
	//should i extract the parameters into objects instead?
	getGameroot3().add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 1.75));
	getGameroot3().add(new Log("file:src/main/resources/log3.png", 150, 220, 166, 1.75));
	getGameroot3().add(new Log("file:src/main/resources/log3.png", 150, 440, 166, 1.75));
	getGameroot3().add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -3));
	getGameroot3().add(new Log("file:src/main/resources/logs.png", 300, 400, 276, -3));
	getGameroot3().add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 1.75));
	getGameroot3().add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 1.75));
	getGameroot3().add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 1.75));
}

/** @Refactor
 * extract method
 */
protected void buildTurtles() {
	getGameroot3().add(new Turtle(500, 376, -3, 130, 130));
	getGameroot3().add(new Turtle(300, 376, -3, 130, 130));
	getGameroot3().add(new WetTurtle(700, 376, -3, 130, 130));
	getGameroot3().add(new WetTurtle(600, 217, -3, 130, 130));
	getGameroot3().add(new WetTurtle(400, 217, -3, 130, 130));
	getGameroot3().add(new WetTurtle(200, 217, -3, 130, 130));

}

/**@Refactor
 * extract method
 */
protected void buildObstacles() {
	getGameroot3().add(new Obstacle("file:src/main/resources/truck1Right.png", 0, 649, 3, 120, 120));
	getGameroot3().add(new Obstacle("file:src/main/resources/truck1Right.png", 300, 649, 3, 120, 120));
	getGameroot3().add(new Obstacle("file:src/main/resources/truck1Right.png", 600, 649, 3, 120, 120));
	getGameroot3().add(new Obstacle("file:src/main/resources/car1Left.png", 100, 597, -3, 50, 50));
	getGameroot3().add(new Obstacle("file:src/main/resources/car1Left.png", 250, 597, -3, 50, 50));
	getGameroot3().add(new Obstacle("file:src/main/resources/car1Left.png", 400, 597, -3, 50, 50));
	getGameroot3().add(new Obstacle("file:src/main/resources/car1Left.png", 550, 597, -3, 50, 50));
	getGameroot3().add(new Obstacle("file:src/main/resources/truck2Right.png", 0, 540, 3, 200, 200));
	getGameroot3().add(new Obstacle("file:src/main/resources/truck2Right.png", 500, 540, 3, 200, 200));
	getGameroot3().add(new Obstacle("file:src/main/resources/car1Left.png", 500, 490, -11, 50, 50));   	
}

public GamePane getGameroot3() {
	return gameroot3;
}


protected void setGameroot3(GamePane gameroot3) {
	this.gameroot3 = gameroot3;
}

public Frog getFrog3() {
	return frog3;
}


protected void setFrog3(Frog frog3) {
	this.frog3 = frog3;
}

public Scene getScenegame3() {
	return scenegame3;
}


protected void setScenegame3(Scene scenegame3) {
	this.scenegame3 = scenegame3;
}

public BackgroundImage getFroggerbackground3() {
	return froggerbackground3;
}


protected void setFroggerbackground3(BackgroundImage froggerbackground3) {
	this.froggerbackground3 = froggerbackground3;
}

public ScoreHandler getScorehandler3() {
	return scorehandler3;
}

public void setScorehandler3(ScoreHandler scorehandler3) {
	this.scorehandler3 = scorehandler3;
}
}
