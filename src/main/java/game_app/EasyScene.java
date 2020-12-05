/** @Refactor
 * extracted class from FroggerApp
 * method hiding of setter methods
 */

package game_app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;



public class EasyScene {
	/**
	 * @Refactor
	 * set up aggregated field here before instantiating as object in start(Stage primaryStage)
	 * field data encapsulation - OO Core Concept
	 * self encapsulating field to avoid direct access of field even within own class
	 * create setter and getter for encapsulated field
	 */
	private AnimationTimer timer;
	private Bgm gameroot1;
	private Frog frog1;
	private Scene scenegame1;
	private BackgroundImage froggerbackground;
	public int[] record;
	public int rounds; 
	//private GameSceneButtons scenebuttons;
	

	public EasyScene() { //view
	record = new int[5];
	rounds =0;
		setGameroot1( new Bgm());
		setFroggerbackground(new BackgroundImage("file:src/main/resources/backdropfrogger600x800.jpg"));
		/**@RefactorFactoryMethodDesignPattern
		 * Replace constructor with factory method
		 */		
		setFrog1(Frog.createFrog("file:src/main/resources/froggerUp.png"));
		getGameroot1().add(getFroggerbackground());
		getGameroot1().add(new Digit(0, 40, 360, 25)); //changed xpos to 560 from 360, changed back to 360
		buildLogs();
		buildTurtles();
		buildFrogHome();
		getGameroot1().add(getFrog1());//DO NOT EVER MOVE THIS method to other place		
		buildObstacles();
		setScenegame1(new Scene(getGameroot1(),598,745));//745
		//setScenebuttons(new GameSceneButtons());
		//getGameroot1().getChildren().addAll(getScenebuttons());
	}

//*****************************************************************************************************************************************************
//****************************************************************************CONTROLLER***************************************************************

	/**@Refactor
	 * gameroot1.start() is moved into start() 
	 */
	public void start() { //controller
		getGameroot1().start();
		getGameroot1().playMusic();
		createTimer();
        getTimer().start();
    }

    public void stop() { //controller
   	getTimer().stop();
    }

//*****************************************************************************************************************************************************	
//************************************************************MODEL*******************************************************************************
protected void createTimer() { //model
    timer = new AnimationTimer() {
    	@Override
       public void handle(long now) {
        	if (getFrog1().getChangeScore()) {
        		setNumber(getFrog1().getPoints());
        	}
   			try {
    				FileWriter board = new FileWriter("D:\\(A)Y2_CSAI\\software maintenance\\"
    						+ "COMP2042_CW2020_E-SHEN_GAN\\Frogger\\scoreboard.txt",true);
    				BufferedWriter writescore = new BufferedWriter(board);
    				BufferedReader readscore = new BufferedReader(new FileReader("D:\\(A)Y2_CSAI\\software maintenance\\"
    						+ "COMP2042_CW2020_E-SHEN_GAN\\Frogger\\scoreboard.txt"));
    				Alert alert = new Alert(AlertType.INFORMATION);
    				String currentline;
                	if (getFrog1().getStop()) {// if end is equal to 5 then 
                		getGameroot1().stopMusic();
                		//GamePane.createbgm().stopMusic(); // stopMusic();
                		stop();
                		getGameroot1().stop();
                		
                		alert.setTitle("You Have Won The Game!");
                		alert.setHeaderText("Your Score: "+getFrog1().getPoints()+"!");
						writescore.write(""+getFrog1().getPoints());
	        			writescore.newLine();
	        			writescore.close();
	        			while((currentline = readscore.readLine()) != null) {
	        				//currentline = readscore.readLine();
	        				int x = Integer.parseUnsignedInt(currentline);
		        			for(int k=0;k<5;k++) {
		        				if(x == record[k]) {
		        					x=0;
		        				}
		        			}		        				
	        				
		        			if (rounds == 5 || rounds > 5) {
	        				  if(x > record[4]) {
	        					  record[4] = x;
	        				  }
		        			}
        			
		        			if(rounds <5) {
		        				record[rounds] = x;
		        			}
		        			rounds++;
		        			BubbleSort.bubbleSort(record);

	        			}
	        			readscore.close();
		        		alert.setContentText("Top 5 high scores\nHighest recorded score:\n"+record[0]+"\n Other high scores:\n"
				        		+record[1]+"\n"+record[2]+"\n"+record[3]+
				        		"\n"+record[4]+"\n\nHighest possible score: 800");
		        		alert.show();
		        		System.out.println("success"+rounds);
	        			//System.exit(0);
                	}

        		
				} 
    			catch (IOException e) {
				e.printStackTrace();}
        }    
    };
}

public AnimationTimer getTimer() {
	return timer;
}

/** @Refactor
 *extract method
 */

protected void setNumber(int n) {//model
	int shift = 0;
	while (n > 0) {
		  int d = n / 10;
		  int k = n - d * 10;
		  n = d;
		  getGameroot1().add(new Digit(k, 40, 360 - shift, 25)); //changed xpos to 560, changed back to 360
		  shift+=30;
		}
}

/** @Refactor
 * extract method
 */
protected void buildFrogHome() {
	int ax = 13 , bx= 141 , cx=269;
	int dx = 398, ex=527;
	int y = 96;
	getGameroot1().add(new End(ax,y));
	getGameroot1().add(new End(bx,y));
	getGameroot1().add(new End(cx,y));
	getGameroot1().add(new End(dx,y));
	getGameroot1().add(new End(ex,y));
}

/**@Refactor
 * extract method
 */
protected void buildLogs() {
	//should i extract the parameters into objects instead?
	getGameroot1().add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.75));
	getGameroot1().add(new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.75));
	getGameroot1().add(new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.75));
	getGameroot1().add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -2));
	getGameroot1().add(new Log("file:src/main/resources/logs.png", 300, 400, 276, -2));
	getGameroot1().add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.75));
	getGameroot1().add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.75));
	getGameroot1().add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.75));
}

/** @Refactor
 * extract method
 */
protected void buildTurtles() {
	getGameroot1().add(new Turtle(500, 376, -1, 130, 130));
	getGameroot1().add(new Turtle(300, 376, -1, 130, 130));
	getGameroot1().add(new WetTurtle(700, 376, -1, 130, 130));
	getGameroot1().add(new WetTurtle(600, 217, -1, 130, 130));
	getGameroot1().add(new WetTurtle(400, 217, -1, 130, 130));
	getGameroot1().add(new WetTurtle(200, 217, -1, 130, 130));

}

/**@Refactor
 * extract method
 */
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

public Bgm getGameroot1() {
	return gameroot1;
}


protected void setGameroot1(Bgm gameroot1) {
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

//public GameSceneButtons getScenebuttons() {
//	return scenebuttons;
//}
//
//public void setScenebuttons(GameSceneButtons scenebuttons) {
//	this.scenebuttons = scenebuttons;
//}
}
