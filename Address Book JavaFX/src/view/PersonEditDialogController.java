package view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Person;
import util.DateUtil;

/**
 * Created by Luca on 21/06/16.
 */
public class PersonEditDialogController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField postalCodeField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField birthdayField;


    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     *
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;

        this.firstNameField.setText(person.getFirstName());
        this.lastNameField.setText(person.getLastName());
        this.streetField.setText(person.getStreet());
        this.postalCodeField.setText(Integer.toString(person.getPostalCode()));
        this.cityField.setText(person.getCity());
        this.birthdayField.setText(DateUtil.format(person.getBirthday()));
        this.birthdayField.setPromptText("dd.mm.yyyy");
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return this.okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            this.person.setFirstName(this.firstNameField.getText());
            this.person.setLastName(this.lastNameField.getText());
            this.person.setStreet(this.streetField.getText());
            this.person.setPostalCode(Integer.parseInt(this.postalCodeField.getText()));
            this.person.setCity(this.cityField.getText());
            this.person.setBirthday(DateUtil.parse(this.birthdayField.getText()));

            this.okClicked = true;
            this.dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        this.dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (this.firstNameField.getText() == null || this.firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (this.lastNameField.getText() == null || this.lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (this.streetField.getText() == null || this.streetField.getText().length() == 0) {
            errorMessage += "No valid street!\n";
        }

        if (this.postalCodeField.getText() == null || this.postalCodeField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n";
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(this.postalCodeField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n";
            }
        }

        if (this.cityField.getText() == null || this.cityField.getText().length() == 0) {
            errorMessage += "No valid city!\n";
        }

        if (this.birthdayField.getText() == null || this.birthdayField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        } else {
            if (!DateUtil.validDate(this.birthdayField.getText())) {
                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(this.dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();

            return false;
        }
    }
}
