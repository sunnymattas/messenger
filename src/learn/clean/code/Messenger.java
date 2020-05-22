package learn.clean.code;

public interface Messenger {
  void send(String message);

  boolean matches(final String type,final String message);
}
