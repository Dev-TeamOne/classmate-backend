package devteamOne.classmate.global.handler.exception;

public class ApplicationException extends RuntimeException {

    private final String status;

    protected ApplicationException(String status, String message) {
        super(message);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
