package learn.clean.code;

public class MessengerClient {

  public static void main(String[] args) {
    String type = args[0];
    String message = args[1];
    if ("slack".equals(type)) {
      if (isValidForSlack(message)) {
        SlackClient client = new SlackClient();
        client.send(message);
      }
    } else if ("skype".equals(type)) {

      if (isValidForSkype(message)) {
        SlackClient client = new SlackClient();
        client.send(message);
      }
    } else if ("hangout".equals(type)) {
      if (isValidForHangout(message)) {
        SlackClient client = new SlackClient();
        client.send(message);
      }
    } else {
      throw new MessageSendFailed(
          String.format(
              "This message '%s' cannot be sent to %s. Remove invalid characters", message, type));
    }
  }

  private static boolean isValidForHangout(final String message) {
    return message != null && !message.isBlank() && !message.contains("!");
  }

  private static boolean isValidForSkype(final String message) {
    return message != null && !message.isBlank() && !message.contains("<");
  }

  private static boolean isValidForSlack(final String message) {
    return message != null && !message.isBlank();
  }
}
