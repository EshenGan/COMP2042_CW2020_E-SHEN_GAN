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



public class MediumScene {
	private AnimationTimer timer2;
	private Bgm gameroot2;
	private Frog frog2;
	private Scene scenegame2;
	private BackgroundImage froggerbackground2;
	public int[] record2;
	public int rounds2; 
	

	public MediumScene() { //view
	record2 = new int[5];
	rounds2 =0;
		setGameroot2( new Bgm());
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
		//setScenebuttons(new GameSceneButtons());
		//getGameroot1().getChildren().addAll(getScenebuttons());
	}

//*****************************************************************************************************************************************************
//****************************************************************************CONTROLLER***************************************************************

	/**@Refactor
	 * gameroot1.start() is moved into start() 
	 */
	public void start() { //controller
		getGameroot2().start();
		getGameroot2().playMusic();
		createTimer2();
        getTimer2().start();
    }

    public void stop() { //controller
   	getTimer2().stop();
    }

//*****************************************************************************************************************************************************	
//************************************************************MODEL*******************************************************************************
protected void createTimer2() { //model
    timer2 = new AnimationTimer() {
    	@Override
       public void handle(long now) {
        	if (getFrog2().getChangeScore()) {
        		setNumber2(getFrog2().getPoints());
        	}
   			try {
    				FileWriter board2 = new FileWriter("D:\\(A)Y2_CSAI\\software maintenance\\"
    						+ "COMP2042_CW2020_E-SHEN_GAN\\Frogger\\scoreboard2.txt",true);
    				BufferedWriter writescore2 = new BufferedWriter(board2);
    				BufferedReader readscore2 = new BufferedReader(new FileReader("D:\\(A)Y2_CSAI\\software maintenance\\"
    						+ "COMP2042_CW2020_E-SHEN_GAN\\Frogger\\scoreboard2.txt"));
    				Alert alert2 = new Alert(AlertType.INFORMATION);
    				String currentline2;
                	if (getFrog2().getStop()) {// if end is equal to 5 then 
                		getGameroot2().stopMusic();
                		//GamePane.createbgm().stopMusic(); // stopMusic();
                		stop();
                		getGameroot2().stop();
                		
                		alert2.setTitle("You Have Won The Game!");
                		alert2.setHeaderText("Your Score: "+getFrog2().getPoints()+"!");
						writescore2.write(""+getFrog2().getPoints());
	        			writescore2.newLine();
	        			writescore2.close();
	        			while((currentline2 = readscore2.readLine()) != null) {
	        				//currentline = readscore.readLine();
	        				int x2 = Integer.parseUnsignedInt(currentline2);
		        			for(int i=0;i<5;i++) {
		        				if(x2 == record2[i]) {
		        					x2=0;
		        				}
		        			}		        				
	        				
		        			if (rounds2 == 5 || rounds2 > 5) {
	        				  if(x2 > record2[4]) {
	        					  record2[4] = x2;
	        				  }
		        			}
        			
		        			if(rounds2 <5) {
		        				record2[rounds2] = x2;
		        			}
		        			rounds2++;
		        			BubbleSort.bubbleSort(record2);

	        			}
	        			readscore2.close();
		        		alert2.setContentText("Top 5 high scores\nHighest recorded score:\n"+record2[0]+"\n Other high scores:\n"
				        		+record2[1]+"\n"+record2[2]+"\n"+record2[3]+
				        		"\n"+record2[4]+"\n\nHighest possible score: 800");
		        		alert2.show();
		        		System.out.println("success"+rounds2);
	        			//System.exit(0);
                	}

        		
				} 
    			catch (IOException e) {
				e.printStackTrace();}
        }    
    };
}

public AnimationTimer getTimer2() {
	return timer2;
}

/** @Refactor
 *extract method
 */

protected void setNumber2(int n) {//model
	int shift2 = 0;
	while (n > 0) {
		  int d2 = n / 10;
		  int k2 = n - d2 * 10;
		  n = d2;
		  getGameroot2().add(new Digit(k2, 40, 360 - shift2, 25)); //changed xpos to 560, changed back to 360
		  shift2+=30;
		}
}

/** @Refactor
 * extract method
 */
protected void buildFrogHome() {
	int ax2 = 13 , bx2= 141 , cx2=269;
	int dx2 = 398, ex2=527;
	int y2 = 96;
	getGameroot2().add(new End(ax2,y2));
	getGameroot2().add(new End(bx2,y2));
	getGameroot2().add(new End(cx2,y2));
	getGameroot2().add(new End(dx2,y2));
	getGameroot2().add(new End(ex2,y2));
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

public Bgm getGameroot2() {
	return gameroot2;
}


protected void setGameroot2(Bgm gameroot2) {
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
}
