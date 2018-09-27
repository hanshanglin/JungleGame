package hk.edu.polyu.comp.comp2021.jungle.model;


public class JungleGame {
    private CheckerBoard cb;
    private int currentTurn;
    private Player p0;
    private Player p1;
    // 0 for user 0, 1 for user 1

    public JungleGame(){
        currentTurn=0;
        this.p0 = new Player(0);
        this.p1 = new Player(1);
    }

    public void newGame(){

    }

    public void openGame(){

    }

    public boolean move(int x1,int y1,int x2, int y2){
        return false;
    }

    public CheckerBoard getCb(){
        return cb;
    }

    public int getCurrentTurn(){
        return currentTurn;
    }

    public Player getPlayer(int id){
        if (id==0) return p0;
        else return p1;
    }

    public boolean saveGame(String path){
        return false;
    }





}
