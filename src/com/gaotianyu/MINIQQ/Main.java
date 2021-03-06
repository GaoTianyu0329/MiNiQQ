package com.gaotianyu.MINIQQ;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Label signup;
    private Label forgetPwd;
    private TextField userid;
    private PasswordField pwd;
    private Button login;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = new FXMLLoader().load(getClass().getResource("View/login.fxml"));
            initView(root);
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.setMaxHeight(400);
            primaryStage.setMaxWidth(600);
            primaryStage.setMinHeight(400);
            primaryStage.setMaxWidth(600);
            primaryStage.show();


        }catch (IOException e){
            e.printStackTrace();
        }

    }
    private void initView(Parent root){
        userid = (TextField) root.lookup("#userid");
        pwd = (PasswordField) root.lookup("#pwd");
        login = (Button)root.lookup("#login");
    }
    //验证登录
    public void whenLogin(String userid,String pwd){

    }
    public void whenSignUp(String userid,String pwd,String nickName,String sex){

    }

}
