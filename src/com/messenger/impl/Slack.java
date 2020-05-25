package com.messenger.impl;

public class Slack implements Action, Rule {
  private final SlackClient slackClient;

  public Slack(final SlackClient slackClient) {
    this.slackClient = slackClient;
  }

  @Override
  public void send(final String message) {
    if (isValid(message)) {
      slackClient.send(message);
    }
  }

  @Override
  public OptionalMessenger matches(final String type, final String message) {
    return getType().equalsIgnoreCase(type) && isValid(message)
        ? OptionalMessenger.of(this)
        : OptionalMessenger.empty();
  }

  @Override
  public String getType() {
    return "slack";
  }

  private boolean isValid(final String message) {
    return message != null && !message.isBlank();
  }
}
