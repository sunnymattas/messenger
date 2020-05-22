package learn.clean.code;

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
    return map(messenger -> getMatches(type, message, messenger))
        .filter(OptionalMessenger::isPresent)
        .findFirst()
        .orElse(OptionalMessenger.empty());
  }

  private OptionalMessenger getMatches(
      final String type, final String message, final Rule messenger) {
    return messenger.matches(type, message);
  }
}
