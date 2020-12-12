/**@Refactor
 * FactoryMethodDesignPattern - factory for all type of scenes available
 * Replace constructors with factory method
 */
/**@Extension
 * factory class to create different type of  scenes
 */
package game_app;

public class SceneFactory {
//********************************************VIEW*********************************************************
	public static MenuScene createMenuScene() {
		return new MenuScene();
	}

	public static GameSceneButtons createGameSceneButtons() {
		return new GameSceneButtons();
	}

	public static ManualScene createManualScene() {
		return new ManualScene();
	}

	public static PauseScene createPauseScene() {
		return new PauseScene();
	}

	public static EasyScene createEasyScene() {
		return new EasyScene();
	}

	public static MediumScene createMediumScene() {
		return new MediumScene();
	}

	public static HardScene createHardScene() {
		return new HardScene();
	}

}
