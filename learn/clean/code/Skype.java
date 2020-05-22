package learn.clean.code;

public class Skype implements Messenger {

  @Override
  public void send(final String message) {
    if (isValidForSkype(message)) {
      SlackClient client = new SlackClient();
      client.send(message);
    }
  }

  private boolean isValidForSkype(final String message) {
    return message != null && !message.isBlank() && !message.contains("<");
  }
}
