package hk.edu.polyu.comp.comp2021.jungle.model;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class RatTest {
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

        pb[2][1] = new Rat(0);
        pb[2][1].setPos(1,2);

        pb[5][1] = new Rat(0);
        pb[5][1].setPos(1,5);

        pb[5][0] = new Rat(1);
        pb[5][0].setPos(0,5);

        pb[4][1] = new Rat(1);
        pb[4][1].setPos(1,4);

        pb[6][1] = new Cat(0);
        pb[6][1].setPos(1,6);

        pb[2][0] = new Elephant(1);
        pb[2][0].setPos(0,2);

        pb[0][2] = new Cat(1);
        pb[0][2].setPos(2,0);

        pb[0][1] = new Rat(0);
        pb[0][1].setPos(1,0);


    }

    @Test
    public void testRat1()throws Exception{
        try{
            assertTrue(pb[2][1].checkMove(1,3,map,pb));
        }
        catch (Exception e){throw e;}
    }

    @Test(expected = Exception.class)
    public void testRat2()throws Exception{
        try{
            assertFalse(pb[5][1].checkMove(1,6,map,pb));
        }
        catch (Exception e){throw e;}
    }
    @Test(expected = Exception.class)
    public void testRat3()throws Exception{
        try{
            pb[5][1].checkMove(0,5,map,pb);
        }
        catch (Exception e){throw e;}
    }
    @Test(expected = Exception.class)
    public void testRat4()throws Exception{
        try{
            assertTrue(pb[5][1].checkMove(0,5,map,pb));
        }
        catch (Exception e){throw e;}
    }
    @Test(expected = Exception.class)
    public void testRat5()throws Exception{
        try{
            assertTrue(pb[5][1].checkMove(0,5,map,pb));
        }
        catch (Exception e){throw e;}
    }

    @Test
    public void testRat6()throws Exception{
        try{
            assertTrue(pb[0][1].checkMove(2,0,map,pb));
        }
        catch (Exception e){throw e;}
    }
    @Test
    public void testRat7()throws Exception{
        try{
            assertTrue(pb[2][1].checkMove(0,2,map,pb));
            assertTrue(pb[5][1].checkMove(1,4,map,pb));
        }
        catch (Exception e){throw e;}
    }
    @Test
    public void testRat8()throws Exception{
        try{
            assertTrue(pb[5][1].checkMove(1,4,map,pb));
        }
        catch (Exception e){throw e;}
    }

}