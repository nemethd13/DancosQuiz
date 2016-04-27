/*
 * Copyright 2016 danco
 */
package hu.danco.quiz;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Németh Dániel
 */
public class XmlQuestionDAOTest {

    @Test
    public void testReadQuestions() {
        XmlQuestionDAO instance = new XmlQuestionDAO("QuestionsTest.xml");
        
        Question q = new Question("Biológia", "Mit nem eszik a jegesmedve?", "hódot", "fókát", "bálnát", "halat", "hódot");
        
        List<Question> expResult = new ArrayList<>();
        
        expResult.add(q);
        
        List<Question> result = instance.readQuestions();
        
        assertEquals("Egy kérdést várunk, ami egyezik a létrehozottal.", expResult, result);
    }
    
}
