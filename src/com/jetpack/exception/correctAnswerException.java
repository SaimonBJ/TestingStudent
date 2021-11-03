package com.jetpack.exception;

/**
 * Exception preventing the correct entry of test answers
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class correctAnswerException extends  Exception{

    /**Constructor displaying an error message*/
    public correctAnswerException(String message) {
        super(message);
    }

}
