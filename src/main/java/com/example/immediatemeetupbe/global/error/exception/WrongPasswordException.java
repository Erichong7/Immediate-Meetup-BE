package com.example.immediatemeetupbe.global.error.exception;

import com.example.immediatemeetupbe.global.exception.BaseExceptionStatus;

public class WrongPasswordException extends RuntimeException {

    public WrongPasswordException() {
        super(BaseExceptionStatus.WRONG_PASSWORD.getMessage());
    }
}
