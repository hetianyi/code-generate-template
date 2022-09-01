package com.github.hetianyi.plugin.template.config;

import java.util.Objects;

import javax.servlet.http.HttpServletResponse;

import com.github.hetianyi.boot.ready.exception.BizException;
import com.github.hetianyi.boot.ready.model.http.Result;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 全局异常拦截转换处理
 *
 * @author Jason He
 */
@Slf4j
@ControllerAdvice
public class RestExceptionHandler {

    @Value("${spring.profiles.active}")
    private String profile;

    @ExceptionHandler({Exception.class})
    public @ResponseBody
    Result exceptionHandler(
            HttpServletResponse response,
            Throwable t
    ) {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        if (!Objects.equals(profile, "!prod")) {
            t.printStackTrace();
        }

        if (t instanceof BizException) {
            return Result.error(t.getMessage());
        }
        else {
            return Result.error("服务器错误");
        }
    }
}
