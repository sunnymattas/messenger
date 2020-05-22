package learn.clean.code;

public class MessengerClient {

  public static void main(String[] args) {
    String type = args[0];
    String message = args[1];
    Messenger messanger;
    if ("slack".equals(type)) {
      messanger = new Slack();
    } else if ("skype".equals(type)) {
      messanger = new Skype();
    } else if ("hangout".equals(type)) {
      messanger = new Hangout();
    } else {
      throw new MessageSendFailed(String.format("This messenger '%s' not supported.", type));
    }
    messanger.send(message);
  }
}
