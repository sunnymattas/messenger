package learn.clean.code;

import java.util.List;

public class MessengerClient {

  public static void main(String[] args) {
    String type = args[0];
    String message = args[1];

    getMessengers().findMatchingMessenger(type, message).send(type, message);
  }

  private static Messengers getMessengers() {
    return new Messengers(List.of(new Admin(), new Slack(), new Skype(), new Hangout()));
  }
}
