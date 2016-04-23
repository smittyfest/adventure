package org.smittyfest.adventuretime;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static org.smittyfest.adventuretime.Context.BOTTOM_OF_FRAME_BARRIER;
import static org.smittyfest.adventuretime.Context.HORIZONTAL_MOVE_INCREMENT;
import static org.smittyfest.adventuretime.Context.LEFTMOST_FRAME_BARRIER;
import static org.smittyfest.adventuretime.Context.OVERWORLD_MAP_COLUMNS;
import static org.smittyfest.adventuretime.Context.OVERWORLD_MAP_ROWS;
import static org.smittyfest.adventuretime.Context.RIGHTMOST_FRAME_BARRIER;
import static org.smittyfest.adventuretime.Context.TOP_OF_FRAME_BARRIER;
import static org.smittyfest.adventuretime.Context.VERTICAL_MOVE_INCREMENT;

/**
 * @author smittyfest
 */
public class AdventureTime4_MoreFail extends Application {
  private final Context ctx = new Context();

  private static final Random random = new Random();
  private static Tile pcTile;
  private static GridPane board;

  private boolean goNorth;
  private boolean goSouth;
  private boolean goEast;
  private boolean goWest;

  public void start(Stage primaryStage) throws Exception {
    board = new GridPane();
    double pcX = random.nextInt(OVERWORLD_MAP_COLUMNS);
    double pcY = random.nextInt(OVERWORLD_MAP_ROWS);
    System.out.println(pcX + ", " + pcY);
    pcTile = Tile.from("-", pcX, pcY);
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

    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
      public void handle(KeyEvent event) {
        switch (event.getCode()) {
          case UP:     System.out.println("UP"); pcTile.toBack(); break;
          case DOWN:   System.out.println("DOWN"); pcTile.toFront(); break;
          case LEFT:   System.out.println("LEFT"); goWest  = true; break;
          case RIGHT:  System.out.println("RIGHT"); goEast  = true; break;
        }
      }
    });

    scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
      public void handle(KeyEvent event) {
        switch (event.getCode()) {
          case UP:    goNorth = false; break;
          case DOWN:  goSouth = false; break;
          case LEFT:  goWest  = false; break;
          case RIGHT: goEast  = false; break;
        }
      }
    });

    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        int dx = 0, dy = 0;
        if (goNorth) dy -= VERTICAL_MOVE_INCREMENT;
        if (goSouth) dy += VERTICAL_MOVE_INCREMENT;
        if (goEast)  dx += HORIZONTAL_MOVE_INCREMENT;
        if (goWest)  dx -= HORIZONTAL_MOVE_INCREMENT;
        moveHeroBy(dx, dy);
      }
    };
    timer.start();
  }

  private void moveHeroBy(int dx, int dy) {
    if (dx == 0 && dy == 0) return;

    final double cx = pcTile.getBoundsInLocal().getWidth() / 2;
    final double cy = pcTile.getBoundsInLocal().getHeight() / 2;

    double x = cx + pcTile.getLayoutX() + dx;
    double y = cy + pcTile.getLayoutY() + dy;

    moveHeroTo(x, y);
  }

  private void moveHeroTo(double x, double y) {
    final double cx = pcTile.getBoundsInLocal().getWidth() / 2;
    final double cy = pcTile.getBoundsInLocal().getHeight() / 2;
    if (x - cx >= LEFTMOST_FRAME_BARRIER && x + cx <= RIGHTMOST_FRAME_BARRIER && y - cy >= TOP_OF_FRAME_BARRIER && y + cy <= BOTTOM_OF_FRAME_BARRIER) {
      pcTile.relocate(x - cx, y - cy);
    }
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}