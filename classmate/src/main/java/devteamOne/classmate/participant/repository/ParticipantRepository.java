package devteamOne.classmate.participant.repository;

import devteamOne.classmate.channel.domain.Channel;
import devteamOne.classmate.participant.domain.Participant;
import devteamOne.classmate.user.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    List<Participant> findAllByUser(User user);

    Optional<Participant> findByUserAndChannel(User user, Channel channel);
}
