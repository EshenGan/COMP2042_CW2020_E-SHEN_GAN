
package game_app;
/**<b>REFACTOR</b>:
 * <p>. FactoryMethodDesignPattern:factory for all type of scenes available<br>
 * . Replace constructors with factory method<br>
 * . Factory class to create different type of  scenes</p>
 */
public class SceneFactory {
//********************************************VIEW*********************************************************
	/** @return MenuScene object : Main Menu
	 */
	public static MenuScene createMenuScene() {
		return new MenuScene();
	}

	/**@return ManualScene object : info screen
	 */
	public static ManualScene createManualScene() {
		return new ManualScene();
	}

	/**@return EasyScene object : easy mode game scene
	 */
	public static EasyScene createEasyScene() {
		return new EasyScene();
	}

	/**@return MediumScene object : medium mode game scene
	 */
	public static MediumScene createMediumScene() {
		return new MediumScene();
	}

	/**@return HardScene object : hard mode game scene
	 */
	public static HardScene createHardScene() {
		return new HardScene();
	}

}
