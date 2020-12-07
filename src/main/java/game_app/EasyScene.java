/** @Refactor
 * extracted class from FroggerApp
 * method hiding of setter methods
 * use of factory method design pattern on setFrog1()
 * gameroot1.start() is moved into start()
 * set up aggregated field here before instantiating as object in start(Stage primaryStage)
 * field data encapsulation - OO Core Concept
 * self encapsulating field to avoid direct access of field even within own class
 * create setter and getter for encapsulated field
 * extracted methods - buildLogs() , buildFrogHome(), buildTurtles(), buildObstacles()
 */

package game_app;
import javafx.scene.Scene;

public class EasyScene {

	private ScoreHandler scorehandler;
	private GamePane gameroot1;
	private Frog frog1;
	private Scene scenegame1;
	private BackgroundImage froggerbackground;
	private final String fp = "D:\\(A)Y2_CSAI\\software maintenance\\COMP2042_CW2020_E-SHEN_GAN\\Frogger\\scoreboard.txt";

//*****************************************************************VIEW****************************************************
	public EasyScene() { //view
		setGameroot1( new GamePane());
		setFroggerbackground(new BackgroundImage("file:src/main/resources/backdropfrogger600x800.jpg"));
		setFrog1(Frog.createFrog("file:src/main/resources/froggerUp.png"));
		getGameroot1().add(getFroggerbackground());
		getGameroot1().add(new Digit(0, 40, 360, 25)); 
		buildLogs();
		buildTurtles();
		buildFrogHome();
		getGameroot1().add(getFrog1());					//DO NOT EVER MOVE THIS method to other place		
		buildObstacles();
		setScenegame1(new Scene(getGameroot1(),598,745));
	}

//********************************************************************************************************************************
//****************************************************************************CONTROLLER********************************************

	public void start() {
		getGameroot1().start();
		getGameroot1().playMusic();
		setScorehandler(ScoreHandler.createScoreHandler(getFrog1(), getGameroot1(), fp));
		getScorehandler().getAt().start();
	}

    public void stop() {
    	getGameroot1().stop();
    	getGameroot1().stopMusic();
    	getScorehandler().getAt().stop();

    }
//******************************************************************************************************************************
//************************************************************MODEL***************************************************************

	protected void buildFrogHome() {
		int ax = 13 , bx= 141 , cx=269;
		int dx = 398, ex=527;
		int y = 96;
		getGameroot1().add(new Home(ax,y));
		getGameroot1().add(new Home(bx,y));
		getGameroot1().add(new Home(cx,y));
		getGameroot1().add(new Home(dx,y));
		getGameroot1().add(new Home(ex,y));
	}
	
	protected void buildLogs() {
		getGameroot1().add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.75));
		getGameroot1().add(new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.75));
		getGameroot1().add(new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.75));
		getGameroot1().add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -2));
		getGameroot1().add(new Log("file:src/main/resources/logs.png", 300, 400, 276, -2));
		getGameroot1().add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.75));
		getGameroot1().add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.75));
		getGameroot1().add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.75));
	}
	
	protected void buildTurtles() {
		getGameroot1().add(new Turtle(500, 376, -1, 130, 130));
		getGameroot1().add(new Turtle(300, 376, -1, 130, 130));
		getGameroot1().add(new WetTurtle(700, 376, -1, 130, 130));
		getGameroot1().add(new WetTurtle(600, 217, -1, 130, 130));
		getGameroot1().add(new WetTurtle(400, 217, -1, 130, 130));
		getGameroot1().add(new WetTurtle(200, 217, -1, 130, 130));
	
	}
	
	protected void buildObstacles() {
		getGameroot1().add(new Obstacle("file:src/main/resources/truck1Right.png", 0, 649, 1, 120, 120));
		getGameroot1().add(new Obstacle("file:src/main/resources/truck1Right.png", 300, 649, 1, 120, 120));
		getGameroot1().add(new Obstacle("file:src/main/resources/truck1Right.png", 600, 649, 1, 120, 120));
		getGameroot1().add(new Obstacle("file:src/main/resources/car1Left.png", 100, 597, -1, 50, 50));
		getGameroot1().add(new Obstacle("file:src/main/resources/car1Left.png", 250, 597, -1, 50, 50));
		getGameroot1().add(new Obstacle("file:src/main/resources/car1Left.png", 400, 597, -1, 50, 50));
		getGameroot1().add(new Obstacle("file:src/main/resources/car1Left.png", 550, 597, -1, 50, 50));
		getGameroot1().add(new Obstacle("file:src/main/resources/truck2Right.png", 0, 540, 1, 200, 200));
		getGameroot1().add(new Obstacle("file:src/main/resources/truck2Right.png", 500, 540, 1, 200, 200));
		getGameroot1().add(new Obstacle("file:src/main/resources/car1Left.png", 500, 490, -5, 50, 50));   	
	}
	
	public GamePane getGameroot1() {
		return gameroot1;
	}
	
	
	protected void setGameroot1(GamePane gameroot1) {
		this.gameroot1 = gameroot1;
	}
	
	public Frog getFrog1() {
		return frog1;
	}
	
	
	protected void setFrog1(Frog frog1) {
		this.frog1 = frog1;
	}
	
	public Scene getScenegame1() {
		return scenegame1;
	}
	
	
	protected void setScenegame1(Scene scenegame1) {
		this.scenegame1 = scenegame1;
	}
	
	public BackgroundImage getFroggerbackground() {
		return froggerbackground;
	}
	
	
	protected void setFroggerbackground(BackgroundImage froggerbackground) {
		this.froggerbackground = froggerbackground;
	}

	public ScoreHandler getScorehandler() {
		return scorehandler;
	}

	public void setScorehandler(ScoreHandler scorehandler) {
		this.scorehandler = scorehandler;
	}
}
