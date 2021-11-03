package com.jetpack.exception;

/**
 * Exception warning correct user name entry
 * @version 1.0 02.11.2021
 * @author Semen Bogun
 */
public class IncorrectUserNameException extends RuntimeException{

    /**Constructor displaying an error message*/
    public IncorrectUserNameException(String message) {
        super(message);
    }

    /**Constructor displaying an error message for student*/
    public static void checkValidNameStudent(boolean foundStudent)throws IncorrectUserNameException{
        if (!foundStudent){
            throw new IncorrectUserNameException("Incorrect!");
        }
    }

    /**Constructor displaying an error message for teacher*/
    public static void checkValidNameTeacher(boolean foundTeacher)throws IncorrectUserNameException{
        if (!foundTeacher){
            throw new IncorrectUserNameException("Incorrect name input!");
        }
    }
}
