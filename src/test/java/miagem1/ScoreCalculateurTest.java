package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

    QuestionAChoixMultiple questionAChoixMultiple;
    ScoreCalculateur sc = new ScoreCalculateur();

    @Before
    public void setUp() throws Exception {
        questionAChoixMultiple = new QuestionAChoixMultiple("q1", new ArrayList<Integer>(Arrays.asList(2, 3, 5)));
    }

    @Test
    public void calculeScoreAllRepOk() {
        ArrayList repEtu = new ArrayList<Integer>(Arrays.asList(2, 3, 5));
        float score = sc.calculeScore(repEtu,questionAChoixMultiple);
        assertEquals(100f, score, 0.01f);
    }

    @Test
    public void calculeScoreSomeRepOk() {
        ArrayList repEtu = new ArrayList<Integer>(Arrays.asList(2, 3));
        float score = sc.calculeScore(repEtu, questionAChoixMultiple);
        assertEquals(2*100/3f, score, 0.01f);
    }

    @Test
    public void calculeScoreNoRepOk() {
        ArrayList repEtu = new ArrayList<Integer>(Arrays.asList(1,4));
        float score = sc.calculeScore(repEtu, questionAChoixMultiple);
        assertEquals(0f, score, 0.01f);
    }
}