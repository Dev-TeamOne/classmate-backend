package devteamOne.classmate.pinned.domain;

import devteamOne.classmate.channel.domain.Channel;
import devteamOne.classmate.question.domain.Question;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@IdClass(PinnedId.class)
public class Pinned {

  @Id
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "channel_id")
  private Channel channel;

  @Id
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "question_id")
  private Question question;
}
