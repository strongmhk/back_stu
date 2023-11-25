package hello.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "error.bad") // code = HTTP 상태코드, reason = 오류 메시지
public class BadRequestException extends RuntimeException{


}
