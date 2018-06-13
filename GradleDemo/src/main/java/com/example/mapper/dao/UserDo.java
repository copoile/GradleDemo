package com.example.mapper.dao;

public class UserDo {
    private Long userId;

    private String userName;

    private String loginName;

    private String password;

    private String address;

    private String phone;

    private String email;

    private String questionPassword;

    private String answerPassword;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getQuestionPassword() {
        return questionPassword;
    }

    public void setQuestionPassword(String questionPassword) {
        this.questionPassword = questionPassword == null ? null : questionPassword.trim();
    }

    public String getAnswerPassword() {
        return answerPassword;
    }

    public void setAnswerPassword(String answerPassword) {
        this.answerPassword = answerPassword == null ? null : answerPassword.trim();
    }
}