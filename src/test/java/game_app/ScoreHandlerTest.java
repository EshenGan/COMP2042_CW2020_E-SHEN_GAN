package game_app;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.embed.swing.JFXPanel;

class ScoreHandlerTest {
	private ScoreHandler shT;
	private AnimationHandler ahT;
	private Frog frogT;
	private GamePane testrootT;
	private String fpT;

	private String s;

	@SuppressWarnings("unused")
	private JFXPanel panel = new JFXPanel();

	@BeforeEach
	void setUp() throws Exception {
		try {
		fpT = "D:\\(A)Y2_CSAI\\software maintenance\\COMP2042_CW2020_E-SHEN_GAN\\Frogger\\testboard.txt";
		shT = new ScoreHandler(fpT);
		shT.setBoard(new FileWriter(fpT,false)); //override appending property of filewriter in scorehandler
		ahT = new AnimationHandler(frogT, testrootT, fpT);
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	/*to test file writing and reading system of scorehandler class
	 * also to test functionality of setter and getters of bufferedwriter and bufferedreader
	 */
	void TestBufferedWriter() { 
			try {
				shT.getWritescore().write("this is a test");
				shT.getWritescore().close();
				s = shT.getReadscore().readLine();
				shT.getReadscore().close();
				assertEquals("this is a test",s,"Error: not the same string, expected 'this is a test'" );
				
				
				
			}
			catch(IOException ioe) {
				ioe.getStackTrace();
			}
	}
	
	@Test
	/**
	 * to test getter of AnimationTimer in AnimationHandler class
	 */
	void testGetAt_in_AnimationHandler() {
		assertTrue(ahT.getAt()!=null,"Error: getAt() returns null");
	}

	@Test
	/**
	 * to test whether the record array created has size as expected
	 */
	void testGetRecord() {
		
		assertEquals(5,shT.getRecord().length,"Error: record array is not 5");
	}


	@Test
	/**
	 * to test whether rounds field contain int 0 as expected in the beginning
	 */
	void testGetRounds() {
		assertEquals(0,shT.getRounds(),"Error: rounds is not 0, expected to always start with 0");
	}
}
