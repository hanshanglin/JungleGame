package hk.edu.polyu.comp.comp2021.jungle.ui;

import hk.edu.polyu.comp.comp2021.jungle.model.Controller;

public class UIController {

    private GameUI ui;
    private Controller currentController;

    /**
     * Singleton
     */
    public static final UIController instance=new UIController();

    public void setCurrentController(Controller ctrl){
        currentController=ctrl;
    }

    protected void createUI(){
        if(ui!=null)
            ui.dispose();
        ui=new GameUI();
    }

    public void sendEvent(UIEvent event){
        sendEvent(event,null);
    }

    public void sendEvent(UIEvent event,String extramsg){
        switch(event){
            case GAME_MODE_SELECT:
            case GAME_SINGLE_PLAYER:
                return;
            case GAME_INITIATED:
                instance.createUI();
            case UI_BOARD_UPDATE:
                ui.updatePawns(currentController.getCheckerBoard());
                return;
            case GAME_SWAP_TURN:
                ui.updateTurnInfo(currentController.getGame().getCurrentTurn(),currentController.getGame().getPlayer(currentController.getGame().getCurrentTurn()));
                return;
        }
        if(extramsg==null){
            sendEvent(UIEvent.UI_ERROR_REPORT,"Event message is null!");
            return;
        }
        switch(event){
            case UI_COMMAND_REJECTED:
                ui.setCmdRejectedMsg(extramsg);
                return;
            case UI_INFO:
                ui.showInfo(extramsg);
                return;
            case UI_ERROR_REPORT:
                ui.showError(extramsg);
                return;
        }
    }
}
