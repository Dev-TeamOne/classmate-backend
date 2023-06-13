package devteamOne.classmate.question.exception;

import devteamOne.classmate.global.handler.exception.ApplicationException;

public class QuestionIdentificationException extends ApplicationException {

    private static final String STATUS = "Q-01";
    private static final String MESSAGE = "해당 질문에 대한 권한이 없습니다.";

    public QuestionIdentificationException() {
        super(STATUS, MESSAGE);
    }
}
