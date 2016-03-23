package hu.danco.quiz;

import java.util.List;

/**
 * Created by Németh Dániel on 2016.03.23..
 */
public interface QuestionDAO {
    public List<Question> readQuestions();

    public List<Question> readQuestions(String theme);
}
