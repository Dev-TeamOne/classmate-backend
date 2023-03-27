package devteamOne.classmate.pinned.domain;

import devteamOne.classmate.channel.domain.Channel;
import devteamOne.classmate.question.domain.Question;
import java.io.Serializable;

public class PinnedId implements Serializable {
  private Channel channel;
  private Question question;
}
