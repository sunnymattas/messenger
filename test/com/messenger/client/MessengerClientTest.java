package com.messenger.client;

import static org.mockito.Mockito.verify;

import com.messenger.impl.Admin;
import com.messenger.impl.Hangout;
import com.messenger.impl.client.HangoutClient;
import com.messenger.impl.Rule;
import com.messenger.impl.Skype;
import com.messenger.impl.client.SkypeClient;
import com.messenger.impl.Slack;
import com.messenger.impl.client.SlackClient;
import com.messenger.impl.exception.MessageSendFailed;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MessengerClientTest {

  private static final String SAMPLE_MESSAGE = "sample message";
  @Mock private SkypeClient skypeClient;
  @Mock private SlackClient slackClient;
  @Mock private HangoutClient hangoutClient;

  @Test
  public void hangout() {
    new MessengerClient(getMessengers()).send("hangout", SAMPLE_MESSAGE);

    verify(hangoutClient).send(SAMPLE_MESSAGE);
  }

  @Test(expected = MessageSendFailed.class)
  public void invalidMessenger() {
    new MessengerClient(getMessengers()).send("invalid", SAMPLE_MESSAGE);
  }

  @Test
  public void adminMessenger() {
    new MessengerClient(getMessengers()).send("admin", SAMPLE_MESSAGE);

    verify(skypeClient).send(SAMPLE_MESSAGE);
    verify(slackClient).send(SAMPLE_MESSAGE);
  }

  private List<Rule> getMessengers() {
    return List.of(
        new Admin(skypeClient, slackClient),
        new Slack(slackClient),
        new Skype(skypeClient),
        new Hangout(hangoutClient));
  }
}
