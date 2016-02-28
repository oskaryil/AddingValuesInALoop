package com.gdm.application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Daniel Andreas Finsrud
 */
public class MainController implements Initializable {
    @FXML
    private TextField txtInput;
    @FXML
    private Button btnAddUp;
    @FXML
    private Label lblResult;

    private Main application; // Not used in this sample, but included it anyway.
    private int result = 0;

    public void setApplication(Main application) {
        this.application = application;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtInput.setOnAction(event -> btnAddUp.fire()); // simulates that btnAddUp was clicked and run its code when Enter is pressed when textfield is the focus

        btnAddUp.setOnAction(event -> {
            /**
             *  if text is not empty and text contains the numbers between 0 - 9
             *  if text only contains - or + (minus or pluss sign) then do nothing
             */
            if (!txtInput.getText().isEmpty() && txtInput.getText().matches("[0-9\\-\\+]+") && !txtInput.getText().matches("\\-") && !txtInput.getText().matches("\\+")) {
                result += Integer.parseInt(txtInput.getText()); // Stores the input to a integer variable
                if (Integer.parseInt(txtInput.getText()) == 0) { // if the input is 0 stop adding - disables the textfield to stop the inputs
                    lblResult.setText("The total is " + result); // Display the finished total result
                    txtInput.setEditable(false); // disables the textfield
                } else {
                    lblResult.setText("The total so far is " + result); // Displays the current total result
                }
                txtInput.setText("");
            }
        });
    }
}
