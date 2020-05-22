package learn.clean.code;

public class MessageSendFailed extends RuntimeException {
  public MessageSendFailed(final String message) {
    super(message);
  }
}
