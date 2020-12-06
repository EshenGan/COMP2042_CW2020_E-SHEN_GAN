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
	private AnimationTimer timer;
	private GamePane gameroot1;
	private Frog frog1;
	private Scene scenegame1;
	private BackgroundImage froggerbackground;
	private int[] record;
	private int rounds; 
//*****************************************************************VIEW****************************************************
	public EasyScene() { //view
		setRecord(new int[5]);
		setRounds(0);
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
		createTimer();
        getTimer().start();
    }

    public void stop() {
    	getGameroot1().stop();
    	getGameroot1().stopMusic();
    	getTimer().stop();
    }
   
    protected void createTimer() {
        timer = new AnimationTimer() {
        	@Override
           public void handle(long now) {
            	if (getFrog1().getChangeScore()) {
            		setNumber(getFrog1().getPoints());
            	}
            	/**@Extension
            	 */
       			try { 
        				FileWriter board = new FileWriter("D:\\(A)Y2_CSAI\\software maintenance\\"
        						+ "COMP2042_CW2020_E-SHEN_GAN\\Frogger\\scoreboard.txt",true);
        				BufferedWriter writescore = new BufferedWriter(board);
        				BufferedReader readscore = new BufferedReader(new FileReader("D:\\(A)Y2_CSAI\\software maintenance\\"
        						+ "COMP2042_CW2020_E-SHEN_GAN\\Frogger\\scoreboard.txt"));
        				Alert alert = new Alert(AlertType.INFORMATION);
        				String currentline;
                    	if (getFrog1().gameOver()) {// if frog home is equal to 5 then 
                    		getGameroot1().stopMusic();
                    		stop();
                    		getGameroot1().stop();
                    		
                    		alert.setTitle("You Have Won The Game!");
                    		alert.setHeaderText("Your Score: "+getFrog1().getPoints()+"!");
    						writescore.write(""+getFrog1().getPoints());
    	        			writescore.newLine();
    	        			writescore.close();
    	        			while((currentline = readscore.readLine()) != null) {
    	        				int x = Integer.parseUnsignedInt(currentline);
    	        				
    		        			for(int k=0;k<5;k++) {
    		        				if(x == getRecord()[k]) { // if same score is read from different line, it will be ignored
    		        					x=0;
    		        				}
    		        			}		        				
    	        				
    		        			if (getRounds() == 5 || getRounds() > 5) { // only the 5 highest scores among all will be shown
    	        				  if(x > getRecord()[4]) {  // starting from the 6th round , if higher than the lowest in top 5,            
    	        					  getRecord()[4] = x;   //then 5th highest will be replaced 
    	        				  }
    		        			}
            			
    		        			if(getRounds() <5) { //first 5 rounds will be recorded in array "record"
    		        				getRecord()[getRounds()] = x;
    		        			}
    		        			addRounds(1); //rounds++;
    		        			BubbleSort.bubbleSort(getRecord()); // sort scores in record array descendingly

    	        			}
    	        			readscore.close();
    		        		alert.setContentText("Top 5 high scores\nHighest recorded score:\n"+record[0]+"\n Other high scores:\n"
    				        		+record[1]+"\n"+record[2]+"\n"+record[3]+
    				        		"\n"+record[4]+"\n\nHighest possible score: 800");
    		        		alert.show();
    		        		System.out.println("success"+rounds);
                    	}

            		
    				} 
        			catch (IOException e) {
    				e.printStackTrace();}
            }    
        };
    }

//******************************************************************************************************************************
//************************************************************MODEL***************************************************************
	public AnimationTimer getTimer() {
		return timer;
	}
	
	public void setNumber(int n) {
		int shift = 0;
		while (n > 0) {
			  int d = n / 10;
			  int k = n - d * 10;
			  n = d;
			  getGameroot1().add(new Digit(k, 40, 360 - shift, 25));
			  shift+=30;
			}
	}
	
	
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
	
	public int[] getRecord() {
		return record;
	}
	
	public void setRecord(int[] record) {
		this.record = record;
	}
	
	public int getRounds() {
		return rounds;
	}
	
	public void setRounds(int rounds) {
		this.rounds = rounds;
	}
	public void addRounds(int rounds) {
		this.rounds += rounds;
	}
}
