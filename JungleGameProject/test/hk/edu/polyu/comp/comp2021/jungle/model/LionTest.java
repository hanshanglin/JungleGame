package hk.edu.polyu.comp.comp2021.jungle.model;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LionTest {
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

        pb[0][1] = new Lion(0);
        pb[0][1].setPos(1,0);

        pb[0][2] = new Elephant(1);
        pb[0][2].setPos(2,0);

        pb[0][0] = new Lion(1);
        pb[0][0].setPos(0,0);

        pb[1][1] = new Rat(1);
        pb[1][1].setPos(0,0);

        pb[3][0] = new Lion(0);
        pb[3][0].setPos(0,3);

        pb[2][1] = new Lion(0);
        pb[2][1].setPos(1,2);

        pb[4][3] = new Lion(0);
        pb[4][3].setPos(3,4);

        pb[6][2] = new Lion(0);
        pb[6][2].setPos(2,6);
    }

    @Test
    public void testLion1()throws Exception{
        try {
            assertTrue(pb[0][1].checkMove(0,0,map,pb));
        }
        catch (Exception e){throw e;}
    }

    @Test
    public void testLion2()throws Exception{
        try {
            assertTrue(pb[0][1].checkMove(1,1,map,pb));
        }
        catch (Exception e){throw e;}
    }

    @Test
    public void testLion3()throws Exception{
        try {
            assertTrue(pb[0][1].checkMove(2,0,map,pb));
        }
        catch (Exception e){throw e;}
    }

    @Test
    public void testLion4()throws Exception{
        try {
            assertTrue(pb[3][0].checkMove(3,3,map,pb));
        }
        catch (Exception e){throw e;}
    }

    @Test
    public void testLion5()throws Exception{
        try {
            assertTrue(pb[2][1].checkMove(1,6,map,pb));
        }
        catch (Exception e){throw e;}
    }

    @Test(expected = Exception.class)
    public void testLion6()throws Exception{
        try {
            pb[2][1].checkMove(1,7,map,pb);
        }
        catch (Exception e){throw e;}
    }

    @Test
    public void testLion7()throws Exception{
        try {
            assertTrue(pb[4][3].checkMove(0,4,map,pb));
        }
        catch (Exception e){throw e;}
    }

    @Test
    public void testLion8()throws Exception{
        try {
            assertTrue(pb[6][2].checkMove(2,2,map,pb));
        }
        catch (Exception e){throw e;}
    }

    @Test(expected = Exception.class)
    public void testLion9()throws Exception{
        try {
            pb[6][2].checkMove(4,2,map,pb);
        }
        catch (Exception e){throw e;}
    }
}
