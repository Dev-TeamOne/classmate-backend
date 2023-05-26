package devteamOne.classmate.user.service;

import devteamOne.classmate.user.domain.Role;
import devteamOne.classmate.user.domain.User;
import devteamOne.classmate.user.domain.dto.UserSignUpDto;
import devteamOne.classmate.user.exception.UserAlreadyExistException;
import devteamOne.classmate.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(UserSignUpDto userSignUpDto) {

        if (userRepository.findByEmail(userSignUpDto.getEmail()).isPresent()) {
            throw new UserAlreadyExistException();
        }

        User user = User.builder()
                .email(userSignUpDto.getEmail())
                .nickname(userSignUpDto.getNickname())
                .password(passwordEncoder.encode(userSignUpDto.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);
    }
}
