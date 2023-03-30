package devteamOne.classmate.surveyOption.domain;

import devteamOne.classmate.survey.domain.Survey;
import jakarta.persistence.*;

@Entity
public class SurveyOption {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String answer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "survey_id")
  private Survey survey;
}