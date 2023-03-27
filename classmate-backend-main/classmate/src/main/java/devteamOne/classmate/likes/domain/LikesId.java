package devteamOne.classmate.likes.domain;

import devteamOne.classmate.question.domain.Question;
import devteamOne.classmate.user.domain.User;
import java.io.Serializable;

public class LikesId implements Serializable {
  private User user;
  private Question question;
}
