package learn.clean.code;

public class Slack implements Messenger {

  @Override
  public void send(final String message) {
    if (isValidForSlack(message)) {
      SlackClient client = new SlackClient();
      client.send(message);
    }
  }

  private boolean isValidForSlack(final String message) {
    return message != null && !message.isBlank();
  }
}
