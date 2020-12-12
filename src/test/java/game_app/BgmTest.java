package game_app;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

class BgmTest {	
private  MediaPlayer mp;
private  String str;
private  Media s;
private Bgm bgm;
@SuppressWarnings("unused")
private JFXPanel panel= new JFXPanel(); 
	@BeforeEach
	void setUp() throws Exception {
		bgm = new Bgm();
		bgm.prepareMP();
	}

	@AfterEach
	void tearDown() throws Exception {

	}

	@Test
	/*
	 * test whether is it functioning as expected
	 */
	void testPrepareMP() {
		try {
		str = "src/main/resources/Frogger Main Song Theme (loop).mp3";
		s = new Media(new File(bgm.getMusicFile()).toURI().toString());	
		mp = new MediaPlayer(bgm.getSound());
		mp.setCycleCount(MediaPlayer.INDEFINITE);
		assertEquals(str,bgm.getMusicFile(),"Error:not the same mp3 file");
		assertTrue(bgm.getMediaPlayer()!=null,"Error: media player does not exist");
		assertNotEquals(s,bgm.getSound(),"Error: same media object");
		assertNotEquals(mp,bgm.getMediaPlayer(),"Error: same mediaplayer object");
		assertEquals(mp.getCycleCount(), bgm.getMediaPlayer().getCycleCount(),"Error: not the same cycle count");
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}


}
