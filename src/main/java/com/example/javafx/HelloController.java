package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField number1;
    @FXML
    private TextField number2;


    //@FXML
    //protected void onClick() { System.out.println(passwordField.getText());System.out.println(userNameField.getText());}
    @FXML
    protected void add(){
        System.out.println(Double.parseDouble(number1.getText())+Double.parseDouble(number2.getText()));
    }
    @FXML
    protected void subtract(){
        System.out.println(Double.parseDouble(number1.getText())-Double.parseDouble(number2.getText()));
    }
    @FXML
    protected void multiply(){
        System.out.println(Double.parseDouble(number1.getText())*Double.parseDouble(number2.getText()));
    }
    @FXML
    protected void divide(){
        System.out.println(Double.parseDouble(number1.getText())/Double.parseDouble(number2.getText()));
    }
}