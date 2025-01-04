/**
 * A decorated version of the BasicValidator.
 * Will check for the same validation as the basic
 * one but will also check if the entered text is
 * at least 8 characters long.
 *
 * @Author Pontus Dahlkvist
 * @date 04/01 -25
 */

package decorator;

import java.util.Objects;

/**
 * ------------------------- PasswordValidator -------------------------
 */
public class PasswordValidator extends ValidatorDecorator {
    private String message = "Fyll i alla textfält.";

    /**
     * Constructor. Extends the ValidatorDecorator.
     * @param decoratedValidator
     */
    public PasswordValidator(Validator decoratedValidator) {
        super(decoratedValidator);
    }

    /**
     * Will check if a string is empty.
     * @param text  String to be checked.
     * @return      True if empty, false if not.
     */
    @Override
    public boolean isEmpty(String text) {
        return text.isEmpty();
    }

    /**
     * Will check if a string is valid or not. A string
     * is valid if it is not empty, and is at least 8
     * characters long.
     * @param text  The string to be checked.
     * @return      True if valid, false if not.
     */
    @Override
    public boolean isValid(String text) {
        if(!decoratedValidator.isValid(text)) {
            message = decoratedValidator.getMessage();
            return false;
        }
        if(text.length() < 8) {
            message = "Lösenordet måste vara minst 8 tecken.";
            return false;
        }
        message = "Fyll i alla textfält.";
        return true;
    }

    /**
     * Will return the message associated with this validator.
     * This message is used to display errors to the user.
     * @return  The message.
     */
    @Override
    public String getMessage() {
        if(Objects.equals(message, "Fyll i alla textfält.")) {
            message = decoratedValidator.getMessage();
        }
        return message;
    }
}
