package devteamOne.classmate.channel.domain;

import devteamOne.classmate.channel.domain.dto.ChannelCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ChannelMapper {

    ChannelMapper INSTANCE = Mappers.getMapper(ChannelMapper.class);

    Channel createDtoToEntity(ChannelCreateRequest request);
}
