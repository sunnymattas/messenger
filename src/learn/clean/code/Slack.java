package learn.clean.code;

public class Slack implements Action, Rule {

  @Override
  public void send(final String message) {
    if (isValid(message)) {
      System.out.println("Sending message to Slack");
    }
  }

  @Override
  public OptionalMessenger matches(final String type, final String message) {
    return getType().equalsIgnoreCase(type) && isValid(message)
        ? OptionalMessenger.of(this)
        : OptionalMessenger.empty();
  }

  @Override
  public String getType() {
    return "slack";
  }

  private boolean isValid(final String message) {
    return message != null && !message.isBlank();
  }
}
