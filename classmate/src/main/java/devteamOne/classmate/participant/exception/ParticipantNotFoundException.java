package devteamOne.classmate.participant.exception;

import devteamOne.classmate.global.handler.exception.ApplicationException;

public class ParticipantNotFoundException extends ApplicationException {

    private static final String STATUS = "P-01";
    private static final String MESSAGE = "해당 채널에 사용자가 참가하고 있지 않습니다.";

    public ParticipantNotFoundException() {
        super(STATUS, MESSAGE);
    }
}