package com.nitasorteadora.bot.utils.exceptions;

import okhttp3.internal.http2.ErrorCode;

public class CreateCardException extends Exception{
    private static final long serialVersionUID = 483298432785L;
    private final ErrorCode code;
    public CreateCardException(ErrorCode code) {
        super();
        this.code = code;
    }
    public CreateCardException(String message, Throwable cause, ErrorCode code) {
        super(message,cause);
        this.code = code;
    }
    public CreateCardException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }
    public CreateCardException(Throwable cause, ErrorCode code) {
        super(cause);
        this.code = code;
    }
    public ErrorCode getCode(){
        return this.code;
    }
}
