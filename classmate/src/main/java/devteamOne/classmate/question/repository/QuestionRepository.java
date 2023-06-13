package devteamOne.classmate.question.repository;

import devteamOne.classmate.question.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
