package com.messenger.impl;

import com.messenger.impl.client.SkypeClient;
import com.messenger.impl.client.SlackClient;
import java.util.List;

public class Admin implements Rule, Action {
  private final SkypeClient skypeClient;
  private final SlackClient slackClient;

  public Admin(final SkypeClient skypeClient, final SlackClient slackClient) {
    this.skypeClient = skypeClient;
    this.slackClient = slackClient;
  }

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
    List.of(new Slack(slackClient), new Skype(skypeClient))
        .forEach(messenger -> messenger.send(message));
  }

  private Messengers geMessengers() {
    return new Messengers(List.of(new Slack(slackClient), new Skype(skypeClient)));
  }
}
