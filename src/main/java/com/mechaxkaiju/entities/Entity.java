package com.mechaxkaiju.entities;

import com.mechaxkaiju.util.Position;

import java.util.logging.Logger;

public class Entity {
  private Position tablePos;
  private String name;
  private GameCharacter character;

  /** Global entity counter. */
  private static int GLOBAL_ID = 0;

  /** Indentifier to the current entity. */
  private final int id;
  private static final Logger log = Logger.getLogger(Entity.class.getName());

  /**
   * Constructor from Entity with a character
   *
   * @param name      Name of the entity
   * @param character The character of the entity
   */
  public Entity(String name, GameCharacter character) {
    this.name = name;
    this.character = character;
    this.id = GLOBAL_ID++;

    log.info("Created the entity: " + this);
  }

  /**
   * Constructor from Entity to create a obstacle
   *
   * @param name Name of the obstacle
   */
  public Entity(String name) {
    this.name = name;
    this.character = null; // create a obstacle
    this.id = GLOBAL_ID++;

    log.info("Created the entity (obstacle): " + this);
  }

  public boolean isObstacle() {
    if (character == null)
      return true;

    return false;
  }

  public Entity setTablePos(Position newPos) {
    tablePos = newPos;

    return this;
  }

  public Position getTablePos() {
    return tablePos;
  }

  public GameCharacter getCharacter() {
    return character;
  }

  @Override
  public String toString() {
    return name + "(" + id + ")";
  }

}
