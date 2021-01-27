package hk.edu.polyu.comp.comp2021.jungle.view;

import hk.edu.polyu.comp.comp2021.jungle.controller.HybridScanner;

import javax.swing.*;
import java.awt.*;

/**
 *
 * Initial UI for the entire game.
 * Handles gamemode selection and issues newgame/loadgame commands.
 */
public class GamePrepareUI extends JFrame {

    private final int PanelWidth=180;
    private final int PanelHeight=140;

    private UIEvent event=UIEvent.GAME_MODE_SELECT;

    private JLabel label;
    private JButton btn1;
    private JButton btn2;

    /**
     *
     * constructor for this class, will instantly display frame
     */
    public GamePrepareUI(){
        label=new JLabel("Please select a game mode");
        this.getContentPane().add(label,BorderLayout.NORTH);

        btn1=new JButton("Standard");
        btn1.addActionListener(e->onButtonAction((JButton)e.getSource()));
        btn2=new JButton("Online (Unavailable)");
        btn2.addActionListener(e->onButtonAction((JButton)e.getSource()));

        JPanel btnpanel=new JPanel(new GridLayout(2,1));
        btnpanel.setPreferredSize(new Dimension(PanelWidth,PanelHeight));
        btnpanel.add(btn1);
        btnpanel.add(btn2);
        this.getContentPane().add(btnpanel);

        this.setTitle("JungleGame");
        this.pack();
        this.setVisible(true);
    }

    private void onButtonAction(JButton obj){
        if(event==UIEvent.GAME_MODE_SELECT){
            if(obj==btn1)
                HybridScanner.instance.feed("STANDALONE");
        }else if(event==UIEvent.GAME_SINGLE_PLAYER){
            if(obj==btn1){
                HybridScanner.instance.feed("NEW");
                if(UIController.instance.getGameUI()!=null){
                    int result = JOptionPane.showConfirmDialog(UIController.instance.getGameUI(), "Are you sure you want to quit the current game and create a new game?",
                            "Load game from file", JOptionPane.YES_NO_OPTION);
                    if (result == JFileChooser.APPROVE_OPTION)
                        HybridScanner.instance.feed("Y");
                    else {
                        HybridScanner.instance.feed("N");
                        return;
                    }
                }
                String p1=null;
                while(p1==null||p1.isEmpty())
                    p1=JOptionPane.showInputDialog(this,"Enter the name of player 1:","Player 1 name",JOptionPane.QUESTION_MESSAGE);
                HybridScanner.instance.feed(p1);
                String p2=null;
                while(p2==null||p2.isEmpty())
                    p2=JOptionPane.showInputDialog(this,"Enter the name of player 2:","Player 2 name",JOptionPane.QUESTION_MESSAGE);
                HybridScanner.instance.feed(p2);
            }else if(obj==btn2){
                if(UIController.instance.getGameUI()!=null)
                    UIController.instance.getGameUI().openFromFile();
                else {
                    JFileChooser filedlg = new JFileChooser();
                    filedlg.setDialogTitle("Load game snapshot");
                    int result = filedlg.showOpenDialog(this);

                    if (result == JFileChooser.APPROVE_OPTION)
                        HybridScanner.instance.feed("OPEN " + filedlg.getSelectedFile().getPath());
                }
            }
        }
    }

    /**
     *
     * get notified on relevant events.
     * @param event UI event
     */
    public void onEvent(UIEvent event){
        if(event!=UIEvent.GAME_MODE_SELECT&&event!=UIEvent.GAME_SINGLE_PLAYER)
            return;
        this.event=event;
        if(event==UIEvent.GAME_SINGLE_PLAYER){
            label.setText("Please choose an action");
            btn1.setText("New Game");
            btn2.setText("Load Game");
        }
    }
}
