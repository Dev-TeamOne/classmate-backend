package devteamOne.classmate.global.handler.exception;

import devteamOne.classmate.global.response.BasicResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = {RestController.class})
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public BasicResponse applicationException(ApplicationException e) {
        return BasicResponse.from(e.getStatus(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BasicResponse methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return BasicResponse.from("E-00", e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public BasicResponse runtimeException(RuntimeException e) {
        return BasicResponse.from("E-00", e.getMessage());
    }
}
