package exceptions;

import exceptions.BeansAmountException;

public class TooManyBeansException extends BeansAmountException {

    public TooManyBeansException(double beans) {
        super(beans, " are too many beans");
    }




}
