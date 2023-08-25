package exceptions;

import enums.ExceptionEnum;

public class ServiceExceptions extends RuntimeException {
    public ServiceExceptions(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
    }
}
