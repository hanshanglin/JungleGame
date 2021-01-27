package hk.edu.polyu.comp.comp2021.jungle;

import hk.edu.polyu.comp.comp2021.jungle.model.Controller;
import hk.edu.polyu.comp.comp2021.jungle.model.HybridScanner;
import hk.edu.polyu.comp.comp2021.jungle.ui.UIController;

/**
 * start of the program
 */
public class Application {

    /**
     * new a controller and setup game
     * @param args no args need to input
     */
    public static void main(String[] args){
        Controller controller = new Controller();

        UIController.instance.setCurrentController(controller);

        //test code
        HybridScanner.instance.feed("standalone");
        HybridScanner.instance.feed("new");
        HybridScanner.instance.feed("Andrew Blah");
        HybridScanner.instance.feed("Blah Andrew");

        controller.gameSetUp();
        // start playing the game

    }
}
