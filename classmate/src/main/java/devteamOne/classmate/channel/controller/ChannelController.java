package devteamOne.classmate.channel.controller;

import devteamOne.classmate.channel.domain.dto.ChannelCreateRequest;
import devteamOne.classmate.channel.service.ChannelWriteService;
import devteamOne.classmate.global.response.BasicResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelWriteService channelWriteService;

    @PostMapping("/channel")
    public BasicResponse create(@RequestBody ChannelCreateRequest request) {
        // get User

        channelWriteService.save(request);

        return BasicResponse.from(HttpStatus.OK, "채널 생성 성공");
    }
}
