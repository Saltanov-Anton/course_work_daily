package Exceptions;

public class IncorrectArgumentException extends Throwable{
    //исключения должны быть проверяемые
    public IncorrectArgumentException(String message) {
        super(message);
    }
}
