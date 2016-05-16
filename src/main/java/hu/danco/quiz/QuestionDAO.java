package hu.danco.quiz;

import java.util.List;

/**
 * A kérdéseket és válaszokat tartalmazó adatbázist
 * feldolgozó interfész.
 * 
 */

public interface QuestionDAO {
    
    /**
     * {@inheritDoc}
     * 
     * Visszaadja a kérdéseket és a hozzájúk tartozó
     * adatokat egy listában .
     * 
     * @return egy {@code Question} objektumokat tartalmazó lista
     */
    
    public List<Question> readQuestions();

    /**
     * Viszadja a paraméterként megkapott témájú
     * kérdéseket és a hozzájuk tartozó adatokat
     * egy listában.
     * 
     * @param theme a beolvasni kívánt kérdések témája
     * 
     * @return egy {@code Question} objektumokat tartalmazó lista
     */
    
    public List<Question> readQuestions(String theme);
}
