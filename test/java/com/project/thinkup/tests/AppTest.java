package com.project.thinkup.tests;

import com.project.thinkup.model.Status;
import com.project.thinkup.model.User;
import com.project.thinkup.model.Idea;
import com.project.thinkup.model.KeyWord;
import com.project.thinkup.model.Like;
import com.project.thinkup.model.Topic;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

    public AppTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        Assert.assertTrue( true );
    }

    @Test
    public void createNewUser() {
        // Arrange
        String firstName = "andres";
        String lastName = "oñate";
        String mail = "andrescamiloquimbayo@gmail.com";
        String password = "123";
        String status = "activo";
        String role = "user";
        String area = "estudiante";

        // Act
        User user = new User(firstName, lastName, mail, password, status, role, area);

        // Assert
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(mail, user.getMail());
        assertEquals(password, user.getPassword());
        assertEquals(status, user.getStatus());
        assertEquals(role, user.getRole());
        assertEquals(area, user.getArea());
    }

    @Test
    public void createNewIdea() {
        // Arrange
        String title = "Test Idea";
        String description = "This is a test idea";
        List<KeyWord> keywords = new ArrayList<>();

        // Act
        Idea idea = new Idea(title, description, keywords);

        // Assert
        assertEquals(title, idea.getTitle());
        assertNotNull(idea.getCreationDate());
        assertEquals(Status.created, idea.getStatus());
        assertEquals(description, idea.getDescription());
        assertEquals(keywords, idea.getKeyWords());
        assertNotNull(idea.getAmountOfLikes());
        assertEquals(0, idea.getAmountOfLikes());
    }

}
