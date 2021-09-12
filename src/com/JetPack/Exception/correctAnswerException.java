package com.JetPack.Exception;

public class correctAnswerException extends  Exception{
    public correctAnswerException() {
    }

    public correctAnswerException(String message) {
        super(message);
    }

    public correctAnswerException(String message, Throwable cause) {
        super(message, cause);
    }

    public correctAnswerException(Throwable cause) {
        super(cause);
    }

    public correctAnswerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
