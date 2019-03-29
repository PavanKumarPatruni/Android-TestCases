package com.pavankumarpatruni.unittesting;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterImplTest {

    @Mock
    private LoginView loginView;

    private LoginPresenterImpl loginPresenterImpl;

    @Before
    public void setUp() throws Exception {
        loginPresenterImpl = new LoginPresenterImpl(loginView);
    }

    @Test
    public void showErrorOnInvalidEmail() throws Exception {
        when(loginView.getEmail()).thenReturn("");
        loginPresenterImpl.validateLogin();

        verify(loginView).showEmailError(R.string.INVALID_EMAIL);
    }

    @Test
    public void showErrorOnInvalidPassword() throws Exception {
        when(loginView.getEmail()).thenReturn("pavanpathro@gmail.com");
        when(loginView.getPassword()).thenReturn("");
        loginPresenterImpl.validateLogin();

        verify(loginView).showPasswordError(R.string.INVALID_PASSWORD);
    }

    @Test
    public void showErrorOnLoginFailed() throws Exception {
        when(loginView.getEmail()).thenReturn("pavanpathro@gmail.com");
        when(loginView.getPassword()).thenReturn("pavan");
        loginPresenterImpl.validateLogin();

        verify(loginView).showPasswordError(R.string.INVALID_EMAIL_OR_PASSWORD);
    }

    @Test
    public void launchHomeOnLoginSuccess() throws Exception {
        when(loginView.getEmail()).thenReturn("pavanpathro@gmail.com");
        when(loginView.getPassword()).thenReturn("pavanpathro");
        loginPresenterImpl.validateLogin();

        verify(loginView).launchHome();
    }
}