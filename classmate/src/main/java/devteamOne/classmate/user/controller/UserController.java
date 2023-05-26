package devteamOne.classmate.user.controller;

import devteamOne.classmate.global.response.BasicResponse;
import devteamOne.classmate.user.domain.dto.UserSignUpDto;
import devteamOne.classmate.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/sign-up")
    public ResponseEntity<BasicResponse> signUp(@RequestBody UserSignUpDto userSignUpDto) {
        userService.signUp(userSignUpDto);

        return ResponseEntity.ok(
                BasicResponse.from("S-00", "회원 가입 성공")
        );
    }
}
