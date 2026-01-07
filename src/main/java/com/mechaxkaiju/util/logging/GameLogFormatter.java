package com.mechaxkaiju.util.logging;

import java.time.LocalTime;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class GameLogFormatter extends Formatter {
  @Override
  public String format(LogRecord record) {
    var level = GameLogLevel.toGameLogLevel(record.getLevel());

    var sbuilder = new StringBuilder();

    sbuilder.append(
        String.format(
            "%s[%s]%s %s[%7s]%s %s - %s%n",

            LogColor.GRAY,
            LocalTime.now(),
            LogColor.RESET,

            colorFor(level),
            level,
            LogColor.RESET,

            shortName(record.getLoggerName()),
            formatMessage(record)));

    if (record.getThrown() != null)
      sbuilder.append(throwableToString(record.getThrown()));

    return sbuilder.toString();
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

  private static String shortName(String name) {
    int i = name.lastIndexOf(".");

    /** Don't have a dot */
    if (i == -1)
      return name;

    return name.substring(i + 1);
  }

  private static String throwableToString(Throwable t) {
    var sbuilder = new StringBuilder();

    sbuilder.append(LogColor.RED)
        .append(t)
        .append(LogColor.RESET)
        .append(System.lineSeparator());

    for (var line : t.getStackTrace()) {
      sbuilder.append("\tat ")
          .append(line)
          .append(System.lineSeparator());
    }

    return sbuilder.toString();
  }
}
