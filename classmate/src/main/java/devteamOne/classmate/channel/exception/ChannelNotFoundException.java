package devteamOne.classmate.channel.exception;

import devteamOne.classmate.global.handler.exception.ApplicationException;

public class ChannelNotFoundException extends ApplicationException {

    private static final String STATUS = "C-01";
    private static final String MESSAGE = "해당 채널을 찾을 수 없습니다.";

    public ChannelNotFoundException() {
        super(STATUS, MESSAGE);
    }
}
