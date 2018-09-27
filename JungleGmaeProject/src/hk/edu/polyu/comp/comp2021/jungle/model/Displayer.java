package hk.edu.polyu.comp.comp2021.jungle.model;

public class Displayer {
    private JungleGame game;

    public Displayer(JungleGame game){
        this.game = game;

    }

    public void boardDisplay(){
        System.out.print(game.getCb().getBoard());
        System.out.print(game.getCb().getPieceBoard());
    }
    public void winnerDisplay(){

    }
    public static void messageDisplay(String msg){
        /**print message*/
    }
}
