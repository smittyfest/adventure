package org.smittyfest.adventuretime;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static org.smittyfest.adventuretime.Context.HORIZONTAL_MOVE_INCREMENT;
import static org.smittyfest.adventuretime.Context.LEFTMOST_FRAME_BARRIER;
import static org.smittyfest.adventuretime.Context.OVERWORLD_MAP_COLUMNS;
import static org.smittyfest.adventuretime.Context.OVERWORLD_MAP_ROWS;
import static org.smittyfest.adventuretime.Context.TOP_OF_FRAME_BARRIER;
import static org.smittyfest.adventuretime.Context.VERTICAL_MOVE_INCREMENT;

/**
 * @author smittyfest
 */
public class AdventureTime3 extends Application {
  private final Context ctx = new Context();

  private static final Random random = new Random();

  public void start(Stage primaryStage) throws Exception {
    GridPane board = new GridPane();
    double pcX = random.nextInt(OVERWORLD_MAP_COLUMNS);
    double pcY = random.nextInt(OVERWORLD_MAP_ROWS);
    System.out.println(pcX + ", " + pcY);
    Tile pcTile = Tile.from("-", pcX, pcY);
    for (int colCoord = LEFTMOST_FRAME_BARRIER, col = 0; col < OVERWORLD_MAP_COLUMNS; ++col, colCoord += HORIZONTAL_MOVE_INCREMENT) {
      for (int rowCoord = TOP_OF_FRAME_BARRIER, row = 0; row < OVERWORLD_MAP_ROWS; ++row, rowCoord += VERTICAL_MOVE_INCREMENT) {
        StackPane stackPane = new StackPane();
        Tile tile = Tile.from("Q", Color.BLACK, colCoord, rowCoord); // generateColor() will randomly set the tile background color
        if (pcX == col && pcY == row) {
          System.out.println("Heelllllooooo!!!!" + pcX + ", " + pcY);
          stackPane.getChildren().addAll(tile, tile.getSymbol(), pcTile, pcTile.getSymbol());
        } else {
          stackPane.getChildren().addAll(tile, tile.getSymbol());
        }
        board.add(stackPane, colCoord, rowCoord);
      }
    }
    Scene scene = new Scene(board, 1010, 384);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Overworld Map");
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
