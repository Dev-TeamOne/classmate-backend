package devteamOne.classmate.global.response;

import lombok.Getter;

@Getter
public class BasicResponse {
    private String status;
    private String message;

    private BasicResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public static BasicResponse from(String status, String message) {
        return new BasicResponse(status, message);
    }
}
