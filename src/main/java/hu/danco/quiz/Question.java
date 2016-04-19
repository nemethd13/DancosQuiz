package hu.danco.quiz;

public class Question {
    private String theme;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String correct;

    public Question(String theme, String question, String answerA, String answerB, String answerC, String answerD, String correct) {
        this.theme = theme;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correct = correct;
    }

    public String getTheme() {
        return theme;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public String getCorrect() {
        return correct;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return "Questions{" + "theme=" + theme + ", question=" + question + ", answerA=" + answerA + ", answerB=" + answerB + ", answerC=" + answerC + ", answerD=" + answerD + ", correct=" + correct + '}';
    }
}
