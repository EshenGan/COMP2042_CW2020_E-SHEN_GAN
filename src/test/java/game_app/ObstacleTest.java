package game_app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;

public class ObstacleTest {

		private Obstacle ob;
		@SuppressWarnings("unused")
		private JFXPanel panel= new JFXPanel(); 
	@BeforeEach
	void setUp() throws Exception {
		ob = new Obstacle("file:src/main/resources/truck1Right.png", 0, 649, 1, 120, 120);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	/**
	 * to test whether the obstacle object properties are set up exactly as expected
	 */
	void test() { 
		try {
			assertNotEquals( new Image("file:src/main/resources/truck1Right.png",120,120,true,true),ob.getImage(),"image object is the same");
			assertEquals(120,ob.getImage().getRequestedHeight(),"height is not the same");
			assertEquals(120,ob.getImage().getRequestedWidth(),"width is not the same");
			assertEquals(1,ob.getSpeed(),"speed is not the same");
			assertEquals(0,ob.getX(),"x position is not the same");
			assertEquals(649,ob.getY(),"y position is not the same");
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	@Test
	/**to test the second  if else statement in obstacle class act() method 
	 */
	void testact() {
		ob.setSpeed(-3);
		assertEquals(-3,ob.getSpeed(),"speed is not the same as what is set");
		ob.setX(-60);
		assertEquals(-60,ob.getX(),"x position is not the same as what is set");
		ob.act(0);
		assertEquals(600,ob.getX(),"x position should be 600");
		
	}
	
	

}
