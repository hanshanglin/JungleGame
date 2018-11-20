package hk.edu.polyu.comp.comp2021.jungle;

import hk.edu.polyu.comp.comp2021.jungle.model.Controller;

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
        controller.gameSetUp();
    }
}
