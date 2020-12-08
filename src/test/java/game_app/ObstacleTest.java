package game_app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.embed.swing.JFXPanel;

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
	void testObstacle() { 
		try {
			assertTrue(ob.getImage()!=null,"Error: image object cannot be null");
			assertEquals(120,ob.getImage().getRequestedHeight(),"Error: height is not the same");
			assertEquals(120,ob.getImage().getRequestedWidth(),"Error: width is not the same");
			assertEquals(1,ob.getSpeed(),"Error: speed is not the same");
			assertEquals(0,ob.getX(),"Error: x position is not the same");
			assertEquals(649,ob.getY(),"Error: y position is not the same");
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
		assertEquals(-3,ob.getSpeed(),"Error: speed is not the same as what is set");
		ob.setX(-60);
		assertEquals(-60,ob.getX(),"Error: x position is not the same as what is set");
		ob.act(0);
		assertEquals(600,ob.getX(),"Error: x position is not 600, expected 600");
		
	}
	
	

}
