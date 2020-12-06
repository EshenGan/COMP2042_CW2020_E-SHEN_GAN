/** @Extension
 * extra levels
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



public class HardScene {
	private AnimationTimer timer3;
	private GamePane gameroot3;
	private Frog frog3;
	private Scene scenegame3;
	private BackgroundImage froggerbackground3;
	public int[] record3;
	public int rounds3; 
	

	public HardScene() { //view
	record3 = new int[5];
	rounds3 =0;
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
		setScenegame3(new Scene(getGameroot3(),598,745));//745
		//setScenebuttons(new GameSceneButtons());
		//getGameroot1().getChildren().addAll(getScenebuttons());
	}

//*****************************************************************************************************************************************************
//****************************************************************************CONTROLLER***************************************************************

	/**@Refactor
	 * gameroot3.start() is moved into start() 
	 */
	public void start() { //controller
		getGameroot3().start();
		getGameroot3().playMusic();
		createTimer3();
        getTimer3().start();
    }

    public void stop() { //controller
    	getGameroot3().stop();
    	getGameroot3().stopMusic();
    	getTimer3().stop();
    }

//*****************************************************************************************************************************************************	
//************************************************************MODEL*******************************************************************************
protected void createTimer3() { //model
    timer3 = new AnimationTimer() {
    	@Override
       public void handle(long now) {
        	if (getFrog3().getChangeScore()) {
        		setNumber3(getFrog3().getPoints());
        	}
   			try {
    				FileWriter board3 = new FileWriter("D:\\(A)Y2_CSAI\\software maintenance\\"
    						+ "COMP2042_CW2020_E-SHEN_GAN\\Frogger\\scoreboard3.txt",true);
    				BufferedWriter writescore3 = new BufferedWriter(board3);
    				BufferedReader readscore3 = new BufferedReader(new FileReader("D:\\(A)Y2_CSAI\\software maintenance\\"
    						+ "COMP2042_CW2020_E-SHEN_GAN\\Frogger\\scoreboard3.txt"));
    				Alert alert3 = new Alert(AlertType.INFORMATION);
    				String currentline3;
                	if (getFrog3().gameOver()) { // if frog home is equal to 5 then 
                		getGameroot3().stopMusic();
                		//GamePane.createbgm().stopMusic(); // stopMusic();
                		stop();
                		getGameroot3().stop();
                		
                		alert3.setTitle("You Have Won The Game!");
                		alert3.setHeaderText("Your Score: "+getFrog3().getPoints()+"!");
						writescore3.write(""+getFrog3().getPoints());
	        			writescore3.newLine();
	        			writescore3.close();
	        			while((currentline3 = readscore3.readLine()) != null) {
	        				//currentline = readscore.readLine();
	        				int x3 = Integer.parseUnsignedInt(currentline3);
		        			for(int j=0;j<5;j++) {
		        				if(x3 == record3[j]) {
		        					x3=0;
		        				}
		        			}		        				
	        				
		        			if (rounds3 == 5 || rounds3 > 5) {
	        				  if(x3 > record3[4]) {
	        					  record3[4] = x3;
	        				  }
		        			}
        			
		        			if(rounds3 <5) {
		        				record3[rounds3] = x3;
		        			}
		        			rounds3++;
		        			BubbleSort.bubbleSort(record3);

	        			}
	        			readscore3.close();
		        		alert3.setContentText("Top 5 high scores\nHighest recorded score:\n"+record3[0]+"\n Other high scores:\n"
				        		+record3[1]+"\n"+record3[2]+"\n"+record3[3]+
				        		"\n"+record3[4]+"\n\nHighest possible score: 800");
		        		alert3.show();
		        		System.out.println("success"+rounds3);
	        			//System.exit(0);
                	}

        		
				} 
    			catch (IOException e) {
				e.printStackTrace();}
        }    
    };
}

public AnimationTimer getTimer3() {
	return timer3;
}

/** @Refactor
 *extract method
 */

protected void setNumber3(int n) {//model
	int shift3 = 0;
	while (n > 0) {
		  int d3 = n / 10;
		  int k3 = n - d3 * 10;
		  n = d3;
		  getGameroot3().add(new Digit(k3, 40, 360 - shift3, 25)); //changed xpos to 560, changed back to 360
		  shift3+=30;
		}
}

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
}
