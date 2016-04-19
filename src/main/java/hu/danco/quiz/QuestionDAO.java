package hu.danco.quiz;

import java.util.List;

public interface QuestionDAO {
    public List<Question> readQuestions();

    public List<Question> readQuestions(String theme);
}
