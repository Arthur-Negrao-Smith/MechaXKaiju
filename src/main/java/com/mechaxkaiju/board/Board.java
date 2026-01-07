package com.mechaxkaiju.board;

import com.mechaxkaiju.entities.Entity;
import com.mechaxkaiju.exception.NonEmptyPosition;
import com.mechaxkaiju.util.logging.GameLogger;

/**
 * Board game to place the entities
 */
public class Board {
  private Entity[][] board = new Entity[8][8];

  private static final GameLogger log = new GameLogger(Board.class);

  public void addEntity(Entity entity) throws NonEmptyPosition {
    if (isEmptyPos(entity.getTablePos())) {

      Position pos = entity.getTablePos();
      board[pos.getX()][pos.getY()] = entity;

      log.debug(
          "Entity '" + entity.getCharacter().getName() + "' added to board in position: "
              + entity.getTablePos());

      return;
    }

    log.warn("The entity '" + entity + "' tried access a filled place on board");
    throw new NonEmptyPosition(entity.getTablePos());
  }

  public boolean isEmptyPos(Position pos) {
    if (board[pos.getX()][pos.getY()] == null) {
      log.debug("The pos " + pos + " is empty");
      return true;
    }

    log.debug("The pos " + pos + " isn't empty");
    return false;
  }

  public Entity getEntity(Position pos) {
    return board[pos.getX()][pos.getY()];
  }
}
