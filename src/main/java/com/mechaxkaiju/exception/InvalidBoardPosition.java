package com.mechaxkaiju.exception;

import com.mechaxkaiju.board.Position;

public class InvalidBoardPosition extends Exception {
  public InvalidBoardPosition(Position pos) {
    super("This position doen't fit on the board: " + pos);
  }
}
