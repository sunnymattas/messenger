package learn.clean.code;

public interface Rule {
  OptionalMessenger matches(final String type, final String message);

  String getType();
}
