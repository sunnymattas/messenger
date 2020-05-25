package com.messenger.impl;

import com.messenger.impl.client.SkypeClient;

public class Skype implements Action, Rule {
  private final SkypeClient skypeClient;

  public Skype(final SkypeClient skypeClient) {
    this.skypeClient = skypeClient;
  }

  @Override
  public void send(final String message) {
    skypeClient.send(message);
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
