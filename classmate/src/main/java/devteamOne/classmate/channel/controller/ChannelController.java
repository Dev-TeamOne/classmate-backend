package devteamOne.classmate.channel.controller;

import devteamOne.classmate.channel.domain.dto.ChannelCreateRequest;
import devteamOne.classmate.channel.service.ChannelWriteService;
import devteamOne.classmate.global.response.BasicResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelWriteService channelWriteService;

    @PostMapping("/channel")
    public ResponseEntity<BasicResponse> create(@RequestBody ChannelCreateRequest request) {
        // get User

        channelWriteService.save(request);

        return ResponseEntity.ok(
                BasicResponse.from("S-00", "채널 생성 성공")
        );
    }

    @DeleteMapping("/channel/{channel_id}")
    public ResponseEntity<BasicResponse> delete(@PathVariable("channel_id") Long id) {

        channelWriteService.delete(id);

        return ResponseEntity.ok(
                BasicResponse.from("S-00", "채널 삭제 성공")
        );
    }
}
