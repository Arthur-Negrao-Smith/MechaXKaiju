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

    var entity1 = new Entity("Rock");
    entity1.setTablePos(new Position(0, 0));

    var entity2 = new Entity("Tree");
    entity2.setTablePos(new Position(0, 0));

    try {
      board.addEntity(entity1);
      board.addEntity(entity2);
    } catch (Exception e) {
      log.error("Error to add a entity", e);
    }

    log.info("Terminate the game");
  }

}
