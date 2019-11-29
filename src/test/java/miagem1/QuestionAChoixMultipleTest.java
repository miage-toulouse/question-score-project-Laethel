package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple question;

    @Before
    public void setUp() throws Exception {
        question = new QuestionAChoixMultiple("un énoncé", new ArrayList<Integer>(Arrays.asList(2,4)));
    }

    @Test
    public void testGetEnonce() {
        // when : on demande l'énoncé de la question
        String resEnonce = question.getEnonce();
        //then : l'énoncé retourné est l'énoncé fourni à la construction de la question
        assertEquals("un énoncé",resEnonce);
    }

    @Test
    public void testGetScoreForIndiceBonneReponse() {
        int indiceEtudiant = 2;
        // and : on demande le score de l'indice à la question
        float resScore = question.getScoreForIndice(indiceEtudiant);
        // then : le score obtenu est 100
        assertEquals(50f, resScore, 0.01f);
    }

    @Test
    public void testGetScoreForIndiceMauvaiseReponse() {
        // when : quand l'étudiant fournit l'indice de la mauvaise réponse
        int indiceEtudiant = 3;
        // and : on demande le score de l'indice à la question
        float resScore = question.getScoreForIndice(indiceEtudiant);
        // then : le score obtenu est 100
        assertEquals(0f, resScore, 0.01f);
    }

}