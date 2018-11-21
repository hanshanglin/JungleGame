package hk.edu.polyu.comp.comp2021.jungle.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ElephantTest {
    Piece[][] pb;
    int[][] map;
    /**
     *                 {0,      0,      -1,     -2,     -1,     0,      0},
     *                 {0,      0,      0,      -1,     0,      0,      0},
     *                 {0,      0,      0,      0,      0,      0,      0},
     *                 {0,      -10,    -10,    0,      -10,    -10,    0},
     *                 {0,      -10,    -10,    0,      -10,    -10,    0},
     *                 {0,      -10,    -10,    0,      -10,    -10,    0},
     *                 {0,      0,      0,      0,      0,      0,      0},
     *                 {0,      0,      0,      -1,     0,      0,      0},
     *                 {0,      0,      -1,     -2,     -1,     0,      0},
     * @throws Exception
     */
    @org.junit.Before
    public void setUp() throws Exception {
        CheckerBoard cb = new CheckerBoard();
        cb.newBoard();
        cb.newPieceBoard();
        this.pb = cb.getPieceBoard();
        this.map = cb.getBoard();

        pb[0][1] = new Elephant(0);
        pb[0][1].setPos(1,0);

        pb[0][2] = new Rat(1);
        pb[0][2].setPos(2,0);

        pb[0][0] = new Elephant(1);
        pb[0][0].setPos(0,0);

        pb[1][1] = new Rat(1);
        pb[1][1].setPos(0,0);
    }

    @Test
    public void testElephant1()throws Exception{
        try {
            assertTrue(pb[0][1].checkMove(0,0,map,pb));
        }
        catch (Exception e){throw e;}
    }

    @Test
    public void testElephant2()throws Exception{
        try {
            assertFalse(pb[0][1].checkMove(1,1,map,pb));
        }
        catch (Exception e){throw e;}
    }

    @Test
    public void testElephant3()throws Exception{
        try {
            assertTrue(pb[0][1].checkMove(2,0,map,pb));
        }
        catch (Exception e){throw e;}
    }
}
