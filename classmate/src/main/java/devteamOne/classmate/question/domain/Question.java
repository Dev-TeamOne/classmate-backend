package devteamOne.classmate.question.domain;

import devteamOne.classmate.channel.domain.Channel;
import devteamOne.classmate.global.domain.BaseTimeEntity;
import devteamOne.classmate.user.domain.User;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Question extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private Boolean answered;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id")
    private Channel channel;

    public void assignCreator(User user, Channel channel) {
        this.user = user;
        this.channel = channel;
        this.answered = false;
    }

    public Boolean checkUser(User user) {
        if (this.user.equals(user)) {
            return true;
        }
        return false;
    }

    public void modifyContent(String content) {
        this.content = content;
    }
}