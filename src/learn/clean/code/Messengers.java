package learn.clean.code;

import java.util.List;
import java.util.stream.Stream;

public class Messengers implements ForwardingStream<Messenger> {
  private final List<Messenger> messengerList;

  public Messengers(List<Messenger> messengers) {
    this.messengerList = messengers;
  }

  @Override
  public Stream<Messenger> getStream() {
    return this.messengerList.stream();
  }

  public OptionalMessenger findMatchingMessenger(String type, String message) {
    return filter(messenger -> messenger.matches(type, message))
        .findFirst()
        .map(OptionalMessenger::of)
        .orElse(OptionalMessenger.empty());
  }
}
