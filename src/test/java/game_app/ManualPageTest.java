package game_app;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobotException;
import javafx.scene.Parent;
import org.testfx.assertions.api.Assertions;

class ManualPageTest extends FroggerAppTest {
	private ManualPage infopage;
	
	public Parent getRootNode() {
		infopage = new ManualPage();
		return infopage.getManualroot();
	}

	@Test
	void testClickOnFakeButton() {
		   assertThrows(FxRobotException.class, () -> {
			      clickOn("#dummytest");
			      });

		}

	
	@Test 
	/*
	 * test existence of back to menu button and BACK TO MENU text word on the button
	 */
	void testClickOnMenubtn_In_Manual() {
		try {
		Button menubtntest = find("#BACK TO MENU");
		clickOn(menubtntest);
		sleep(1000000000);
		assertTrue(infopage.getManualmenu() != null,"Error: back to menu button does not exist");
		Assertions.assertThat(infopage.getManualmenu().getTxt());
		
		}
		catch(NoSuchElementException e) {
			e.getStackTrace();
		}
	}
	
	@Test
	/*
	 * test existence of exit button and EXIT text word on the button
	 */
	void testClickOnExitbtn_In_Manual() {
		try {
		Button exitbtntest = find("#EXIT");
		clickOn(exitbtntest);
		sleep(1000000000);
		assertTrue(infopage.getManualexit() != null,"Error: exit button does not exist");
		Assertions.assertThat(infopage.getManualexit().getTxt());
		}
		catch(NoSuchElementException e) {
			e.getStackTrace();
		}

	}
}
