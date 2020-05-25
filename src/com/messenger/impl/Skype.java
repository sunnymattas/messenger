package com.messenger.impl;

public class Skype implements Action, Rule {

  @Override
  public void send(final String message) {
    System.out.println("Sending message to Skype");
  }

  @Override
  public OptionalMessenger matches(final String type, final String message) {
    return getType().equalsIgnoreCase(type) && isValid(message)
        ? OptionalMessenger.of(this)
        : OptionalMessenger.empty();
  }

  @Override
  public String getType() {
    return "skype";
  }

  private boolean isValid(final String message) {
    return message != null && !message.isBlank() && !message.contains("<");
  }
}
