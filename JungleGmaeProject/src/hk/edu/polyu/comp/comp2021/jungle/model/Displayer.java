package hk.edu.polyu.comp.comp2021.jungle.model;

public class Displayer {
    private JungleGame game;

    public Displayer(JungleGame game){
        this.game = game;
    }

    public void boardDisplay(){
        int[][] cb = game.getCb().getBoard();
        Piece[][] pb  = game.getCb().getPieceBoard();
        System.out.print("\n");
        for (int i = 8; i >=0; i--) {
            System.out.print(i+1);
            System.out.print(": ");
            for (int j = 0; j < 7; j++) {
                if(pb[i][j]==null){
                    System.out.print(cb[i][j]);
                    System.out.print("\t");
                }
                else{
                    if(pb[i][j].getOwner() == 0){
                        System.out.print((char)('A'+pb[i][j].getRank()-1));
                        System.out.print("\t");
                    }
                    else{
                        System.out.print((char)('a'+pb[i][j].getRank()-1));
                        System.out.print("\t");
                    }
                }
            }
            System.out.print("\n");
        }
        System.out.print("   ");
        for (int i = 0 ;i<7;i++){
            System.out.print((char)('A'+i));
            System.out.print("\t");
        }
        System.out.println();
    }

    public void winnerDisplay(){
        System.out.print("the WINNER is :");
        System.out.print(game.getWinner().getName());
    }

    /**
     * @param msg the msg to print
     */
    public static void messageDisplay(String msg){
        System.out.print(msg);
    }

    public void turnMsgDisplay(){
        System.out.print("Now is "+ (game.getCurrentTurn() == 0?game.getPlayer(0).getName():game.getPlayer(1).getName())+ "'s turn:\n");

    }
}
