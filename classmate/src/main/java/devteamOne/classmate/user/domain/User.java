package devteamOne.classmate.user.domain;

import devteamOne.classmate.channel.domain.Channel;
import devteamOne.classmate.global.domain.BaseTimeEntity;
import devteamOne.classmate.question.domain.Question;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;

@Entity
public class User extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nickname;

  private String socialId;

  private String provider;

  @OneToMany(mappedBy = "user")
  private List<Channel> channelList = new ArrayList<>();

  @OneToMany(mappedBy = "user")
  private List<Question> questionList = new ArrayList<>();
}