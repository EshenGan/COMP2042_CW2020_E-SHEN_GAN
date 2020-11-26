/**@Remove
 * remove all unused imports
 */
package game_app;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class MyStage extends World{
	private MediaPlayer mediaPlayer;
	/**@Refactor
	 * act method pulled to superclass
	 * self encapsulating field to avoid direct access of field  even within own class
	 * create setter and getter for encapsulated field
	 */
	
//*****************************CONTROLLER*************************************
	public void playMusic() {
		setMediaPlayer();
		getMediaPlayer();
		getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
		getMediaPlayer().play();
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
	}
	

//*****************************MODEL***************************************	
	public void setMediaPlayer() {
		String musicFile = "src/main/resources/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
	}
	
	public MediaPlayer getMediaPlayer() {
		 return mediaPlayer;
	}

}
