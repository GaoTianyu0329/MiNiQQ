package com.gaotianyu.MINIQQ.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class SignUpController {
    @FXML
    private TextField tf_userId;
    @FXML
    private TextField tf_pwd1;
    @FXML
    private TextField tf_pwd2;
    @FXML
    private TextField tf_nickName;
    @FXML
    private TextField tf_sex;
    @FXML
    private Button signUp;
    @FXML
    public void OnSignUp(ActionEvent actionEvent){
        String userId = tf_userId.getText();
        String pwd1 = tf_pwd1.getText();
        String pwd2 = tf_pwd2.getText();
        String nickName = tf_nickName.getText();
        String sex = tf_sex.getText();
        if (userId.equals(null)){
//            "用户名不能为空"
            return;
        }
        if (userId.length()>16||userId.length()<7){
//            "用户名长度应大于6且小于17"
            return;
        }
        if (pwd1.equals(null)){
//            "密码不能为空"
            return;
        }
        if (pwd1.length()>16||pwd1.length()<7){
//            "密码长度应大于6且小于17"
            return;
        }
        if (pwd2.equals(null)){
//            "请确认密码"
            return;
        }
        if(!pwd1.equals(pwd2)){
//            "两次输入密码不同"
            return;
        }
        if (nickName.equals(null)){
//            "昵称不能为空"
            return;
        }
        if (nickName.length()>16||nickName.length()<7){
//            "昵称长度应大于6且小于17"
            return;
        }
        if (sex.equals(null)){
//            "性别不能为空"
            return;
        }
        if (sex.equals("男")||sex.equals("女")){
        }else {
            //"性别输入错误"
            return;
        }
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        String serverIP = "127.0.0.1";
        //服务器注册端口
        int port = 0;
        String data = userId+"|"+pwd1+"|"+nickName+"|"+sex;
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





    }

}
