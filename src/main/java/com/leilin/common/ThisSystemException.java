package com.leilin.common;

/**
 * 自定义异常，区分业务异常与系统异常
 */
public class ThisSystemException extends RuntimeException {

    public ThisSystemException(String message) {
        super(message);
    }

    public ThisSystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
