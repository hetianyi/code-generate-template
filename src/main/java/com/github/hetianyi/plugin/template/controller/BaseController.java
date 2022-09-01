package com.github.hetianyi.plugin.template.controller;

import com.github.hetianyi.boot.ready.exception.BizException;
import com.github.hetianyi.boot.ready.model.http.Page;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public interface BaseController {
    /**
     * 校验字段规则，如果校验不通过，则抛出异常
     */
    default void validateFields(BindingResult bindingResult) {
        for (FieldError err : bindingResult.getFieldErrors()) {
            throw new BizException(err.getDefaultMessage());
        }
    }
}