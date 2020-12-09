/**@Refactor
 * extracted class
 * always favor aggregation/composition over inheritance
 */
package game_app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ScoreHandler {

	private AnimationTimer at;
	private int[] record;
	private int rounds; 
	private FileWriter board;
	private FileReader readboard;
	private BufferedWriter writescore;
	private BufferedReader readscore;
	
	public static ScoreHandler createScoreHandler(Frog frog, GamePane gameroot, String filepath) {
		return new ScoreHandler(frog, gameroot, filepath);
	}

	private ScoreHandler (Frog frog, GamePane gameroot, String filepath) {
		setRecord(new int[5]);
		setRounds(0);
		try {
			setBoard(new FileWriter(filepath,true));
			setWritescore(new BufferedWriter(getBoard()));
			setReadboard(new FileReader(filepath));
			setReadscore(new BufferedReader(getReadboard()));
			setAt(new AnimationTimer() {

				@Override
				public void handle(long now) {
	            	if (frog.getChangeScore()) {
	            		setNumber(frog.getPoints(),gameroot);
	            	}
	            	/**@Extension
	            	 */
	            	try { 
	        				Alert alert = new Alert(AlertType.INFORMATION);
	        				String currentline;
	                    	if (frog.gameOver()) {// if frog home is equal to 5 then 
	                    		gameroot.stopMusic();//.stopMusic();
	                    		stop();
	                    		gameroot.stop();
	                    		
	                    		alert.setTitle("You Have Won The Game!");
	                    		alert.setHeaderText("Your Score: "+frog.getPoints()+"!");
	    						getWritescore().write(""+frog.getPoints());
	    	        			getWritescore().newLine();
	    	        			getWritescore().close();
	    	        			while((currentline = getReadscore().readLine()) != null) {
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
	    	        			getReadscore().close();
	    		        		alert.setContentText("Top 5 high scores:\nHighest recorded score:\n"+getRecord()[0]+"\n Other high scores:\n"
	    				        		+getRecord()[1]+"\n"+getRecord()[2]+"\n"+getRecord()[3]+
	    				        		"\n"+getRecord()[4]+"\n\n\nHighest possible score: 800");
	    		        		alert.show();
	    		        		System.out.println("success"+rounds);
	                    	}
	
	            		
	    				} 
	        			catch (IOException e) {
	    				e.printStackTrace();}				
				}
				
			});}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

	
	public void setNumber(int n,GamePane gameroot) {
		int shift = 0;
		while (n > 0) {
			  int d = n / 10;
			  int k = n - d * 10;
			  n = d;
			 gameroot.add(new Digit(k, 40, 360 - shift, 25));
			  shift+=30;
			}
	}

	public AnimationTimer getAt() {
		return at;
	}

	public void setAt(AnimationTimer at) {
		this.at = at;
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

	public FileWriter getBoard() {
		return board;
	}

	public void setBoard(FileWriter board) {
		this.board = board;
	}

	public FileReader getReadboard() {
		return readboard;
	}

	public void setReadboard(FileReader readboard) {
		this.readboard = readboard;
	}

	public BufferedWriter getWritescore() {
		return writescore;
	}

	public void setWritescore(BufferedWriter writescore) {
		this.writescore = writescore;
	}

	public BufferedReader getReadscore() {
		return readscore;
	}

	public void setReadscore(BufferedReader readscore) {
		this.readscore = readscore;
	}

}
