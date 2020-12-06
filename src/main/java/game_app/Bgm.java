/**@RemoveAndRename
 * remove all unused imports
 * changed file name from MyStage to Bgm
 */
package game_app;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Bgm {
	private MediaPlayer mediaPlayer;
	/**@Refactor
	 * Bgm not subclass of GamePane, replace with aggregation, promote loose coupling
	 * self encapsulating field to avoid direct access of field  even within own class
	 * create setter and getter for encapsulated field
	 */
	
//*****************************CONTROLLER*************************************
	public void playMusic() {
		String musicFile = "src/main/resources/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		setMediaPlayer(new MediaPlayer(sound));
		getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
		getMediaPlayer().play();
	}
	
	public void stopMusic() {
		getMediaPlayer().stop();
	}
	

//*****************************MODEL***************************************	
	protected void setMediaPlayer(MediaPlayer mediaPlayer ) {
		this.mediaPlayer = mediaPlayer;
		
	}
	
	protected MediaPlayer getMediaPlayer() {
		 return mediaPlayer;
	}

}
