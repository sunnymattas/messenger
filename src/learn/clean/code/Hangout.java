package learn.clean.code;

public class Hangout implements Messenger {

  @Override
  public boolean matches(final String type, final String message) {
    return "hangout".equalsIgnoreCase(type) && isValidForHangout(message);
  }

  private boolean isValidForHangout(final String message) {
    return message != null && !message.isBlank() && !message.contains("!");
  }

  @Override
  public void send(final String message) {
    System.out.println("Sending message to Hangout");
  }
}
