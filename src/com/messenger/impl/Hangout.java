package com.messenger.impl;

public class Hangout implements Action, Rule {
  private final HangoutClient hangoutClient;

  public Hangout(final HangoutClient hangoutClient) {
    this.hangoutClient = hangoutClient;
  }

  @Override
  public OptionalMessenger matches(final String type, final String message) {
    return getType().equalsIgnoreCase(type) && isValidForHangout(message)
        ? OptionalMessenger.of(this)
        : OptionalMessenger.empty();
  }

  @Override
  public String getType() {
    return "hangout";
  }

  private boolean isValidForHangout(final String message) {
    return message != null && !message.isBlank() && !message.contains("!");
  }

  @Override
  public void send(final String message) {
    hangoutClient.send(message);
  }
}
