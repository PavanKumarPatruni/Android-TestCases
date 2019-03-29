package com.pavankumarpatruni.unittesting;

public interface LoginView {

    void onLoginClicked();

    String getEmail();

    String getPassword();

    void showEmailError(int messageId);

    void showPasswordError(int messageId);

    void launchHome();
}
