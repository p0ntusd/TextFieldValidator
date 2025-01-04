/**
 * The simplest form of the text validators.
 * It will look at text and validate if the
 * text field is empty or not. Other validator
 * classes will build more on top of this one.
 *
 * @author Pontus Dahlkvist
 * @date 04/01 -25
 */

package decorator;

/**
 * ------------------- Basic Validator -------------------------
 */
public class BasicValidator implements Validator {
    private String message = "Fyll i alla textfält.";

    /**
     * Will check a string and return if it
     * is empty or not.
     *
     * @param text  The string to be checked.
     * @return      True if empty, false if not.
     */
    @Override
    public boolean isEmpty(String text) {
        return text.isEmpty();
    }

    /**
     * Will check if a string is valid. The string
     * is valid as long as it is not empty.
     * @param text  The string to be checked.
     * @return      True if valid, false if not.
     */
    @Override
    public boolean isValid(String text) {
        if(text.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Will return the message associated with this validator.
     * This message is used to display errors to the user.
     * @return  The message.
     */
    @Override
    public String getMessage() {
        return message;
    }
}
