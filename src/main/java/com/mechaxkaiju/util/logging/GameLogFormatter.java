package com.mechaxkaiju.util.logging;

import java.time.LocalTime;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class GameLogFormatter extends Formatter {
  @Override
  public String format(LogRecord record) {
    var level = GameLogLevel.toGameLogLevel(record.getLevel());

    return String.format(
        "%s[%s]%s %s[%s]%s %s - %s%n",

        LogColor.GRAY,
        LocalTime.now(),
        LogColor.RESET,

        colorFor(level),
        level,
        LogColor.RESET,

        record.getLoggerName(),
        formatMessage(record));
  }

  private static String colorFor(GameLogLevel level) {
    switch (level) {
      case DEBUG:
        return LogColor.BLUE;
      case INFO:
        return LogColor.GREEN;
      case WARNING:
        return LogColor.YELLOW;
      case ERROR:
        return LogColor.RED + LogColor.BOLD;
      default:
        return LogColor.RESET;
    }
  }
}
