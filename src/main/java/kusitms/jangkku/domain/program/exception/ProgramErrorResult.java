package kusitms.jangkku.domain.program.exception;

import kusitms.jangkku.global.common.code.BaseErrorCode;
import kusitms.jangkku.global.common.dto.ErrorReasonDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ProgramErrorResult implements BaseErrorCode {
    NOT_FOUND_PROGRAM(HttpStatus.NOT_FOUND, "404", "존재하지 않는 프로그램 페이지입니다.");
    
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDto getReason() {
        return ErrorReasonDto.builder()
                .isSuccess(false)
                .code(code)
                .message(message)
                .build();
    }

    @Override
    public ErrorReasonDto getReasonHttpStatus() {
        return ErrorReasonDto.builder()
                .isSuccess(false)
                .httpStatus(httpStatus)
                .code(code)
                .message(message)
                .build();
    }
}