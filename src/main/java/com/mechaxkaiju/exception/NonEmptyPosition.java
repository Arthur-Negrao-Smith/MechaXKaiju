package com.mechaxkaiju.exception;

import com.mechaxkaiju.util.Position;

/**
 * Exception to throw when the entity tryes access the filled space on the board
 */
public class NonEmptyPosition extends Exception {
  public NonEmptyPosition(Position pos) {
    super("This position already is fill: x=" + pos.getX() + ", y=" + pos.getY());
  }
}
