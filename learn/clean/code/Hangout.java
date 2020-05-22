package learn.clean.code;

public class Hangout implements Messenger {

  @Override
  public void send(final String message) {
    if (isValidForHangout(message)) {
      SlackClient client = new SlackClient();
      client.send(message);
    }
  }

  private boolean isValidForHangout(final String message) {
    return message != null && !message.isBlank() && !message.contains("!");
  }
}
