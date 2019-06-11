package com.parallel5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Record {
  private static Pattern pattern =
      Pattern.compile(
          "^.+\\[(\\d+\\/\\w+\\/\\d+).*] \"((\\w+) .*)\" (\\d{3}) [\\d-]+$",
          Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
  private static SimpleDateFormat dateFormat =
      new SimpleDateFormat("dd/MMM/yyyy", new Locale(Locale.ENGLISH.getLanguage()));

  private int status;
  private String request;
  private String method;
  private Date date;

  private Record(Date date, String request, String method, int status) {
    this.request = request;
    this.status = status;
    this.method = method;
    this.date = date;
  }

  public static Record fromString(String input) {
    Matcher matcher = pattern.matcher(input);

    if (!matcher.find()) {
      return null;
    }

    try {
      Date date = dateFormat.parse(matcher.group(1));
      String request = matcher.group(2);
      String method = matcher.group(3);
      int status = Integer.parseInt(matcher.group(4));

      return new Record(date, request, method, status);
    } catch (ParseException e) {
      e.printStackTrace();

      return null;
    }
  }

  public int getStatus() {
    return status;
  }

  public String getMethod() {
    return method;
  }

  public Date getDate() {
    return date;
  }

  public String getRequest() {
    return request;
  }
}
