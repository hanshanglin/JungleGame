package hk.edu.polyu.comp.comp2021.jungle.model;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class PlayerTest {
    @Test
    public void testPlayer(){
        Player p0 = new Player(0);
        Player p1 = new Player(1);
        p0.setName("hans");
        p1.setName("leo");
        assertSame("hans",p0.getName());
        assertSame("leo",p1.getName());
        assertSame(0,p0.getPlayerID());
        assertSame(1,p1.getPlayerID());



    }
}
