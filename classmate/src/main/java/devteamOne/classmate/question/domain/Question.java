package devteamOne.classmate.question.domain;

import devteamOne.classmate.channel.domain.Channel;
import devteamOne.classmate.global.domain.BaseTimeEntity;
import devteamOne.classmate.user.domain.User;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Question extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String context;

  private Boolean answered;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "channel_id")
  private Channel channel;
}