package hk.edu.polyu.comp.comp2021.jungle;

import hk.edu.polyu.comp.comp2021.jungle.model.JungleGame;
import hk.edu.polyu.comp.comp2021.jungle.model.IOController;

public class Application {

    public static void main(String[] args){
        JungleGame game = new JungleGame();
        game.gameSetUp();
        // start playing the game
    }
}
