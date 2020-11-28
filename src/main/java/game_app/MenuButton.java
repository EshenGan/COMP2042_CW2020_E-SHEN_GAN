package game_app;

import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MenuButton extends StackPane {
	private Text txt;

	/**
	 * @FactoryMethod
	 * created a factory method /virtual constructor for complex MenuButton constructor
	 * @param label
	 * @return
	 */
    public static MenuButton createMenuButton(String label) { // view
		return new MenuButton(label);
	}

	

    public Text getTxt() { //model
		return txt;
	}

	public void setTxt(Text txt) { //model
		this.txt = txt;
	}

	private MenuButton(String label) { //controller
		setTxt(new Text(label));
        getTxt().getFont();
        getTxt().setFont(Font.font(20));
        getTxt().setFill(Color.WHITE);

        Rectangle rect0 = new Rectangle(250, 30);
        rect0.setOpacity(0.6);
        rect0.setFill(Color.BLACK);
        rect0.setEffect(new GaussianBlur(3.5));

        setAlignment(Pos.CENTER_LEFT);
        setRotate(-0.5);
        getChildren().addAll(rect0, txt);

        setOnMouseEntered(event -> {
            rect0.setTranslateX(10);
            getTxt().setTranslateX(10);
            rect0.setFill(Color.WHITE);
            getTxt().setFill(Color.BLACK);
        });

        setOnMouseExited(event -> {
            rect0.setTranslateX(0);
            getTxt().setTranslateX(0);
            rect0.setFill(Color.BLACK);
            getTxt().setFill(Color.WHITE);
        });

        DropShadow ds = new DropShadow(50, Color.WHITE);
        ds.setInput(new Glow());

        setOnMousePressed(e -> setEffect(ds));
        setOnMouseReleased(e -> setEffect(null));
    }
}
