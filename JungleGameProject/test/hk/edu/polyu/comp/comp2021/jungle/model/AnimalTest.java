package hk.edu.polyu.comp.comp2021.jungle.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnimalTest {
    Piece[][] pb;
    int[][] map;

    /**
     * {0,      0,      -1,     -2,     -1,     0,      0},
     * {0,      0,      0,      -1,     0,      0,      0},
     * {0,      0,      0,      0,      0,      0,      0},
     * {0,      -10,    -10,    0,      -10,    -10,    0},
     * {0,      -10,    -10,    0,      -10,    -10,    0},
     * {0,      -10,    -10,    0,      -10,    -10,    0},
     * {0,      0,      0,      0,      0,      0,      0},
     * {0,      0,      0,      -1,     0,      0,      0},
     * {0,      0,      -1,     -2,     -1,     0,      0},
     *
     * @throws Exception
     */
    @org.junit.Before
    public void setUp() throws Exception {
        CheckerBoard cb = new CheckerBoard();
        cb.newBoard();
        cb.newPieceBoard();
        this.pb = cb.getPieceBoard();
        this.map = cb.getBoard();

        pb[0][2] = new Elephant(1);
        pb[0][2].setPos(2,0);

        pb[1][0] = new Dog(0);
        pb[1][0].setPos(0,1);

        pb[1][1] = new Leopard(1);
        pb[1][1].setPos(1,1);

        pb[1][2] = new Wolf(0);
        pb[1][2].setPos(2,1);

        pb[2][0] = new Dog(1);
        pb[2][0].setPos(0,2);

        pb[2][1] = new Leopard(0);
        pb[2][1].setPos(1,2);

        pb[2][2] = new Wolf(1);
        pb[2][2].setPos(2,2);
    }

    @Test
    public void test1()throws Exception{
        try {
            assertTrue(pb[1][0].checkMove(0,2,map,pb));
        }
        catch (Exception e){throw e;}
    }

    @Test
    public void test2()throws Exception{
        try {
            assertTrue(pb[2][1].checkMove(1,1,map,pb));
        }
        catch (Exception e){throw e;}
    }
    @Test
    public void test3()throws Exception{
        try {
            assertFalse(pb[1][0].checkMove(1,1,map,pb));
        }
        catch (Exception e){throw e;}
    }

    @Test
    public void test4()throws Exception{
        try {
            assertTrue(pb[1][2].checkMove(2,0,map,pb));
        }
        catch (Exception e){throw e;}
    }
}