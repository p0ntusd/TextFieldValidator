/**
 * The GUI for the text validator program.
 * Contains three auto-validated text fields
 * and a button to display errors.
 *
 * @author Pontus Dahlkvist
 * @date 04/01 -25
 */

package decorator;

import javax.swing.*;
import java.util.ArrayList;

/**
 * ------------------------- GUI --------------------------
 */
public class GUI {
    private ArrayList<ValidatedTextField> validatedTextFields = new ArrayList<>();
    private JTextArea errorText;


    /**
     * Constructor.
     */
    void buildGUI() {
        JFrame frame = new JFrame("Validator");
        frame.setSize(500, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        ValidatedTextField name = new ValidatedTextField(new BasicValidator());
        ValidatedTextField email = new ValidatedTextField(new EmailValidator(new BasicValidator()));
        ValidatedTextField password = new ValidatedTextField(new PasswordValidator(new BasicValidator()));

        validatedTextFields.add(name);
        validatedTextFields.add(email);
        validatedTextFields.add(password);
        panel.add(name);
        panel.add(email);
        panel.add(password);

        JButton validateButton = new JButton("Visa fel");
        validateButton.addActionListener(e -> getErrors());
        panel.add(validateButton);

        errorText = new JTextArea(3, 30);
        errorText.setEditable(false);
        errorText.setLineWrap(true);
        errorText.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(errorText);
        panel.add(scrollPane);

        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * Will display all current errors from the
     * three text fields in a separate error text area.
     * It does so when the user pushes the button to do it.
     */
    private void getErrors() {
        ArrayList<String> errors = new ArrayList<>();

        for (ValidatedTextField validatedTextField : validatedTextFields) {
            if (!validatedTextField.isValid()) {
                errors.add(validatedTextField.getError());
            }
        }
        if(errors.isEmpty()) {
            errorText.setText("Alla fält godkända!");
        } else {
            errorText.setText(String.join("\n", errors));
        }
    }
}
