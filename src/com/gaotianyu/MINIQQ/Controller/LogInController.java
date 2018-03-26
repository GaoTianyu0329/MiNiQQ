package com.gaotianyu.MINIQQ.Controller;

import com.gaotianyu.MINIQQ.Main;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


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
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void onLoginClick(javafx.event.ActionEvent event){

        //登录点击响应
        String userId = userid.getText();
        String password = pwd.getText();
        if (userId.equals("")||password.equals("")){
            //用户名或密码不能为空
            return;
        }
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        String serverIP = "127.0.0.1";
        //服务器登录端口
        int port = 0;
        String data = userId+"|"+password;
        try{
            socket = new Socket(serverIP,port);
            os = socket.getOutputStream();
            os.write(data.getBytes("UTF-8"));
            is = socket.getInputStream();
            byte[] b = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = is.read(b)) != -1) {
                //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
                sb.append(new String(b, 0, len,"UTF-8"));
            }
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            try{
                is.close();
                os.close();
                socket.close();
            }catch (Exception e2){

            }
        }

//        main.whenLogin(userid.getText(),pwd.getText());
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
