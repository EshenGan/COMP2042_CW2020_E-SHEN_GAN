/**@Extension
 * class for creating buttons
 */
package game_app;

import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Button extends StackPane {
	private Text txt;
	private Rectangle rectBtn;
	private DropShadow ds;
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
	    public Text getTxt() { return txt;}

		public void setTxt(Text txt) {this.txt = txt;}

		public Rectangle getRectBtn() {return rectBtn;}

		public void setRectBtn(Rectangle rectBtn) {this.rectBtn = rectBtn;}

		public DropShadow getDs() {return ds;}

		public void setDs(DropShadow ds) {this.ds = ds;}
		
}
