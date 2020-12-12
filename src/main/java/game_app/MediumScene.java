/** @Extension
 * extra levels - similar to easy mode
 * increased speed of safe platforms and obstacles
 * added snake as another new obstacle
 */

package game_app;
import javafx.scene.Scene;

public class MediumScene{
	private ScoreHandler scorehandler2;
	private GamePane gameroot2;
	private Frog frog2;
	private Scene scenegame2;
	private BackgroundImage froggerbackground2;
	private final String fp2 = "D:\\(A)Y2_CSAI\\software maintenance\\COMP2042_CW2020_E-SHEN_GAN\\Frogger\\scoreboard2.txt";
//*****************************************************************CONTROLLER****************************************************************
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
		buildObstacles();
    	getGameroot2().add(SpriteFactory.createSnake(0, 445, 4, 80, 80,1));
		setScenegame2(new Scene(getGameroot2(),598,745));
	}

	public void start() { 
		getGameroot2().start();
		getGameroot2().playMusic();
		setScorehandler2(new ScoreHandler(getFrog2(), getGameroot2(), fp2));
		getScorehandler2().getAt().start();
    }

    public void stop() { 
    	getGameroot2().stop();
    	getGameroot2().stopMusic();
    	getScorehandler2().getAt().stop();
    }

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

	private void buildLogs() {
		getGameroot2().add(SpriteFactory.createLog("file:src/main/resources/log3.png", 150, 0, 166, 1.25));
		getGameroot2().add(SpriteFactory.createLog("file:src/main/resources/log3.png", 150, 220, 166, 1.25));
		getGameroot2().add(SpriteFactory.createLog("file:src/main/resources/log3.png", 150, 440, 166, 1.25));
		getGameroot2().add(SpriteFactory.createLog("file:src/main/resources/logs.png", 300, 0, 276, -2.50));
		getGameroot2().add(SpriteFactory.createLog("file:src/main/resources/logs.png", 300, 400, 276, -2.50));
		getGameroot2().add(SpriteFactory.createLog("file:src/main/resources/log3.png", 150, 50, 329, 1.25));
		getGameroot2().add(SpriteFactory.createLog("file:src/main/resources/log3.png", 150, 270, 329, 1.25));
		getGameroot2().add(SpriteFactory.createLog("file:src/main/resources/log3.png", 150, 490, 329, 1.25));
	}

	private void buildTurtles() {
		getGameroot2().add(SpriteFactory.createTurtle(500, 376, -2, 130, 130));
		getGameroot2().add(SpriteFactory.createTurtle(300, 376, -2, 130, 130));
		getGameroot2().add(SpriteFactory.createWetTurtle(700, 376, -2, 130, 130));
		getGameroot2().add(SpriteFactory.createWetTurtle(600, 217, -2, 130, 130));
		getGameroot2().add(SpriteFactory.createWetTurtle(400, 217, -2, 130, 130));
		getGameroot2().add(SpriteFactory.createWetTurtle(200, 217, -2, 130, 130));
	
	}

	private void buildObstacles() {
		getGameroot2().add(SpriteFactory.createVehicles("file:src/main/resources/truck1Right.png", 0, 649, 2, 120, 120));
		getGameroot2().add(SpriteFactory.createVehicles("file:src/main/resources/truck1Right.png", 300, 649, 2, 120, 120));
		getGameroot2().add(SpriteFactory.createVehicles("file:src/main/resources/truck1Right.png", 600, 649, 2, 120, 120));
		getGameroot2().add(SpriteFactory.createVehicles("file:src/main/resources/car1Left.png", 100, 597, -2, 50, 50));
		getGameroot2().add(SpriteFactory.createVehicles("file:src/main/resources/car1Left.png", 250, 597, -2, 50, 50));
		getGameroot2().add(SpriteFactory.createVehicles("file:src/main/resources/car1Left.png", 400, 597, -2, 50, 50));
		getGameroot2().add(SpriteFactory.createVehicles("file:src/main/resources/car1Left.png", 550, 597, -2, 50, 50));
		getGameroot2().add(SpriteFactory.createVehicles("file:src/main/resources/truck2Right.png", 0, 540, 2, 200, 200));
		getGameroot2().add(SpriteFactory.createVehicles("file:src/main/resources/truck2Right.png", 500, 540, 2, 200, 200));
		getGameroot2().add(SpriteFactory.createVehicles("file:src/main/resources/car1Left.png", 500, 490, -8, 50, 50));   	
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
	
	public ScoreHandler getScorehandler2() {
		return scorehandler2;
	}
	
	public void setScorehandler2(ScoreHandler scorehandler2) {
		this.scorehandler2 = scorehandler2;
	}
}
