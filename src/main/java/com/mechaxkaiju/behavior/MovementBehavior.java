package com.mechaxkaiju.behavior;

import com.mechaxkaiju.board.Board;
import com.mechaxkaiju.board.Position;

public interface MovementBehavior {
  public void move(Position newPos);

  public boolean canMove(Board board, Position targetPos);
}
