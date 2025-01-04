/**
 * This class is a text field that will automatically
 * validate itself based on what validator it has.
 * It will display a checkmark icon if valid and
 * a cross icon of not. Will continue to validate
 * in real time as the user edits the text in the
 * text field.
 *
 * @author Pontus Dahlkvist
 * @date 04/01 -25
 */

package decorator;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * -------------------------- ValidatedTextField -------------------------
 */
public class ValidatedTextField  extends JPanel {
    private JTextField textField;
    private Validator validator;
    private JLabel icon;
    private boolean valid;

    /**
     * Constructor.
     * @param validator
     */
    public ValidatedTextField(Validator validator) {
        this.validator = validator;

        setLayout(new FlowLayout(FlowLayout.LEFT));

        textField = new JTextField(20);
        icon = new JLabel();

        icon.setText("❌");
        add(textField);
        add(icon);

        textField.getDocument().addDocumentListener((new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validate();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validate();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validate();
            }
        }));
    }

    /**
     * Checks if the text in the text field is
     * valid for the validator. Sets the icon to
     * a checkmark if valid and a cross if not.
     */
    public void validate() {
        if(validator.isValid(textField.getText())) {
            icon.setText("✅");
            valid = true;
        } else {
            icon.setText("❌");
            valid = false;
        }
    }

    /**
     * Will return its validators error message.
     *
     * @return The message.
     */
    public String getError() {
        return validator.getMessage();
    }

    /**
     * Will return if this text field is valid or not.
     *
     * @return True if valid, false if not.
     */
    public boolean isValid() {
        return valid;
    }
}
