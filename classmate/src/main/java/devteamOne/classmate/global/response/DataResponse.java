package devteamOne.classmate.global.response;

import lombok.Getter;

@Getter
public class DataResponse<T> {

    private String status;
    private String message;
    private T data;

    private DataResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> DataResponse from(String status, String message, T data) {
        return new DataResponse(status, message, data);
    }
}
