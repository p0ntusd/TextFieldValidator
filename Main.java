/**
 * The main class for the validator program.
 * This program will open a gui with three text fields.
 * One for name, one for email and one for password.
 * It will automatically validate the text that the user
 * puts in the text fields, and display an icon if it's
 * ok or not ok. Clicking a button will display any errors.
 *
 * @author Pontus Dahlkvist
 * @date 04/01 -25
 */

package decorator;

/**
 * ------------------------- Main ---------------------------
 */
public class Main {
    public static void main(String [] args) {
        GUI gui = new GUI();
        gui.buildGUI();
    }
}
