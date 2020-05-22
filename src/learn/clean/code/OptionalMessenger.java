package learn.clean.code;

import java.util.Optional;

public class OptionalMessenger {
  private final Optional<Messenger> messenger;

  private OptionalMessenger(Optional<Messenger> messenger) {
    this.messenger = messenger;
  }

  public static OptionalMessenger of(Messenger messenger) {
    return new OptionalMessenger(Optional.of(messenger));
  }

  public static OptionalMessenger empty() {
    return new OptionalMessenger(Optional.empty());
  }

  public Optional<Messenger> asOptional() {
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
}
