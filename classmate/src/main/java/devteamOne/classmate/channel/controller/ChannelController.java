package devteamOne.classmate.channel.controller;

import devteamOne.classmate.channel.converter.ChannelType;
import devteamOne.classmate.channel.domain.dto.ChannelCreateRequest;
import devteamOne.classmate.channel.domain.dto.ChannelDto;
import devteamOne.classmate.channel.service.ChannelService;
import devteamOne.classmate.global.response.BasicResponse;
import devteamOne.classmate.global.response.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelService channelService;

    @GetMapping("/channels")
    public ResponseEntity<DataResponse<List<ChannelDto>>> getChannels(@RequestParam ChannelType type, Principal principal) {

        String email = principal.getName();

        return ResponseEntity.ok(
                DataResponse.from("S-00", "채널 조회 성공", channelService.getChannels(email, type))
        );
    }


    @PostMapping("/channels")
    public ResponseEntity<BasicResponse> create(@RequestBody ChannelCreateRequest request, Principal principal) {

        String email = principal.getName();
        channelService.save(email, request);

        return ResponseEntity.ok(
                BasicResponse.from("S-00", "채널 생성 성공")
        );
    }

    @DeleteMapping("/channels/{channel_id}")
    public ResponseEntity<BasicResponse> delete(@PathVariable("channel_id") Long id, Principal principal) {

        String email = principal.getName();
        channelService.delete(email, id);

        return ResponseEntity.ok(
                BasicResponse.from("S-00", "채널 삭제 성공")
        );
    }
}
