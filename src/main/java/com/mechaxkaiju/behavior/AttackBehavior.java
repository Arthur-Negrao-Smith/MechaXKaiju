package com.mechaxkaiju.behavior;

import com.mechaxkaiju.board.Board;
import com.mechaxkaiju.board.Position;

public interface AttackBehavior {
  public void attack(Position targetPos);

  public boolean canAttack(Board board, Position targetPos);
}
