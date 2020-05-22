package learn.clean.code;

import java.util.List;

public class MessengerClient {

  public static void main(String[] args) {
    String type = args[0];
    String message = args[1];

    getMessengers().stream()
        .filter(messenger -> messenger.matches(type, message))
        .findFirst()
        .orElseThrow(
            () ->
                new MessageSendFailed(
                    String.format(
                        "Your message has invalid text or messenger '%s' or not supported.", type)))
        .send(message);
  }

  private static List<Messenger> getMessengers() {
    return List.of(new Slack(), new Skype(), new Hangout());
  }
}
