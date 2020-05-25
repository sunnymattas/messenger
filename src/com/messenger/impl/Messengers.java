package com.messenger.impl;

import com.messenger.util.ForwardingStream;
import java.util.List;
import java.util.stream.Stream;

public class Messengers implements ForwardingStream<Rule> {
  private final List<Rule> messengerList;

  public Messengers(List<Rule> messengers) {
    this.messengerList = messengers;
  }

  @Override
  public Stream<Rule> getStream() {
    return this.messengerList.stream();
  }

  public OptionalMessenger findMatchingMessenger(String type, String message) {
    return map(messenger -> messenger.matches(type, message))
        .filter(OptionalMessenger::isPresent)
        .findFirst()
        .orElse(OptionalMessenger.empty());
  }
}
