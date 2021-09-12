package com.JetPack.Exception;

public class IncorrectUserNameException extends RuntimeException{
    public IncorrectUserNameException() {
    }

    public IncorrectUserNameException(String message) {
        super(message);
    }

    public IncorrectUserNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectUserNameException(Throwable cause) {
        super(cause);
    }

    public IncorrectUserNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static void checkValidNameStudent(boolean foundStudent)throws IncorrectUserNameException{
        if (!foundStudent){
            throw new IncorrectUserNameException("Incorrect!");
        }
    }

    public static void checkValidNameTeacher(boolean foundTeacher)throws IncorrectUserNameException{
        if (!foundTeacher){
            throw new IncorrectUserNameException("Incorrect name input!");
        }
    }
}
