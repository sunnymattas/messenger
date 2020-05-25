package com.messenger.client;

import com.messenger.impl.Messengers;
import com.messenger.impl.Rule;
import java.util.List;

public class MessengerClient {

  private final List<Rule> messengerList;

  public MessengerClient(final List<Rule> messengerList) {
    this.messengerList = messengerList;
  }

  public void send(final String type, final String message) {
    new Messengers(messengerList).findMatchingMessenger(type, message).send(type, message);
  }
}
