package game_app;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**<b>REFACTOR</b>:
 * <p>. Rename class from MyStage to Bgm <br>
 * . Bgm not subclass of GamePane, replace with aggregation to promote loose coupling <br>
 * . Self encapsulating field to avoid direct access of field  even within own class,create setter and getter for encapsulated field</p>
 */
public class Bgm {
	private MediaPlayer mediaPlayer;
	private String musicFile;
	private Media sound;
	
//*********************************CONTROLLER**********************************
/**Method to play music in media player
 */
	public void playMusic() {
		prepareMP();
		getMediaPlayer().play();
	}
	/**Method to stop music in media player
	 */	
	public void stopMusic() {
		getMediaPlayer().stop();
	}

	/**? <b>REFACTOR</b>:Extract method prepareMP() from playMusic() to set up a media player<br>
	 * <b>EXTENSION</b>:<br> 
	 * ? get music file path using static getter method from MenuScene class<br>
	 * ? if no background music is chosen by user, there is a default song : Frogger Main Song Theme (loop).mp3
	 */
	public void prepareMP() {
		if(MenuScene.getSong() != null) {
			setMusicFile(MenuScene.getSong());
		}
		else {
			setMusicFile("src/main/resources/Frogger Main Song Theme (loop).mp3");
		}
		
		setSound(new Media(new File(getMusicFile()).toURI().toString()));
		setMediaPlayer(new MediaPlayer(getSound()));
		getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
	}

//*****************************MODEL***************************************	
	/**setter for mediaPlayer object of type MediaPlayer
	 * @param mediaPlayer : MediaPlayer object instantiated
	 */
	public void setMediaPlayer(MediaPlayer mediaPlayer ) {
		this.mediaPlayer = mediaPlayer;
		
	}
	
	/**getter for mediaPlayer object
	 * @return mediaPlayer : mediaPlayer object of type MediaPlayer
	 */
	public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}
	
	/**getter for musicFile object
	 * @return musicFile : musicFile object of type String
	 */
	public String getMusicFile() {
		return musicFile;
	}

	/**setter for musicFile object of type String
	 * @param musicFile : String object instantiated
	 */
	public void setMusicFile(String musicFile) {
		this.musicFile = musicFile;
	}

	/** getter for sound object
	 * @return sound : sound object of type Media
	 */
	public Media getSound() {
		return sound;
	}

	/**setter for sound object of type Media
	 * @param sound : Media object instantiated
	 */
	public void setSound(Media sound) {
		this.sound = sound;
	}

}
