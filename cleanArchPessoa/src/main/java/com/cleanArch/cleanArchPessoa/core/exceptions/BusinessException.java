package com.cleanArch.cleanArchPessoa.core.exceptions;

public class BusinessException extends  RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}