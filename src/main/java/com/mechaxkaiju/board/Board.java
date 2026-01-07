package com.mechaxkaiju.board;

import com.mechaxkaiju.entities.Entity;
import com.mechaxkaiju.util.logging.GameLogger;
import com.mechaxkaiju.exception.NonEmptyPosition;
import com.mechaxkaiju.exception.InvalidBoardPosition;

/**
 * Board game to place the entities
 */
public class Board {
  private static final int xSize = 8;
  private static final int ySize = 8;
  private Entity[][] board = new Entity[ySize][xSize];

  private static final GameLogger log = new GameLogger(Board.class);

  public void addEntity(Entity entity) throws InvalidBoardPosition, NonEmptyPosition {
    if (!isValidPos(entity.getTablePos())) {
      log.warn("The entity '" + entity + "' attempted to access an invalid position");

      throw new InvalidBoardPosition(entity.getTablePos());
    }

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

  public boolean isValidPos(Position pos) {
    if ((pos.getX() < xSize || pos.getX() >= xSize) ||
        (pos.getY() < ySize || pos.getY() >= ySize))
      return false;

    return true;

  }

  public boolean isEmptyPos(Position pos) {
    if (board[pos.getX()][pos.getY()] == null) {
      log.debug("The pos " + pos + " is empty");
      return true;
    }

    log.debug("The pos " + pos + " isn't empty");
    return false;
  }

  public static final int getXSize() {
    return xSize;
  }

  public static final int getYSize() {
    return ySize;
  }

  public Entity getEntity(Position pos) {
    return board[pos.getX()][pos.getY()];
  }
}
