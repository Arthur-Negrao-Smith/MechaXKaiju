package com.mechaxkaiju.entities;

import com.mechaxkaiju.behavior.AttackBehavior;
import com.mechaxkaiju.behavior.MovementBehavior;

public interface GameCharacter {
  public String getName();

  public int getHP();

  public int getArmour();

  public int getDamage();

  public float getDodge();

  public int getLevel();

  public MovementBehavior getMovementBehavior();

  public AttackBehavior getAttackBehavior();
}
