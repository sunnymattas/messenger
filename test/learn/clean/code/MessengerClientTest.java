package learn.clean.code;

import org.junit.Test;

public class MessengerClientTest {

  @Test
  public void hangout() {
    String[] input = {"hangout", "sample message"};
    MessengerClient.main(input);
  }

  @Test
  public void invalidMessenger() {
    String[] input = {"invalid", "sample message"};
    MessengerClient.main(input);
  }
}
