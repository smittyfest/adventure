package org.smittyfest.adventuretime;

import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * @author smittyfest
 */
public class Tile extends Rectangle {

  private static final Random RANDOM = new Random();
  private static final int TILE_WIDTH = 10; // original: 8
  private static final int TILE_HEIGHT = 16; // original: 12
  private static final int SYMBOL_FONT_SIZE = 16;
  private static final String SYMBOL_FONT_STYLE = "Courier";
  private static final FontWeight SYMBOL_FONT_WEIGHT = FontWeight.BOLD;
  private final Text symbol;
  private final Color color;

  private Tile(String symbol, Color color, double coordX, double coordY) {
    super();
    this.symbol = createSymbol(symbol);
    this.color = color;
    super.setFill(color);
    super.setWidth(TILE_WIDTH);
    super.setHeight(TILE_HEIGHT);
    super.setX(coordX);
    super.setY(coordY);
  }

  // Static Factory method for creation of new Tile objects
  public static Tile from(String symbol, Color color, double coordX, double coordY) {
    return new Tile(symbol, color, coordX, coordY);
  }

  public static Tile from(String symbol, double coordX, double coordY) {
    return new Tile(symbol, generateColor(), coordX, coordY);
  }

  public Text getSymbol() {
    return symbol;
  }

  public Color getColor() {
    return color;
  }

  public int getXCoord() {
    return (int)super.getX();
  }

  public void setXCoord(double xCoord) {
    super.setX(xCoord);
  }

  public int getYCoord() {
    return (int)super.getY();
  }

  public void setYCoord(double yCoord) {
    super.setY(yCoord);
  }

  private Text createSymbol(String symbol) {
    Text sym = new Text(symbol);
    sym.setFill(generateColor());
    sym.setFont(Font.font(SYMBOL_FONT_STYLE, SYMBOL_FONT_WEIGHT, SYMBOL_FONT_SIZE));
    return sym;
  }

  private static Color generateColor() {
    return Color.rgb(RANDOM.nextInt(256), RANDOM.nextInt(256), RANDOM.nextInt(256));
  }
}
