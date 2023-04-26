package devteamOne.classmate.participant.repository;

import devteamOne.classmate.participant.domain.Participant;
import devteamOne.classmate.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    List<Participant> findAllByUser(User user);
}
