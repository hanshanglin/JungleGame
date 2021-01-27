package hk.edu.polyu.comp.comp2021.jungle.view;

import hk.edu.polyu.comp.comp2021.jungle.model.*;
import hk.edu.polyu.comp.comp2021.jungle.controller.HybridScanner;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 *
 * Main game UI.
 * Handles board updates and mouse to cmd behaviors.
 */
public class GameUI extends JFrame{

    /**
     *
     * flag for test cases and code coverage trials.
     * prevents info dialogs from displaying so that test cases won't be blocked
     */
    private static boolean isTestCase=false;

    private final int BoardRows=9;
    private final int BoardCols=7;
    private final int PawnSize=74;
    private final int BoardWidth=518;
    private final int BoardHeight=666;
    private final int FrameHeight=769;
    private final int LabelHeight=35;
    private final int LabelWidth=35;
    private final int ButtonWidth=90;
    private final int ButtonHeight=35;

    private JButton[][] pawns;
    private JLabel[] turnlabels;
    private JLabel rejectmsglabel;

    private String command;

    /**
     *
     * constructor
     * @param title title provided with player names, eg. "p1 vs p2"
     */
    public GameUI(String title){

        JLayeredPane boardpanel=new JLayeredPane();

        JPanel panel=new JPanel();
        panel.setSize(BoardWidth,BoardHeight);
        LayoutManager layout=new GridLayout(9,7);
        panel.setLayout(layout);
        panel.setOpaque(false);

        JButton btn;
        pawns=new JButton[BoardRows][BoardCols];
        for(int i=0;i<9;i++)
            for(int j=0;j<7;j++){
                btn=new JButton();
                btn.setSize(PawnSize,PawnSize);
                btn.setBorder(new EmptyBorder(3,3,3,3));
                btn.setBorderPainted(false);
                btn.setOpaque(false);
                btn.setContentAreaFilled(false);
                btn.addActionListener(event->prepareMoveCommand((JButton)event.getSource()));
                panel.add(btn);
                pawns[i][j]=btn;
            }


        JLabel board=new JLabel(Textures.getIcon("board"));
        board.setSize(BoardWidth,BoardHeight);

        boardpanel.add(board,new Integer(0));
        boardpanel.add(panel,new Integer(1));


        turnlabels=new JLabel[2];
        turnlabels[0]=new JLabel();
        turnlabels[0].setPreferredSize(new Dimension(LabelWidth,LabelHeight));
        turnlabels[1]=new JLabel();
        turnlabels[1].setPreferredSize(new Dimension(LabelWidth,LabelHeight));
        rejectmsglabel=new JLabel();
        rejectmsglabel.setSize(BoardWidth-LabelWidth,LabelHeight);
        rejectmsglabel.setHorizontalAlignment(SwingConstants.RIGHT);
        rejectmsglabel.setForeground(Color.red);
        JPanel statubar=new JPanel(new GridLayout(1,2));
        statubar.add(turnlabels[0]);
        statubar.add(rejectmsglabel);


        btn=new JButton("Open");
        btn.setBounds(BoardWidth-ButtonWidth*2,0,ButtonWidth,ButtonHeight);
        btn.addActionListener(e->openFromFile());
        this.getContentPane().add(btn);

        btn=new JButton("Save");
        btn.setBounds(BoardWidth-ButtonWidth,0,ButtonWidth,ButtonHeight);
        btn.addActionListener(e->saveToFile());
        this.getContentPane().add(btn);

        this.getContentPane().add(turnlabels[1], BorderLayout.NORTH);
        this.getContentPane().add(boardpanel, BorderLayout.CENTER);
        this.getContentPane().add(statubar, BorderLayout.SOUTH);

        this.command="MOVE";

        this.setSize(BoardWidth,FrameHeight);
        this.setResizable(false);
        this.setTitle(title);
        this.setVisible(true);

    }

    /**
     *
     * update turn info. should only be triggered via UI events
     * @param turn id of the turn
     * @param p player of the current turn
     */
    public void updateTurnInfo(int turn,Player p){
        turnlabels[turn].setText(p.getName()+"\'s turn");
        turnlabels[1-turn].setText("");
    }

    /**
     *
     * update the board. should only be triggered via UI events
     * @param checkerBoard the board of the current game
     */
    public void updatePawns(CheckerBoard checkerBoard){

        this.rejectmsglabel.setText("");

        Piece[][] board=checkerBoard.getPieceBoard();

        for(int i=0;i<BoardRows;i++)
            for(int j=0;j<7;j++)
                if (board[i][j] == null)
                    pawns[8 - i][j].setIcon(null);
                else
                    pawns[8 - i][j].setIcon(Textures.getIcon(board[i][j].toString()));
    }

    /**
     *
     * set the move command invalid info
     * @param msg description of the invalid move
     */
    public void setCmdRejectedMsg(String msg){
        this.rejectmsglabel.setText(msg);
    }

    /**
     *
     * display neutral message
     * @param msg message
     */
    public void showInfo(String msg){
        if(isTestCase) return;
        JOptionPane.showMessageDialog(this, msg, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     *
     * display error message
     * @param msg error message
     */
    public void showError(String msg){
        if(isTestCase) return;
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void prepareMoveCommand(JButton btn){
        for(int i=BoardRows-1;i>-1;i--)
            for(int j=0;j<7;j++)
                if(pawns[i][j]==btn){
                    i=8-i;
                    String coord=Character.toString((char)('A'+j));
                    coord+=Integer.toString(i+1);
                    command+=" "+coord;
                    if(command.length()>9){
                        System.out.println(command);
                        HybridScanner.instance.feed(command);
                        command="MOVE";
                    }
                    return;
                }
    }

    private void saveToFile(){
        JFileChooser filedlg=new JFileChooser();
        filedlg.setDialogTitle("Save game snapshot");
        int result = filedlg.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION)
            HybridScanner.instance.feed("SAVE "+filedlg.getSelectedFile().getPath());
    }

    /**
     *
     * initiate open file dialog and show discard game confirmation.
     */
    protected void openFromFile(){
        JFileChooser filedlg=new JFileChooser();
        filedlg.setDialogTitle("Load game snapshot");
        int result = filedlg.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            HybridScanner.instance.feed("OPEN " + filedlg.getSelectedFile().getPath());

            result = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit the current game and load from file?",
                    "Load game from file", JOptionPane.YES_NO_OPTION);
            if (result == JFileChooser.APPROVE_OPTION)
                HybridScanner.instance.feed("Y");
            else HybridScanner.instance.feed("N");
        }
    }
}
