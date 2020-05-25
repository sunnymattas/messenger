package com.messenger.impl;

import java.util.List;

public class Admin implements Rule, Action {

  @Override
  public OptionalMessenger matches(final String type, final String message) {
    return getType().equalsIgnoreCase(type) && isValid(message)
        ? OptionalMessenger.of(this)
        : OptionalMessenger.empty();
  }

  @Override
  public String getType() {
    return "admin";
  }

  private boolean isValid(final String message) {
    return geMessengers()
        .allMatch(messenger -> messenger.matches(messenger.getType(), message).isPresent());
  }

  @Override
  public void send(final String message) {
    List.of(new Slack(), new Skype()).forEach(messenger -> messenger.send(message));
  }

  private Messengers geMessengers() {
    return new Messengers(List.of(new Slack(), new Skype()));
  }
}
