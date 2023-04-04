package devteamOne.classmate.channel.repository;

import devteamOne.classmate.channel.domain.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
