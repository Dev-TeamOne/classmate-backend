package devteamOne.classmate.user.domain.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
public class UserSignUpDto {

    @Email
    private String email;

    private String password;
    private String nickname;
}
