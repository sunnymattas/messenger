package learn.clean.code;

public class Skype implements Messenger {

  @Override
  public void send(final String message) {
    if (isValidForSkype(message)) {
      System.out.println("Sending message to Skype");
    }
  }

  @Override
  public boolean matches(final String type, final String message) {
    return false;
  }

  private boolean isValidForSkype(final String message) {
    return message != null && !message.isBlank() && !message.contains("<");
  }
}
