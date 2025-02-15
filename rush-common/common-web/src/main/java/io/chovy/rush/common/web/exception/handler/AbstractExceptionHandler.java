package io.chovy.rush.common.web.exception.handler;

import io.chovy.rush.common.lang.exception.BizException;
import io.chovy.rush.common.lang.exception.SysException;
import io.chovy.rush.common.lang.exception.code.CommonErrCode;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class AbstractExceptionHandler<R> {

    protected static final Logger log = LoggerFactory.getLogger(AbstractExceptionHandler.class);

    /** 请求参数校验异常 */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handleValidationException(
            MethodArgumentNotValidException ex, HttpServletRequest request) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        log.warn("参数校验异常: uri={} , errMsg={} ", request.getRequestURI(), ex.getMessage());
        FieldError firstError = fieldErrors.get(0);
        return getResult(
                CommonErrCode.PARAM_BIND_ERROR.getCode(),
                String.format("参数校验异常: %s", firstError.getDefaultMessage()));
    }

    /** 业务异常 */
    @ExceptionHandler(BizException.class)
    public R handleBizException(BizException ex, HttpServletRequest request) {
        log.warn("业务异常: uri={} , errMsg={} ", request.getRequestURI(), ex.getMessage());
        return getResult(ex.getErrCode(), ex.getErrMsg());
    }

    /** 系统异常 */
    @ExceptionHandler(SysException.class)
    public R handleSysException(SysException ex, HttpServletRequest request) {
        log.error("系统异常: uri={} , errMsg={} ", request.getRequestURI(), ex.getMessage(), ex);
        return getResult(ex.getErrCode(), ex.getErrMsg());
    }

    /** 未知异常 */
    @ExceptionHandler(Exception.class)
    public R handleException(Exception ex, HttpServletRequest request) {
        log.error("未知异常: uri={} , errMsg={} ", request.getRequestURI(), ex.getMessage(), ex);
        return getResult(CommonErrCode.SYS_ERROR.getCode(), CommonErrCode.SYS_ERROR.getMsg());
    }

    /** 返回结果 */
    protected abstract R getResult(Integer errCode, String errMsg);
}
