package devteamOne.classmate.user.domain;

import devteamOne.classmate.channel.domain.Channel;
import devteamOne.classmate.question.domain.Question;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nickname;

  private String socialId;

  private String provider;

  private LocalDateTime createdAt;

  @OneToMany(mappedBy = "user")
  private List<Channel> channelList = new ArrayList<>();

  @OneToMany(mappedBy = "user")
  private List<Question> questionList = new ArrayList<>();
}