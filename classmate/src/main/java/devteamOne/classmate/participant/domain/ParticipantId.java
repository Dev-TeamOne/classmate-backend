package devteamOne.classmate.participant.domain;

import devteamOne.classmate.channel.domain.Channel;
import devteamOne.classmate.user.domain.User;
import java.io.Serializable;

public class ParticipantId implements Serializable {
  private Channel channel;
  private User user;
}
