package com.mechaxkaiju.util.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class GameLogger {
  private final Logger logger;

  public static void init() {
    var root = Logger.getLogger("");
    root.setUseParentHandlers(false);

    root.setLevel(Level.FINE);

    for (var handler : root.getHandlers()) {
      handler.setLevel(Level.FINE);
      handler.setFormatter(new GameLogFormatter());
    }
  }

  public static void init(GameLogLevel level) {
    var root = Logger.getLogger("");
    root.setUseParentHandlers(false);

    root.setLevel(GameLogLevel.toJavaLogLevel(level));

    for (var handler : root.getHandlers()) {
      handler.setLevel(GameLogLevel.toJavaLogLevel(level));
      handler.setFormatter(new GameLogFormatter());
    }
  }

  public GameLogger(Class<?> cls) {
    this.logger = Logger.getLogger(cls.getName());
  }

  public void info(String msg) {
    log(Level.INFO, msg);
  }

  public void debug(String msg) {
    log(Level.FINE, msg);
  }

  public void warn(String msg) {
    log(Level.WARNING, msg);
  }

  public void error(String msg, Throwable t) {
    log(Level.SEVERE, msg, t);
  }

  private void log(Level level, String msg) {
    logger.log(level, msg);
  }

  private void log(Level level, String msg, Throwable t) {
    logger.log(level, msg, t);
  }
}
