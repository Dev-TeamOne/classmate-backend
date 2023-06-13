package devteamOne.classmate.question.domain;

import devteamOne.classmate.question.domain.dto.QuestionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    Question createDtoToEntity(QuestionRequest questionRequest);
}