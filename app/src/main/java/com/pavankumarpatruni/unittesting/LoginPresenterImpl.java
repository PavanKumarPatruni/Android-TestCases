package com.pavankumarpatruni.unittesting;

class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;

    LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }


    @Override
    public void validateLogin() {
        String email = loginView.getEmail();
        String password = loginView.getPassword();

        if (email.isEmpty()) {
            loginView.showEmailError(R.string.INVALID_EMAIL);
            return;
        }

        if (password.isEmpty()) {
            loginView.showPasswordError(R.string.INVALID_PASSWORD);
            return;
        }

        boolean loginFlag = email.equals("pavanpathro@gmail.com") && password.equals("pavanpathro");

        if (!loginFlag) {
            loginView.showPasswordError(R.string.INVALID_EMAIL_OR_PASSWORD);
            return;
        }

        loginView.launchHome();

    }
}
