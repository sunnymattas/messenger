package learn.clean.code;

public class Hangout implements Messenger {

  @Override
  public boolean matches(final String type, final String message) {
    return getType().equalsIgnoreCase(type) && isValidForHangout(message);
  }

  @Override
  public String getType() {
    return "hangout";
  }

  private boolean isValidForHangout(final String message) {
    return message != null && !message.isBlank() && !message.contains("!");
  }

  @Override
  public void send(final String message) {
    System.out.println("Sending message to Hangout");
  }
}
