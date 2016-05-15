package hu.danco.quiz;

import java.util.Objects;

/**
 * Egy kérdést, és a kérdéshez tartozó válaszokat reprezentáló osztály.
 */

public class Question {
    private String theme;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String correct;


/**
 * Konstruktor egy Question objektum létrehozására.
 * 
 * @param theme     a kérdés témája.
 * @param question  a kérdés
 * @param answerA   a kérdéshez tartozó A válasz
 * @param answerB   a kérdéshez tartozó B válasz
 * @param answerC   a kérdéshez tartozó C válasz
 * @param answerD   a kérdéshez tartozó D válasz
 * @param correct   a kérdéshez tartozó helyes válasz
 */    
    
    
    public Question(String theme, String question, String answerA, String answerB, String answerC, String answerD, String correct) {
        this.theme = theme;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correct = correct;
    }

    /**
     * Visszaadja a kérdés témájáz.
     * 
     * @return a kérdés témája 
     */
    
    public String getTheme() {
        return theme;
    }

    /**
     * Visszaadja a kérdést.
     * 
     * @return a kérdés
     */
    
    public String getQuestion() {
        return question;
    }

    /**
     * Visszaadja a kérdéshez tartozó A választ.
     * 
     * @return A válasz
     */
    
    public String getAnswerA() {
        return answerA;
    }
    
    /**
     * Visszaadja a kérdéshez tartozó B választ.
     * 
     * @return B válasz 
     */
    
    public String getAnswerB() {
        return answerB;
    }
    
    /**
     * Visszaadja a kérdéshez tartozó C választ.
     * 
     * @return C válasz 
     */
    
    public String getAnswerC() {
        return answerC;
    }
    
    /**
     * Visszaadja a kérdéshez tartozó D választ.
     * 
     * @return D válasz 
     */
    
    public String getAnswerD() {
        return answerD;
    }
    
    /**
     * Visszaadja a kérdéshez tartozó helyes választ.
     * 
     * @return helyes válasz 
     */
    
    public String getCorrect() {
        return correct;
    }

    /**
     * Beállítja kérdés a témát.
     * 
     * @param theme a téma
     */
    
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * Beállítja kérdést.
     * 
     * @param question a kérdés 
     */
    
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Beállítja a kérdéshez tartozó A választ.
     * 
     * @param answerA az A válasz 
     */
    
    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    /**
     * Beállítja a kérdéshez tartozó B választ.
     * 
     * @param answerB a B válasz 
     */
   
    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    /**
     * Beállítja a kérdéshez tartozó C választ.
     * 
     * @param answerC a C válasz 
     */
   
    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    /**
     * Beállítja a kérdéshez tartozó D választ.
     * 
     * @param answerD a D válasz 
     */
   
    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    /**
     * Beállítja a kérdéshez tartozó helyes választ.
     * 
     * @param correct a helyes válasz 
     */
   
    public void setCorrect(String correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return "Questions{" + "theme=" + theme + ", question=" + question + ", answerA=" + answerA + ", answerB=" + answerB + ", answerC=" + answerC + ", answerD=" + answerD + ", correct=" + correct + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.theme);
        hash = 89 * hash + Objects.hashCode(this.question);
        hash = 89 * hash + Objects.hashCode(this.answerA);
        hash = 89 * hash + Objects.hashCode(this.answerB);
        hash = 89 * hash + Objects.hashCode(this.answerC);
        hash = 89 * hash + Objects.hashCode(this.answerD);
        hash = 89 * hash + Objects.hashCode(this.correct);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        if (!Objects.equals(this.theme, other.theme)) {
            return false;
        }
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        if (!Objects.equals(this.answerA, other.answerA)) {
            return false;
        }
        if (!Objects.equals(this.answerB, other.answerB)) {
            return false;
        }
        if (!Objects.equals(this.answerC, other.answerC)) {
            return false;
        }
        if (!Objects.equals(this.answerD, other.answerD)) {
            return false;
        }
        if (!Objects.equals(this.correct, other.correct)) {
            return false;
        }
        return true;
    }
}
