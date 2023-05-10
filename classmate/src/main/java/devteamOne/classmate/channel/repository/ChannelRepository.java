package devteamOne.classmate.channel.repository;

import devteamOne.classmate.channel.domain.Channel;
import devteamOne.classmate.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChannelRepository extends JpaRepository<Channel, Long> {

    List<Channel> findAllByUser(User user);
}
