package com.messenger.impl.exception;

public class MessageSendFailed extends RuntimeException {
  public MessageSendFailed(final String message) {
    super(message);
  }
}
