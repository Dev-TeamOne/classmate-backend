package devteamOne.classmate.survey.domain;

import devteamOne.classmate.channel.domain.Channel;
import devteamOne.classmate.global.domain.BaseTimeEntity;
import devteamOne.classmate.surveyOption.domain.SurveyOption;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Survey extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String question;

  private Boolean multipleCheck;

  private Boolean opened;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "channel_id")
  private Channel channel;

  @OneToMany(mappedBy = "survey")
  private List<SurveyOption> surveyOptionList = new ArrayList<>();
}