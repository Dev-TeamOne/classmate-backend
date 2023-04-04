package devteamOne.classmate.global.response;

import org.springframework.http.HttpStatus;

public class BasicResponse {
    private HttpStatus status;
    private String message;

    private BasicResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public static BasicResponse from(HttpStatus status, String message) {
        return new BasicResponse(status, message);
    }
}
