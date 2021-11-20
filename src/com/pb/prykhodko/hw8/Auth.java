package com.pb.prykhodko.hw8;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Auth {
    String login;
    String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    void  signUp (String str1, String str2, String confirmPassword) throws WrongLoginException,WrongPasswordException{
        if (str1.matches("^[a-zA-Z0-9]{2,19}$"))  {
            setLogin(str1);
        }else {
            throw new WrongLoginException("Введенный логин не соответствует условиям");
        }
        if (str2.matches("^[a-zA-Z0-9_]{5,}$")) {
            setPassword(str2);
        }else {
            throw new WrongPasswordException("Введенный пароль не соответствует условиям");
        }
        if (str2.equals(confirmPassword)){
            System.out.println("Регистрация прошла успешно");
        }else System.out.println("Пароли не совпадают!");


    }

    void signIn (String login, String password) throws WrongPasswordException, WrongLoginException{
        if (login.equals(getLogin())){
            if (password.equals(getPassword())){
                System.out.println("Вы вошли на сервис успешно");
            }else {
                throw new WrongPasswordException("Введенный логин или пароль неверный, или такого пользователя не существует");
            }
        }else {
            throw new WrongLoginException("Введенный логин или пароль неверный, или такого пользователя не существует");
        }

    }

}
