package devteamOne.classmate.channel.domain;

import devteamOne.classmate.channel.domain.dto.ChannelCreateRequest;
import devteamOne.classmate.channel.domain.dto.ChannelDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ChannelMapperTest {

    @Test
    @DisplayName("채널생성폼_To_엔티티_Mapper 테스트")
    void createDtoToEntity() {

        ChannelCreateRequest createRequest = ChannelCreateRequest.builder()
                .name("test_channel_name")
                .maxPersonnel(10)
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now())
                .build();

        Channel channel = ChannelMapper.INSTANCE.createDtoToEntity(createRequest);

        assertAll(
                () -> assertThat(channel.getName()).isEqualTo(createRequest.getName()),
                () -> assertThat(channel.getMaxPersonnel()).isEqualTo(createRequest.getMaxPersonnel()),
                () -> assertThat(channel.getStartDate()).isEqualTo(createRequest.getStartDate()),
                () -> assertThat(channel.getEndDate()).isEqualTo(createRequest.getEndDate())
        );
    }

    @Test
    @DisplayName("채널엔티티_To_DTO_MAPPER 테스트")
    void EntityToDto() {

        Channel channel = Channel.builder()
                .id(1L)
                .code("test_code")
                .createdAt(LocalDateTime.now())
                .name("test_name")
                .build();

        ChannelDto channelDto = ChannelMapper.INSTANCE.entityToDto(channel);

        assertAll(
                () -> assertThat(channel.getName()).isEqualTo(channelDto.getName()),
                () -> assertThat(channel.getCode()).isEqualTo(channelDto.getCode()),
                () -> assertThat(channel.getCreatedAt()).isEqualTo(channelDto.getCreatedAt())
        );
    }
}