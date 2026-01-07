package com.mechaxkaiju.util.logging;

import java.util.logging.Level;

public enum GameLogLevel {
  DEBUG, INFO, WARNING, ERROR;

  public static Level toJavaLogLevel(GameLogLevel level) {
    switch (level) {
      case DEBUG:
        return Level.FINE;
      case INFO:
        return Level.INFO;
      case WARNING:
        return Level.WARNING;
      case ERROR:
        return Level.SEVERE;
      default:
        return Level.FINE;
    }
  }

  public static GameLogLevel toGameLogLevel(Level level) {
    if (level == Level.FINE)
      return DEBUG;
    else if (level == Level.INFO)
      return INFO;
    else if (level == Level.WARNING)
      return WARNING;
    else if (level == Level.SEVERE)
      return ERROR;
    else
      return DEBUG;
  }
}
