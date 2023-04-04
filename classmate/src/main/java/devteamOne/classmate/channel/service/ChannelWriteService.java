package devteamOne.classmate.channel.service;

import devteamOne.classmate.channel.domain.Channel;
import devteamOne.classmate.channel.domain.ChannelMapper;
import devteamOne.classmate.channel.domain.dto.ChannelCreateRequest;
import devteamOne.classmate.channel.exception.ChannelNotFoundException;
import devteamOne.classmate.channel.repository.ChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ChannelWriteService {

    private final ChannelRepository channelRepository;

    public void save(ChannelCreateRequest request) {
        Channel channel = ChannelMapper.INSTANCE.createDtoToEntity(request);
        // set User

        channelRepository.save(channel);
    }

    public void delete(Long id) {
        Channel channel = channelRepository.findById(id).orElseThrow(ChannelNotFoundException::new);

        // User 권한 체크
        channelRepository.delete(channel);
    }
}

