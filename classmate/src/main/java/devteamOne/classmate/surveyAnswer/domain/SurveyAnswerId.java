package devteamOne.classmate.surveyAnswer.domain;

import devteamOne.classmate.survey.domain.Survey;
import devteamOne.classmate.surveyOption.domain.SurveyOption;
import devteamOne.classmate.user.domain.User;
import java.io.Serializable;

public class SurveyAnswerId implements Serializable {
  private User user;
  private Survey survey;
  private SurveyOption surveyOption;
}
