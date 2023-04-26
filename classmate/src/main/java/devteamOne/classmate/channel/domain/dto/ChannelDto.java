package devteamOne.classmate.channel.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ChannelDto {
    private String name;
    private String code;
    private LocalDateTime createdAt;
}
