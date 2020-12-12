/**@Refactor
 * remove all unused imports
 * changed file name from MyStage to Bgm
 * Bgm not subclass of GamePane, replace with aggregation, promote loose coupling
 * self encapsulating field to avoid direct access of field  even within own class
 * create setter and getter for encapsulated field
 * extract method prepareMP() to set up a media player
 */
package game_app;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Bgm {
	private MediaPlayer mediaPlayer;
	private String musicFile;
	private Media sound;
	
//*********************************CONTROLLER**********************************
	public void playMusic() {
		prepareMP();
		getMediaPlayer().play();
	}
	
	public void stopMusic() {
		getMediaPlayer().stop();
	}
	public void prepareMP() {
		setMusicFile("src/main/resources/Frogger Main Song Theme (loop).mp3");   
		setSound(new Media(new File(getMusicFile()).toURI().toString()));
		setMediaPlayer(new MediaPlayer(getSound()));
		getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
	}

//*****************************MODEL***************************************	
	public void setMediaPlayer(MediaPlayer mediaPlayer ) {
		this.mediaPlayer = mediaPlayer;
		
	}
	
	public MediaPlayer getMediaPlayer() {
		 return mediaPlayer;
	}

	public String getMusicFile() {
		return musicFile;
	}

	public void setMusicFile(String musicFile) {
		this.musicFile = musicFile;
	}

	public Media getSound() {
		return sound;
	}

	public void setSound(Media sound) {
		this.sound = sound;
	}

}
