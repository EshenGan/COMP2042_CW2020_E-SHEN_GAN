/** @Extension
 * extra levels
 */

package game_app;
import javafx.scene.Scene;




public class MediumScene {
	private ScoreHandler scorehandler2;
	private GamePane gameroot2;
	private Frog frog2;
	private Scene scenegame2;
	private BackgroundImage froggerbackground2;
	private final String fp2 = "D:\\(A)Y2_CSAI\\software maintenance\\COMP2042_CW2020_E-SHEN_GAN\\Frogger\\scoreboard2.txt";
	
public MediumScene() { //view
		setGameroot2( new GamePane());
		setFroggerbackground2(new BackgroundImage("file:src/main/resources/backdropfrogger600x800.jpg"));
		/**@RefactorFactoryMethodDesignPattern
		 * Replace constructor with factory method
		 */		
		setFrog2(Frog.createFrog("file:src/main/resources/froggerUp.png"));
		getGameroot2().add(getFroggerbackground2());
		getGameroot2().add(new Digit(0, 40, 360, 25)); //changed xpos to 560 from 360, changed back to 360
		buildLogs();
		buildTurtles();
		buildFrogHome();
		getGameroot2().add(getFrog2());//DO NOT EVER MOVE THIS method to other place		
		buildObstacles();
		setScenegame2(new Scene(getGameroot2(),598,745));//745
	}

//*****************************************************************************************************************************************************
//****************************************************************************CONTROLLER***************************************************************

	/**@Refactor
	 * gameroot2.start() is moved into start() 
	 */
	public void start() { //controller
		getGameroot2().start();
		getGameroot2().playMusic();
		setScorehandler2(ScoreHandler.createScoreHandler(getFrog2(), getGameroot2(), fp2));
		getScorehandler2().getAt().start();
    }

    public void stop() { //controller
    	getGameroot2().stop();
    	getGameroot2().stopMusic();
    	getScorehandler2().getAt().stop();
    }

//*****************************************************************************************************************************************************	
//************************************************************MODEL*******************************************************************************

/** @Refactor
 * extract method
 */
protected void buildFrogHome() {
	int ax2 = 13 , bx2= 141 , cx2=269;
	int dx2 = 398, ex2=527;
	int y2 = 96;
	getGameroot2().add(new Home(ax2,y2));
	getGameroot2().add(new Home(bx2,y2));
	getGameroot2().add(new Home(cx2,y2));
	getGameroot2().add(new Home(dx2,y2));
	getGameroot2().add(new Home(ex2,y2));
}

/**@Refactor
 * extract method
 */
protected void buildLogs() {
	//should i extract the parameters into objects instead?
	getGameroot2().add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 1.25));
	getGameroot2().add(new Log("file:src/main/resources/log3.png", 150, 220, 166, 1.25));
	getGameroot2().add(new Log("file:src/main/resources/log3.png", 150, 440, 166, 1.25));
	getGameroot2().add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -2.50));
	getGameroot2().add(new Log("file:src/main/resources/logs.png", 300, 400, 276, -2.50));
	getGameroot2().add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 1.25));
	getGameroot2().add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 1.25));
	getGameroot2().add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 1.25));
}

/** @Refactor
 * extract method
 */
protected void buildTurtles() {
	getGameroot2().add(new Turtle(500, 376, -2, 130, 130));
	getGameroot2().add(new Turtle(300, 376, -2, 130, 130));
	getGameroot2().add(new WetTurtle(700, 376, -2, 130, 130));
	getGameroot2().add(new WetTurtle(600, 217, -2, 130, 130));
	getGameroot2().add(new WetTurtle(400, 217, -2, 130, 130));
	getGameroot2().add(new WetTurtle(200, 217, -2, 130, 130));

}

/**@Refactor
 * extract method
 */
protected void buildObstacles() {
	getGameroot2().add(new Obstacle("file:src/main/resources/truck1Right.png", 0, 649, 2, 120, 120));
	getGameroot2().add(new Obstacle("file:src/main/resources/truck1Right.png", 300, 649, 2, 120, 120));
	getGameroot2().add(new Obstacle("file:src/main/resources/truck1Right.png", 600, 649, 2, 120, 120));
	getGameroot2().add(new Obstacle("file:src/main/resources/car1Left.png", 100, 597, -2, 50, 50));
	getGameroot2().add(new Obstacle("file:src/main/resources/car1Left.png", 250, 597, -2, 50, 50));
	getGameroot2().add(new Obstacle("file:src/main/resources/car1Left.png", 400, 597, -2, 50, 50));
	getGameroot2().add(new Obstacle("file:src/main/resources/car1Left.png", 550, 597, -2, 50, 50));
	getGameroot2().add(new Obstacle("file:src/main/resources/truck2Right.png", 0, 540, 2, 200, 200));
	getGameroot2().add(new Obstacle("file:src/main/resources/truck2Right.png", 500, 540, 2, 200, 200));
	getGameroot2().add(new Obstacle("file:src/main/resources/car1Left.png", 500, 490, -8, 50, 50));   	
}

public GamePane getGameroot2() {
	return gameroot2;
}


protected void setGameroot2(GamePane gameroot2) {
	this.gameroot2 = gameroot2;
}

public Frog getFrog2() {
	return frog2;
}


protected void setFrog2(Frog frog2) {
	this.frog2 = frog2;
}

public Scene getScenegame2() {
	return scenegame2;
}


protected void setScenegame2(Scene scenegame2) {
	this.scenegame2 = scenegame2;
}

public BackgroundImage getFroggerbackground2() {
	return froggerbackground2;
}


protected void setFroggerbackground2(BackgroundImage froggerbackground2) {
	this.froggerbackground2 = froggerbackground2;
}

public ScoreHandler getScorehandler2() {
	return scorehandler2;
}

public void setScorehandler2(ScoreHandler scorehandler2) {
	this.scorehandler2 = scorehandler2;
}
}
