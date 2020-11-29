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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
	private MyStage gameroot;
	private Frog frog1;
	private Scene scenegame;
	public Scene scenemenu;
	public Scene scenemanual;
	private BackgroundImage froggerbackground;
	public int[] record;
	public int rounds; 
	
	
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
		// main menu scene
        Pane menuroot = new Pane();
        menuroot.setPrefSize(800, 600);
        scenemenu = new Scene(menuroot);
        Image img0 = new Image("file:src/main/resources/wallpaper-frogger-boxart-800x600.jpg",800,600,true,true);
        ImageView img4menu = new ImageView(img0);
        menuroot.getChildren().addAll(img4menu);
        
        // menu bar buttons
        HBox menuhbox = new HBox(10);       //MAKE 2 MORE FILE -MAINMENU.JAVA & MENUBUTTON.JAVA and also extract handle() in animationtimer
        menuhbox.setTranslateX(15);
        menuhbox.setTranslateY(300);
        MenuButton btnPlay = MenuButton.createMenuButton("PLAY");
        MenuButton btnManual = MenuButton.createMenuButton("MANUAL");
        MenuButton btnExit = MenuButton.createMenuButton("EXIT");
        menuhbox.getChildren().addAll(btnPlay, btnManual, btnExit);
        Rectangle rect = new Rectangle(800, 600);
        rect.setFill(Color.BLUE);
        rect.setOpacity(0.2);
        menuroot.getChildren().addAll(rect, menuhbox);
        
        //user guide scene
        Pane manualroot = new Pane();
        manualroot.setPrefSize(800, 525);
        scenemanual = new Scene(manualroot);
        Image img1 = new Image("file:src/main/resources/user_guide.png",800,525,true,true);
        ImageView manual = new ImageView(img1);
        manualroot.getChildren().addAll(manual);
        //manual buttons
        HBox manualhbox = new HBox(20);
        manualhbox.setTranslateX(5);
        manualhbox.setTranslateY(490);
        MenuButton manualplay = MenuButton.createMenuButton("PLAY");
        MenuButton manualexit = MenuButton.createMenuButton("EXIT");
        MenuButton manualmenu = MenuButton.createMenuButton("BACK TO MENU");
        Rectangle rect1 = new Rectangle(800, 50);
        rect1.setFill(Color.DARKCYAN);
        rect1.setOpacity(0.8);
        manualhbox.getChildren().addAll(manualplay, manualmenu, manualexit);
        rect1.setTranslateY(480);
        manualroot.getChildren().addAll(rect1, manualhbox);
        
        // frogger game scene
		setGameroot( new MyStage());
		setScenegame(new Scene(getGameroot(),600,800));//745
		setFroggerbackground(new BackgroundImage("file:src/main/resources/backdropmain.png"));
		/**@RefactorFactoryMethodDesignPattern
		 * Replace constructor with factory method
		 */		
		setFrog1(Frog.createFrog("file:src/main/resources/froggerUp.png"));
		getGameroot().add(getFroggerbackground());
		getGameroot().add(new Digit(0, 40, 360, 25)); //changed xpos to 560 from 360, changed back to 360
		buildLogs();
		buildTurtles();
		buildFrogHome();
		getGameroot().add(getFrog1());//DO NOT EVER MOVE THIS method below to other place		
		buildObstacles();
		primaryStage.getIcons().add(new Image("file:src/main/resources/icon-frogger-boxart-96x96.png"));
		primaryStage.setTitle("FROGGER ARCADE GAME by E-Shen Gan");
		primaryStage.setScene(scenemenu);
		primaryStage.show();
		
		//button actions
        btnPlay.setOnMouseClicked(event -> {
            primaryStage.setScene(getScenegame()); // frogger game scene
            start();
        });
		
        
        btnManual.setOnMouseClicked(event -> {
        	primaryStage.setScene(scenemanual);
        });
        
        btnExit.setOnMouseClicked(event -> {
            System.exit(0);
        });
        
        manualplay.setOnMouseClicked(event -> {
            primaryStage.setScene(getScenegame());
            start();
        });
        
        manualmenu.setOnMouseClicked(event -> {
            primaryStage.setScene(scenemenu);
        });

        manualexit.setOnMouseClicked(event -> {
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
        				BufferedWriter output = new BufferedWriter(board);
        				BufferedReader readscore = new BufferedReader(new FileReader("D:\\(A)Y2_CSAI\\software maintenance\\"
        						+ "COMP2042_CW2020_E-SHEN_GAN\\Frogger\\scoreboard.txt"));
        				Alert alert = new Alert(AlertType.INFORMATION);
        				String currentline;
                    	if (getFrog1().getStop()) {// if end is equal to 5 then 
                    		//System.out.print("STOP:");
                    		getGameroot().stopMusic();
                    		stop();
                    		getGameroot().stop();
                    		
                    		alert.setTitle("You Have Won The Game!");
                    		alert.setHeaderText("Your Score: "+getFrog1().getPoints()+"!");
							output.write(""+getFrog1().getPoints());
		        			output.newLine();
		        			output.close();
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
			        		alert.setContentText("Top 5 high scores\nHighest recorded score:\n"+record[0]+"\n Other high scores"
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

	public MyStage getGameroot() {
		return gameroot;
	}
	
	/**@Refactor
	 * method hiding since it is only used within the class
	 */
	protected void setGameroot(MyStage gameroot) {
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

	public Scene getScenegame() {
		return scenegame;
	}

	/**@Refactor
	 * method hiding since it is only used within the class
	 */
	protected void setScenegame(Scene scenegame) {
		this.scenegame = scenegame;
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
 
	/*
	 * public static class MenuButton extends StackPane { public Text text;
	 * 
	 * public MenuButton(String name) { text = new Text(name); text.getFont();
	 * text.setFont(Font.font(20)); text.setFill(Color.WHITE);
	 * 
	 * Rectangle bg = new Rectangle(250, 30); bg.setOpacity(0.6);
	 * bg.setFill(Color.BLACK); bg.setEffect(new GaussianBlur(3.5));
	 * 
	 * setAlignment(Pos.CENTER_LEFT); setRotate(-0.5); getChildren().addAll(bg,
	 * text);
	 * 
	 * setOnMouseEntered(event -> { bg.setTranslateX(10); text.setTranslateX(10);
	 * bg.setFill(Color.WHITE); text.setFill(Color.BLACK); });
	 * 
	 * setOnMouseExited(event -> { bg.setTranslateX(0); text.setTranslateX(0);
	 * bg.setFill(Color.BLACK); text.setFill(Color.WHITE); });
	 * 
	 * DropShadow drop = new DropShadow(50, Color.WHITE); drop.setInput(new Glow());
	 * 
	 * setOnMousePressed(event -> setEffect(drop)); setOnMouseReleased(event ->
	 * setEffect(null)); } }
	 */


