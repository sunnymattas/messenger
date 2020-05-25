package com.messenger.client;

import com.messenger.impl.Admin;
import com.messenger.impl.Hangout;
import com.messenger.impl.Rule;
import com.messenger.impl.Skype;
import com.messenger.impl.Slack;
import com.messenger.impl.exception.MessageSendFailed;
import java.util.List;
import org.junit.Test;

public class MessengerClientTest {

  private static final String SAMPLE_MESSAGE = "sample message";

  @Test
  public void hangout() {
    new MessengerClient(getMessengers()).send("hangout", SAMPLE_MESSAGE);
  }

  @Test(expected = MessageSendFailed.class)
  public void invalidMessenger() {

    new MessengerClient(getMessengers()).send("invalid", SAMPLE_MESSAGE);
  }

  @Test
  public void adminMessenger() {
    new MessengerClient(getMessengers()).send("admin", SAMPLE_MESSAGE);
  }

  private List<Rule> getMessengers() {
    return List.of(new Admin(), new Slack(), new Skype(), new Hangout());
  }
}
