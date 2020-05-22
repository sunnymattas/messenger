package learn.clean.code;

public class Slack implements Messenger {

  @Override
  public void send(final String message) {
    if (isValidForSlack(message)) {
      System.out.println("Sending message to Slack");
    }
  }

  @Override
  public boolean matches(final String type, final String message) {
    return false;
  }

  private boolean isValidForSlack(final String message) {
    return message != null && !message.isBlank();
  }
}
