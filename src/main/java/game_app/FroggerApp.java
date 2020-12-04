/**
 * @Refactor 
 *  renaming of package and Main java file with meaningful name
 *  remove unused imports
 *  move png  jpg piskel etc "media" files to src/main/resources
 *  edited background color for all digits and also edited background for game scene
 */
package game_app;

import java.io.*;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class FroggerApp extends Application {
	/**
	 * @Refactor
	 * set up aggregated field here before instantiating as object in start(Stage primaryStage)
	 * field data encapsulation - OO Core Concept
	 * self encapsulating field to avoid direct access of field even within own class
	 * create setter and getter for encapsulated field
	 */
	private AnimationTimer timer;
	private Bgm gameroot;
//	public Bgm gameroot2;
//	public Bgm gameroot3;
	private Frog frog1;
	private Scene scenegame1;
//	public Scene scenegame2;
//	public Scene scenegame3;
	public Scene scenemenu;
	public Scene scenemanual;
	private BackgroundImage froggerbackground;
	public int[] record;
	public int rounds; 
	public int pauseflag=0;
	public MenuPage menu;
	public ManualPage manual;
	
	
//*********************************************************************VIEW****************************************************************************
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * @Override
	 * method overriding on application class
	 */
	public void start(Stage primaryStage) throws Exception { 
	record = new int[5];
	rounds =0;
		primaryStage.getIcons().add(new Image("file:src/main/resources/icon-frogger-boxart-96x96.png"));
		primaryStage.setTitle("FROGGER ARCADE GAME by E-Shen Gan");
		// main menu scene
        Pane menuroot = new Pane();
        menuroot.setPrefSize(800, 600);
        scenemenu = new Scene(menuroot);
        Image img0 = new Image("file:src/main/resources/wallpaper-frogger-boxart-800x600.jpg",800,600,true,true);
        ImageView img4menu = new ImageView(img0);
        menu = new MenuPage();
        menuroot.getChildren().addAll(img4menu,menu);
 
        //user guide scene
        Pane manualroot = new Pane();
        manualroot.setPrefSize(800, 525);
        scenemanual = new Scene(manualroot);
        Image img1 = new Image("file:src/main/resources/user_guide.png",800,525,true,true);
        ImageView img4manual = new ImageView(img1);
        manual = new ManualPage();
        manualroot.getChildren().addAll(img4manual,manual);

        
        //  game scene MAYBE CAN MOVE ENITRE Gameroot and scenegame1 to other class and invoke here
		setGameroot( new Bgm());
		setScenegame1(new Scene(getGameroot(),598,745));//745
		setFroggerbackground(new BackgroundImage("file:src/main/resources/backdropfrogger600x800.jpg"));
		/**@RefactorFactoryMethodDesignPattern
		 * Replace constructor with factory method
		 */		
		setFrog1(Frog.createFrog("file:src/main/resources/froggerUp.png"));
		getGameroot().add(getFroggerbackground());
		getGameroot().add(new Digit(0, 40, 360, 25)); //changed xpos to 560 from 360, changed back to 360
		buildLogs();
		buildTurtles();
		buildFrogHome();
		getGameroot().add(getFrog1());//DO NOT EVER MOVE THIS method to other place		
		buildObstacles();
		
//		gameroot2 = new Bgm();
//		scenegame2 = new Scene(gameroot2,598,745);
//		
//		
//		
//		gameroot3 = new Bgm();
//		scenegame3 = new Scene(gameroot3,598,745);
		
		

		
		//game scene buttons
		VBox gamebox = new VBox(5);
		gamebox.setTranslateX(5);
		gamebox.setTranslateY(5);
		Button gamepause = Button.createButton("PAUSE",150,30);
		Button gameexit = Button.createButton("EXIT",150,30);
		gamebox.getChildren().addAll(gamepause,gameexit);
		getGameroot().getChildren().addAll(gamebox);
		
		//pauselayer buttons
		VBox pausebox = new VBox(30);
		pausebox.setTranslateX(185);
		pausebox.setTranslateY(300);
		Button gameresume = Button.createButton("RESUME",250,30);
		Button gameExit = Button.createButton("EXIT",250,30);
		pausebox.getChildren().addAll(gameresume,gameExit);
		Rectangle pauselayer = new Rectangle(598,745);
        pauselayer.setOpacity(0.8);
		
		primaryStage.setScene(scenemenu);
		primaryStage.show();
		
		//button actions
		gamepause.setOnMouseClicked(event ->{
			if(pauseflag == 0) {
				getGameroot().getChildren().addAll(pauselayer,pausebox);
				pauseflag=1;
			}
			if(gamepause.isDisabled() == false) {
			getGameroot().stop();
			getGameroot().stopMusic();
			stop();
			pauselayer.setDisable(false);
			pauselayer.setFill(Color.DARKBLUE);
			gameresume.setVisible(true);
			gameExit.setVisible(true);
	        gameresume.setDisable(false);
	        gameExit.setDisable(false);			
	        gamepause.setDisable(true);
	        gameexit.setDisable(true);

			}
		});
		
		gameresume.setOnMouseClicked(event ->{
			if(gameresume.isDisabled() == false) {
				pauselayer.setFill(Color.TRANSPARENT);
				pauselayer.setDisable(true);
				gameresume.setVisible(false);
				gameExit.setVisible(false);
				primaryStage.setScene(getScenegame1());
				start();
				gamepause.setDisable(false);
				gameexit.setDisable(false);	
				gameresume.setDisable(true);
				gameExit.setDisable(true);
			}			

		});
		gameExit.setOnMouseClicked(event ->{
			System.exit(0);
		});
		
		gameexit.setOnMouseClicked(event ->{
			System.exit(0);
		});
		
		menu.getMenuplay().setOnMouseClicked(event -> {
			primaryStage.setScene(getScenegame1()); // frogger game scene
			start();
  		});
	
  		menu.getMenumanual().setOnMouseClicked(event -> {
  			primaryStage.setScene(scenemanual);
  		});
  
  		menu.getMenuexit().setOnMouseClicked(event -> {
  			System.exit(0);
  		});
        
        manual.getManualplay().setOnMouseClicked(event -> {
            primaryStage.setScene(getScenegame1());
            start();
        });
        
        manual.getManualmenu().setOnMouseClicked(event -> {
            primaryStage.setScene(scenemenu);
        });

       manual.getManualexit().setOnMouseClicked(event -> {
            System.exit(0);
          
        });
        
	}

//*****************************************************************************************************************************************************
//****************************************************************************CONTROLLER***************************************************************

	/**@Refactor
	 * gameroot.start() is moved into start() 
	 * from start(Stage primaryStage)
	 * method hiding since it is only used within the class
	 */
	protected void start() { //controller
		getGameroot().start();
		getGameroot().playMusic();
    	createTimer();
        getTimer().start();
    }

	/**@Override
	 * overrides stop() method in javafx.application.application
	 */
    public void stop() { //controller
    	getTimer().stop();
    }
//*****************************************************************************************************************************************************	
//************************************************************MODEL*******************************************************************************
	/**@Refactor
	 * method hiding since it is only used within the class
	 */
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
                    		getGameroot().stopMusic();
                    		//GamePane.createbgm().stopMusic(); // stopMusic();
                    		stop();
                    		getGameroot().stop();
                    		
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
	
    /** @Refactor
     * extract method
     *  method hiding since it is only used within the class
     */
    protected void setNumber(int n) {//model
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  getGameroot().add(new Digit(k, 40, 360 - shift, 25)); //changed xpos to 560, changed back to 360
    		  shift+=30;
    		}
    }
    
    /** @Refactor
     * extract method
     *  method hiding since it is only used within the class
     */
    protected void buildFrogHome() {
    	int ax = 13 , bx= 141 , cx=269;
    	int dx = 398, ex=527;
    	int y = 96;
    	getGameroot().add(new End(ax,y));
    	getGameroot().add(new End(bx,y));
    	getGameroot().add(new End(cx,y));
    	getGameroot().add(new End(dx,y));
    	getGameroot().add(new End(ex,y));
    }
    
    /**@Refactor
     * extract method
     *  method hiding since it is only used within the class
     */
    protected void buildLogs() {
    	//should i extract the parameters into objects instead?
    	getGameroot().add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.75));
    	getGameroot().add(new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.75));
    	getGameroot().add(new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.75));
    	getGameroot().add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -2));
    	getGameroot().add(new Log("file:src/main/resources/logs.png", 300, 400, 276, -2));
    	getGameroot().add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.75));
    	getGameroot().add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.75));
    	getGameroot().add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.75));
    }
    
    /** @Refactor
     * extract method
     * method hiding since it is only used within the class
     */
    protected void buildTurtles() {
    	getGameroot().add(new Turtle(500, 376, -1, 130, 130));
    	getGameroot().add(new Turtle(300, 376, -1, 130, 130));
    	getGameroot().add(new WetTurtle(700, 376, -1, 130, 130));
    	getGameroot().add(new WetTurtle(600, 217, -1, 130, 130));
    	getGameroot().add(new WetTurtle(400, 217, -1, 130, 130));
    	getGameroot().add(new WetTurtle(200, 217, -1, 130, 130));
    
    }
    
    /**@Refactor
     * extract method
     * method hiding since it is only used within the class
     */
    protected void buildObstacles() {
    	getGameroot().add(new Obstacle("file:src/main/resources/truck1Right.png", 0, 649, 1, 120, 120));
    	getGameroot().add(new Obstacle("file:src/main/resources/truck1Right.png", 300, 649, 1, 120, 120));
    	getGameroot().add(new Obstacle("file:src/main/resources/truck1Right.png", 600, 649, 1, 120, 120));
    	getGameroot().add(new Obstacle("file:src/main/resources/car1Left.png", 100, 597, -1, 50, 50));
    	getGameroot().add(new Obstacle("file:src/main/resources/car1Left.png", 250, 597, -1, 50, 50));
    	getGameroot().add(new Obstacle("file:src/main/resources/car1Left.png", 400, 597, -1, 50, 50));
    	getGameroot().add(new Obstacle("file:src/main/resources/car1Left.png", 550, 597, -1, 50, 50));
    	getGameroot().add(new Obstacle("file:src/main/resources/truck2Right.png", 0, 540, 1, 200, 200));
    	getGameroot().add(new Obstacle("file:src/main/resources/truck2Right.png", 500, 540, 1, 200, 200));
    	getGameroot().add(new Obstacle("file:src/main/resources/car1Left.png", 500, 490, -5, 50, 50));   	
    }

	public AnimationTimer getTimer() {
		return timer;
	}

	public Bgm getGameroot() {
		return gameroot;
	}
	
	/**@Refactor
	 * method hiding since it is only used within the class
	 */
	protected void setGameroot(Bgm gameroot) {
		this.gameroot = gameroot;
	}

	public Frog getFrog1() {
		return frog1;
	}

	/**@Refactor
	 * method hiding since it is only used within the class
	 */
	protected void setFrog1(Frog frog1) {
		this.frog1 = frog1;
	}

	public Scene getScenegame1() {
		return scenegame1;
	}

	/**@Refactor
	 * method hiding since it is only used within the class
	 */
	protected void setScenegame1(Scene scenegame) {
		this.scenegame1 = scenegame;
	}

	public BackgroundImage getFroggerbackground() {
		return froggerbackground;
	}

	/**@Refactor
	 * method hiding since it is only used within the class
	 */
	protected void setFroggerbackground(BackgroundImage froggerbackground) {
		this.froggerbackground = froggerbackground;
	}
}
//**********************************************************************************************************************************************
 


