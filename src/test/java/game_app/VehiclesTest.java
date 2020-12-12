package game_app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.embed.swing.JFXPanel;

class VehiclesTest {

		private Vehicles vh;
		@SuppressWarnings("unused")
		private JFXPanel panel= new JFXPanel(); 
	@BeforeEach
	void setUp() throws Exception {
		vh = SpriteFactory.createVehicles("file:src/main/resources/truck1Right.png", 0, 649, 1, 120, 120);
		
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
			assertTrue(vh.getImage()!=null,"Error: image object cannot be null");
			assertEquals(120,vh.getImage().getRequestedHeight(),"Error: height is not the same");
			assertEquals(120,vh.getImage().getRequestedWidth(),"Error: width is not the same");
			assertEquals(1,vh.getSpeed(),"Error: speed is not the same");
			assertEquals(0,vh.getX(),"Error: x position is not the same");
			assertEquals(649,vh.getY(),"Error: y position is not the same");
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	@Test
	/**to test the second  if else statement in obstacle class act() method 
	 */
	void testact() {
		vh.setSpeed(-3);
		assertEquals(-3,vh.getSpeed(),"Error: speed is not the same as what is set");
		vh.setX(-60);
		assertEquals(-60,vh.getX(),"Error: x position is not the same as what is set");
		vh.act(0);
		assertEquals(600,vh.getX(),"Error: x position is not 600, expected 600");
		
	}
	
	

}
