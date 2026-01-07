package com.mechaxkaiju.board;

import com.mechaxkaiju.entities.Entity;
import com.mechaxkaiju.exception.NonEmptyPosition;
import com.mechaxkaiju.util.Position;

import java.util.logging.Logger;

/**
 * Board game to place the entities
 */
public class Board {
  private Entity[][] board = new Entity[8][8];
  private static final Logger log = Logger.getLogger(Board.class.getName());

  public void addEntity(Entity entity) throws NonEmptyPosition {
    if (isEmptyPos(entity.getTablePos())) {

      Position pos = entity.getTablePos();
      board[pos.getX()][pos.getY()] = entity;

      log.fine("Entity '" + entity.getCharacter().getName() + "' added to board in position: "
          + entity.getTablePos());

      return;
    }

    log.severe("The entity '" + entity + "' tried access a filled place on board");
    throw new NonEmptyPosition(entity.getTablePos());
  }

  public boolean isEmptyPos(Position pos) {
    if (board[pos.getX()][pos.getY()] == null) {
      log.fine("The pos " + pos + " is empty");
      return true;
    }

    log.fine("The pos " + pos + " isn't empty");
    return false;
  }

  public Entity getEntity(Position pos) {
    return board[pos.getX()][pos.getY()];
  }
}
