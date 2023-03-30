package devteamOne.classmate.surveyAnswer.domain;

import devteamOne.classmate.survey.domain.Survey;
import devteamOne.classmate.surveyOption.domain.SurveyOption;
import devteamOne.classmate.user.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(SurveyAnswerId.class)
public class SurveyAnswer {

  @Id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @Id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "survey_id")
  private Survey survey;

  @Id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "survey_option_id")
  private SurveyOption surveyOption;
}
