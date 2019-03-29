package com.pavankumarpatruni.unittesting;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    private EditText editTextEmail, editTextPassword;
    private Button buttonLogin;

    private LoginPresenterImpl loginPresenterImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUI();

        initPresenter();

    }

    private void initPresenter() {
        loginPresenterImpl = new LoginPresenterImpl(this);
    }

    private void initUI() {
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onLoginClicked();
    }

    @Override
    public void onLoginClicked() {
        loginPresenterImpl.validateLogin();
    }

    @Override
    public String getEmail() {
        return editTextEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return editTextPassword.getText().toString();
    }

    @Override
    public void showEmailError(int messageId) {
        editTextEmail.setError(getString(messageId));
    }

    @Override
    public void showPasswordError(int messageId) {
        editTextPassword.setError(getString(messageId));
    }

    @Override
    public void launchHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
