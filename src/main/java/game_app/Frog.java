/**@Refactor
 * Rename Animal.java to Frog.java
 * self encapsulating field to avoid direct access of field even within own class
 * create setter and getter for encapsulated field
 * remove unused field 
 * constructor in default access
 */
package game_app;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Frog extends Sprites{

	 private Image imgW1;
	 private Image imgA1;
	 private Image imgS1;
	 private Image imgD1;
	 private Image imgW2;
	 private Image imgA2;
	 private Image imgS2;
	 private Image imgD2;
	 private int points = 0;
	 private boolean second = false;
	 private boolean noMove = false;
	 private final double movement = 13.3333333*2;
	 private final double movementX = 10.666666*2;
	 private final int imgSize = 40;
	 private boolean changeScore = false;
	 private double w = 800;
	 private int home = 0;
	 private boolean carDeath = false;
	 private boolean waterDeath = false;
	 private int carD = 0;
	 private int waterD = 0;
	 private String mode;
//******************************************************************CONTROLLER************************************************************************
	Frog(String imageLink,String mode) {
		setMode(mode);
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(300); 
		setY(679.8+movement); 
		setFrogSprite(imgSize);
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
			/**@Refactor
			 * consolidate duplicate conditional fragments
			 * removed the outer most layer of if else statement
			 * 
			 */
				if (isNoMove() == false) {
					if (isSecond()) {
						if (event.getCode() == KeyCode.W) {	  
			                move(0, -movement);
			                setChangeScore(false);
			                setImage(getw1());
			            }
			            else if (event.getCode() == KeyCode.A) {	            	
			            	 move(-movementX, 0);
			            	 setImage(geta1());
			            }
			            else if (event.getCode() == KeyCode.S) {	            	
			            	 move(0, movement);
			            	 setImage(gets1());
			            }
			            else if (event.getCode() == KeyCode.D) {	            	
			            	 move(movementX, 0);
			            	 setImage(getd1());
			            }
						setSecond(false);
					}
					else if (event.getCode() == KeyCode.W) {	            	
		                move(0, -movement);
		                setImage(getw2());
		            }
		            else if (event.getCode() == KeyCode.A) {	            	
		            	 move(-movementX, 0);
		            	 setImage(geta2());
		            }
		            else if (event.getCode() == KeyCode.S) {	            	
		            	 move(0, movement);
		            	 setImage(gets2());
		            }
		            else if (event.getCode() == KeyCode.D) {	            	
		            	 move(movementX, 0);
		            	 setImage(getd2());
		            }
					setSecond(true);
				}
			
			}// handle method body
		}// eventhandler instantiation body
		);// setonkeypressed method call
		
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (isNoMove() == false ){
					if (event.getCode() == KeyCode.W) {	  
						if (getY() < getW()) {
							setChangeScore(true);
							setW(getY());
							pPoints(10);
						}
		                move(0, -movement);
		                setImage(getw1());
		            }
		            else if (event.getCode() == KeyCode.A) {	            	
		            	 move(-movementX, 0);
		            	 setImage(geta1());
		            }
		            else if (event.getCode() == KeyCode.S) {	            	
		            	 move(0, movement);
		            	 setImage(gets1());
		            }
		            else if (event.getCode() == KeyCode.D) {	            	
		            	 move(movementX, 0);
		            	 setImage(getd1());
		            }
				setSecond(false);	
				}

			}
			
		});
	}// end of frog constructor
	
	 ArrayList<Home> inter = new ArrayList<Home>();
		@Override
		public void act(long now) {
			
			if (getY()<0 || getY()>734) {
				setX(300);
				setY(679.8+movement);
			}
			if (getX()<0) {
				move(movement*2, 0);
			}
			if (isCarDeath()) {
				setNoMove(true);
				if ((now)% 11 ==0) {
					addCarD(1);
				}
				if (getCarD() == 1) {
					setImage(new Image("file:src/main/resources/cardeath1.png", imgSize, imgSize, true, true));
				}
				if (getCarD() == 2) {
					setImage(new Image("file:src/main/resources/cardeath2.png", imgSize, imgSize, true, true));
				}
				if (getCarD() == 3) {
					setImage(new Image("file:src/main/resources/cardeath3.png", imgSize, imgSize, true, true));
				}
				if (getCarD() == 4) {
					setX(300);
					setY(679.8+movement);
					setCarDeath(false);
					setCarD(0);
					setImage(new Image("file:src/main/resources/froggerUp.png", imgSize, imgSize, true, true));
					setNoMove(false);
					if (getPoints() >50) {
						nPoints(50);
						setChangeScore(true);
					}
				}
				
			}
			/**@Rename 
			 * changed use of carD to waterD to avoid confusion
			 * with car death
			 */
			if (isWaterDeath()) {
				setNoMove(true);
				if ((now)% 11 ==0) {
					addWaterD(1);
				}
				if (getWaterD() == 1) {
					setImage(new Image("file:src/main/resources/waterdeath1.png", imgSize,imgSize , true, true));
				}
				if (getWaterD()== 2) {
					setImage(new Image("file:src/main/resources/waterdeath2.png", imgSize,imgSize , true, true));
				}
				if (getWaterD()== 3) {
					setImage(new Image("file:src/main/resources/waterdeath3.png", imgSize,imgSize , true, true));
				}
				if (getWaterD() == 4) {
					setImage(new Image("file:src/main/resources/waterdeath4.png", imgSize,imgSize , true, true));
				}
				if (getWaterD() == 5) {
					setX(300);
					setY(679.8+movement);
					setWaterDeath(false);
					setWaterD(0);
					setImage(new Image("file:src/main/resources/froggerUp.png", imgSize, imgSize, true, true));
					setNoMove(false);
					if (getPoints()>50) {
						nPoints(50);
						setChangeScore(true);
					}
				}	
			}
			
			if (getX()>600) {
				move(-movement*2, 0);
			}
			if (getIntersectingObjects(Vehicles.class).size() >= 1) {
				setCarDeath(true);
			}
			//new
			if (getIntersectingObjects(Snake.class).size() >= 1) {
				setCarDeath(true);
			}			
			if (getIntersectingObjects(Log.class).size() >= 1 && !isNoMove()) {
				if(getMode().equalsIgnoreCase("EASY") || getMode().equalsIgnoreCase("E")) {
					if(getIntersectingObjects(Log.class).get(0).moveLeft()) {
							move(-2,0);
					}
					else {
						move(.75,0);
					}
				}
				else if(getMode().equalsIgnoreCase("MEDIUM") || getMode().equalsIgnoreCase("M")) {
					if(getIntersectingObjects(Log.class).get(0).moveLeft()) {
							move(-2.50,0);
					}
					else {
						move(1.25,0);
					}
				}
				else if(getMode().equalsIgnoreCase("HARD") || getMode().equalsIgnoreCase("H")) {
					if(getIntersectingObjects(Log.class).get(0).moveLeft()) {
							move(-3,0);
					}
					else {
						move(1.75,0);
					}					
				}
			}
			else if (getIntersectingObjects(Turtle.class).size() >= 1 && !isNoMove()) {
				if(getMode().equalsIgnoreCase("EASY") || getMode().equalsIgnoreCase("E")) {
					move(-1,0);
				}
				else if (getMode().equalsIgnoreCase("MEDIUM") || getMode().equalsIgnoreCase("M")) {
					move(-2,0);
				}
				else if(getMode().equalsIgnoreCase("HARD") || getMode().equalsIgnoreCase("H")) {
					move(-3,0);
				}
				
			}
			else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
				if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) 
					setWaterDeath(true);
				 else {
					 if(getMode().equalsIgnoreCase("EASY") || getMode().equalsIgnoreCase("E")) {
						 move(-1,0);
					 }
					 else if(getMode().equalsIgnoreCase("MEDIUM") || getMode().equalsIgnoreCase("M")) {
						 move(-2,0);
					 }
					 else if(getMode().equalsIgnoreCase("HARD") || getMode().equalsIgnoreCase("H")) {
						 move(-3,0);
					 }
				 }				 
			}
			else if (getIntersectingObjects(Home.class).size() >= 1) {
				inter = (ArrayList<Home>) getIntersectingObjects(Home.class);
				if (getIntersectingObjects(Home.class).get(0).isActivated()) {
					minusHome(1);
					nPoints(50);
				}
				pPoints(50);
				setChangeScore(true);
				setW(800);
				getIntersectingObjects(Home.class).get(0).reachHome();
				addHome(1);
				setX(300);
				setY(679.8+movement);
			}
			else if (getY()<413){
				setWaterDeath(true);
			}
		}//act(long now)
	
//********************************************************************************MODEL***********************************************************	
	
	public boolean gameOver() {return home==5;}
	
	public void pPoints(int points) {this.points += points;	}

	public void nPoints(int points) {this.points -= points;	}

	public int getPoints() {return points;	}

	public int getHome() {return home;	}

	public void addHome(int home) {this.home += home;}

	public void minusHome(int home) {this.home -= home;	}
	
	public boolean isSecond() {return second;	}

	public void setSecond(boolean second) {this.second = second;	}

	public boolean isNoMove() {return noMove;	}

	public void setNoMove(boolean noMove) {this.noMove = noMove;	}

	public boolean isCarDeath() {return carDeath;	}

	public void setCarDeath(boolean carDeath) {this.carDeath = carDeath;	}

	public boolean isWaterDeath() {return waterDeath;}

	public void setWaterDeath(boolean waterDeath) {this.waterDeath = waterDeath;}

	/**@Rename
	 * rename to getChangeScore from ChangeScore
	 */
	public boolean getChangeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
	}
	
	public void setChangeScore(boolean changeScore) {this.changeScore = changeScore;}
	
	public int getCarD() {return carD;}

	public void setCarD(int carD) {this.carD = carD;}
	
	public void addCarD(int carD) {this.carD += carD;}

	public int getWaterD() {return waterD;}

	public void setWaterD(int waterD) {this.waterD = waterD;}
	
	public void addWaterD(int waterD) {this.waterD += waterD;}

	public double getW() {return w;}

	public void setW(double w) {this.w = w;}
	
	public void setFrogSprite(int i) {
		imgW1 = new Image("file:src/main/resources/froggerUp.png", i, i, true, true);
		imgA1 = new Image("file:src/main/resources/froggerLeft.png", i, i, true, true);
		imgS1 = new Image("file:src/main/resources/froggerDown.png", i, i, true, true);
		imgD1 = new Image("file:src/main/resources/froggerRight.png", i, i, true, true);
		imgW2 = new Image("file:src/main/resources/froggerUpJump.png", i, i, true, true);
		imgA2 = new Image("file:src/main/resources/froggerLeftJump.png", i, i, true, true);
		imgS2 = new Image("file:src/main/resources/froggerDownJump.png", i, i, true, true);
		imgD2 = new Image("file:src/main/resources/froggerRightJump.png", i, i, true, true);
	}
	
	public Image getw1() {return imgW1;}
	
	public Image geta1() {return imgA1;}
	
	public Image gets1() {return imgS1;}
	
	public Image getd1() {return imgD1; }
	
	public Image getw2() {return imgW2;	}
	
	public Image geta2() {return imgA2;	}
	
	public Image gets2() {return imgS2;	}
	
	public Image getd2() {return imgD2;	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

}
