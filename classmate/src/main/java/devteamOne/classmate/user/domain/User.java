package devteamOne.classmate.user.domain;

import devteamOne.classmate.channel.domain.Channel;
import devteamOne.classmate.global.domain.BaseTimeEntity;
import devteamOne.classmate.question.domain.Question;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nickname;
    private String password;
    private String socialId;
    private String refreshToken;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Channel> channelList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Question> questionList = new ArrayList<>();

    public void updateRefreshToken(String updateRefreshToken) {
        this.refreshToken = updateRefreshToken;
    }
}