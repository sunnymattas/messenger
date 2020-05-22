package learn.clean.code;

import java.util.List;

public class Admin implements Messenger {

  @Override
  public boolean matches(final String type, final String message) {
    return getType().equalsIgnoreCase(type) && isValid(message);
  }

  @Override
  public String getType() {
    return "admin";
  }

  private boolean isValid(final String message) {
    return geMessengers().stream()
        .allMatch(messenger -> messenger.matches(messenger.getType(), message));
  }

  @Override
  public void send(final String message) {
    geMessengers().forEach(messenger -> messenger.send(message));
  }

  List<Messenger> geMessengers() {
    return List.of(new Slack(), new Skype());
  }
}
