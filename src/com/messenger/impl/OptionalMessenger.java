package com.messenger.impl;

import com.messenger.impl.exception.MessageSendFailed;
import java.util.Optional;

public class OptionalMessenger {
  private final Optional<Action> messenger;

  private OptionalMessenger(Optional<Action> messenger) {
    this.messenger = messenger;
  }

  public static OptionalMessenger of(Action messenger) {
    return new OptionalMessenger(Optional.of(messenger));
  }

  public static OptionalMessenger empty() {
    return new OptionalMessenger(Optional.empty());
  }

  public Optional<Action> asOptional() {
    return this.messenger;
  }

  public void send(final String type, final String message) {
    messenger
        .orElseThrow(
            () ->
                new MessageSendFailed(
                    String.format(
                        "Your message has invalid text or messenger '%s' not supported.", type)))
        .send(message);
  }

  public boolean isPresent() {
    return messenger.isPresent();
  }
}
