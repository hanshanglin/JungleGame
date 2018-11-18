package hk.edu.polyu.comp.comp2021.jungle.model;


public class CheckerBoard {
    private int[][] board;
    private Piece[][] pieceBoard;
    private int X;
    private int Y;

    public  CheckerBoard(){
    }

    public int[][] getBoard() {
        return board;
    }

    public Piece[][] getPieceBoard() {
        return pieceBoard;
    }

    public boolean movePiece(int x1, int y1, int x2, int y2)throws Exception{

        /**if can't move return false/
         * if can move, do move and return true
         */
        try {
            pieceBoard[y1][x1].checkMove(x2,y2,board,pieceBoard);
            pieceBoard[y2][x2] = pieceBoard[y1][x1];
            pieceBoard[y1][x1] = null;
            pieceBoard[y2][x2].setPos(x2,y2);
        }
        catch (Exception e) {throw e;}
        return true;
    }

    public void newBoard(){
        this.board = new int[][]{
                {0,0,-1,-2,-1,0,0},
                {0,0,0,-1,0,0,0},
                {0,0,0,0,0,0,0},
                {0,-10,-10,0,-10,-10,0},
                {0,-10,-10,0,-10,-10,0},
                {0,-10,-10,0,-10,-10,0},
                {0,0,0,0,0,0,0},
                {0,0,0,-1,0,0,0},
                {0,0,-1,-2,-1,0,0}
        };
    }


    public void newPieceBoard(){
        /**set original PieceBoard
         * */
        /**
         * 8 Elephant
         * 7 Lion
         * 6 Tiger
         * 5 Leopard
         * 4 Wolf
         * 3 Dog
         * 2 Cat
         * 1 Rat */
        pieceBoard = new Piece[9][7];
        Rat p1 = new Rat(0);
        Rat p2 = new Rat(1);
        Cat p3 = new Cat(0);
        Cat p4 = new Cat(1);
        Dog p5 = new Dog(0);
        Dog p6 = new Dog(1);
        Wolf p7 = new Wolf(0);
        Wolf p8 = new Wolf(1);
        Leopard p9 = new Leopard(0);
        Leopard p10 =new Leopard(1);
        Tiger p11 = new Tiger(0);
        Tiger p12 = new Tiger(1);
        Lion p13 =  new Lion(0);
        Lion p14 = new Lion(1);
        Elephant p15 = new Elephant(0);
        Elephant p16 = new Elephant(1);

        pieceBoard[p1.getY()] [p1.getX()] =  p1;
        pieceBoard[p2.getY()] [p2.getX()] =  p2;
        pieceBoard[p3.getY()] [p3.getX()] =  p3;
        pieceBoard[p4.getY()] [p4.getX()] =  p4;
        pieceBoard[p5.getY()] [p5.getX()] =  p5;
        pieceBoard[p6.getY()] [p6.getX()] =  p6;
        pieceBoard[p7.getY()] [p7.getX()] =  p7;
        pieceBoard[p8.getY()] [p8.getX()] =  p8;
        pieceBoard[p9.getY()] [p9.getX()] =  p9;
        pieceBoard[p10.getY()][p10.getX()] = p10;
        pieceBoard[p11.getY()][p11.getX()] = p11;
        pieceBoard[p12.getY()][p12.getX()] = p12;
        pieceBoard[p13.getY()][p13.getX()] = p13;
        pieceBoard[p14.getY()][p14.getX()] = p14;
        pieceBoard[p15.getY()][p15.getX()] = p15;
        pieceBoard[p16.getY()][p16.getX()] = p16;
    }

    public Piece[][] loadPieceBoard(){
        pieceBoard = new Piece[9][7];
        return pieceBoard;
    }

    public Piece getPiece(int x1, int y1){
        return pieceBoard[y1][x1];
    }

}
