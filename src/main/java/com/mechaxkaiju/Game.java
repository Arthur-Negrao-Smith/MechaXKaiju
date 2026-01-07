package com.mechaxkaiju;

import com.mechaxkaiju.board.Board;
import com.mechaxkaiju.entities.Entity;
import com.mechaxkaiju.board.Position;
import com.mechaxkaiju.util.logging.GameLogger;

public class Game {

  private static final GameLogger log = new GameLogger(Game.class);

  public static void main() {
    GameLogger.init();

    log.info("Init the game");

    var board = new Board();
    var entity = new Entity("Test");
    entity.setTablePos(new Position(0, 0));

    try {
      board.addEntity(entity);
    } catch (Exception e) {
      System.out.println("Error to add a entity");
    }

    log.info("Terminate the game");
  }

}
