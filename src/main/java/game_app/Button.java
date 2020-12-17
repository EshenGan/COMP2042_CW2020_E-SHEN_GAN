package game_app;

import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**<b>EXTENSION</b>:
 * class for creating buttons
 */
public class Button extends StackPane {
	private Text txt;
	private Rectangle rectBtn;
	private DropShadow ds;
	
	/**Construct buttons in any pane or layout
	 * @param label   : string name for button
	 * @param width   : horizontal length of button
	 * @param height  : vertical length of button
	 */
	public Button(String label, double width, double height) {
//**************************************************************CONTROLLER*****************************************************************
		setTxt(new Text(label));
        getTxt().getFont();
        getTxt().setFont(Font.font(20));
        getTxt().setFill(Color.WHITE);
        setRectBtn(new Rectangle(width, height));
        getRectBtn().setOpacity(0.6);
        getRectBtn().setFill(Color.BLACK);
        getRectBtn().setEffect(new GaussianBlur(3.5));
 
        setOnMouseEntered(event -> {
        	getRectBtn().setTranslateX(5);
            getTxt().setTranslateX(5);
            getRectBtn().setFill(Color.WHITE);
            getTxt().setFill(Color.BLACK);
        });

        setOnMouseExited(event -> {
        	getRectBtn().setTranslateX(0);
            getTxt().setTranslateX(0);
            getRectBtn().setFill(Color.BLACK);
            getTxt().setFill(Color.WHITE);
        });

        setDs(new DropShadow(30, Color.WHITE));
        getDs().setInput(new Glow());

        setOnMousePressed(e -> setEffect(getDs()));
        setOnMouseReleased(e -> setEffect(null));
        
        getChildren().addAll(getRectBtn(), getTxt());
    }

//**************************************************************MODEL*****************************************************************
	    /** @return txt : txt object of type Text
	     */
		public Text getTxt() { return txt;}

		/**@param txt : txt object instantiated of type Text
		 */
		public void setTxt(Text txt) {this.txt = txt;}
		
		/**@return rectBtn : rectBtn object of type Rectangle
		 */
		public Rectangle getRectBtn() {return rectBtn;}
		
		/**@param rectBtn : rectBtn object instantiated of type Rectangle
		 */
		public void setRectBtn(Rectangle rectBtn) {this.rectBtn = rectBtn;}
		
		/**@return ds : ds object of type DropShadow
		 */
		public DropShadow getDs() {return ds;}
		
		/**@param ds : ds object instantiated of type DropShadow
		 */
		public void setDs(DropShadow ds) {this.ds = ds;}
		
}
