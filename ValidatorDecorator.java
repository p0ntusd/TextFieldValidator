/**
 * Implements Validator and is used to
 * decorate a Validator by the decorator
 * design pattern.
 *
 * @author Pontus Dahlkvist
 * @date 04/01 -25
 */

package decorator;

/**
 * ------------------------- ValidatorDecorator ----------------------------
 */
public abstract class ValidatorDecorator implements Validator {
    protected Validator decoratedValidator;

    /**
     * Constructor.
     * @param decoratedValidator
     */
    public ValidatorDecorator(Validator decoratedValidator) {
        this.decoratedValidator = decoratedValidator;
    }

    /**
     * Will check if a String is empty or not.
     *
     * @param text  The string to be checked.
     * @return      True if empty, false if not.
     */
    public boolean isEmpty(String text) {
        return decoratedValidator.isEmpty(text);
    }

    /**
     * Will check if a string is valid or not.
     * How it is decided depends on what validator it is
     * decorated with.
     *
     * @param text  String to be checked.
     * @return      True if valid, false if not.
     */
    public boolean isValid(String text) {
        return decoratedValidator.isValid(text);
    }

    /**
     * Will return the error message that a
     * validator has.
     *
     * @return  The message.
     */
    public String getMessage() {
        return decoratedValidator.getMessage();
    }
}
