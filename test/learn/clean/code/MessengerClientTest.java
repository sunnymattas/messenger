package learn.clean.code;

import org.junit.Test;

public class MessengerClientTest {

  @Test
  public void hangout() {
    String[] input = {"hangout", "sample message"};
    MessengerClient.main(input);
  }

  @Test(expected = MessageSendFailed.class)
  public void invalidMessenger() {
    String[] input = {"invalid", "sample message"};
    MessengerClient.main(input);
  }

  @Test
  public void adminMessenger() {
    String[] input = {"admin", "sample message"};
    MessengerClient.main(input);
  }
}
