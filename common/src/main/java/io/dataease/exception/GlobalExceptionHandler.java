package io.dataease.exception;


import io.dataease.i18n.Translator;
import io.dataease.result.ResultCode;
import io.dataease.result.ResultMessage;
import io.dataease.utils.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * -------- 参数校验异常 --------
     **/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultMessage MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        String msg = objectError.getDefaultMessage();
        msg = Translator.get(msg);
        LogUtil.error(msg);
        return new ResultMessage(ResultCode.PARAM_IS_INVALID.code(), msg);
    }

    @ExceptionHandler(DEException.class)
    public ResultMessage deExceptionHandler(DEException e) {
        log.error("", e);
        LogUtil.error(e.getMessage());
        return new ResultMessage(e.getCode(), e.getMessage());
    }

}
