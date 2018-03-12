package com.gaotianyu.MINIQQ.Controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;



public class LogInController {
    @FXML
    private Label signup;
    @FXML
    private Label forgetPwd;
    @FXML
    private TextField userid;
    @FXML
    private PasswordField pwd;
    @FXML
    private Button login;
    @FXML
    public void onLoginClick(javafx.event.ActionEvent event){
        //登录点击响应
        Stage secondWindow=new Stage();
        secondWindow.setTitle("1Window");
        secondWindow.show();
    }
    @FXML
    public void onSignUpClick(MouseEvent event){
        //注册点击相应
        Stage secondWindow=new Stage();
        secondWindow.setTitle("secondWindow");
        secondWindow.show();
    }
    @FXML
    public void onForgetClick(MouseEvent event){
        //忘记密码点击相应
        Stage secondWindow=new Stage();
        secondWindow.setTitle("3Window");
        secondWindow.show();
    }


}
