/**
 * @Refactor 
 *  renaming of package and Main java file with meaningful name
 *  remove unused imports
 *  move png  jpg piskel etc "media" files to src/main/resources
 */
package game_app;


import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FroggerApp extends Application {
	/**
	 * @Refactor
	 * set up aggregated field here before instantiating as object in start(Stage primaryStage)
	 * field data encapsulation - OO Core Concept
	 * self encapsulating field to avoid direct access of field even within own class
	 * create setter and getter for encapsulated field
	 */
	private AnimationTimer timer;
	private MyStage background;
	private Frog frog1;
	private Scene scene;
	private BackgroundImage froggerbackground;
	//private GameMenu gameMenu;
	//public int flag =0;
	
	
	
//*********************************************************************VIEW****************************************************************************
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * @Override
	 * method overriding on application class
	 */
	public void start(Stage primaryStage) throws Exception {  // view
		/* main menu
        Pane root = new Pane();
        root.setPrefSize(800, 600);
        Image img = new Image("file:src/main/resources/wallpaper-frogger-boxart-800x600.jpg",800,600,true,true);
        ImageView imgView = new ImageView(img);
        //gameMenu.setVisible(false);
        if(gameMenu == null) {
        	gameMenu = new GameMenu();
        }
        root.getChildren().addAll(imgView,gameMenu);
        Scene menuscene = new Scene(root);
		primaryStage.setScene(menuscene);
		primaryStage.show();		
		*/

	    setBackground( new MyStage());
	    setScene(new Scene(getBackground(),600,800));
	    setFroggerbackground(new BackgroundImage("file:src/main/resources/try1.jpg"));
		/**@RefactorFactoryMethodDesignPattern
		 * Replace constructor with factory method
		 */
		setFrog1(Frog.createFrog("file:src/main/resources/froggerUp.png"));
		primaryStage.setScene(getScene());
		getBackground().add(getFroggerbackground());
		getBackground().add(new Digit(0, 30, 560, 25)); //changed xpos to 560 from 360
		buildLogs();
		buildTurtles();
		buildFrogHome();
		getBackground().add(getFrog1());//DO NOT EVER MOVE THIS method below to other place		
		buildObstacles();
		primaryStage.show();
		start();
	}

//*****************************************************************************************************************************************************
//****************************************************************************CONTROLLER***************************************************************
	/**@Refactor
	 * background.start() is moved into start() 
	 * from start(Stage primaryStage)
	 * method hiding since it is only used within the class
	 */
	protected void start() { //controller
		getBackground().start();
		getBackground().playMusic();
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
            	if (getFrog1().getStop()) {// if end is equal to 5 then 
            		System.out.print("STOP:");
            		getBackground().stopMusic();
            		stop();
            		getBackground().stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+frog1.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
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
    		  getBackground().add(new Digit(k, 30, 560 - shift, 25)); //changed xpos to 560
    		  shift+=30;
    		}
    }
    
    /** @Refactor
     * extract method
     *  method hiding since it is only used within the class
     */
    protected void buildFrogHome() {
    	int ax = 13 , bx= 141 , cx=269;
    	int dx = 394, ex=524;
    	int y = 96;
    	getBackground().add(new End(ax,y));
    	getBackground().add(new End(bx,y));
    	getBackground().add(new End(cx,y));
    	getBackground().add(new End(dx,y));
    	getBackground().add(new End(ex,y));
    }
    
    /**@Refactor
     * extract method
     *  method hiding since it is only used within the class
     */
    protected void buildLogs() {
    	//should i extract the parameters into objects instead?
    	getBackground().add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.75));
    	getBackground().add(new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.75));
    	getBackground().add(new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.75));
		//background.add(new Log("file:src/game_app/log3.png", 150, 0, 166, 0.75));
    	getBackground().add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -2));
    	getBackground().add(new Log("file:src/main/resources/logs.png", 300, 400, 276, -2));
		///background.add(new Log("file:src/game_app/logs.png", 300, 800, 276, -2));
    	getBackground().add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.75));
    	getBackground().add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.75));
    	getBackground().add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.75));
		///background.add(new Log("file:src/game_app/log3.png", 150, 570, 329, 0.75));
		//background.add(new Log("file:src/game_app/log2.png", 200, 100,300, 1));
		//background.add(new Log("file:src/game_app/log2.png", 0, 100, 1));
		//background.add(new Log("file:src/game_app/log2.png", 100, 120, -1));
		//background.add(new Log("file:src/game_app/log2.png", 200, 120, -1));
		//background.add(new Log("file:src/game_app/log2.png", 100, 140, 1));
		//background.add(new Log("file:src/game_app/log2.png", 200, 140, 1));
		//background.add(new Log("file:src/game_app/log2.png", 100, 160, -1));
		//background.add(new Log("file:src/game_app/log2.png", 300, 160, -1));
		//background.add(new Log("file:src/game_app/log2.png", 100, 180, 1));
		//background.add(new Log("file:src/game_app/log2.png", 200, 180, 1));
		//background.add(new Log("file:src/game_app/log2.png", 100, 200, -1));
		//background.add(new Log("file:src/game_app/log2.png", 200, 200, -1));
		//background.add(new Log("file:src/game_app/log2.png", 100, 220, 1));
		//background.add(new Log("file:src/game_app/log2.png", 200, 220, 1));
		//background.add(new Log("file:src/game_app/log2.png", 400, 220, 1));
    }
    
    /** @Refactor
     * extract method
     * method hiding since it is only used within the class
     */
    protected void buildTurtles() {
    	getBackground().add(new Turtle(500, 376, -1, 130, 130));
    	getBackground().add(new Turtle(300, 376, -1, 130, 130));
    	getBackground().add(new WetTurtle(700, 376, -1, 130, 130));
    	getBackground().add(new WetTurtle(600, 217, -1, 130, 130));
    	getBackground().add(new WetTurtle(400, 217, -1, 130, 130));
    	getBackground().add(new WetTurtle(200, 217, -1, 130, 130));
    
    }
    
    /**@Refactor
     * extract method
     * method hiding since it is only used within the class
     */
    protected void buildObstacles() {
    	getBackground().add(new Obstacle("file:src/main/resources/truck1Right.png", 0, 649, 1, 120, 120));
    	getBackground().add(new Obstacle("file:src/main/resources/truck1Right.png", 300, 649, 1, 120, 120));
    	getBackground().add(new Obstacle("file:src/main/resources/truck1Right.png", 600, 649, 1, 120, 120));
		//background.add(new Obstacle("file:src/game_app/truck1"+"Right.png", 720, 649, 1, 120, 120));
    	getBackground().add(new Obstacle("file:src/main/resources/car1Left.png", 100, 597, -1, 50, 50));
    	getBackground().add(new Obstacle("file:src/main/resources/car1Left.png", 250, 597, -1, 50, 50));
    	getBackground().add(new Obstacle("file:src/main/resources/car1Left.png", 400, 597, -1, 50, 50));
    	getBackground().add(new Obstacle("file:src/main/resources/car1Left.png", 550, 597, -1, 50, 50));
    	getBackground().add(new Obstacle("file:src/main/resources/truck2Right.png", 0, 540, 1, 200, 200));
    	getBackground().add(new Obstacle("file:src/main/resources/truck2Right.png", 500, 540, 1, 200, 200));
    	getBackground().add(new Obstacle("file:src/main/resources/car1Left.png", 500, 490, -5, 50, 50));   	
    }

	public AnimationTimer getTimer() {
		if(timer == null) {
			createTimer();
		}
		return timer;
	}

	public MyStage getBackground() {
		return background;
	}
	
	/**@Refactor
	 * method hiding since it is only used within the class
	 */
	protected void setBackground(MyStage background) {
		this.background = background;
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

	public Scene getScene() {
		return scene;
	}

	/**@Refactor
	 * method hiding since it is only used within the class
	 */
	protected void setScene(Scene scene) {
		this.scene = scene;
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
//**********************************************************************************************************************************************
    public class GameMenu extends Parent {
        public GameMenu() {
            VBox menu0 = new VBox(10);

            menu0.setTranslateX(100);
            menu0.setTranslateY(200);


            MenuButton btnResume = new MenuButton("PLAY");
            btnResume.setOnMouseClicked(event -> {
                FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.setOnFinished(evt -> setVisible(false));
                //flag = 1;
            });


            MenuButton btnOptions = new MenuButton("MANUAL");
            btnOptions.setOnMouseClicked(event -> {

            });

            MenuButton btnExit = new MenuButton("EXIT");
            btnExit.setOnMouseClicked(event -> {
                System.exit(0);
                //flag =0;
            });


            menu0.getChildren().addAll(btnResume, btnOptions, btnExit);


            Rectangle bg = new Rectangle(800, 600);
            bg.setFill(Color.GREY);
            bg.setOpacity(0.4);

            getChildren().addAll(bg, menu0);
        }
    }
    
    public static class MenuButton extends StackPane {
        public Text text;

        public MenuButton(String name) {
            text = new Text(name);
            text.getFont();
			text.setFont(Font.font(20));
            text.setFill(Color.WHITE);

            Rectangle bg = new Rectangle(250, 30);
            bg.setOpacity(0.6);
            bg.setFill(Color.BLACK);
            bg.setEffect(new GaussianBlur(3.5));

            setAlignment(Pos.CENTER_LEFT);
            setRotate(-0.5);
            getChildren().addAll(bg, text);

            setOnMouseEntered(event -> {
                bg.setTranslateX(10);
                text.setTranslateX(10);
                bg.setFill(Color.WHITE);
                text.setFill(Color.BLACK);
            });

            setOnMouseExited(event -> {
                bg.setTranslateX(0);
                text.setTranslateX(0);
                bg.setFill(Color.BLACK);
                text.setFill(Color.WHITE);
            });

            DropShadow drop = new DropShadow(50, Color.WHITE);
            drop.setInput(new Glow());

            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));
        }
    }

}
