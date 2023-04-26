package devteamOne.classmate.channel.domain;

import devteamOne.classmate.global.domain.BaseTimeEntity;
import devteamOne.classmate.participant.domain.Participant;
import devteamOne.classmate.question.domain.Question;
import devteamOne.classmate.survey.domain.Survey;
import devteamOne.classmate.user.domain.User;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Channel extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String code;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @OneToMany(mappedBy = "channel")
  private List<Question> questionList = new ArrayList<>();

  @OneToMany(mappedBy = "channel")
  private List<Survey> surveyList = new ArrayList<>();

  @OneToMany(mappedBy = "channel")
  private List<Participant> participantList = new ArrayList<>();
}