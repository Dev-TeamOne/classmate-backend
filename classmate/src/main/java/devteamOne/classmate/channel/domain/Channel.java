package devteamOne.classmate.channel.domain;

import devteamOne.classmate.participant.domain.Participant;
import devteamOne.classmate.question.domain.Question;
import devteamOne.classmate.survey.domain.Survey;
import devteamOne.classmate.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer maxPersonnel;

    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "channel")
    private List<Question> questionList = new ArrayList<>();

    @OneToMany(mappedBy = "channel")
    private List<Survey> surveyList = new ArrayList<>();

    @OneToMany(mappedBy = "channel")
    private List<Participant> participantList = new ArrayList<>();

    public void assignCreator(User user) {
        this.user = user;
        this.code = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }
}