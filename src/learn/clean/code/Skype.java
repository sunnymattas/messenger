package learn.clean.code;

public class Skype implements Messenger {

  @Override
  public void send(final String message) {
    System.out.println("Sending message to Skype");
  }

  @Override
  public boolean matches(final String type, final String message) {
    return getType().equalsIgnoreCase(type) && isValid(message);
  }

  @Override
  public String getType() {
    return "skype";
  }

  private boolean isValid(final String message) {
    return message != null && !message.isBlank() && !message.contains("<");
  }
}
