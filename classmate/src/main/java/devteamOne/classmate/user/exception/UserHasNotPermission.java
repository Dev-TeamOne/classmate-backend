package devteamOne.classmate.user.exception;

import devteamOne.classmate.global.handler.exception.ApplicationException;

public class UserHasNotPermission extends ApplicationException {

    private static final String STATUS = "U-03";
    private static final String MESSAGE = "해당 유저에는 권한이 없습니다.";

    public UserHasNotPermission() {
        super(STATUS, MESSAGE);
    }
}
