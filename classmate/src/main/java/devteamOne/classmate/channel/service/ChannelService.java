package devteamOne.classmate.channel.service;

import devteamOne.classmate.channel.converter.ChannelType;
import devteamOne.classmate.channel.domain.Channel;
import devteamOne.classmate.channel.domain.ChannelMapper;
import devteamOne.classmate.channel.domain.dto.ChannelCreateRequest;
import devteamOne.classmate.channel.domain.dto.ChannelDto;
import devteamOne.classmate.channel.exception.ChannelNotFoundException;
import devteamOne.classmate.channel.repository.ChannelRepository;
import devteamOne.classmate.participant.repository.ParticipantRepository;
import devteamOne.classmate.user.domain.User;
import devteamOne.classmate.user.exception.UserNotFoundException;
import devteamOne.classmate.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ChannelService {

    private final ChannelRepository channelRepository;
    private final UserRepository userRepository;
    private final ParticipantRepository participantRepository;

    @Transactional(readOnly = true)
    public List<ChannelDto> getChannels(String socialId, ChannelType type) {

        // userService.findBySocialId(socialId);
        User user = userRepository.findById(1L).orElseThrow(UserNotFoundException::new);

        if (type.equals(ChannelType.ME)) {
            return channelRepository.findAllByUser(user).stream()
                    .map(ChannelMapper.INSTANCE::entityToDto)
                    .toList();
        } else if (type.equals(ChannelType.PARTICIPATED)) {
            return participantRepository.findAllByUser(user).stream()
                    .map(p -> ChannelMapper.INSTANCE.entityToDto(p.getChannel()))
                    .toList();
        }

        throw new IllegalStateException();
    }

    public void save(String socialId, ChannelCreateRequest request) {
        // userService.findBySocialId(socialId);
        User user = userRepository.findById(1L).orElseThrow(UserNotFoundException::new);

        Channel channel = ChannelMapper.INSTANCE.createDtoToEntity(request);
        channel.assignCreator(user);

        channelRepository.save(channel);
    }

    public void delete(Long id) {
        Channel channel = channelRepository.findById(id).orElseThrow(ChannelNotFoundException::new);

        // User 권한 체크
        channelRepository.delete(channel);
    }
}

