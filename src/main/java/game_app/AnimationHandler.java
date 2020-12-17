package game_app;

import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**<b>REFACTOR</b>:
 * <p>. Extracted class for createTimer() method in FroggerApp: replace method with method object<br>
 * . Use of ScoreHandler lass: always favor aggregation/composition over inheritance</p>
 */
public class AnimationHandler {
	private AnimationTimer at;
	private ScoreHandler sh;
	
	/**<b>EXTENSION</b>:<br>
	 * ? Using a file to store score permanently in a high score list,
	 * top scores pop up listed at end of each round<br>
	 * ? Makes use of ScoreHandler class<br>
	 * @param frog     : frog object
	 * @param gameroot : Pane for any game scene
	 * @param filepath : txt file directory
	 */
	public AnimationHandler(Frog frog, GamePane gameroot,String filepath) {
		setSh(new ScoreHandler(filepath));
		setAt(new AnimationTimer() {

			@Override
			public void handle(long now) {
            	if (frog.getChangeScore()) {
            		setScore(frog.getPoints(),gameroot);
            	}
            	
            	try { 
        				Alert alert = new Alert(AlertType.INFORMATION);
        				String currentline;
                    	if (frog.gameOver()) {// if frog home is equal to 5 then 
                    		gameroot.stopMusic();
                    		stop();
                    		gameroot.stop();
                    		
                    		alert.setTitle("You Have Won The Game!");
                    		alert.setHeaderText("Your Score: "+frog.getPoints()+"!");
    						getSh().getWritescore().write(""+frog.getPoints());
    	        			getSh().getWritescore().newLine();
    	        			getSh().getWritescore().close();
    	        			while((currentline = getSh().getReadscore().readLine()) != null) {
    	        				int x = Integer.parseUnsignedInt(currentline);
    	        				
    		        			for(int k=0;k<5;k++) {
    		        				if(x == getSh().getRecord()[k]) { // if same score is read from different line, it will be ignored
    		        					x=0;
    		        				}
    		        			}		        				
    	        				
    		        			if (getSh().getRounds() == 5 || getSh().getRounds() > 5) { // only the 5 highest scores among all will be shown
    	        				  if(x > getSh().getRecord()[4]) {  // starting from the 6th round , if higher than the lowest in top 5,            
    	        					  getSh().getRecord()[4] = x;   //then 5th highest will be replaced 
    	        				  }
    		        			}
            			
    		        			if(getSh().getRounds() <5) { //first 5 rounds will be recorded in array "record"
    		        				getSh().getRecord()[getSh().getRounds()] = x;
    		        			}
    		        			getSh().addRounds(1); //rounds++;
    		        			BubbleSort.bubbleSort(getSh().getRecord()); // sort scores in record array descendingly

    	        			}
    	        			getSh().getReadscore().close();
    		        		alert.setContentText("Top 5 high scores:\nHighest recorded score:\n"+getSh().getRecord()[0]+"\n Other high scores:\n"
    				        		+getSh().getRecord()[1]+"\n"+getSh().getRecord()[2]+"\n"+getSh().getRecord()[3]+
    				        		"\n"+getSh().getRecord()[4]+"\n\n\nHighest possible score: 800");
    		        		alert.show();
    		        		System.out.println("success"+getSh().getRounds());
                    	}

            		
    				} 
        			catch (IOException e) {
    				e.printStackTrace();}				
			}
			
		});
	}
	
	/**<b>RENAME</b>:
	 * Rename from setNumber() to SetScore()
	 * @param n        : score to be set
	 * @param gameroot : Pane for any game scene
	 */
	public void setScore(int n,GamePane gameroot) {
		int shift = 0;
		while (n > 0) {
			  int d = n / 10;
			  int k = n - d * 10;
			  n = d;
			 gameroot.add(SpriteFactory.createDigit(k, 40, 360 - shift, 25));
			  shift+=30;
			}
	}

/**getter for at object
 *  @return at object of type AnimationTimer
 */
	public AnimationTimer getAt() {
		return at;
	}

	/**setter for at object type AnimationTimer
	 * @param at : AnimationTimer object instantiated
	 */
	public void setAt(AnimationTimer at) {
		this.at = at;
	}

	/** getter for sh object
	 * @return sh object of type ScoreHandler
	 */
	public ScoreHandler getSh() {
		return sh;
	}

	/**setter for sh object type ScoreHandler
	 * @param sh : ScoreHandler object instantiated
	 */
	public void setSh(ScoreHandler sh) {
		this.sh = sh;
	}

}
