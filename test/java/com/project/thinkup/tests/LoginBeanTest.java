package com.project.thinkup.tests;

import com.project.thinkup.beans.LoginBean;
import com.project.thinkup.model.User;
import com.project.thinkup.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class LoginBeanTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private LoginBean loginBean;

    private User user;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        user = new User("Santiago", "Arevalo", "santiago.arevalo@gmail.com", "123", "activo", "user",
                "estudiante");
        user.setUserId(10L);
        when(userService.getUserByEmail("santiago.arevalo@gmail.com")).thenReturn(user);
    }

    @Test
    public void checkIfLoginIsSuccess() {
        boolean loginResult = loginBean.login();
        assertTrue(loginResult);
    }

    @Test
    public void checkIfLoginIsFailed() {
        user.setMail("invalid.email@gmail.com");
        boolean loginResult = loginBean.login();
        assertFalse(loginResult);
    }

}
