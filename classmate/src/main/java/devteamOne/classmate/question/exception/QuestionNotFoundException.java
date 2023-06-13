package devteamOne.classmate.question.exception;

import devteamOne.classmate.global.handler.exception.ApplicationException;

public class QuestionNotFoundException extends ApplicationException {

    private static final String STATUS = "Q-01";
    private static final String MESSAGE = "해당 질문을 찾을 수 없습니다.";

    public QuestionNotFoundException() {
        super(STATUS, MESSAGE);
    }
}