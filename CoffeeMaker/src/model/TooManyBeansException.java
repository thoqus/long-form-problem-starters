package model;

public class TooManyBeansException extends BeansAmountException {

    public TooManyBeansException(double beans) {
        super(beans, super().getMessage());
    }

}
