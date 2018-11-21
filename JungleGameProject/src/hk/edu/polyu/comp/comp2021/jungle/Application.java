package hk.edu.polyu.comp.comp2021.jungle;

import hk.edu.polyu.comp.comp2021.jungle.controller.Controller;
import hk.edu.polyu.comp.comp2021.jungle.controller.HybridScanner;
import hk.edu.polyu.comp.comp2021.jungle.view.UIController;

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

        controller.gameSetUp();
        // start playing the game

    }
}
