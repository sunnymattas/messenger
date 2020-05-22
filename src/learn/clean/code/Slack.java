package learn.clean.code;

public class Slack implements Messenger {

  @Override
  public void send(final String message) {
    if (isValid(message)) {
      System.out.println("Sending message to Slack");
    }
  }

  @Override
  public boolean matches(final String type, final String message) {
    return getType().equalsIgnoreCase(type) && isValid(message);
  }

  @Override
  public String getType() {
    return "slack";
  }

  private boolean isValid(final String message) {
    return message != null && !message.isBlank();
  }
}
