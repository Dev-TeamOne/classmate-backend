package devteamOne.classmate.question.service;

import devteamOne.classmate.channel.domain.Channel;
import devteamOne.classmate.channel.exception.ChannelNotFoundException;
import devteamOne.classmate.channel.repository.ChannelRepository;
import devteamOne.classmate.participant.exception.ParticipantNotFoundException;
import devteamOne.classmate.participant.repository.ParticipantRepository;
import devteamOne.classmate.question.domain.Question;
import devteamOne.classmate.question.domain.QuestionMapper;
import devteamOne.classmate.question.domain.dto.QuestionRequest;
import devteamOne.classmate.question.exception.QuestionIdentificationException;
import devteamOne.classmate.question.exception.QuestionNotFoundException;
import devteamOne.classmate.question.repository.QuestionRepository;
import devteamOne.classmate.user.domain.User;
import devteamOne.classmate.user.exception.UserNotFoundException;
import devteamOne.classmate.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final ChannelRepository channelRepository;
    private final ParticipantRepository participantRepository;

    public void save(Long channelId, QuestionRequest questionRequest) {

        // channel 조회
        Channel channel = channelRepository.findById(channelId)
            .orElseThrow(ChannelNotFoundException::new);

        // user 조회
        User user = userRepository.findById(1L)
            .orElseThrow(UserNotFoundException::new);

        // channel 참가자에 포함되어 있는지 확인
        participantRepository.findByUserAndChannel(user, channel)
            .orElseThrow(ParticipantNotFoundException::new);

        // question 생성
        Question question = QuestionMapper.INSTANCE.createDtoToEntity(questionRequest);
        question.assignCreator(user, channel);

        // question 저장
        questionRepository.save(question);
    }

    public void modifyQuestion(Long questionId, QuestionRequest questionRequest) {

        // question 조회
        Question question = questionRepository.findById(questionId)
            .orElseThrow(QuestionNotFoundException::new);

        // 본인 확인
        User user = userRepository.findById(1L).orElseThrow();
        Boolean identification = question.checkUser(user);
        if (!identification) {
            throw new QuestionIdentificationException();
        }

        // question 수정
        question.modifyContent(questionRequest.getContent());

        // question 저장
        questionRepository.save(question);
    }

    public void delete(Long question_id) {

        // question 조회
        Question question = questionRepository.findById(question_id)
            .orElseThrow(QuestionNotFoundException::new);

        // 본인 확인
        User user = userRepository.findById(1L).orElseThrow();
        Boolean identification = question.checkUser(user);
        if (!identification) {
            throw new QuestionIdentificationException();
        }

        // question 삭제
        questionRepository.delete(question);
    }
}
