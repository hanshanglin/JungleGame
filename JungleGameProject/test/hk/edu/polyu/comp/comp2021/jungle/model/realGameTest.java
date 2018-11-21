package hk.edu.polyu.comp.comp2021.jungle.model;


import hk.edu.polyu.comp.comp2021.jungle.controller.Controller;
import hk.edu.polyu.comp.comp2021.jungle.view.UIController;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;


public class realGameTest {
    @org.junit.Before
    public void setUp() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream(("standalone\n" +
                "new\n" +
                "leo\n" +
                "hans\n" +
                "move c3 d3\n" +
                "move a7 a6\n" +
                "move d3 d4\n" +
                "move a6 b6\n" +
                "move d4 d5\n" +
                "move b6 b5\n" +
                "move d5 d6\n" +
                "move b5 b4\n" +
                "move d6 d7\n" +
                "move b4 b3\n" +
                "move d7 d8\n" +
                "move b3 a3\n" +
                "move d8 d9\n\n").getBytes());
        System.setIn(in);
    }

    @Ignore
    @Test//(timeout = 100)
    public void testController(){
        Controller controller = new Controller();
        UIController.instance.setCurrentController(controller);
        controller.gameSetUp();
    }


}