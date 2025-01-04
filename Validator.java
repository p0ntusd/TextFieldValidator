/**
 * The Validator interface.
 * Contains the method declarations.
 *
 * @author Pontus Dahlkvist
 * @date 04/01 -25
 */

package decorator;

/**
 * ------------------------------- Validator --------------------------------
 */
public interface Validator {
    /**
     * Will check if a string is empty ot not.
     *
     * @param text  String to be checked.
     * @return      True if empty, false if not.
     */
    boolean isEmpty(String text);

    /**
     * Will check if a string is valid or not.
     * How this is decided depends on the specific
     * validator.
     *
     * @param text  String to be checked.
     * @return      True if valid, false if not.
     */
    boolean isValid(String text);

    /**
     * Will return a validators error message.
     *
     * @return  The message.
     */
    String getMessage();
}
