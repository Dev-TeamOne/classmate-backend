package devteamOne.classmate.question.controller;

import devteamOne.classmate.global.response.BasicResponse;
import devteamOne.classmate.question.domain.dto.QuestionRequest;
import devteamOne.classmate.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/question/{channel_id}")
    public ResponseEntity<BasicResponse> create(@RequestBody QuestionRequest questionRequest, @PathVariable("channel_id") Long channelId) {

        questionService.save(channelId, questionRequest);

        return ResponseEntity.ok(
            BasicResponse.from("200", "질문 생성 성공")
        );
    }

    @PutMapping("/question/{question_id}")
    public ResponseEntity<BasicResponse> modify(@RequestBody QuestionRequest questionRequest, @PathVariable("question_id") Long questionId) {

        questionService.modifyQuestion(questionId, questionRequest);

        return ResponseEntity.ok(
            BasicResponse.from("200", "질문 수정 성공")
        );
    }
}
