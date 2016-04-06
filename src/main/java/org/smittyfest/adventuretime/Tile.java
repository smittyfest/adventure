package org.smittyfest.adventuretime;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author smittyfest
 */
public class Tile extends Rectangle {

  private static final int TILE_WIDTH = 8;
  private static final int TILE_HEIGHT = 12;
  private final String symbol;
  private final Color color;

  private Tile(String symbol, Color color, double coordX, double coordY) {
    super();
    this.symbol = symbol;
    this.color = color;
    super.setWidth(TILE_WIDTH);
    super.setHeight(TILE_HEIGHT);
    super.setX(coordX);
    super.setY(coordY);
  }

  // Static Factory method for creation of new Tile objects
  public static Tile from(String symbol, Color color, double coordX, double coordY) {
    return new Tile(symbol, color, coordX, coordY);
  }

  public String getSymbol() {
    return symbol;
  }

  public Color getColor() {
    return color;
  }
}
