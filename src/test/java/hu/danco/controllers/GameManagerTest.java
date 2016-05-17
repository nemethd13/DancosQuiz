/*
* Copyright 2016 danco
*/
package hu.danco.controllers;

import hu.danco.quiz.Question;
import hu.danco.quiz.User;
import javafx.collections.ObservableList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
*
* @author Németh Dániel
*/
public class GameManagerTest {

  private GameManager gameManager;

  public GameManagerTest() {}

    @Before
    public void setUp() {
      gameManager = new GameManager();
    }

    @Test
    public void testGetCurrentUserName() {
      String name = "Test";
      int point = 10;

      gameManager.setCurrentUser(name, point);

      assertEquals("A megadott játékos nevét kell visszaadnia.", name, gameManager.getCurrentUserName());
    }

    @Test
    public void testGetCurrentUser() {
      User expResult = new User("Test", 10);

      gameManager.setCurrentUser("Test", 10);

      assertEquals("A megadott User objektumot kell visszaadnia.", expResult, gameManager.getCurrentUser());
    }

    @Test
    public void testSetCurrentUser() {
      User expResult = new User("Test",10);

      gameManager.setCurrentUser("Test",10);

      assertEquals("A megadott User objektumot kell visszadnia.", expResult, gameManager.getCurrentUser());
    }



  }
