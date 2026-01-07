package com.mechaxkaiju.board;

/**
 * Position on the board game
 */
public class Position {
  private int x;
  private int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "(%d, %d)".formatted(x, y);
  }

  public void setX(int newX) {
    x = newX;
  }

  public void setY(int newY) {
    y = newY;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
