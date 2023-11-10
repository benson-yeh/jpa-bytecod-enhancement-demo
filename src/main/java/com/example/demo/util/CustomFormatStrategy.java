package com.example.demo.util;

import com.github.vertical_blank.sqlformatter.SqlFormatter;
import com.github.vertical_blank.sqlformatter.languages.Dialect;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

public class CustomFormatStrategy implements MessageFormattingStrategy {

  @Override
  public String formatMessage(
      int connectionId,
      String now,
      long elapsed,
      String category,
      String prepared,
      String sql,
      String url) {
    return SqlFormatter.of(Dialect.TSql).format(sql) + "\n";
  }
}
