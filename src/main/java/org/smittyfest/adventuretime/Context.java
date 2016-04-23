package org.smittyfest.adventuretime;

/**
 * @author Eric Smith
 * @since 4/21/16
 */
public class Context {
  public static final int HORIZONTAL_MOVE_INCREMENT = 8;
  public static final int VERTICAL_MOVE_INCREMENT = 12;

  public static final int TOP_OF_FRAME_BARRIER = 12;
  public static final int BOTTOM_OF_FRAME_BARRIER = 641;

  public static final int LEFTMOST_FRAME_BARRIER = 2;
  public static final int RIGHTMOST_FRAME_BARRIER = 630;

  public static final int OVERWORLD_MAP_WIDTH = 1001;
  public static final int OVERWORLD_MAP_HEIGHT = 443;

  public static final int OVERWORLD_MAP_ROWS_ADJUSTMENT = 12;
  public static final int OVERWORLD_MAP_COLUMNS_ADJUSTMENT = 24;

  public static final int OVERWORLD_MAP_ROWS = (OVERWORLD_MAP_HEIGHT / VERTICAL_MOVE_INCREMENT) - OVERWORLD_MAP_ROWS_ADJUSTMENT;
  public static final int OVERWORLD_MAP_COLUMNS = (OVERWORLD_MAP_WIDTH / HORIZONTAL_MOVE_INCREMENT) - OVERWORLD_MAP_COLUMNS_ADJUSTMENT;
}
