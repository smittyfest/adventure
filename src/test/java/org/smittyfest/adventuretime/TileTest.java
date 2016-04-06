package org.smittyfest.adventuretime;

import org.junit.Before;
import org.junit.Test;

import javafx.scene.paint.Color;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author smittyfest
 */
public class TileTest {

  private static final double TILE_WIDTH = 8;
  private static final double TILE_HEIGHT = 12;
  private static final double TILE_COORD_X = 60;
  private static final double TILE_COORD_Y = 40;

  @Before
  public void before() {

  }

  @Test
  public void tileCreationTest() {
    Tile tile = Tile.from("@", Color.BLACK, TILE_COORD_X, TILE_COORD_Y);
    assertNotNull(tile);
    assertEquals("@", tile.getSymbol());
    assertEquals(Color.BLACK, tile.getColor());
    assertEquals(TILE_COORD_X, tile.getX());
    assertEquals(TILE_COORD_Y, tile.getY());
    assertEquals(TILE_WIDTH, tile.getWidth());
    assertEquals(TILE_HEIGHT, tile.getHeight());
  }
}
