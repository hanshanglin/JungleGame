package hk.edu.polyu.comp.comp2021.jungle.model;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class PieceTest {
    Piece[][] pb;
    int[][] map;
    /**
     *                 {0,      0,      -1,     -2,     -1,     0,      0},
     *                 {0,      0,      0,      -1,     0,      0,      0},
     *                 {0,      Rat,      0,      0,      0,      0,      0},
     *                 {0,      -10,    -10,    0,      -10,    -10,    0},
     *                 {0,      -10,    -10,    0,      -10,    -10,    0},
     *                 {0,      Rat,    -10,    0,      -10,    -10,    0},
     *                 {0,      Cat,      0,      0,      0,      0,      0},
     *                 {0,      0,      0,      -1,     0,      0,      0},
     *                 {0,      0,      -1,     -2,     -1,     0,      0},
     * @throws Exception
     */
    @org.junit.Before
    public void setUp() throws Exception {
        CheckerBoard cb = new CheckerBoard();
        cb.newBoard();
        cb.loadPieceBoard();
        this.pb = cb.getPieceBoard();
        this.map = cb.getBoard();
        pb[2][1] = new Rat(0);
        pb[2][1].setPos(1,2);

        pb[5][1] = new Rat(0);
        pb[5][1].setPos(1,5);

        pb[6][1] = new Cat(0);
        pb[6][1].setPos(1,6);

    }

    @Test
    public void testRatRule(){
        try{
            assertTrue(pb[2][1].checkMove(3,1,map,pb));
            assertTrue(pb[2][1].checkMove(2,0,map,pb));
            assertFalse(pb[5][1].checkMove(6,1,map,pb));
        }
        catch (Exception e){}
    }

}