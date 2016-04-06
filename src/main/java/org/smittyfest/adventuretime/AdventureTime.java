package org.smittyfest.adventuretime;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * @author smittyfest
 */
public class AdventureTime extends Application {

  private static final int HORIZONTAL_MOVE_INCREMENT = 8;
  private static final int VERTICAL_MOVE_INCREMENT = 12;

  private static final int TOP_OF_FRAME_BARRIER = 12;
  private static final int BOTTOM_OF_FRAME_BARRIER = 641;

  private static final int LEFTMOST_FRAME_BARRIER = 0;
  private static final int RIGHTMOST_FRAME_BARRIER = 630;

  private static final int OVERWORLD_MAP_WIDTH = 1001;
  private static final int OVERWORLD_MAP_HEIGHT = 443;

  private static final int OVERWORLD_MAP_ROWS = (OVERWORLD_MAP_HEIGHT / VERTICAL_MOVE_INCREMENT); // 35?
  private static final int OVERWORLD_MAP_COLUMNS = (OVERWORLD_MAP_WIDTH / HORIZONTAL_MOVE_INCREMENT);//125

  private static final String FONTSTYLE = "Courier";
  private static final int FONTSIZE = 14;
  private static final int FONT_PLAIN = 0;
  private static final int MAX_COLOR_VALUE = 16777215;

  private static final Random random = new Random();

  @Override public void start(Stage stage) throws Exception {
    String symbol = "\u0472";
    GridPane grid = new GridPane();
    Group group = new Group();
    for (int colCoord = LEFTMOST_FRAME_BARRIER, col = 0; col < OVERWORLD_MAP_COLUMNS; ++col, colCoord += HORIZONTAL_MOVE_INCREMENT) {
      for (int rowCoord = TOP_OF_FRAME_BARRIER, row = 0; row < OVERWORLD_MAP_ROWS; ++row, rowCoord += VERTICAL_MOVE_INCREMENT) {

      }

    }
    char that = 'Ѳ';
    String landscape = "§";
    // set the landscape
    //Text textRef = new Text(String.valueOf(that));
    Text textRef = new Text(landscape);
    textRef.setLayoutY(-1);
    textRef.setLayoutX(1);
    textRef.setTextOrigin(VPos.TOP);
    textRef.setTextAlignment(TextAlignment.JUSTIFY);
    textRef.setWrappingWidth(400);
    textRef.setFill(generateColor());
    textRef.setFont(Font.font("Courier", FontWeight.BOLD, 16));

    // create GUI Window
    Scene scene = new Scene(new Group(textRef), 1016, 387); // original: new Scene(new Group(), 516, 387);
    stage.setScene(scene);
    stage.setTitle("ADVENTURE TIME!!!");
    stage.setResizable(false);
    stage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }

  private Color generateColor() {
    return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
  }
}
