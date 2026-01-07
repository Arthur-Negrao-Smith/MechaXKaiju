package com.mechaxkaiju;

import com.mechaxkaiju.board.Board;
import com.mechaxkaiju.entities.Entity;
import com.mechaxkaiju.util.Position;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Game {

  public static void main() {
    var root = Logger.getLogger(Game.class.getName());
    root.setLevel(Level.ALL);

    root.info("Init the game");

    var board = new Board();
    var entity = new Entity("Test");
    entity.setTablePos(new Position(0, 0));

    try {
      board.addEntity(entity);
    } catch (Exception e) {
      System.out.println("Error to add a entity");
    }

    root.info("Terminate the game");
  }

}
