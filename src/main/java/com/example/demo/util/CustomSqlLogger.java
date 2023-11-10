package com.example.demo.util;

import com.p6spy.engine.logging.Category;
import com.p6spy.engine.spy.appender.StdoutLogger;

@SuppressWarnings("unused")
public class CustomSqlLogger extends StdoutLogger {

  @Override
  public void logException(Exception e) {}

  @Override
  public void logText(String text) {
    System.out.println(text);
  }

  @Override
  public void logSQL(
      int connectionId,
      String now,
      long elapsed,
      Category category,
      String prepared,
      String sql,
      String url) {
    CustomFormatStrategy customFormatStrategy = new CustomFormatStrategy();
    var message =
        customFormatStrategy.formatMessage(
            connectionId, now, elapsed, category.toString(), prepared, sql, url);
    this.logText(message);
  }
}
