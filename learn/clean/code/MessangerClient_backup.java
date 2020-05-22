package learn.clean.code;

public class MessangerClient_backup {

  public static void main(String[] args) {

    String type = args[0];
    String message = args[1];
    // new Slack().send();
    Messenger messanger;
    if ("slack".equals(type)) {
      messanger = new Slack();
    } else if ("skype".equals(type)) {
      messanger = new Skype();
    } else if ("hangout".equals(type)) {
      messanger = new Hangout();
    } else {
      throw new MessageSendFailed(
          String.format(
              "This message '%s' cannot be sent to %s. Remove invalid characters", message, type));
    }

    messanger.send(message);
  }
}
